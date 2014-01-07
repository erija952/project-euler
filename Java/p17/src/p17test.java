import static org.junit.Assert.*;

import org.junit.Test;

public class p17test {

	@Test
	public void testConvert() {
		Converter c = new Converter();
		assertEquals(c.convert(1), "one");
		assertEquals(c.convert(2), "two");
		assertEquals(c.convert(11), "eleven");
		
		assertEquals(c.convert(21), "twentyone");
	}
}
