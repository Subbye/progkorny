package neptun;

import java.util.LinkedList;
import java.util.List;

/**A bankszámlaszámok egy listába való csoportosítását szolgálja. */
public class Szamlak_csoport {
	/** A lista amiben számlákat tároljuk, elemei {@link Szamla_egy} tipusúak.*/
	List<Szamla_egy> lista = new LinkedList<Szamla_egy>();
	
	/**
	 * Számlaszám hozzáadása a listához.
	 * @param s {@link Szamla_egy} típusú.
	 */
	void add(Szamla_egy s){
		lista.add(s);
	}
	
	/**
	 *Számlaszám törlése a listából.  
	 * @param s {@link Szamla_egy} típusú.
	 */
	void remove (Szamla_egy s){
		lista.remove(s);
	}
}