import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class p28test {
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
	public void testFind() throws Exception {
		assertEquals(101,c.find(5));
		
	}
	
}
