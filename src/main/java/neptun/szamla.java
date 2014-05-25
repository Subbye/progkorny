package neptun;

import java.util.logging.Logger;

/** A bankszámlaszám tárolására létrehozott osztály */
public class szamla {
	/** A bankszámla számlaszáma*/
	long szamlaszam;
	/** A számlaszámon szereplő összeg*/	
	int osszeg;
	/** A tulajdonos neptun azonosítója*/
	String tulajdonos_azonositoja;
	private final static Logger LOGGER = Logger.getLogger("Szamlalogger");
	
	public szamla(long szamlaszam, int osszeg, String tulajdonos_azonositoja) {
		this.szamlaszam = szamlaszam;
		this.osszeg = osszeg;
		this.tulajdonos_azonositoja = tulajdonos_azonositoja;
	}

	@Override
	public String toString() {
		return "szamla [szamlaszam=" + szamlaszam + ", osszeg=" + osszeg
				+ ", tulajdonos_azonositoja=" + tulajdonos_azonositoja + "]";
	}
	
	/** A gyüjtőszámláról való visszautalás kezelése.
	 * @param Paraméterként "vissza" egy {@code int} típust kap meg, amely az az összeg amit vissza szeretnénk utalni.
	 * @return Visszatérési értéke {@code boolean} a sikeresség függvényében.
	 * */
	boolean visszautal(int vissza){
		if(osszeg>vissza){
			osszeg-=vissza;
			LOGGER.info("Sikerült a visszautalás a gyüjtőszámláról");
			return true;
		}
		LOGGER.warning("A visszautalni kívánt összeg nem haladhatja meg a számlán levő összeget.");
		return false;
	}
}
