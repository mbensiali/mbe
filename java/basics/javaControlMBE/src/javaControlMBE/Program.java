package javaControlMBE;
import java.util.*;

public class Program {

	public static void main(String[] args) {
		// la chaine scanner permet de lire le contenu d'un flux
		// ici, en l'occurence, les saisies utilisateur
		Scanner lecteur = new Scanner (System.in);
		
		System.out.println("quelle heure est il ?");
		// je demande au scanner la prochaine ligne saisie
		String saisie = lecteur.nextLine();
		
		//System.out.println(saisie);
		
		//Integer.parseInt permet de convertir une chaine de caracteres en Entier
		int heure = Integer.parseInt(saisie);
		
		if (heure < 12) {
			System.out.println("bonjour, un café");
		}
		else if(heure < 15){
			System.out.println("bonjour, bon appetit");
		}
		else{
			System.out.println("bonjour, belle journée");
		}
		
		System.out.println("-------------------------------------");
		
		switch(heure){
			case 9:
				System.out.println("bonjour, un café");
				break;
			case 12:
				System.out.println("bonjour, bon appetit");
				break;
			default:
				System.out.println("bonjour, belle journée");
				break;
		}
		
		// == -> egalité,  != -> différent
		// On ne compare JAMAIS JAMAIS les strings avec == !!!!!!
		
		int i = 0;
		
		// les boucles
		
		while(i<10){
			System.out.println("i = " + i);
			// ++ = postincrement --> augmente la valeur de 1
			// -- = postdecrement --> diminue la valeur 1
			i++; //<=> i += 1;  // <=> i = i + 1;
		}
		
		i = 5;
		int j = i++;
		System.out.println("i = " + i + " j = " + j);
		
		i = 5;
		j = ++i;
		System.out.println("i = " + i + " j = " + j);
		
		i = 12;
		do{
			System.out.println("i = " + i);
			i++;
		}while(i<10);
		
		
	System.out.println("-----------------------------------------");
	
	for(int k = 0; k < 10; k++){
		if (k == 5)
			continue; // sauter à l'iteration suivante
		if (k == 8){
			break; // sortie prématurée de la boucle
		}
		System.out.println("k = " + k );
	}

	}

}
