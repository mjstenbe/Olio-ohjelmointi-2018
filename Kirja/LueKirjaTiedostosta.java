package Kirja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LueKirjaTiedostosta {

	public static void main(String[] args) throws FileNotFoundException {

		File tiedostoKahva = new File("Kirjat.txt");

		if (!tiedostoKahva.exists()) {
			System.out.println("Tiedostoa ei löydy!");
			return; // keskeytetään kaikki!
		}

		Scanner syottotiedosto = new Scanner(tiedostoKahva);
		Kirja omakirja = new Kirja();

		while (syottotiedosto.hasNextLine()) {
			String rivi = syottotiedosto.nextLine();
			// System.out.println(rivi);

			// Poimitaan tiedostosta relevantti tieto talteen
			// ja sijoitetaan se uuteen Kirja-olioon
			
			if (rivi.indexOf("Kirjan nimi:") != -1) {				
				String nimi = rivi.substring(rivi.lastIndexOf(":")+1, rivi.length());
				System.out.println("-->" + nimi);
				
				omakirja.setTeoksenNimi(nimi);
			}

			if (rivi.indexOf("Tekijä:") != -1) {				
				String tekija = rivi.substring(rivi.lastIndexOf(":")+1, rivi.length());
				System.out.println("-->"+tekija);
				
				omakirja.setTekija(tekija);
				
			}

			if (rivi.indexOf("Julkaisuvuosi:") != -1) {				
				String vuosi = rivi.substring(rivi.lastIndexOf(":")+1, rivi.length());
				System.out.println("-->"+vuosi);
								
				omakirja.setJulkaisuvuosi(Integer.parseInt(vuosi.trim()));
				
				System.out.println("Tulostetaan uusi Kirja-olio");
				System.out.println(omakirja);
			}
			
			
		}
		

		syottotiedosto.close(); // Huom.!!
	}

}
