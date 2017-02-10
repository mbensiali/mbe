package com.mbe.airlineStat;

import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.mbe.airlineStat.util.AirlineDataUtil;

public class AgregCarrierMRJob extends Configured implements Tool 
{


	public static final IntWritable VOL = new IntWritable(0);
	public static final IntWritable A_HEURE_ARRIVE = new IntWritable(1);
	public static final IntWritable A_HEURE_DEPART = new IntWritable(2);
	
	public static final IntWritable RETARD_DEPART = new IntWritable(3);
	public static final IntWritable RETARD_ARRIVE = new IntWritable(4);
	public static final IntWritable ANNULE = new IntWritable(5);
	public static final IntWritable DEROUTE = new IntWritable(6);
	
	
	
	public static class SelectMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

		
		@Override
		protected void map(LongWritable key, Text value,
				Mapper<LongWritable, Text, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			
			if (!AirlineDataUtil.isHeader(value)) {
				
				String[] champs = value.toString().split(",");
				
				String carrier = AirlineDataUtil.getUniqueCarrier(champs);
				
								
				int duree_vol = AirlineDataUtil.parseMinutes(AirlineDataUtil.getElapsedTime(champs), 0);
				int duree_prevu_vol = AirlineDataUtil.parseMinutes(AirlineDataUtil.getScheduledElapsedTime(champs), 0);
				
				
				if (carrier == null) {
					return;
				}
				
				Text c = new Text(carrier);
				
				IntWritable dv = new IntWritable(duree_vol);
				IntWritable dpv = new IntWritable(duree_prevu_vol);
				
				context.write(c, VOL);
				context.write(c, dv);
				context.write(c, dpv);
				
				
			
			}
		}
		
	}
	
	
	public static class AgregationReducer extends Reducer<Text,Text, NullWritable, Text> {

		@Override
		protected void reduce(
				Text carrier,
				Iterable<Text> codes,
				Reducer<Text, Text, NullWritable, Text>.Context context)
				throws IOException, InterruptedException {
			
			double volsTotals = 0;
			double sumDureeVol = 0;
			double sumDureePrevuVol = 0;
			double duree_moyenne = 0;
			double diffrence_moyenne = 0;
			
			for (Text code : codes){
				
				volsTotals++;
				  

				
				
				
			}
			/*
			DecimalFormat df = new DecimalFormat("00.0000");
			
			StringBuilder sb = new StringBuilder(mois.toString());
			sb.append(",").append(volsTotals);
			sb.append(",").append(df.format(arriveAHeure/volsTotals * 100.0));
			sb.append(",").append(df.format(departAHeure/volsTotals * 100.0));
			sb.append(",").append(df.format(arriveRetard/volsTotals * 100.0));
			sb.append(",").append(df.format(departRetard/volsTotals * 100.0));
			sb.append(",").append(df.format(annules/volsTotals * 100.0));
			sb.append(",").append(df.format(deroutes/volsTotals * 100.0));
			
			context.write(NullWritable.get(), new Text(sb.toString()));
			*/
			

		}
		
		
		
	}

	@Override
	public int run(String[] args) throws Exception {
		// je recupere le job a executer avec les parametres de la conf
		Job job = Job.getInstance(this.getConf());
		
		job.setJarByClass(AgregCarrierMRJob.class);
		
		// format des fichier d'entrée et de sortie
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Text.class);
		
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setMapperClass(SelectMapper.class);
		job.setReducerClass(AgregationReducer.class);
		
		job.setNumReduceTasks(1);
		
		// recupération des parametres/configuration
		
		String[] arguments = new GenericOptionsParser(this.getConf(), args).getRemainingArgs();
		
		FileInputFormat.setInputPaths(job, new Path(arguments[0]));
		FileOutputFormat.setOutputPath(job, new Path(arguments[1]));
		
		// true -> mode verbose
		boolean status = job.waitForCompletion(true);
		if (status)
			return 0;
		else
			return 1;
	}
	
	public static void main(String[] args) throws Exception {
		
		// comme notre classe implement l'interface tools
		// on est censé l'executé via un ToolRunner
		ToolRunner.run(new AgregCarrierMRJob(), args);
	}
	

}
