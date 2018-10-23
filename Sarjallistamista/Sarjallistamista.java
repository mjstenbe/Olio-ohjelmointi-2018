package Sarjallistamista;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Sarjallistamista {
// Tallennetaan Auto-olio sarjallistettuna tiedostoon

	private static void serializeToXML(Auto oma) throws Exception  {
		FileOutputStream fos = new FileOutputStream("Auto.xml");
		XMLEncoder encoder = new XMLEncoder(fos);
		encoder.writeObject(oma);
		encoder.close();
		fos.close();
	}

	private static Auto deserializeFromXML() throws Exception {
		FileInputStream fis = new FileInputStream("Auto.xml");
		XMLDecoder decoder = new XMLDecoder(fis);
		Auto decodedAuto = (Auto) decoder.readObject();
		decoder.close();
		fis.close();
		return decodedAuto;
	}

	public static void main(String[] args) throws Exception  { // eli ei käsitellä poikkeuksia

		// Tiedostojen kirjoittamista varten
		FileOutputStream apuTied = new FileOutputStream("AutotTallessa.oma");
		ObjectOutputStream talteen = new ObjectOutputStream(apuTied);

		// Tiedostojen lukemista varten
		FileInputStream fis = new FileInputStream("AutotTallessa.oma");
		ObjectInputStream luettuData = new ObjectInputStream(fis);

		// Luodaan Autot ja annetaan niille arvot

		Auto a = new Auto();
		Auto b = new Auto();

		a.setAutonMerkki("Ferrari");
		b.setAutonMerkki("Honda");
		a.setNopeus(100);
		b.setNopeus(200);
		a.setVuosimalli(1999);
		b.setVuosimalli(2010);
		a.setAjokilometrit(180000);
		b.setAjokilometrit(167000);

		System.out.println(a);
		System.out.println(b);

		// Kirjoitetaan molemmat autot samaan tiedostoon
		talteen.writeObject(a);
		talteen.writeObject(b);

		// Tallennetaan auto a myös XML-muodossa
		serializeToXML(a);

		talteen.flush(); // !!
		apuTied.close(); // !!

		// Luetaan oliot takaisin levyltä

		Auto uusi =  (Auto) luettuData.readObject();
		Auto toinenUusi = (Auto) luettuData.readObject();

		Auto c = deserializeFromXML();
		

		// Tulostetaan ne
		System.out.println(uusi);
		System.out.println(toinenUusi);
		System.out.println(c);
	}
}