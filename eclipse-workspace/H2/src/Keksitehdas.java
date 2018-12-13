
public class Keksitehdas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Keksi ekaKeksi = new Keksi();
		Keksi tokaKeksi = new Keksi(500);
		Keksi kolmasKeksi = new Keksi(1500, "Filipinos");

		System.out.println(ekaKeksi);
		System.out.println(tokaKeksi);
		System.out.println(kolmasKeksi);

		ekaKeksi.setMerkki("Domino");
		ekaKeksi.setPaino(34);

		System.out.println(ekaKeksi);

		ekaKeksi.haukkaa();

		System.out.println(ekaKeksi);

		ekaKeksi.haukkaa();

		System.out.println(ekaKeksi);

		ekaKeksi.haukkaa();
		System.out.println(ekaKeksi);
		ekaKeksi.haukkaa();
		System.out.println(ekaKeksi);
		ekaKeksi.haukkaa();

	}

}
