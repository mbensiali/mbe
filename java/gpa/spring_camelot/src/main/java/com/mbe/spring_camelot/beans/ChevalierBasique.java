package com.mbe.spring_camelot.beans;

public class ChevalierBasique implements IChevalier {

	private String nom;
	private IQuete quete;
	private double reussite;
	
	public double getReussite() {
		return reussite;
	}

	public void setReussite(double reussite) {
		this.reussite = reussite;
	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public void setQuete(IQuete quete) {
		this.quete = quete;

	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public void partirEnQuete() {
		System.out.println("Moi, " + getNom() + " part joyeusement en quete de " + this.quete);
		if (this.quete.realiseQuete(getReussite())){
			System.out.println("Moi, " + getNom() + " reviens victorieusement de quete");
		}
		else
			System.out.println("Moi, " + getNom() + " a echoué dans ma quete");

	}

}
