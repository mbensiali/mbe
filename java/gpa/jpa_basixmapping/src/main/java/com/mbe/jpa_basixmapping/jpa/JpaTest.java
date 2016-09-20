package com.mbe.jpa_basixmapping.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mbe.jpa_basixmapping.beans.*;

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
		Produit p = new Produit(0,"spaghetti Presto",8.99, 0.5, 40);
		Produit p2 = new Produit(0,"champignon farci",10.99, 1.5, 60);
		Produit p3 = new Produit(0,"poulet roti",115.99, 11.5, 10);
		Produit p4 = new Produit(0,"hachi parmentier",0.99, 0.5, 22);
		Produit p5 = new Produit(0,"lapin degueu",1.99, 5.5, 50);
		
		em.persist(p);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);
		
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
		Produit p = em.find(Produit.class,2);
		System.out.println(p);
		
		System.out.println("--------------------------------------");
		
		TypedQuery<Produit> requette= em.createQuery("select p from Produit as p", Produit.class);
		
		List<Produit> produits = requette.getResultList();
		for(Produit pr: produits){
			System.out.println(pr);
		}
		
		System.out.println("apres liste------------------------------------------");
		p = em.find(Produit.class, 3);
		System.out.println(p);
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
