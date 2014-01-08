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
		
		teensMap.put(10, "ten");		
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
		tensMap.put(40, "forty");
		tensMap.put(50, "fifty");
		tensMap.put(60, "sixty");
		tensMap.put(70, "seventy");
		tensMap.put(80, "eighty");
		tensMap.put(90, "ninety");
	}
		
	public String convert(int num) {

		int modnum = 0;
		int ones = num % 10;
		int tens = (num -ones) % 100;
		int hundreds = (num -tens -ones) % 1000 / 100;
		int thousands = (num - hundreds - tens -ones) % 10000 / 1000;

		String nr = "";
		
		if(thousands > 0) {
			nr += singleMap.get(thousands);
			nr += " thousand";
		}
		
		if(hundreds > 0) {
			nr += singleMap.get(hundreds);
			nr += " hundred";
			if( tens > 0 || ones > 0) {
				nr += " and ";
			}
		}				
		
		if(tens >= 20) {
			nr += tensMap.get(tens);
		} else 
		if(tens == 10)
		{
			modnum = num - hundreds*100;
			nr += teensMap.get(modnum);
		}	
		
		if(ones > 0  && tens != 10) {
			nr += singleMap.get(ones);
		}
		
		return nr;
	}

	public int count(String string) {
		String myString = "";
		myString  = string.replaceAll(" ", "");
		return myString.length();
	}

	public int sum(int maxnum) {
		int sum = 0;
		for(int i = 1; i <= maxnum; i++) 
		{
			sum += count(convert(i));
		}
		return sum;
	}

	public static void main(String[] args) {
		Converter c = new Converter();
		int maxnum = 1000;
		int result = c.sum(maxnum);
		System.out.println("Sum of letters from 1 to " + maxnum + " was " + result);
		
	}
}
