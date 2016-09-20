package com.mbe.spring_jdbc.spring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mbe.spring_jdbc.beans.*;
import com.mbe.spring_jdbc.metier.Post;

public class SpringApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("--------------------------------------");
        IPostDAO postDAO = ctx.getBean("postDAO", IPostDAO.class);
        
        System.out.println("titre de post ?");
        String titre = input.nextLine();
        System.out.println("corps de post ?");
        String corps = input.nextLine();
        
        Post p = new Post(0, titre, corps);
        postDAO.save(p);
        
		System.out.println("--------------------------------------");

		System.out.println("done...");

	}





}
