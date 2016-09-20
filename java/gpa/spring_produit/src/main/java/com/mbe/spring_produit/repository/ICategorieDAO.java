package com.mbe.spring_produit.repository;

import java.util.List;

import com.mbe.spring_produit.metier.Categorie;

public interface ICategorieDAO {
	List<Categorie> findAll();
	Categorie findByID(int id);
	Categorie save(Categorie c);
	void remove(int id);

}
