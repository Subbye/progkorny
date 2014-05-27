package neptun;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**Az osztály egy lista segítségével kezeli a hallgato számláit.*/
public class Tetelek_csoport {
	List<Tetel_egy> tetelek = new LinkedList<Tetel_egy>();
	private final static Logger LOGGER = Logger.getLogger("Teteleklogger");

	/**Számlaszám hozzáadása a listához. Paraméterként egy {@link Tetel_egy} elemet kap meg.*/
	void add(Tetel_egy t){
		tetelek.add(t);
	}
	
	/**Számlaszám törlése a listából.
	 * @param Paraméterként egy {@link Tetel_egy} elemet kap meg.
	 * @return Visszatérési értéke {@code boolean} a sikeresség függvényében.
	 * */
	boolean remove (Tetel_egy t){
		if (t.torolheto==true){
			tetelek.remove(t);
			return true;
	}
		LOGGER.warning("A megadott tétel nem törölhető!");
	return false;
	}
	
	/**Az össze tétel kilistázására szolgál.
	 * @param Nincs paramétere
	 * @return Nincs visszatérési értéke.*/
	void kiir(){
		for (Tetel_egy t : tetelek) {
			LOGGER.info(t.toString());
		}
	}
	
	/**A csak ki- vagy befizetések listázása.
	 * @param Paraméterkén egy {@code boolean} értéket kap meg, amivel állítható hogy csak a ki vagy be fizetéseket listázza ki.
	 * @return nincs visszatérési értéke. */
	void kiir (boolean be_vagy_ki){
		for (Tetel_egy t : tetelek) {
			if(t.be_vagy_ki==be_vagy_ki){
				LOGGER.info(t.toString());
			}
		}
	}
}
