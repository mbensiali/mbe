package com.mbe.firstStruts2.actions;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
	
	private String nom;
	private String prenom;
	private int age;
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	// Une classe d'action DOIT avoir un constructeur sans parametres
	public HomeAction(){
	}
	
	// afficher le formulaire
	public String index(){
		
		//le contenu par defaut du formulaire
		setNom("cloe");
		setPrenom("john");
		setAge(25);
		return SUCCESS;
		
	}
	
	//receptionner le formulaire
	public String save(){
		this.message = "bonjour, " + getNom() + " " + getPrenom() + ", tu as " + getAge() + " ans";
		
		return SUCCESS;
		
	}


}
