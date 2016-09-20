package com.mbe.jpa_amphi.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Etudiant {
	private int id;
	private String nom;
	private String email;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToMany(mappedBy="etudiants")
	public Set<Cours> getLesCours() {
		if (lesCours == null)
			lesCours = new HashSet<>();
		return lesCours;
	}
	public void setLesCours(Set<Cours> lesCours) {
		this.lesCours = lesCours;
	}
	
	public Etudiant(){
		this(0,"","");
	}
	public Etudiant(int id, String nom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
	}

}
