
public class Auto {

	String v�ri;
	int nopeus;
	int tankinTilavuus;

	
	public static void main(String[] args) {
		
		// Olioiden luominen
		
		int luku = 10;
		Auto omaAuto = new Auto();
		Auto toinenAuto = new Auto();
		
		// Arvojen antaminen
		
		omaAuto.nopeus = 100;
		toinenAuto.nopeus = 200;
		
		omaAuto.v�ri = "Punainen";
		toinenAuto.v�ri = "Sininen";
		
		System.out.println(omaAuto);
		System.out.println(toinenAuto);
		
		
	}

	public String toString() {
		
		return "V�ri: "+v�ri + " Nopeus: "+nopeus;
		
	}
	
	
	
}
