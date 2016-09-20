package com.mbe.spring_academy.beans;

public class Saxophone implements IInstrument {
	
	private String nom;

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public void jouer() {
		System.out.println("Voooh!!!Voohhh!!!Voooh!!!");

	}

}
