package com.mbe.myUtilisateurMeteo.metier;

public class Utilisateur {

	private int id;
	private String nom;
	private String email;
	private String ville;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	public Utilisateur(){
		this (0,"","","");
	}
	public Utilisateur(int id, String nom, String email, String ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.ville = ville;
	}
	
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", email=" + email + ", ville=" + ville + "]";
	}
	
	
	
	
	
	
	
	

}
