package Kirjasto_DB_retrieve;

import java.util.Scanner;



public class Kirja {

	private String teoksenNimi;
	private int julkaisuvuosi;
	private String tekija;

	public Kirja() {
		this.teoksenNimi = "ei m‰‰ritelty";
		this.julkaisuvuosi = 0;
		this.tekija = "tuntematon";
	}

	public Kirja(String teoksenNimi, int julkaisuvuosi, String tekija) {
		super();
		this.teoksenNimi = teoksenNimi;
		this.julkaisuvuosi = julkaisuvuosi;
		this.tekija = tekija;
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
				+ "- Tekij‰: " + this.getTekija() + "\n" + "- Julkaisuvuosi: " + this.getJulkaisuvuosi() + "\n"
				+ "--------------------------------";
		return tiedot;
	}


//	public static void main(String[] args) {
//
//		Kirja[] kirjaHylly = new Kirja[2];
//		Scanner lukija = new Scanner(System.in);
//
//		String nimi;
//		String tekija;
//		int vuosi;
//
//		for (int i = 0; i < kirjaHylly.length; i++) {
//
//			Kirja kirja = new Kirja();
//			kirjaHylly[i] = kirja;
//
//			System.out.println("Anna kirjan nimi: ");
//			nimi = lukija.nextLine();
//			kirja.setTeoksenNimi(nimi);
//
//			System.out.println("Anna kirjan tekij‰: ");
//			tekija = lukija.nextLine();
//			kirja.setTekija(tekija);
//
//			System.out.println("Anna kirjan julkaisuvuosi: ");
//			vuosi = lukija.nextInt();
//			lukija.nextLine();
//			kirja.setJulkaisuvuosi(vuosi);
//
//		}
//
//		for (int i = 0; i < kirjaHylly.length; i++) {
//			System.out.println(kirjaHylly[i]);
//
//			JDBCExample.tallennaKirja(kirjaHylly[i]);
//
//		}
//
//		JDBCExample.lataaKirjat();
//		
//		GUI test = new GUI(kirjaHylly);
//		test.setVisible(true);
//
//	}

}
