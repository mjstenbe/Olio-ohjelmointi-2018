package Kirjasto_DB;

import javax.swing.JFrame;


public class Kirjasto {

	// Alustetaan taulukko
	static Kirja kirjaHylly[];

	// Ohjelman p‰‰metodi
	public static void main(String[] args) {

		kirjaHylly = new Kirja[5];

		JFrame ikkuna = new GUI( kirjaHylly );
		ikkuna.setVisible(true);

	}

}
