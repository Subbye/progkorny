package neptun;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**Az osztály egy lista segítségével kezeli a hallgato számláit.*/
public class tetelek {
	List<tetel> tetelek = new LinkedList<tetel>();
	private final static Logger LOGGER = Logger.getLogger("Teteleklogger");

	/**Számlaszám hozzáadása a listához. Paraméterként egy {@link tetel} elemet kap meg.*/
	void add(tetel t){
		tetelek.add(t);
	}
	
	/**Számlaszám törlése a listából.
	 * @param Paraméterként egy {@link tetel} elemet kap meg.
	 * @return Visszatérési értéke {@code boolean} a sikeresség függvényében.
	 * */
	boolean remove (tetel t){
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
		for (tetel t : tetelek) {
			LOGGER.info(t.toString());
		}
	}
	
	/**A csak ki- vagy befizetések listázása.
	 * @param Paraméterkén egy {@code boolean} értéket kap meg, amivel állítható hogy csak a ki vagy be fizetéseket listázza ki.
	 * @return nincs visszatérési értéke. */
	void kiir (boolean be_vagy_ki){
		for (tetel t : tetelek) {
			if(t.be_vagy_ki==be_vagy_ki){
				LOGGER.info(t.toString());
			}
		}
	}
}
