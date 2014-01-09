import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class Calculator {
	
	Calculator() {
	}
	public String[] parts;
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		long sum = c.sumNames("names.txt");
		System.out.println("Length of names sorted and converted is " + sum);
	}
	
	
	public long sumNames(String file) {
		try {
			load(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long sum = 0;
		sort();
		for(int i = 0; i < parts.length; i++ ) {
			sum = sum + calculateName(parts[i])*(i+1);
		}
		System.out.println("Length of names sorted and converted is " + sum);
		return sum;
	}
    public void load(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
           
           parts = line.split(",");
           
           for (int i = 0; i < parts.length; i++) {
                    try {
                    	parts[i] = parts[i].replace("\"", "");
                    } catch (NumberFormatException nfe) {};
                }
        }
        br.close();
}
    
	public int calculateName(String name) {
		int sum = 0;
		for(int i = 0; i < name.length(); i++) {
			char character = name.charAt(i); 
			int ascii = (int) character; 
			int position = ascii - 64; //Minus position for A
			sum += position;
		}
		return sum;
	}

	public void sort() {
		 Arrays.sort(parts);
	}
}
