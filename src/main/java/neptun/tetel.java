package neptun;

import java.util.logging.Logger;

/**A különböző be és kifizetési tételek letárolására szolgál.*/
public class tetel {
	String leiras;
	int osszeg;
	String allapot;
	boolean torolheto;
	boolean be_vagy_ki;
	private final static Logger LOGGER = Logger.getLogger("Tetellogger");
	
	public tetel(String leiras, int osszeg, String allapot, boolean torolheto,
			boolean be_vagy_ki) {
		super();
		this.leiras = leiras;
		this.osszeg = osszeg;
		this.allapot = allapot;
		this.torolheto = torolheto;
		this.be_vagy_ki = be_vagy_ki;
	}

	@Override
	public String toString() {
		return "tetel [leiras=" + leiras + ", osszeg=" + osszeg + ", allapot="
				+ allapot + ", torolheto=" + torolheto + ", be_vagy_ki="
				+ be_vagy_ki + "]";
	} 
	
	/**Tétel teljesítése egy számláról.
	 * @param Paraméterként egy {@link szamla} típust kap, erről a számláról vonja le az összeget.
	 * @return Visszatérési értéke {@code boolean} a sikeresség függvényében.
	 * */
	boolean befizet(szamla sz){
		if(allapot.equals("Teljesített")){
			LOGGER.warning("A tétel már teljesítve van");
			return false;
		}
		if(osszeg<sz.osszeg){
			sz.osszeg-=osszeg;
			allapot="Teljesített";
			LOGGER.info("A tétel befizetése sikeres");
			return true;
		}
		LOGGER.warning("Nincs elegendő összeg a számlán");
		return false;
	}
	
	/**Tétel teljesítése több számláról.
	 * @param Paraméterként egy {@link szamlak} típust kap meg, ami {@link szamla} típusú elemeket tartalmazó lista.
	 * @return Visszatérésként {@code boolean} értéked ad a sikeresség függvényében.
	 * */
	boolean befizet(szamlak sz){
		int temp=0;
		for(szamla szam: sz.lista){
			temp+=szam.osszeg;
		}
		if(temp>osszeg){
			for(szamla szam: sz.lista){
				if(szam.osszeg>osszeg){
					szam.osszeg-=osszeg;
					LOGGER.info("A tétel bifizetése sikeres!");
					return true;
				}else{
					osszeg-=szam.osszeg;
					szam.osszeg=0;
				}
			}
		}
		LOGGER.warning("Nincs elegendő összeg a számlákon!");
		return false;
	}
}