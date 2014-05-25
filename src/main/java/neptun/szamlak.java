package neptun;

import java.util.LinkedList;
import java.util.List;

/**A bankszámlaszámok egy listába való csoportosítását szolgálja */
public class szamlak {
	/** A lista amiben számlákat tároljuk, elemei {@link szamla} tipusúak*/
	List<szamla> lista = new LinkedList<szamla>();
	
	/**Számlaszám hozzáadása a listához. */
	void add(szamla s){
		lista.add(s);
	}
	
	/**Számlaszám törlése a listából. */
	void remove (szamla s){
		lista.remove(s);
	}
}
