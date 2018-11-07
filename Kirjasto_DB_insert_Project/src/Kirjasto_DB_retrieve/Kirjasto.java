package Kirjasto_DB_retrieve;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Font;


public class Kirjasto {

	// Alustetaan taulukko
	static Kirja kirjaHylly[];

	// Ohjelman päämetodi
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		

		// Ladataan kirjat tietokannasta ja sijoitetaan kirjaHylly -muuttujaan
		kirjaHylly = JDBCExample.palautaKirjat();

		// Uutta ikkunaa piirrettäessä, välitetään kirjahyllyn sisältö mukana
		JFrame ikkuna = new GUI( kirjaHylly );
		ikkuna.getContentPane().setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		ikkuna.setVisible(true);
		

	}

}
