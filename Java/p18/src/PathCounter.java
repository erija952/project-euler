import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class PathCounter {

	public static void main(String[] args) throws IOException {
		PathCounter p = new PathCounter();
		p.load("p18.txt");
		int result = p.sum();
		System.out.println("Max path length was " + result);
		
	}

	List<int[]> matrix = new ArrayList<int[]>();

	public void load(String file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {
		   
		   String[] parts = line.split(" ");
		   int[] intarray = new int[parts.length];
		   
		   for (int i = 0; i < parts.length; i++) {
			    try {
			        intarray[i] = Integer.parseInt(parts[i]);
			    } catch (NumberFormatException nfe) {};
			}
		   matrix.add(intarray);
		}
		br.close();
		
	}

	public int sum() {
		int nrLines = matrix.size();
		System.out.println("nrlines " + nrLines);
		for(int lineNr = nrLines-2; lineNr >= 0; lineNr--) { //Lines are zero indexed in matrix
			
			int[] lineArray = matrix.get(lineNr);
			int[] nextLine = matrix.get(lineNr+1);
			for(int i = 0; i < lineArray.length; i++) {
				int tmp = lineArray[i] + Math.max(nextLine[i], nextLine[i+1]);
//				System.out.println("lineNr " + lineNr + " of length " + lineArray.length + " val" + lineArray[i] + " next line[i] " + nextLine[i] + " next line[i+ 1] " + nextLine[i+1] + "newval" + tmp);
				lineArray[i] = lineArray[i] + Math.max(nextLine[i], nextLine[i+1]);				
			}
			matrix.set(lineNr, lineArray);
			
			for(int j = 0; j < nrLines -1; j++) {
				System.out.println();
				int[] line = matrix.get(j);
				System.out.println(Arrays.toString(line));
			}
		}
		
		return matrix.get(0)[0];
	}
	
	
}



