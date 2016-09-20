package com.mbe.jpa_enchere.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mbe.jpa_enchere.beans.*;

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
		Enchere e = new Enchere(0, "spaghetti presto", 8.99, 0.5, 40);
		Enchere e2 = new Enchere(0, "champignon farci", 12.99, 0.75, 35);
		Enchere e3 = new Enchere(0, "saumon a l'americaine", 11.99, 0.45, 70);
		Enchere e4 = new Enchere(0, "choucroute garnie", 15.99, 1.0, 15.99);
		Enchere e5 = new Enchere(0, "tourte a la viande", 22.99, 1.5, 30);
		em.persist(e);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		em.persist(e5);

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
		Enchere e = em.find(Enchere.class, 2);
		System.out.println(e);

		System.out.println("---------------------------");
		// requette en JPAQL / EJBQL
		// TypedQuery<Produit> requette = em.createQuery("from Produit", Produit.class);
		TypedQuery<Enchere> requette = em.createQuery("select e from Enchere as e", Enchere.class);
		// execution de la requette
		List<Enchere> encheres = requette.getResultList();
		for (Enchere ecr : encheres) {
			System.out.println(ecr);
		}
		
		//----------------------------------------------------
		System.out.println("---------------------------");
		Enchere e2 = em.find(Enchere.class, 3);
		System.out.println(e2);
		e2.setPrixDepart(1.2);
		System.out.println(e2);
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
		Scanner input = new Scanner(System.in);
		System.out.println("prix actuel minimum ? ");
		double prixActuelMin = Double.parseDouble(input.nextLine());		
		
		TypedQuery<Enchere> requette = em.createQuery(
				"select e from Enchere as e where e.prixActuel > :pmin",
				Enchere.class);
		requette.setParameter("pmin", prixActuelMin);
		List<Enchere> encheres = requette.getResultList();
		
		input.nextLine();
		
		for (Enchere ec : encheres) {
			System.out.println(ec);		
		}

		//----------------------------------------------------
		tx.commit();
		em.close();
	}
	

}
