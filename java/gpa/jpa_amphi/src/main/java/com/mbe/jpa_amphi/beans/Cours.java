package com.mbe.jpa_amphi.beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cours {
	private int id;
	private Date dateCours;
	private int capaciteMax;
	
	private Set<Etudiant> etudiants;
	private Professeur professeur;
	private Set<Matiere> matieres;
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDateCours() {
		return dateCours;
	}
	public void setDateCours(Date dateCours) {
		this.dateCours = dateCours;
	}
	public int getCapaciteMax() {
		return capaciteMax;
	}
	public void setCapaciteMax(int capaciteMax) {
		this.capaciteMax = capaciteMax;
	}
	
	
	@ManyToMany
	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	
	@ManyToOne
	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	
	
	@OneToMany(mappedBy="cours")
	public Set<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}
	
	public Cours(){
		this(0,null,0);
	}
	public Cours(int id, Date dateCours, int capaciteMax) {
		super();
		this.id = id;
		this.dateCours = dateCours;
		this.capaciteMax = capaciteMax;
	}

}
