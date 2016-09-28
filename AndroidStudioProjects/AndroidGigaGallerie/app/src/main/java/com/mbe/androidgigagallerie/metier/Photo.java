package com.mbe.androidgigagallerie.metier;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Photo {
    private int id;
    private String nom;
    private String description;
    private Date dateCreation;
    private String fileName;
    private String contentType;


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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
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

    public Photo() { this(0, "", "", null, "", "");}
    public Photo(int id, String nom, String description, Date dateCreation, String fileName, String contentType) {
        super();
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.dateCreation = dateCreation;
        this.fileName = fileName;
        this.contentType = contentType;
    }




}

