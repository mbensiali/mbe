package triangeMBE;
import java.util.*;

public class ProgramTr {

	public static void main(String[] args) {
		
		Scanner lecteur = new Scanner (System.in);
		String saisie;
		int taille;
		System.out.println("Entrer une taille:  ");
		// je demande au scanner la prochaine ligne saisie
		saisie = lecteur.nextLine();
		
		taille = Integer.parseInt(saisie);
		
		for (int j=taille; j> 0; j--){
			if (j!=taille && j!= 1){
				for (int i = 0; i < j; i++){
					System.out.print('-');
				}
			}
			System.out.println('*');
		}
	}

}
