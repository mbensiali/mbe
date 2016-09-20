package com.mbe.js_produitBio.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mbe.js_produitBio.metier.Produit;
//import com.mbe.js_produitBio.repositories.IProduitDAO;
import com.mbe.js_produitBio.repositories.ProduitRepository;
import com.opensymphony.xwork2.ActionSupport;

public class ProduitAction extends ActionSupport {
	/*private IProduitDAO produitDAO;
	public void setProduitDAO(IProduitDAO produitDAO) {this.produitDAO = produitDAO;}
	

	private List<Produit> produits;
	public List<Produit> getProduits() {
		return produits;
	}
	
	private String searchTerm;
	public String getSearchTerm() {return searchTerm;}
	public void setSearchTerm(String searchTerm) {this.searchTerm = searchTerm;}
	
	//  GET -> /produit/
	public String liste() {
		produits = produitDAO.findAll();
		return SUCCESS;
	}
	
	//  GET -> /produit/search/:searchterm
	public String searchByName() {
		produits = produitDAO.findByName(getSearchTerm());
		return SUCCESS;
	}*/
	
	@Autowired
	private ProduitRepository produitRepository;
	public ProduitRepository getProduitRepository() {return produitRepository;}
	public void setProduitRepository(ProduitRepository produitRepository) {this.produitRepository = produitRepository;}

	private Iterable<Produit> produits;
	public Iterable<Produit> getProduits() {
		return produits;
	}
	
	private String searchTerm;
	public String getSearchTerm() {return searchTerm;}
	public void setSearchTerm(String searchTerm) {this.searchTerm = searchTerm;}
	
	//  GET -> /produit/
	public String liste() {
		produits = produitRepository.findAll(); 
		//produits = produitDAO.findAll();
		return SUCCESS;
	}
	
	//  GET -> /produit/search/:searchterm
	public String searchByName() {
		produits = produitRepository.findByNomContaining(getSearchTerm());
		return SUCCESS;
	}
	
	

}
