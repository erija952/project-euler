import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class p21test {
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
	public void testFindProperDivisors() throws Exception {
		
		ArrayList<Integer> expected = new ArrayList<Integer>(
			    Arrays.asList(1,2,4,5,10,11,20,22,44,55,110));
		List<Integer> divisors = c.findDivisors(220);
		assertEquals(expected, divisors);
	}
	
	@Test
	public void testSumDivisors() throws Exception {
		ArrayList<Integer> divisors = new ArrayList<Integer>(
			    Arrays.asList(1,2,4,5,10,11,20,22,44,55,110));
		assertEquals(284, c.sumArrayList(divisors));
	}
	
//	@Test
//	public void testIsAmicable() throws Exception {
//		assertEquals(c.isAmicable(220,284), true);
//		assertEquals(c.isAmicable(220,284), false);
//	}
	
	@Test
	public void testGetAllProperDivisors() throws Exception {
		
		Map <Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		int max = 6;
		c.fillProperDivisors(max, map);
		assertEquals(new ArrayList<Integer>(Arrays.asList(1)), map.get(2));
		assertEquals(new ArrayList<Integer>(Arrays.asList(1)), map.get(3));
		assertEquals(new ArrayList<Integer>(Arrays.asList(1,2)), map.get(4));
		assertEquals(new ArrayList<Integer>(Arrays.asList(1)), map.get(5));
		assertEquals(new ArrayList<Integer>(Arrays.asList(1,2,3)), map.get(6));
	}
	
	@Test
	public void testFindAmicable() throws Exception {
		int max = 300;
		assertEquals(new ArrayList<Integer>(Arrays.asList(220,284)), c.findAmicable(max));
	}
}
