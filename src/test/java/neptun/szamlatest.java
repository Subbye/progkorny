package neptun;
import static org.junit.Assert.*;

import org.junit.Test;


public class szamlatest {

	private void assertSzamla(long expectedSzamlaszam, int expectedOsszeg, String expectedTulajdonos_azonositoja, szamla actual) {
		assertEquals(expectedSzamlaszam, actual.szamlaszam);
		assertEquals(expectedOsszeg, actual.osszeg);
		assertEquals(expectedTulajdonos_azonositoja, actual.tulajdonos_azonositoja);
	}
	
	@Test
	public void testSzamla(){
		assertSzamla(1234567890, 8658, "ASD123", new szamla(1234567890, 8658, "ASD123"));
		assertSzamla(54452342, 861238, "ASDF342", new szamla(54452342, 861238, "ASDF342"));
	}
	
	@Test
	public void testVisszautal(){
		assertTrue(new szamla(12312312, 98765, "ASDF123").visszautal(5894));
	}
}
