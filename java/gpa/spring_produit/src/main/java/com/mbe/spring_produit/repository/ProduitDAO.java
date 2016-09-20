package com.mbe.spring_produit.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.mbe.spring_produit.metier.Categorie;
import com.mbe.spring_produit.metier.Produit;

public class ProduitDAO implements IProduitDAO {
	

	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	@Transactional
	public List<Produit> findAll() {
		return em.createQuery("select p from Produit as p", Produit.class).getResultList();
	}

	@Override
	@Transactional
	public Produit findByID(int id) {
		return em.find(Produit.class, id);
	}

	@Override
	@Transactional
	public Produit save(Produit p) {
		Produit existing = em.find(Produit.class, p.getId());
		// si l'entite existe deja en base, faire un Merge
		if (existing != null) {
			existing = em.merge(p);
		}
		// sinon, faire un persist car nouvelle entité
		else {
			em.persist(p);
			existing = p;
		}
		return existing;
	}

	@Override
	@Transactional
	public void remove(int id) {
		Produit existing =  em.find(Produit.class, id);
		if (existing != null)
			em.remove(existing);

	}

	public List<Categorie> listCategorie() {
		List<Categorie> cats = new ArrayList<>();
		
		return cats;
	}	

}
