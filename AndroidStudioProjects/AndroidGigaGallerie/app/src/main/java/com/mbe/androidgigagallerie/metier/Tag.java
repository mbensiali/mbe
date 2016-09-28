package com.mbe.androidgigagallerie.metier;

import java.util.HashSet;
import java.util.Set;

public class Tag {
    private int id;
    private String libelle;

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

    public Tag() { this(0, "");}
    public Tag(int id, String libelle) {
        super();
        this.id = id;
        this.libelle = libelle;
    }



}
