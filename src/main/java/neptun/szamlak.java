package neptun;

import java.util.LinkedList;
import java.util.List;

/**A bankszámlaszámok egy listába való csoportosítását szolgálja */
public class szamlak {
	/** A lista amiben számlákat tároljuk, elemei {@link Szamla} tipusúak*/
	List<Szamla> lista = new LinkedList<Szamla>();
	
	/**Számlaszám hozzáadása a listához. Paraméterként egy {@link Szamla} típust kap meg, amit hozzáfűz a listához.*/
	void add(Szamla s){
		lista.add(s);
	}
	
	/**Számlaszám törlése a listából. Paraméterként egy {@link Szamla} típust kap meg. */
	void remove (Szamla s){
		lista.remove(s);
	}
}
