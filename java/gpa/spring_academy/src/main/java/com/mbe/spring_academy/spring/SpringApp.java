package com.mbe.spring_academy.spring;

import java.util.*;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mbe.spring_academy.beans.*;

public class SpringApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        Scanner input = new Scanner(System.in);
        

        input.nextLine();
        System.out.println("--------------------------------------");
        
        IArtiste Artiste1 = ctx.getBean("Mozart", IArtiste.class);
        Artiste1.faireNumero();

        input.nextLine();
        System.out.println("--------------------------------------");
        
        
        IArtiste Artiste2 = ctx.getBean("Jongleur de feu", IArtiste.class);
        Artiste2.faireNumero();
        

        
        input.nextLine();
		System.out.println("--------------------------------------");

		System.out.println("done...");
	}





}
