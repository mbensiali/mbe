package com.mbe.spring_camelot.beans;

public class ChevalierTableRonde implements IChevalier {

	private String nom;
	private IQuete quete;
	private Cheval mouture;
	private double reussite;
	
	
	
	public double getReussite() {
		return reussite;
	}
	public void setReussite(double reussite) {
		this.reussite = reussite;
	}
	public Cheval getMouture() {
		return mouture;
	}
	public void setMouture(Cheval mouture) {
		this.mouture = mouture;
	}
	public IQuete getQuete() {
		return quete;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public void setQuete(IQuete quete) {
		this.quete = quete;

	}

	@Override
	public void partirEnQuete() {
		System.out.println("Moi, " + getNom() + " part joyeusement en quete de " + getQuete() + "sur  mon fidele destrier" + getMouture().getNom());
		if (getQuete().realiseQuete(getReussite() * 2.0)){
			System.out.println("Moi, Sire" + getNom() + " reviens couvert dse gloire");
		}
		else
			System.out.println("Moi, Sire" + getNom() + " a eu un contretemps");

	}

}
