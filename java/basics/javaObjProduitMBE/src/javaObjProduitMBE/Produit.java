package javaObjProduitMBE;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Produit {
	
	private static final double DISCOUNT_DEFAUT = 5;
	
	private static int compteurId = 0;
	
	private final int id; 
	private final String nom;
	private final double prix;
	private final double poids;
	
	// constructeurs
	
	public Produit() {
		this("Patate", 3, 1); 
	}
	
	public Produit(String nom, double prix, double poids) {
		compteurId++;
		this.id = compteurId;
		if (nom.length() >= 3 && nom.length() <= 50){
			this.nom = nom;
		}
		else{
			this.nom = "XXX";
		}
		
		this.prix = (prix >= 0)? prix : 1.0;
		this.poids = (poids >= 0)? poids : 1.0;
	}
	
	public void afficher(double poids, double prix) {
		System.out.println("Le produit " + this.id + ": " + this.nom + "  poids: " + poids + "  prix : " + prix);
	}
	
	public double getPrice(double quantite){
		
		double prixFinal = 0;
		
		prixFinal = this.prix * quantite / poids;
		if (quantite > 10){
			prixFinal = prixFinal - prixFinal * DISCOUNT_DEFAUT / 100;
		}
		
		return prixFinal;
	}
	
}
