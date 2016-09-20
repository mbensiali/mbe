package com.mbe.jpa_amphi.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professeur {
	
	private int id;
	private String nom;
	private double salaire;
	
	private Set<Cours> lesCours;
	
	@Id @GeneratedValue
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
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	@OneToMany(mappedBy="professeur")
	public Set<Cours> getLesCours() {
		return lesCours;
	}
	public void setLesCours(Set<Cours> lesCours) {
		this.lesCours = lesCours;
	}


	
	public Professeur(){
		this (0,"",0);
	}
	public Professeur(int id, String nom, double salaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.salaire = salaire;
	}
	
	

}
