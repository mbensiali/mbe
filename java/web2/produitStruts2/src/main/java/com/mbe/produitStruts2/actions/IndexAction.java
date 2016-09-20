package com.mbe.produitStruts2.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.util.ServletContextAware;

import com.mbe.produitStruts2.metier.Produit;
import com.mbe.produitStruts2.utils.BDDListener;
import com.mbe.produitStruts2.utils.ProduitDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class IndexAction extends ActionSupport implements
ServletContextAware, ModelDriven<Produit>{
	
	private static Logger log = LogManager.getLogger(ActionSupport.class); 
	private static final long serialVersionUID = 1L;

	private Produit model;
	
	private ProduitDAO produitDAO;
	
	// la liste des produits
	private List<Produit> produits;
	public List<Produit> getProduits() {
		return produits;
	}
	
	public String liste() {
		log.info("appel de liste");
		produits = produitDAO.findAll();
		return SUCCESS;
	}


	
	@Override
	public Produit getModel() {
		if (model == null)
			model = new Produit();
		log.info("appel de getModel()");
		return model;
	}
	
	
	public String edit() {
		log.info("appel de edit");

		Produit produit = produitDAO.findByID(getModel().getId());
		if (produit == null)
			return "notfound";
		getModel().setNom(produit.getNom());
		getModel().setPrix(produit.getPrix());
		getModel().setPoids(produit.getPoids());
		getModel().setStock(produit.getStock());
		return SUCCESS;
	}
	
	public String create() {
		log.info("appel de create");
		
		getModel().setNom("");
		getModel().setPrix(0);
		getModel().setPoids(0);
		getModel().setStock(0);
		
		return SUCCESS;
	}
	

	public String save() {
		log.info("appel de save");
		Produit produit = getModel();
		produitDAO.save(produit);
		return SUCCESS;
	}	
	
	@Override
	public void setServletContext(ServletContext ctx) {
		produitDAO = (ProduitDAO)ctx.getAttribute(BDDListener.PRODUIT_DAO);
		
	}

}
