package com.mbe.airlineStat;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.mbe.airlineStat.util.AirlineDataUtil;

public class SelectMRJob extends Configured implements Tool 
{


	public static class SelectMapper extends Mapper<LongWritable, Text, NullWritable, Text> {

		
		@Override
		protected void map(LongWritable key, Text value,
				Mapper<LongWritable, Text, NullWritable, Text>.Context context)
				throws IOException, InterruptedException {
			
			// sauter la ligne d'en-tête (titre de colonne)
			if (!AirlineDataUtil.isHeader(value)) {
				// je renvoie uniquement les champs qui m'intéresse
				StringBuilder sb = AirlineDataUtil
									.mergeStringArray(
											AirlineDataUtil.getSelectedColumnsA(value), ",");
				// j'ecris en sortie du mapper cette ligne
				// je passe un NullWritable en cle comme je n'en ai pas
				// besoin, pour eviter une colonne vide inutile en sortie
				context.write(NullWritable.get(), new Text(sb.toString()));
			}
		}
		
	}

	@Override
	public int run(String[] args) throws Exception {
		// je recupere le job a executer avec les parametres de la conf
		Job job = Job.getInstance(this.getConf());
		
		job.setJarByClass(SelectMRJob.class);
		
		// format des fichier d'entrée et de sortie
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Text.class);
		
		job.setMapperClass(SelectMapper.class);
		
		/*
		 * en mettant à 0 le nombre de réducteur
		 * hadoop exportera directement le resultat du mapper
		 * ATTENTION, si vous omettez d'indiquer le reducteur
		 * et ne mettez pas numreducetask à 0
		 * hadoop fournis automatquement un reducteur par defaut
		 * identite, qui copie tel quel son entree vers sa sortie
		 * cela peut avoir un gros impact ur les performances
		 */
		job.setNumReduceTasks(0);
		
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
		ToolRunner.run(new SelectMRJob(), args);
	}
	

}
