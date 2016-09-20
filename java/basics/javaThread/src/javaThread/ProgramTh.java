package javaThread;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class ProgramTh {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Appuyer sur entrer pour commencer");
		reader.nextLine();
		
		Date debut = new Date();
		
		compter();
		System.out.println("------------------------------");
		compter();
		
		Date fin = new Date();
	}
	
	public static void compter(){
		Random rd = new Random();
		double d = rd.nextDouble();
		for (long l=0; l < 2*1000*1000*1000; l++){
			d=Math.sqrt(d*Math.PI);
			if (l%(100*1000*1000)==0){
				System.out.println("iteration = " + l);
			}
		}
		System.out.println("d = " + d);
	}

}
