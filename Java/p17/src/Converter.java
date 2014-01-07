import java.util.HashMap;
import java.util.Map;


public class Converter {
	Map <Integer, String> singleMap = new HashMap<Integer, String>();
	Map <Integer, String> teensMap = new HashMap<Integer, String>();
	Map <Integer, String> tensMap = new HashMap<Integer, String>();
	
	Converter() {
		singleMap.put(0, "zero");
		singleMap.put(1, "one");
		singleMap.put(2, "two");
		singleMap.put(3, "three");
		singleMap.put(4, "four");
		singleMap.put(5, "five");
		singleMap.put(6, "six");
		singleMap.put(7, "seven");
		singleMap.put(8, "eight");
		singleMap.put(9, "nine");	
		singleMap.put(10, "ten");
		
		teensMap.put(11, "eleven");
		teensMap.put(12, "twelve");
		teensMap.put(13, "thirteen");
		teensMap.put(14, "fourteen");
		teensMap.put(15, "fifteen");
		teensMap.put(16, "sixteen");
		teensMap.put(17, "seventeen");
		teensMap.put(18, "eighteen");
		teensMap.put(19, "nineteen");
		
		tensMap.put(20, "twenty");
		tensMap.put(30, "thirty");
		tensMap.put(40, "fourty");
		tensMap.put(50, "fifty");
		tensMap.put(60, "sixty");
		tensMap.put(70, "seventy");
		tensMap.put(80, "eighty");
		tensMap.put(90, "ninety");
	}
		
	public Object convert(int num) {
		
		int ones = num % 10;
		int tens = (num -ones) % 100;
		int hundreds = (num -tens -ones) % 1000;
		int thousands = (num - hundreds - tens -ones) % 10000;
		System.out.println("num " + num);
		System.out.println("ones " + ones + " tens " + tens + " hundreds " + hundreds + " thousands " + thousands);

		if(num > 10  ) {
			return teensMap.get(num);
		}
		else
		{
			return singleMap.get(num);
		}

	}

}
