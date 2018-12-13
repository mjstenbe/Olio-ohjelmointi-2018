import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Kirja {

	private String teoksenNimi;
	private int julkaisuvuosi;
	private String tekijä;
	private double hinta;

	public Kirja(String teoksenNimi, String tekijä, int julkaisuvuosi) {

		this.teoksenNimi = teoksenNimi;
		this.julkaisuvuosi = julkaisuvuosi;
		this.tekijä = tekijä;
	}

	public Kirja() {

		this.teoksenNimi = "Ei nimetty";
		this.julkaisuvuosi = -1;
		this.tekijä = "Tuntematon";
		this.hinta = 0;
	}

	@Override
	public String toString() {
		return "Kirja [teoksenNimi=" + teoksenNimi + ", julkaisuvuosi=" + julkaisuvuosi + ", tekijä=" + tekijä
				+ ", hinta=" + hinta + "]";
	}

	public String getTeoksenNimi() {
		return teoksenNimi;
	}

	public void setTeoksenNimi(String teoksenNimi) {
		this.teoksenNimi = teoksenNimi;
	}

	public int getJulkaisuvuosi() {
		return julkaisuvuosi;
	}

	public void setJulkaisuvuosi(int julkaisuvuosi) {
		this.julkaisuvuosi = julkaisuvuosi;
	}

	public String getTekijä() {
		return tekijä;
	}

	public void setTekijä(String tekijä) {
		this.tekijä = tekijä;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public static void main(String[] args) {
		Kirja ekaKirja = new Kirja();
		Kirja tokaKirja = new Kirja();

		ekaKirja.setTeoksenNimi("Sinuhe egyptiläinen");
		ekaKirja.setJulkaisuvuosi(1950);
		ekaKirja.setTekijä("Waltari, Mika");

		System.out.println(ekaKirja);
		// Tulostetaan myös tokaKirja, joka on tyhjä
		System.out.println(tokaKirja);

		Kirja kolmasKirja = new Kirja("Turms kuolematon", "Waltari, Mika", 1956);
		System.out.println(kolmasKirja);

		Kirja[] kirjaHylly = new Kirja[3];
		int[] luku = new int[5];

		kirjaHylly[0] = ekaKirja;
		kirjaHylly[1] = tokaKirja;
		kirjaHylly[2] = kolmasKirja;

		// OSA 2.

		for (int i = 0; i < kirjaHylly.length; i++) {
			System.out.println(kirjaHylly[i]);
		}

		Scanner lukija = new Scanner(System.in);

		for (int i = 0; i < kirjaHylly.length; i++) {

			System.out.println("Anna kirjan nimi: ");
			// String nimi = lukija.nextLine();

			String nimi = JOptionPane.showInputDialog(null, "Anna kirjan nimi?", "Kirjan tietojen kysely",
					JOptionPane.QUESTION_MESSAGE);

			System.out.println("Anna kirjan tekijä: ");
			String tekija = lukija.nextLine();

			System.out.println("Anna julkaisuvuosi: ");
			
			String julkaisuvuosi = JOptionPane.showInputDialog(null, "Anna kirjan julkaisuvuosi?", "Kirjan tietojen kysely",
					JOptionPane.QUESTION_MESSAGE);
			// Muutetaan String-tyyppinen julkaisuvuosi int-tyyppiseksi
			
			int vuosi = Integer.parseInt( julkaisuvuosi );

			kirjaHylly[i].setTeoksenNimi(nimi);
			kirjaHylly[i].setTekijä(tekija);
			kirjaHylly[i].setJulkaisuvuosi(vuosi);

			System.out.println(kirjaHylly[i]);

			// OSA 3

			// ArrayList-muuttujan alustus. Huomaa että muuttujan tyyppi voidaan antaa
			// nuolisulkeissa

			ArrayList<Kirja> kirjaVarasto = new ArrayList<>();

			// Olioiden lisäys
			kirjaVarasto.add(ekaKirja);

			// Olioiden poisto halutusta indeksistä
			kirjaVarasto.remove(1);

			// Listassa olevien alkioiden määrän kysely
			kirjaVarasto.size();

			// Listassa olevan alkion poimiminen
			kirjaVarasto.get(0);

		}

	}

}
