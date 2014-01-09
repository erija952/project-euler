import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class p22test {
	Calculator c;
	@Before
	public void runBeforeEveryTest() {
		c = new Calculator();
	}

	@After
	public void runAfterEveryTest() {
		c = null;
	}
	
	@Test
	public void testLoad() throws Exception {
		c.load("short.txt");
		assertArrayEquals(new String[] {"COLIN", "ERIK"}, c.parts);
	}
	
	@Test
	public void testSortArray() throws Exception {
		c.parts = new String[] {"FREDDY", "COLIN", "ERIK"};
		c.sort();
		assertArrayEquals(new String[] {"COLIN", "ERIK", "FREDDY"}, c.parts);
		
	}
	
	@Test
	public void testSumList() throws Exception {
		int colinNr = c.calculateName("COLIN");
		int erikNr = c.calculateName("ERIK");
		int freddyNr = c.calculateName("FREDDY");
		System.out.println("C" +  colinNr + " E " + erikNr + " F " + freddyNr);
		
		assertEquals(1*colinNr + 2*erikNr + 3*freddyNr, c.sumNames("three.txt"));
	}
	
	@Test
	public void testName() throws Exception {
		assertEquals(53, c.calculateName("COLIN"));
	}
}
