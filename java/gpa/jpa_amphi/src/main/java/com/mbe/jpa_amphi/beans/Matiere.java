package com.mbe.jpa_amphi.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Matiere {
	
	private int id;
	private String libelle;
	private Cours cours;

	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	@ManyToOne
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	
	public Matiere(){
		this(0,"");
	}
	public Matiere(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	

}
