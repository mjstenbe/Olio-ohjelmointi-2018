package Sarjallistamista;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tiedostoja {

	public static void main(String[] args) {
		// Esitellään Scanner-olio sekä tiedosto, joka tullaan lukemaan

		Scanner lukija = null;
		File tiedosto = new File("c:\\temp\\tiedosto.txt");

		// Luetaan tiedostoa skannerin avulla rivi kerrallaan
		// Varaudutaan poikkeuksiin try-catch -rakenteella

		try {
			lukija = new Scanner(tiedosto);
		} catch (FileNotFoundException e) {
			System.out.println("Tiedostoa ei löydy!");
		}

		int i = 0;

		while (lukija.hasNextLine()) {
			i++;
			String rivi = lukija.nextLine();
			if (rivi.indexOf("whale") > 0)
				System.out.println(i + " : " + rivi);
		}
	}

}
