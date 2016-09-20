package com.mbe.livreStruts2.actions;

import com.opensymphony.xwork2.ActionSupport;

public class LivreAction extends ActionSupport {
	
	private String titre;
	private String auteur;
	private String categorie;
	private int nbPages;
	
	private String isbn;
	
	private String message;
	
	
	public String getMessage() {
		return message;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public LivreAction(){
	}
	
	
	// afficher le formulaire
	public String index(){
		
		//le contenu par defaut du formulaire
		setTitre("");
		setAuteur("");
		setCategorie("");
		setNbPages(0);
		setIsbn("00000000");
		
		return SUCCESS;
		
	}
	
	//receptionner le formulaire
	public String save(){
		this.message = "Voici les infos du livre: " + '\n' + getTitre() + " \n" + getAuteur() + "\n" + getCategorie() + " \n" + getNbPages() + "\n" + getIsbn();
				
		return SUCCESS;
		
	}
	
	
	

}
