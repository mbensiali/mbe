package com.mbe.spring_produit.actions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mbe.spring_produit.metier.Categorie;
import com.mbe.spring_produit.metier.Produit;
import com.mbe.spring_produit.repository.ICategorieDAO;
import com.mbe.spring_produit.repository.IProduitDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class IndexAction extends ActionSupport implements ModelDriven<Produit> {
	
	private static Logger log = LogManager.getLogger(ActionSupport.class); 
	private static final long serialVersionUID = 1L;


	private IProduitDAO produitDAO;
	private ICategorieDAO categorieDAO;
	public void setProduitDAO(IProduitDAO produitDAO) {
		this.produitDAO = produitDAO;
	}
	
	private List<Produit> produits;
	public List<Produit> getProduits() {
		return produits;
	}
	
	private List<Categorie> categories;
	public List<Categorie> getCategories() {
		if (categories == null)
			categories = categorieDAO.findAll();
		return categories;
	}
	private Produit model;
	@Override
	public Produit getModel() {
		if (model == null)
			model = new Produit();
		return model;
	}

	
	//private String message;
	
	//public String getMessage() {
		//return message;
	//}
	//public void setMessage(String message) {
	//	this.message = message;
	//}


	public String index() {
		log.info("appel de index!");
		produits = produitDAO.findAll();
		return SUCCESS;
	}
	
	public String edit() {
		Produit p = produitDAO.findByID(getModel().getId());
		if (p == null)
			return "notfound";
		
		getModel().setNom(p.getNom());
		getModel().setPrix(p.getPrix());
		getModel().setPoids(p.getPoids());
		getModel().setStock(p.getStock());
		
		return SUCCESS;
	}
	
	public String save() {
		Produit p = getModel();
		p = produitDAO.save(p);
		return SUCCESS;
	}
	
	public String create() {
		return SUCCESS;
	}
	
	public String remove() {
		produitDAO.remove(getModel().getId());
		return SUCCESS;
	}	

}
