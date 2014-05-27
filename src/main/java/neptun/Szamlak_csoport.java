package neptun;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/** A bankszámlaszámok egy listába való csoportosítását szolgálja. */
public class Szamlak_csoport {
	/** A lista amiben számlákat tároljuk, elemei {@link Szamla_egy} tipusúak. */
	List<Szamla_egy> lista = new LinkedList<Szamla_egy>();
	/**
	 * Logger létrehozása amiben visszajelzünk, hogy sikeresen végrehajtódtak-e
	 * a műveletek, vagy sem.
	 */
	private final static Logger LOGGER = Logger
			.getLogger("Szamlak_csoportlogger");

	/**
	 * Számlaszám hozzáadása a listához.
	 * 
	 * @param s
	 *            {@link neptun.Szamla_egy Szamla_egy} típusú.
	 * @return {@code boolean} típusú, a sikeresség függvényében.
	 */
	public boolean add(Szamla_egy s) {
		if (lista.isEmpty()) {
			lista.add(s);
			LOGGER.info("Sikeresen hozzáadva.");
			return true;
		}
		for (Szamla_egy sz : lista) {
			if (sz.szamlaszam==s.szamlaszam) {
				LOGGER.warning("Ez a számlaszám már szerepel a listában.");
				return false;
			} else if (sz.tulajdonos_azonositoja
					.equals(s.tulajdonos_azonositoja)) {
				lista.add(s);
				LOGGER.info("Sikeresen hozzáadva.");
				return true;
			}
		}
		LOGGER.warning("Csak azonos tulajdonosú számla adható hozzá.");
		return false;
	}

	/**
	 * Számlaszám törlése a listából.
	 * 
	 * @param s
	 *            {@link neptun.Szamla_egy Szamla_egy} típusú.
	 * @return {@code boolean} típusú, a sikeresség függvényében.
	 */
	public boolean remove(Szamla_egy s) {
		for (Szamla_egy sz : lista) {
			if (sz.szamlaszam == s.szamlaszam
					&& sz.tulajdonos_azonositoja == s.tulajdonos_azonositoja
					&& sz.osszeg == s.osszeg) {
				lista.remove(s);
				LOGGER.info("Sikeresen törölve!");
				return true;
			}
		}
		LOGGER.warning("Nincs ilyen számla a listában!");
		return false;
	}
}
