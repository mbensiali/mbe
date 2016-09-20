package com.mbe.spring_academy.beans;

public class Jongleur implements IArtiste {
	
	private String nom;
	private int nombreDeBalles;
	

	public int getNombreDeBalles() {
		return nombreDeBalles;
	}
	public void setNombreDeBalles(int nombreDeBalles) {
		this.nombreDeBalles = nombreDeBalles;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String getNom() {
		return nom;
	}
	
	

	public Jongleur(){
		this("",0);
	}
	public Jongleur(String nom, int nombreDeBalles) {
		super();
		this.nom = nom;
		this.nombreDeBalles = nombreDeBalles;
	}
	
	@Override
	public void faireNumero() {
		System.out.println(" Je jongle avec " + getNombreDeBalles() + " balles");
	}

}
