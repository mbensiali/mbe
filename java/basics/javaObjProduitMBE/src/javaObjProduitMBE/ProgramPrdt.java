package javaObjProduitMBE;

public class ProgramPrdt {

	public static void main(String[] args) {
		
		Produit P1;
		
		P1 = new Produit("Patate", 3, 1);
		
		P1.afficher(100, P1.getPrice(100) );
		

	}

}
