package neptun;

/** A bankszámlaszám tárolására létrehozott osztály */
public class szamla {
	/** A bankszámla számlaszáma*/
	String szamlaszam;
	/** A számlaszámon szereplő összeg*/	
	int osszeg;
	/** A tulajdonos neptun azonosítója*/
	String tulajdonos_azonositoja;
	
	public szamla(String szamlaszam, int osszeg, String tulajdonos_azonositoja) {
		super();
		this.szamlaszam = szamlaszam;
		this.osszeg = osszeg;
		this.tulajdonos_azonositoja = tulajdonos_azonositoja;
	}

	@Override
	public String toString() {
		return "szamla [szamlaszam=" + szamlaszam + ", osszeg=" + osszeg
				+ ", tulajdonos_azonositoja=" + tulajdonos_azonositoja + "]";
	}
	
	/** a gyüjtőszámláról való visszautalás kezelése*/
	boolean visszautal(int vissza){
		if(osszeg>vissza){
			osszeg-=vissza;
			System.out.println("Sikerült a visszautalás a gyüjtőszámláról");
			return true;
		}
		System.out.println("A visszautalni kívánt összeg nem haladhatja meg a számlán levő összeget.");
		return false;
	}
}
