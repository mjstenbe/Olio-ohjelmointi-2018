import java.io.FileNotFoundException;

public class Överiksi {
	public static void main(String[] args) {
		int[] taulu = new int[15];

		try {

			for (int i = 0; i < 15; i++)
				System.out.println(taulu[i]);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nyt mentiin indeksin yli ja lujaa.");

		} catch (ArithmeticException e) {

			System.out.println("Nyt laskutoimitus ei onnistunut!");
		}
		catch (Exception e) {
			System.out.println("TUli joku muu poikkeus");
		}
		finally {
			System.out.println("Lopputoimet tehdään täällä.");
		}
	}
}
