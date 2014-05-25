package diak;

/**A hallgató letárolására használt osztály */
public class hallgato {
	String azonosito;
	String vezeteknev;
	String keresztnev;
	int szuletesi_ev;
	int szuletesi_ho;
	int szuletesi_nap;
	
	public hallgato(String azonosito, String vezeteknev, String keresztnev,
			int szuletesi_ev, int szuletesi_ho, int szuletesi_nap) {
		super();
		this.azonosito = azonosito;
		this.vezeteknev = vezeteknev;
		this.keresztnev = keresztnev;
		this.szuletesi_ev = szuletesi_ev;
		this.szuletesi_ho = szuletesi_ho;
		this.szuletesi_nap = szuletesi_nap;
	}

	@Override
	public String toString() {
		return "hallgato [azonosito=" + azonosito + ", vezeteknev="
				+ vezeteknev + ", keresztnev=" + keresztnev + ", szuletesi_ev="
				+ szuletesi_ev + ", szuletesi_ho=" + szuletesi_ho
				+ ", szuletesi_nap=" + szuletesi_nap + "]";
	}
}
