package com.mbe.enchereStruts2.actions;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.mbe.enchereStruts2.metier.Enchere;
import com.mbe.enchereStruts2.util.EnchereDAO;
import com.opensymphony.xwork2.ActionSupport;

public class EnchereAction extends ActionSupport implements ServletContextAware{
	

	private EnchereDAO enchereDAO;
	
	private List<Enchere> encheres;
		
	public List<Enchere> getEncheres() {return encheres;}
	
	private int id;
	private String description;
	private double prixDepart;
	private double enchereMin;
	private double prixActuel;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrixDepart() {
		return prixDepart;
	}
	public void setPrixDepart(double prixDepart) {
		this.prixDepart = prixDepart;
	}
	public double getEnchereMin() {
		return enchereMin;
	}
	public void setEnchereMin(double enchereMin) {
		this.enchereMin = enchereMin;
	}
	public double getPrixActuel() {
		return prixActuel;
	}
	public void setPrixActuel(double prixActuel) {
		this.prixActuel = prixActuel;
	}

	

	// afficher le formulaire
	public String index(){
		
		//le contenu par defaut du formulaire
		setDescription("");
		setPrixDepart(10);
		setPrixActuel(10);
		setEnchereMin(1);
		return SUCCESS;
		
	}
	
	public String liste() {
		// ma methode d'action doit préparer les donnée pour la vue (page jsp)
		// ici, on veu la liste des message pour les afficher
		// je les requettes avec le DAO, et le fourni dans ma propriété "messages"
		this.encheres = enchereDAO.findAll();
		return SUCCESS;
	}
	
	// receptionner le formulaire
	public String save() {
		enchereDAO.save(new Enchere(getId(),getDescription(), getPrixDepart(),getEnchereMin(),getPrixActuel()));
		return SUCCESS;
	}
	
	
	@Override
	public void setServletContext(ServletContext ctx) {
		this.enchereDAO = (EnchereDAO)ctx.getAttribute("enchereDAO");
		
	}
	

}
