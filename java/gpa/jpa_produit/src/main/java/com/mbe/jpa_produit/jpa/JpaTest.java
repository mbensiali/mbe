package com.mbe.jpa_produit.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mbe.jpa_produit.beans.*;
import com.mbe.spring_produit.metier.Categorie;
import com.mbe.spring_produit.metier.Produit;

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

        /*input.nextLine();
		System.out.println("--------------------------------------");
		test2(emf);*/

        input.nextLine();
		System.out.println("--------------------------------------");
		test3(emf);	

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
		
		Categorie c1 = new Categorie(0, "Meuble");
		Categorie c2 = new Categorie(0, "Electromenager");
		Categorie c3 = new Categorie(0, "Vetements");
		Categorie c4 = new Categorie(0, "Nourriture");
		Categorie c5 = new Categorie(0, "Auto");

		
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.persist(c5);
		
		Random rd = new Random();
		for (int i = 1; i <= 10; i++) {
			Produit p = new Produit(0,"chaise" + i, rd.nextInt(10), rd.nextInt(20),rd.nextInt(30) );
			p.setCategorie(em.find(Categorie.class, 1));
			em.persist(p);
		}

		for (int i = 1; i <= 10; i++) {
			Produit p = new Produit(0,"Casserole" + i, rd.nextInt(10), rd.nextInt(20),rd.nextInt(30) );
			p.setCategorie(em.find(Categorie.class, 2));
			em.persist(p);
		}
		
		for (int i = 1; i <= 10; i++) {
			Produit p = new Produit(0,"Chemise" + i, rd.nextInt(10), rd.nextInt(20),rd.nextInt(30) );
			p.setCategorie(em.find(Categorie.class,3));
			em.persist(p);
		}
		
		for (int i = 1; i <= 10; i++) {
			Produit p = new Produit(0,"Fromage" + i, rd.nextInt(10), rd.nextInt(20),rd.nextInt(30) );
			p.setCategorie(em.find(Categorie.class, 4));
			em.persist(p);
		}

		for (int i = 1; i <= 10; i++) {
			Produit p = new Produit(0,"Mercedes" + i, rd.nextInt(10), rd.nextInt(20),rd.nextInt(30) );
			p.setCategorie(em.find(Categorie.class, 5));
			em.persist(p);
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
		TypedQuery<Produit> requete1 = em.createQuery("select p from Produit as p",Produit.class);
		List<Produit> produits = requete1.getResultList();
		for (Produit p : produits) {
			System.out.println(p + " --- " + p.getCategorie());
			
		}		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}
	
	public static void test3(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		
		TypedQuery<Produit> requete1 = em.createQuery("select p from Produit as p where p.categorie.libelle='Vetement'",Produit.class);
		List<Produit> produits = requete1.getResultList();
		for (Produit p : produits) {
			System.out.println(p + " --- " + p.getCategorie());
			
		}
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}	

}
