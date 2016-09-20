package com.mbe.spring_memento.spring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mbe.spring_memento.beans.*;

public class SpringApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        Scanner input = new Scanner(System.in);
        

        input.nextLine();
        System.out.println("--------------------------------------");
        
        IFactoriel fact = ctx.getBean("fact", IFactoriel.class);
        System.out.println(fact.calculFactorielDe(3));
        System.out.println(fact.calculFactorielDe(6));
        System.out.println(fact.calculFactorielDe(3));
        
        System.out.println(fact.calculLeTripleDe(3));
        
        input.nextLine();
		System.out.println("--------------------------------------");

		System.out.println("done...");
	}





}
