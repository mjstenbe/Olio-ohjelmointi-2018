
public class Auto {

	private String v�ri;
	private int nopeus;
	private int ajokilometrit;
	private String GPSID;
	static int autojenLkm;

	public Auto() {
		autojenLkm++;
		
	}
	
	public static int getAutojenLkm() {
		return autojenLkm;
	}

	public static void setAutojenLkm(int autojenLkm) {
		Auto.autojenLkm = autojenLkm;
	}

	@Override
	public String toString() {
		return "Auto [v�ri=" + v�ri + ", nopeus=" + nopeus + ", ajokilometrit=" + ajokilometrit + ", GPSID=" + GPSID
				+ "]";
	}

	public String getGPSID() {
		return GPSID;
	}


	public void setGPSID(String gPSID) {
		GPSID = gPSID;
	}


	public String getV�ri() {
		return v�ri;
	}


	public void setV�ri(String v�ri) {
		this.v�ri = v�ri;
	}


	public int getNopeus() {
		return nopeus;
	}


	public void setNopeus(int nopeus) {
		this.nopeus = nopeus;
	}


	public int getAjokilometrit() {
		return ajokilometrit;
	}


	public void setAjokilometrit(int ajokilometrit) {
		this.ajokilometrit = ajokilometrit;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
