package com.mbe.spring_produit.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Illustration {

	private int id;
	private String description;
	private String fileName;
	private String contentType;

	@Id @GeneratedValue
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	
	public Illustration(){
		this(0,"","","");
	}
	public Illustration(int id, String description, String fileName, String contentType) {
		super();
		this.id = id;
		this.description = description;
		this.fileName = fileName;
		this.contentType = contentType;
	}
	
	
	
	
}
