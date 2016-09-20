package webToDo.metier;

public class Tache {
	
	private String descritpion;
	private String categorie;
	private int priorite;
	
	
	public String getDescritpion() {
		return descritpion;
	}
	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getPriorite() {
		return priorite;
	}
	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}
	
	
	
	public Tache(){
		this("","",0);
	}
	public Tache(String descritpion, String categorie, int priorite) {
		super();
		setDescritpion(descritpion);
		setCategorie(categorie);
		setPriorite(priorite);
	}
	

}
