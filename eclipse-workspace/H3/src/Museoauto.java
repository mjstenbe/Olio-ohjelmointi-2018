
public class Museoauto extends Auto {

	int valmistusvuosi;

	public static void main(String[] args) {

		Museoauto musti = new Museoauto();
		Urheiluauto jaguar = new Urheiluauto();

		musti.valmistusvuosi = 1930;

		musti.setAjokilometrit(35000);
		musti.setNopeus(100);
		musti.setGPSID("12345678");
		jaguar.setAjokilometrit(80000);

		System.out.println(musti);
		System.out.println(jaguar);
		System.out.println("Autoja luotu yhteensä: " + musti.autojenLkm);
		System.out.println("Autoja luotu yhteensä: " + jaguar.autojenLkm);

	}

	@Override
	public String toString() {
		return super.toString() + "Museoauto [valmistusvuosi=" + valmistusvuosi + "]";

	}

}
