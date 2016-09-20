package com.mbe.jpa_amphi.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mbe.jpa_amphi.beans.*;
import com.mbe.jpa_produit.beans.Categorie;
import com.mbe.jpa_produit.beans.Produit;

public class JpaTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testHibernate");
        Scanner input = new Scanner(System.in);

        input.nextLine();
        System.out.println("--------------------------------------");
		test1(emf);

        input.nextLine();
		System.out.println("--------------------------------------");
		test2(emf);

        input.nextLine();
		System.out.println("--------------------------------------");		

	    emf.close();
		System.out.println("done...");
	}




	public static void test1(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------

		//*** Insertion de 3 professeurs
		Professeur p1 = new Professeur(0,"Kepler",2000);
		Professeur p2 = new Professeur(0,"Newton",5000);
		Professeur p3 = new Professeur(0,"Hubble",3000);
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);

		
		//*** Insertion de 10 cours
		
		
		Random rd = new Random();
		for (int i = 1; i <= 10; i++) {
			Cours c = new Cours(0, new Date(rd.nextInt(16) + 100,rd.nextInt(12),15), 10 );
			c.setProfesseur(em.find(Professeur.class, rd.nextInt(4)+1));
			em.persist(c);
		}
		
		//*** Insertion de 100 etudiant
		
		
		Random rd = new Random();
		for (int i = 1; i <= 10; i++) {
			Cours c = new Cours(0, new Date(rd.nextInt(16) + 100,rd.nextInt(12),15), 10 );
			c.setProfesseur(em.find(Professeur.class, rd.nextInt(4)+1));
			em.persist(c);
		}
		

		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}


	public static void test2(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
