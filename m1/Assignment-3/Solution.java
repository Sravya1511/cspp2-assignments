import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
      
		Scanner scan = new Scanner(System.in);
		double degreesCelsius = scan.nextDouble();
		calculateFromDegreesToFarenheit(degreesCelsius);
	}

	static void calculateFromDegreesToFarenheit(double degreesCelsius) {
		double fahren;
		fahren = (degreesCelsius * 9/5) + 32;
	    System.out.println(fahren);  

		 		
	}
	/*
	Need to fill the calculateFromDegreesToFarenheit function and print the output
	of fahrenheit.
	*/
}