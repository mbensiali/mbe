package com.mbe.jpa_enchere.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Enchere {
	
	private int id;
	private String description;
	private double prixDepart;
	private double enchereMinimum;
	private double prixActuel;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(length=50)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="P_depart")
	public double getPrixDepart() {
		return prixDepart;
	}
	public void setPrixDepart(double prixDepart) {
		this.prixDepart = prixDepart;
	}
	public double getEnchereMinimum() {
		return enchereMinimum;
	}
	public void setEnchereMinimum(double enchereMinimum) {
		this.enchereMinimum = enchereMinimum;
	}
	
	@Column(name="P_actuel")
	public double getPrixActuel() {
		return prixActuel;
	}
	public void setPrixActuel(double prixActuel) {
		this.prixActuel = prixActuel;
	}

	
	public Enchere() { this(0, "", 0, 0 ,0); }
	public Enchere(int id, String description, double prixDepart, double enchereMinimum, double prixActuel) {
		super();
		this.id = id;
		this.description = description;
		this.prixDepart = prixDepart;
		this.enchereMinimum = enchereMinimum;
		this.prixActuel = prixActuel;
	}
	

	@Override
	public String toString() {
		return "Enchere [id=" + id + ", description=" + description + ", prixDepart=" + prixDepart + ", enchereMinimum="
				+ enchereMinimum + ", prixActuel=" + prixActuel + "]";
	}
	
	
	

}
