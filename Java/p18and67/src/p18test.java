import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class p18test {
	PathCounter p;
	@Before
	public void runBeforeEveryTest() {
		p = new PathCounter();
	}

	@After
	public void runAfterEveryTest() {
		p = null;
	}

	@Test
	public void testLoadTriangle() throws Exception {
		p.load("mini.txt");
		assertEquals(3, p.matrix.get(0)[0]);
		assertEquals(7, p.matrix.get(1)[0]);
		assertEquals(4, p.matrix.get(1)[1]);
		assertEquals(9, p.matrix.get(3)[2]);
	}
	
	@Test
	public void testSumTriangle() throws Exception {
		p.load("mini.txt");
		assertEquals(23, p.sum());
		
		
		
	}
}

