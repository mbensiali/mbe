package inverseChaineJavaMBE;

public class ProgramInv {

	public static void main(String[] args) {
		
		// String Str ="aaabbbcccdddeee";
		// System.out.println(inverserChaine(Str));
		
		System.out.println("le nombre d'années est : " + nbreAnnees(1000, 10000, 5));

	}

	public static String inverserChaine(String str) {
		
		String Buffer = "";
		
		for (int i = str.length()-1; i >= 0 ; i--){
			Buffer = Buffer + str.charAt(i);
		}
		
		return Buffer;
	}
	
	public static int nbreAnnees(int sommeInit, int sommeFinal, float taux){
		int value =0;
		float montant = sommeInit;
		
		while(montant < sommeFinal){
			montant = montant + montant * taux / 100;
			value++;
		}
		
		return value;
	}



}
