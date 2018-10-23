package Kirja;

import javax.swing.JDialog;
//import java.util.Scanner;
// Dialogin luominen vaatii JOptionPane -luokan
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// Muuten identtinen kirja-luokan kanssa, mutta Scannerin käytön sijaan
// Tiedot luetaan käyttäen JOptionPane-luokan inputDialogia

public class Kirja_GUI_omapaneeli {

	private String teoksenNimi;
	private int julkaisuvuosi;
	private String tekija;

	public Kirja_GUI_omapaneeli() {
		this.teoksenNimi = "ei määritelty";
		this.julkaisuvuosi = 0;
		this.tekija = "tuntematon";
	}

	public int getJulkaisuvuosi() {
		return julkaisuvuosi;
	}

	public void setJulkaisuvuosi(int vuosi) {
		this.julkaisuvuosi = vuosi;
	}

	public String getTeoksenNimi() {
		return teoksenNimi;
	}

	public void setTeoksenNimi(String nimi) {
		this.teoksenNimi = nimi;
	}

	public String getTekija() {
		return tekija;
	}

	public void setTekija(String tekija) {
		this.tekija = tekija;
	}

	public String toString() {
		String tiedot = "--------------------------------\n" + "- Kirjan nimi: " + this.getTeoksenNimi() + "\n"
				+ "- Tekijä: " + this.getTekija() + "\n" + "- Julkaisuvuosi: " + this.getJulkaisuvuosi() + "\n"
				+ "--------------------------------";
		return tiedot;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Kirja[] kirjaHylly = new Kirja[3];
		// Scanner lukija = new Scanner(System.in);

		String nimi;
		String tekija;
		int vuosi;

		JDialog oma= new KirjaDialog();
		oma.setVisible(true);
		
		for (int i = 0; i < kirjaHylly.length; i++) {

			Kirja kirja = new Kirja();
			kirjaHylly[i] = kirja;

			// System.out.println("Anna kirjan nimi: ");
			// nimi = lukija.nextLine();

			int res = JOptionPane.showInternalConfirmDialog(null, oma, "Kirjan tietojen kysely",
					JOptionPane.OK_CANCEL_OPTION);

			//kirja.setTeoksenNimi(nimi);

			// System.out.println("Anna kirjan tekijä: ");
			// tekija = lukija.nextLine();

			tekija = JOptionPane.showInputDialog(null, "Anna tekijän nimi?", "Kirjan tietojen kysely",
					JOptionPane.QUESTION_MESSAGE);

			kirja.setTekija(tekija);

			// System.out.println("Anna kirjan julkaisuvuosi: ");
			// vuosi = lukija.nextInt();
			// lukija.nextLine();

			String vuosiMerkkijonona = JOptionPane.showInputDialog(null, "Anna julkaisuvuosi?",
					"Kirjan tietojen kysely", JOptionPane.QUESTION_MESSAGE);

			// Muutetaan vuosiluku merkkijonosta int-tyyppiseksi
			vuosi = new Integer(vuosiMerkkijonona);

			kirja.setJulkaisuvuosi(vuosi);

		}

		for (int i = 0; i < kirjaHylly.length; i++) {
			System.out.println(kirjaHylly[i]);
		}

	}

}
