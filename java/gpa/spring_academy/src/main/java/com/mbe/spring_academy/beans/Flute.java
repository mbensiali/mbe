package com.mbe.spring_academy.beans;

public class Flute implements IInstrument {

	private String nom;
	
	@Override
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public void jouer() {
		System.out.println("Flu!!!Flu!!!Flu!!!");
	}


}
