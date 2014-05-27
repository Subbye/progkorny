package diak;

/**
 * A hallgató letárolására használt osztály.
 * @author Subbye
 *
 */
public class hallgato {
	/**
	 * Neptun azonosító.
	 */
	String azonosito;
	/**
	 * Hallgató Vezetékneve.
	 */
	String vezeteknev;
	/**
	 * Hallgató Keresztneve.
	 */
	String keresztnev;
	/**
	 * Hallgató születési éve.
	 */
	int szuletesi_ev;
	/**
	 * Hallgató születési hónapja.
	 */
	int szuletesi_ho;
	/**
	 * Hallgató születési napja.
	 */
	int szuletesi_nap;
/**
 * 
 * @param azonosito (Neptun azonosító)
 * @param vezeteknev (Hallgató vezetékneve)
 * @param keresztnev (Hallgató keresztneve)
 * @param szuletesi_ev	(Hallgató születési éve)
 * @param szuletesi_ho	(Hallgató születési hónapja)
 * @param szuletesi_nap	(Hallgató születési napja)
 */
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
