package Sarjallistamista;

import java.io.*;
//Toteutetaan Serializable rajapinta jotta olio voidaan kirjoittaa tiedostoon

public class Auto implements Serializable {

	private int ajokilometrit;
	private int vuosimalli;
	private int nopeus;
	private int polttoaine;
	private int tankintilavuus;
	private String autonV�ri;
	private String autonMerkki;

	// konstruktori ajetaan aina kun luokasta luodaan ilmentym�
	public Auto() {

		this.ajokilometrit = 0;
		this.vuosimalli = 1970;
		this.nopeus = 0;
		this.polttoaine = 25;
		this.tankintilavuus = 50;
		this.autonV�ri = "Metalli";
		this.autonMerkki = "Ei merkki�";

	}

	// luodaan get- ja set- metodit kaikille luokan private- kentille,
	// jotta niihin p��st��n k�siksi my�s ulkoap�in
	public void setPolttoaine(int polttoaine) {

		// Ei voida tankata enemp�� kuin tankki sallii
		if (polttoaine > this.tankintilavuus)
				this.polttoaine = tankintilavuus;
		else 
			this.polttoaine = polttoaine;
	}

	public int getPolttoaine() {
		return polttoaine;
	}

	public void setTankintilavuus(int tankintilavuus) {
		this.tankintilavuus = tankintilavuus;
	}

	public int getTankintilavuus() {
		return tankintilavuus;
	}

	public int getVuosimalli() {
		return vuosimalli;
	}

	public void setVuosimalli(int vuosimalli) {
		this.vuosimalli = vuosimalli;
	}

	public int getAjokilometrit() {
		return ajokilometrit;
	}

	public void setAjokilometrit(int ajokilometrit) {
		this.ajokilometrit = ajokilometrit;
	}

	public int getNopeus() {
		return nopeus;
	}

	public void setNopeus(int nopeus) {
		this.nopeus = nopeus;
	}

	public String getAutonV�ri() {
		return autonV�ri;
	}

	public void setAutonV�ri(String autonV�ri) {
		this.autonV�ri = autonV�ri;
	}

	public String getAutonMerkki() {
		return autonMerkki;
	}

	public void setAutonMerkki(String autonMerkki) {
		this.autonMerkki = autonMerkki;
	}

	public void tankkaa() {
		if (this.polttoaine + 15 > this.tankintilavuus){
			System.out.println("Tankki on t�ynn�!");
			this.polttoaine = this.tankintilavuus;
		}
		else
			this.polttoaine += 15;
	}

	public void aja(int km) {
		
		int kulutus = (int) (km * 0.08);
		System.out.println("Matkalla: "+km+" kuluu bensaa: "+kulutus+" litraa.");
		
		if (this.polttoaine - kulutus <= 0){
			System.out.println("Bensa loppuu, et voi ajaa matkaa ennen tankkausta.");
			this.polttoaine = 0;
		}
		else {
			this.ajokilometrit += km;
			this.polttoaine -= kulutus;
		}

	}

	public String toString() {

		String varoitusvalo ="";

		if (this.getPolttoaine() == 0) 
			varoitusvalo = " * Polttoaine loppu! *";
		
		else if (this.getPolttoaine() <= 20) 			
			varoitusvalo = " * Polttoaine v�hiss� ! *";
		
		
		String tilatieto = "\nAuton tilatiedot: \n "
				+ "+------------------------------------------+\n"
				+ "+ Merkki: " + this.getAutonMerkki() + "\n" + "+ V�ri: "
				+ this.getAutonV�ri() + "\n" + "+ Nopeus: " + this.getNopeus()
				+ "\n" + "+ Vuosimalli: " + this.getVuosimalli() + "\n"
				+ "+ Ajokilometrit: " + this.getAjokilometrit() + "\n"
				+ "+ Tankintilavuus: " + this.getTankintilavuus() + "\n"
				+ "+ Polttoaine: " + this.getPolttoaine() + varoitusvalo +"\n"
				+ "+------------------------------------------+";
		

		return tilatieto;
	}

	public static void main(String[] args) {
		Auto uusiAuto = new Auto();

		uusiAuto.setNopeus(120);
		uusiAuto.setAutonV�ri("Punainen");
		uusiAuto.setAutonMerkki("Porsche");
		uusiAuto.setVuosimalli(2007);
		uusiAuto.setAjokilometrit(10324);
		uusiAuto.setTankintilavuus(60);
		uusiAuto.setPolttoaine(60);
		

		System.out.println(uusiAuto);
		uusiAuto.aja(100);
		System.out.println(uusiAuto);

		for (int i = 0; i < 10; ++i) {
			uusiAuto.aja(200);
			System.out.println(uusiAuto);
		}

	}

}
