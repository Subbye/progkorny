package diak;
import static org.junit.Assert.*;
import org.junit.Test;

public class hallgatotest {

	private void assertHallgato(String expectedAzonosito, String expectedVezeteknev,
			String expectedKeresztnev, int expectedSzuletesi_ev,
			int expectedSzuletesi_ho, int expectedSzuletesi_nap, hallgato actual) {
		assertEquals(expectedAzonosito, actual.azonosito);
		assertEquals(expectedVezeteknev, actual.vezeteknev);
		assertEquals(expectedKeresztnev, actual.keresztnev);
		assertEquals(expectedSzuletesi_ev, actual.szuletesi_ev);
		assertEquals(expectedSzuletesi_ho, actual.szuletesi_ho);
		assertEquals(expectedSzuletesi_nap, actual.szuletesi_nap);
	}
	
	@Test
	public void testHallgato(){
		assertHallgato("ASD23D","Kovács", "Tamás", 1988, 02, 04, new hallgato("ASD23D", "Kovács", "Tamás", 1988, 02, 04));
		assertHallgato("ASD453","Tóth", "Tímea", 1985, 9, 20, new hallgato("ASD453", "Tóth", "Tímea", 1985, 9, 20));
	}
}