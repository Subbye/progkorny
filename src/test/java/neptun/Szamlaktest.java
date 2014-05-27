package neptun;
import static org.junit.Assert.*;

import org.junit.Test;

public class Szamlaktest {
	
	@Test
	public void testSzamlakAdd(){
		Szamlak_csoport test = new Szamlak_csoport();
		test.add(new Szamla_egy(123134, 25000, "A34SDF"));
		test.add(new Szamla_egy(8516, 2000, "A34SDF"));
		assertFalse(test.add(new Szamla_egy(123134, 12000, "A34SDF")));
		assertFalse(test.add(new Szamla_egy(234324, 2000, "XX34")));
	}
	@Test
	public void testSzamlakRemove(){
		Szamlak_csoport test = new Szamlak_csoport();
		test.add(new Szamla_egy(123134, 25000, "A34SDF"));
		test.add(new Szamla_egy(8516, 2000, "A34SDF"));
		assertTrue(test.remove(new Szamla_egy(123134, 25000, "A34SDF")));
		assertFalse(test.remove(new Szamla_egy(56456, 25000, "A34SDF")));
	}
}
