package neptun;
import static org.junit.Assert.*;

import org.junit.Test;

public class Teteltest {

	private void assertTetel(String expectedLeiras, int expectedOsszeg, String expectedAllapot, boolean expectedTorolheto,
			boolean expectedBe_vagy_ki, Tetel_egy actual) {
		assertEquals(expectedLeiras, actual.leiras);
		assertEquals(expectedOsszeg, actual.osszeg);
		assertEquals(expectedAllapot, actual.allapot);
		assertEquals(expectedTorolheto, actual.torolheto);
		assertEquals(expectedBe_vagy_ki, actual.be_vagy_ki);
	}
	
	@Test
	public void testTetel(){
		assertTetel("Késedelmi díj", 5000, "Teljesített", false, false, new Tetel_egy("Késedelmi díj", 5000, "Teljesített", false, false));
		assertTetel("Ösztöndíj", 3000, "Elutalt", false, true, new Tetel_egy("Ösztöndíj", 3000, "Elutalt", false, true));
	}
	
	@Test
	public void testBefizet(){
		assertTrue(new Tetel_egy("Nem teljesített kredit", 7500, "Aktív", false, false).befizet(new Szamla_egy(123134, 25000, "A34SDF")));
		assertFalse(new Tetel_egy("Nem teljesített kredit", 7500, "Aktív", false, false).befizet(new Szamla_egy(468134, 250, "PO34SDF")));
		assertFalse(new Tetel_egy("Nem teljesített kredit", 7500, "Teljesített", false, false).befizet(new Szamla_egy(123134, 25000, "A34SDF")));
	}
	
	@Test
	public void testBefizetSzamlakrol(){
		Szamlak_csoport test = new Szamlak_csoport();
		test.add(new Szamla_egy(123134, 25000, "A34SDF"));
		test.add(new Szamla_egy(8516, 2000, "A34SDF"));
		assertTrue(new Tetel_egy("Nem teljesített kredit", 7500, "Aktív", false, false).befizet(test));
		assertFalse(new Tetel_egy("Nem teljesített kredit", 7500, "Teljesített", false, false).befizet(test));
		assertFalse(new Tetel_egy("Nem teljesített kredit", 75000, "Aktív", false, false).befizet(test));
	}
	
}
