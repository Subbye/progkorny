package neptun;

import java.util.logging.Logger;

/**A különböző be és kifizetési tételek letárolására szolgál.*/
public class Tetel_egy {
	/**
	 * A be- vagy kifizetési kötelezettség megnevezése. pl. késedelmi díj, nem teljesített kredit.
	 */
	String leiras;
	/**
	 * A be- vagy kifizetési kötelezettség összege.
	 */
	int osszeg;
	/**
	 * A be- vagy kifizetési kötelezettség állapota. pl. teljesített, aktív.
	 */
	String allapot;
	/**
	 * A be- vagy kifizetési kötelezettség törölhető-e, vagyis felhasználó hozta létra, vagy admin.
	 */
	boolean torolheto;
	/**
	 * A be- vagy kifizetési kötelezettés iránya, vagyis be- vagy kifizetés. Ha be akkor false értéket kap, ha ki akkor true értéket kap.
	 */
	boolean be_vagy_ki;
	/**
	 * A Loggert példányosítása, ebbe kerülnek a program futása közben kiírandó szövegek.
	 */
	private final static Logger LOGGER = Logger.getLogger("Tetellogger");
	/**
	 * Egy ki- vagy befizetéshez tartozó konstruktor.
	 * @param leiras	(A tétel leírása pl. késedlmi díj, nem teljesített kredit)
	 * @param osszeg	(A teljesítés/kifizetés összege)
	 * @param allapot	(A tétel állapota pl. Aktív, Teljesített)
	 * @param torolheto	(Törölhető-e, azaz felhasználó hozta létre, vagy adminként lett kiírva)
	 * @param be_vagy_ki	(Be vagy kifizetés az adott tétel. 0 esetén be, 1 esetén kifizetés.)
	 */
	public Tetel_egy(String leiras, int osszeg, String allapot, boolean torolheto,
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
	
	/**
	 * Tétel teljesítése egy számláról.
	 * @param sz {@link neptun.Szamla_egy Szamla_egy} típusú, erről a számláról vonja majd le az összeget.
	 * @return {@code boolean} értékkel tér vissza a sikeresség függvényében
	 * @since version 1.00
	 */
	public boolean befizet(Szamla_egy sz){
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
	
	/**
	 * Tétel teljesítése több számláról.
	 * @param sz {@link neptun.Szamlak_csoport Szamlak_csoport} típust kap meg, ami {@link neptun.Szamla_egy Szamla_egy} típusú elemeket tartalmazó lista.
	 * @return {@code boolean} értékkel tér vissza a sikeresség függvényében
	 * @since version 1.00
	 */
	public boolean befizet(Szamlak_csoport sz){
		int temp=0;
		if(allapot.equals("Teljesített")){
			LOGGER.warning("A tétel már teljesítve van");
			return false;
		}
		for(Szamla_egy szam: sz.lista){
			temp+=szam.osszeg;
		}
		if(temp>osszeg){
			for(Szamla_egy szam: sz.lista){
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
