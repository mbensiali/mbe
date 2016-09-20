package notesMBE;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		
		Scanner lecteur = new Scanner (System.in);
		String saisie;
		float note;
		float notemin = 0;
		float notemax = 0;
		float sommenotes = 0;
		float moyenne =0;
		int nbreDeNotes = 0;
			
		
		do {

			System.out.println("Entrer une note:  ");
			// je demande au scanner la prochaine ligne saisie
			saisie = lecteur.nextLine();
			
			note = Float.parseFloat(saisie);
			
			if (nbreDeNotes == 0){
				notemin = note;
				notemax = note;
				sommenotes = note;
			}
			else{
				if (note < notemin && note != -1){
					notemin = note;
				}
				if (note > notemax){
					notemax = note;
				}
				if (note != -1){
					sommenotes = sommenotes + note;
				}
			}
			if (note != -1){
				nbreDeNotes++;
			}
		}while(note != -1);
		
		moyenne = sommenotes / nbreDeNotes; 
		
		System.out.println("la note min = " + notemin);
		System.out.println("la note max = " + notemax);
		System.out.println("la note moyenne = " + moyenne);
	}

}
