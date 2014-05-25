package neptun;

/**A különböző be és kifizetési tételek letárolására szolgál.*/
public class tetel {
	String leiras;
	int osszeg;
	String allapot;
	boolean torolheto;
	boolean be_vagy_ki;
	
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
	
	/**Tétel teljesítése egy számláról*/
	boolean befizet(szamla sz){
		if(osszeg<sz.osszeg){
			sz.osszeg-=osszeg;
			allapot="Teljesített";
			System.out.println("A tétel befizetése sikeres");
			return true;
		}
		System.out.println("Nincs elegendő összeg a számlán");
		return false;
	}
	
	/**Tétel teljesítése több számláról.*/
	boolean befizet(szamlak sz){
		int temp=0;
		for(szamla szam: sz.lista){
			temp+=szam.osszeg;
		}
		if(temp>osszeg){
			for(szamla szam: sz.lista){
				if(szam.osszeg>osszeg){
					szam.osszeg-=osszeg;
					System.out.println("A tétel bifizetése sikeres!");
					return true;
				}else{
					osszeg-=szam.osszeg;
					szam.osszeg=0;
				}
			}
		}
		System.out.println("Nincs elegendő összeg a számlákon!");
		return false;
	}
}
