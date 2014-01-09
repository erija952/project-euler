import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
	
	Calculator() {
	}
		
	public static void main(String[] args) {
		Calculator c = new Calculator();
		int max = 10000;
		ArrayList<Integer> amicable = c.findAmicable(max);
		int sumofAmicable = c.sumArrayList(amicable);
		System.out.println("Sum of amicable numbers below " + max + " is " + sumofAmicable);
		
	}

	public ArrayList<Integer> findDivisors(int num) {
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		if(num == 1) {
			return new ArrayList<Integer>(Arrays.asList(1));
		}
		
		for(int i = 1; i < num ; i++) {
			if( num % i == 0) {
				divisors.add(i);				
			}
		}
		
		return divisors;
	}

	public int sumArrayList(ArrayList<Integer> divisors) {
		int sum = 0;
		for(int i = 0; i < divisors.size(); i++) {
			sum += divisors.get(i);
		}
		return sum;
	}

//	public boolean isAmicable(int i, int j) {
//		return null;
//	}

	public void fillProperDivisors(int max, Map<Integer, ArrayList<Integer>> map) {
		for(int i = 2; i <=max; i++) {
			map.put(i, findDivisors(i));
		}
	}

	public ArrayList<Integer> findAmicable(int max) {
		ArrayList<Integer> amicable = new ArrayList<Integer>();
		Map <Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		fillProperDivisors(max, map);
		for(int a = 2; a < max ; a++) {
			if(map.containsKey(a)) {
				int b = sumArrayList(map.get(a));
				if(map.containsKey(b)) {
					int db = sumArrayList(map.get(b));
					if(a != b && db == a) {
						System.out.println("Found amicable a " + a +  " b " + b);
						amicable.add(a);
						amicable.add(b);

						map.remove(a);
						map.remove(b);
					}

				}
			}
		}
			
		return amicable;
	}
}
