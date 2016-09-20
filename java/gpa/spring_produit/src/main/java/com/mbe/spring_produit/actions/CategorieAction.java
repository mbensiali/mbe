package com.mbe.spring_produit.actions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mbe.spring_produit.metier.Categorie;
import com.mbe.spring_produit.repository.ICategorieDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CategorieAction extends ActionSupport implements ModelDriven<Categorie> {

	private static Logger log = LogManager.getLogger(ActionSupport.class); 
	private static final long serialVersionUID = 1L;


	private ICategorieDAO categorieDAO;
	public void setCategorieDAO(ICategorieDAO categorieDAO) {
		this.categorieDAO = categorieDAO;
	}
	
	private List<Categorie> categories;
	public List<Categorie> getCategories() {
		return categories;
	}

	private Categorie model;
	@Override
	public Categorie getModel() {
		if (model == null)
			model = new Categorie();
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
		categories = categorieDAO.findAll();
		return SUCCESS;
	}
	
	public String edit() {
		Categorie c = categorieDAO.findByID(getModel().getId());
		if (c == null)
			return "notfound";
		
		getModel().setLibelle(c.getLibelle());
		
		return SUCCESS;
	}
	
	public String save() {
		Categorie c = getModel();
		c = categorieDAO.save(c);
		return SUCCESS;
	}
	
	public String create() {
		return SUCCESS;
	}
	
	public String remove() {
		categorieDAO.remove(getModel().getId());
		return SUCCESS;
	}	

}
