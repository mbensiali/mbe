package com.mbe.enchereStruts2.metier;

public class Enchere {
	
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



	public Enchere() {this(0, "",0,0,0);}
	public Enchere(int id, String description, double prixDepart, double enchereMin, double prixActuel) {
		super();
		this.id = id;
		this.description = description;
		this.prixDepart = prixDepart;
		this.enchereMin = enchereMin;
		this.prixActuel = prixActuel;
	}
	
}
