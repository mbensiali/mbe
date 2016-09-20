package javaExceptTemp;

import java.util.Scanner;

public class ProgramExT {

	public static void main(String[] args) {
		
		try {
			int temp = saisie_temperature();
			System.out.println("temperature en °F est " + temp/2);
			System.out.println("temperature en °K est " + (temp-10));

				return;
			
		}
		catch (TempException ex) {
			System.out.println("Temperature invalide");

		}
		catch (Exception ex) {
			System.out.println("ouhla, une erreur est survenue..." + ex.getMessage());
		}
		
	}
	
	public static int saisie_temperature()
	{
		Scanner reader = new Scanner(System.in);
		int temp = 0;
		while (true) {
			try {
				System.out.println("votre temperature en °C?");
				String saisie = reader.nextLine();
				temp = Integer.parseInt(saisie);
				if (temp < -70 || temp > 70) {
					TempException Tex = new TempException();
					throw Tex;
				}
				return temp;
			}
			catch (NumberFormatException ex) {
				System.out.println("On ne saisit pas un chiffre " + ex.getMessage());
			}
		}
	}
	

}
