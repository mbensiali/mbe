package com.mbe.spring_academy.beans;

public class Percussion implements IInstrument {
	
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
		System.out.println("TamTam!!!Tamtam!!!Tam!!!TamTamTam!!!");

	}

}
