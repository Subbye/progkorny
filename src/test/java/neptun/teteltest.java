package neptun;
import static org.junit.Assert.*;

import org.junit.Test;

public class teteltest {

	private void assertTetel(String expectedLeiras, int expectedOsszeg, String expectedAllapot, boolean expectedTorolheto,
			boolean expectedBe_vagy_ki, tetel actual) {
		assertEquals(expectedLeiras, actual.leiras);
		assertEquals(expectedOsszeg, actual.osszeg);
		assertEquals(expectedAllapot, actual.allapot);
		assertEquals(expectedTorolheto, actual.torolheto);
		assertEquals(expectedBe_vagy_ki, actual.be_vagy_ki);
	}
	
	@Test
	public void testTetel(){
		assertTetel("Késedelmi díj", 5000, "Teljesített", false, false, new tetel("Késedelmi díj", 5000, "Teljesített", false, false));
		assertTetel("Ösztöndíj", 3000, "Elutalt", false, true, new tetel("Ösztöndíj", 3000, "Elutalt", false, true));
	}
	
	@Test
	public void testBefizet(){
		assertTrue(new tetel("Nem teljesített kredit", 7500, "Aktív", false, false).befizet(new Szamla(123134, 25000, "A34SDF")));
	}
}
