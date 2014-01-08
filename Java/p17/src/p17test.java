import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class p17test {
	Converter c;
	
	@Before
	public void runBeforeEveryTest() {
		c = new Converter();
	}

	@After
	public void runAfterEveryTest() {
		c = null;
	}

	@Test
	public void testConvert() {
	
		
		assertEquals("one", c.convert(1));
		assertEquals("two", c.convert(2));
		assertEquals("ten", c.convert(10));
		assertEquals("eleven", c.convert(11));
		
		assertEquals("twentyone", c.convert(21));
		assertEquals("fifty", c.convert(50));
		assertEquals("ninetynine", c.convert(99));
		
		assertEquals("one hundred", c.convert(100));
		assertEquals("one hundred and fifteen", c.convert(115));
		assertEquals("three hundred and fortytwo", c.convert(342));
		assertEquals("three hundred and forty", c.convert(340));
		
		assertEquals("one thousand", c.convert(1000));
//		assertEquals("one thousand and eleven", c.convert(1011)); //Non necessary
	}
	
	@Test
	public void testCount() throws Exception {
		assertEquals(3, c.count("one"));
		assertEquals(4, c.count("four "));
		assertEquals(20, c.count("one hundred and fifteen"));
		assertEquals(23, c.count("three hundred and fortytwo"));
	}
	
	@Test
	public void testSum() throws Exception {
		assertEquals(19, c.sum(5));
		assertEquals(11, c.sum(3));				
	}
}
