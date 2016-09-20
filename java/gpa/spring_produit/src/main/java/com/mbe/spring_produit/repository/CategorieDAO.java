package com.mbe.spring_produit.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.mbe.spring_produit.metier.Categorie;

public class CategorieDAO implements ICategorieDAO {
	
	@PersistenceContext
	private EntityManager em_c;
	public EntityManager getEm_c() {
		return em_c;
	}
	public void setEm_c(EntityManager em_c) {
		this.em_c = em_c;
	}

	@Override
	@Transactional
	public List<Categorie> findAll() {
		return em_c.createQuery("select c from Categorie as c", Categorie.class).getResultList();
	}

	@Override
	@Transactional
	public Categorie findByID(int id) {
		return em_c.find(Categorie.class, id);
	}

	@Override
	@Transactional
	public Categorie save(Categorie c) {
		Categorie existing = em_c.find(Categorie.class, c.getId());
		// si l'entite existe deja en base, faire un Merge
		if (existing != null) {
			existing = em_c.merge(c);
		}
		// sinon, faire un persist car nouvelle entité
		else {
			em_c.persist(c);
			existing = c;
		}
		return existing;
	}

	@Override
	@Transactional
	public void remove(int id) {
		Categorie existing =  em_c.find(Categorie.class, id);
		if (existing != null)
			em_c.remove(existing);
	}

}
