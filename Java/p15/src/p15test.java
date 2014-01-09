import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class p15test {
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
	public void test2square() throws Exception {
		int squaresize = 4;
		long[][] square = c.calc(squaresize);
		assertArrayEquals(new long[] {2,3,4,5}, square[0] );
		assertArrayEquals(new long[] {3,6,10,15}, square[1] );
		assertArrayEquals(new long[] {4,10,20, 35}, square[2] );
		assertArrayEquals(new long[] {5,15,35, 70}, square[3] );
		
		System.out.println("Number of paths in square " + squaresize + " is " + square[squaresize-1][squaresize-1] );
	}
	
}
