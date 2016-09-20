package palindromeMBE;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		Scanner lecteur = new Scanner (System.in);
		
		System.out.println("Entrer un texte: ");
		// je demande au scanner la prochaine ligne saisie
		String saisie = lecteur.nextLine();
		
		int nbreDeCaracteres = saisie.length();
		boolean isPalindrome = true;
		int j = nbreDeCaracteres -1;
		
		for(int i = 0; i < nbreDeCaracteres; i++ ){
			if (saisie.charAt(i) != saisie.charAt(j-i)){
				isPalindrome = false;
			}
		}
		
		if (isPalindrome == true){
			System.out.println("le texte est palindrome");
		}
		else{
			System.out.println("le texte n'est pas palindrome");
		}

	}

}
