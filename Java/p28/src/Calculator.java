
public class Calculator {
	
	Calculator() {
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		System.out.println(c.find(1001));
	}
	
	public int find(int size) {
		int required_steps = (size -1) / 2;
		int sum = 1;
		int previous = 1;
		for(int step = 1; step <= required_steps; step++) {
			for(int corner = 1; corner <=4 ; corner++) {
				int cornerval = previous + (2*step);
				sum += cornerval;
				previous = cornerval;
			}
			 
		}
		return sum;
	}
}
