package javaListeProduitMBE;

public class Produit implements Comparable<Produit> {
	
	private String nom;
	private double prix;
	private double poids;

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	public Produit(String nom, double prix, double poids) {
		setNom (nom);
		setPrix (prix);
		setPoids (poids);
	}
	
	public String saveToCsv() {
		return getNom() + ";" 
			+ getPrix() + ";" 
			+ getPoids();
	}
	
	@Override
	public String toString() {
		return "Produit [nom=" + nom + ", prix=" + prix + ", poids=" + poids + "]";
	}
	@Override
	public int compareTo(Produit p) {
		
		if (getPrix() > p.getPrix())
			return 1;
		if (getPrix() < p.getPrix())
			return -1;
		return 0;		
	}
	
}
