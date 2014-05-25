package neptun;

import java.util.LinkedList;
import java.util.List;

/**Az osztály egy lista segítségével kezeli a hallgato számláit.*/
public class tetelek {
	List<tetel> tetelek = new LinkedList<tetel>();

	/**Számlaszám hozzáadása a listához. */
	void add(tetel t){
		tetelek.add(t);
	}
	
	/**Számlaszám törlése a listából, ha lehetséges akkor true visszatéréssel, ha nem lehetséges akkor false visszatérés + üzenet.*/
	boolean remove (tetel t){
		if (t.torolheto==true){
			tetelek.remove(t);
			return true;
	}
	System.out.println("A megadott tétel nem törölhető!");
	return false;
	}
	
	/**Az össze tétel kilistázására szolgál. */
	void kiir(){
		for (tetel t : tetelek) {
			System.out.println(t);
		}
	}
	
	/**A csak ki- vagy befizetések listázása.*/
	void kiir (boolean be_vagy_ki){
		for (tetel t : tetelek) {
			if(t.be_vagy_ki==be_vagy_ki){
				System.out.println(t);
			}
		}
	}
}
