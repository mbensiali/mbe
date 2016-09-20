package com.mbe.spring_produit.repository;

import java.util.List;

import com.mbe.spring_produit.metier.Produit;

public interface IProduitDAO {
	List<Produit> findAll();
	Produit findByID(int id);
	Produit save(Produit p);
	void remove(int id);	

}
