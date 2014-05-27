package neptun;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**Az osztály egy lista segítségével kezeli a hallgato számláit.*/
public class Tetelek_csoport {
	/**
	 * Egy lista, amely tartalmazza az összes tételt, ennek segítségével lehet törölni és hozzáadni új tételt.
	 */
	List<Tetel_egy> tetelek = new LinkedList<Tetel_egy>();
	/**
	 * Létrehozzuk egy logger állományt, amiben a listázások és az esetlegesen felmerülő hibát jelzését tároljuk.
	 */
	private final static Logger LOGGER = Logger.getLogger("Teteleklogger");

	/**
	 * Számlaszám hozzáadása a listához. 
	 * @param t {@link neptun.Tetel_egy Tetel_egy} elemet kap meg.
	 */
	public void add(Tetel_egy t){
		tetelek.add(t);
	}
	
	/**
	 * Számlaszám törlése a listából.
	 * @param t {@link neptun.Tetel_egy Tetel_egy} típusú elemet kap.
	 * @return {@code boolean} értékkel tér vissza a sikeresség függvényében.
	 */
	public boolean remove (Tetel_egy t){
		if (t.torolheto==true){
			tetelek.remove(t);
			return true;
	}
		LOGGER.warning("A megadott tétel nem törölhető!");
	return false;
	}
	
	/**
	 * Az összes tétel kilistázása.
	 */
	public void kiir(){
		for (Tetel_egy t : tetelek) {
			LOGGER.info(t.toString());
		}
	}
	
	/**
	 * A csak ki- vagy befizetések listázása.
	 * @param be_vagy_ki {@code boolean} értéket kap meg, amivel állítható, hogy csak a be- vagy kifizetéseket listázza ki. Ha false akkor csak a befizetések, ha true akkor a kifizetéseket listázza ki.
	 */
	public void kiir (boolean be_vagy_ki){
		for (Tetel_egy t : tetelek) {
			if(t.be_vagy_ki==be_vagy_ki){
				LOGGER.info(t.toString());
			}
		}
	}
}
