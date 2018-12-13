
public class Keksi {

	public Keksi() {
		this.paino = 35;
		this.merkki = "Merkki� ei ole viel� asetettu.";
	}

	public Keksi(int uusipaino) {
		this.paino = uusipaino;
		this.merkki = "Merkki� ei ole viel� asetettu.";
	}

	public Keksi(int uusipaino, String uusiMerkki) {
		this.paino = uusipaino;
		this.merkki = uusiMerkki;
	}

	private String merkki;
	private int paino;

	public String getMerkki() {
		return this.merkki;
	}

	public void setMerkki(String uusiMerkki) {
		this.merkki = uusiMerkki;
	}

	public int getPaino() {
		return this.paino;
	}

	public void setPaino(int uusiPaino) {
		this.paino = uusiPaino;
	}

	public void haukkaa() {
		if (this.paino - 10 < 0) {
			this.paino = 0;
			System.out.println("Omenaa ei voi en�� haukata!");
		}

		else
			this.paino -= 10;

		//
		// this.paino = this.paino - 10;
	}

	@Override
	public String toString() {
		return "Keksi [merkki=" + merkki + ", paino=" + paino + "]";
	}

	public static void main(String[] args) {

	}

}
