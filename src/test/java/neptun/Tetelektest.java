package neptun;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Tetelektest {
	@Test
	public void testSzamlakAdd(){
		Tetelek_csoport tetelek = new Tetelek_csoport();
		Tetel_egy egy = new Tetel_egy("Ösztöndíj", 3000, "Aktív", false, true);
		Tetel_egy ketto = new Tetel_egy("Valami", 8000, "Aktív", true, false);
		tetelek.add(egy);
		tetelek.add(ketto);
		assertTrue(tetelek.remove(ketto));
		assertFalse(tetelek.remove(egy));
	}
}
