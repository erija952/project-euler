import java.io.IOException;
import java.util.Arrays;

public class Calculator {
	
	Calculator() {
	}
		
	public static void main(String[] args) {
		Calculator c = new Calculator();
		int squaresize = 20;
		long[][] square = c.calc(squaresize);
		System.out.println("Number of paths in square " + squaresize + " is " + square[squaresize-1][squaresize-1] );
	}

	public long[][] calc(int squaresize) {
		long[][] square = new long[squaresize][squaresize];
		
		//First row
		for(int i = 0; i < squaresize; i++) {
			square[0][i] = i+2;
		}
		
		//First col
		for(int i = 0; i < squaresize; i++) {
			square[i][0] = i+2;
		}
		//Rest
		for(int i = 1; i < squaresize; i++) { // row
			for(int j = 1 ; j < squaresize ; j++)  {//col
				square[i][j] = square[i-1][j] + square[i][j-1];
			}
		}
		
		return square;
	}

}
