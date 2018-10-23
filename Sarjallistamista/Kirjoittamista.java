package Sarjallistamista;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Kirjoittamista {

	public static void main(String[] args)  {

		Kirja kirja = new Kirja();

		PrintWriter tulos = null;
		try {
			tulos = new PrintWriter("c:\\temp\\Kirjat.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Tiedostoa ei löydy!");
		}
		Scanner lukija = new Scanner(System.in);

		System.out.println("Anna kirjan nimi: ");
		String nimi = lukija.nextLine();

		System.out.println("Anna kirjan tekijä: ");
		String tekija = lukija.nextLine();
		
		kirja.setTeoksenNimi(nimi);
		kirja.setTekija(tekija);

		tulos.println(kirja);
		tulos.close();

	}

}
