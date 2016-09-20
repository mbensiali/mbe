package com.mbe.js_produitBio.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.mbe.js_produitBio.metier.Categorie;
import com.mbe.js_produitBio.repositories.CategorieRepository;
import com.opensymphony.xwork2.ActionSupport;

public class CategorieAction extends ActionSupport {
	@Autowired
	private CategorieRepository categorieRepository;
	public CategorieRepository getCategorieRepository() {return categorieRepository;}
	public void setCategorieRepository(CategorieRepository categorieRepository) {this.categorieRepository = categorieRepository;}
	
	private Iterable<Categorie> categories;
	public Iterable<Categorie> getCategories() {
		return categories;
	}
	
	public String index() {
		categories = categorieRepository.findAll();
		return SUCCESS;
	}
		

}
