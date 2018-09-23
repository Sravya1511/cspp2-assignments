// import java.io.BufferedReader;
import java.io.File;
// import java.io.FileReader;
import java.io.IOException;
// import java.util.HashMap;
// import java.util.Hashtable;
// import java.util.Map;
import java.util.Scanner;
import java.util.NoSuchElementException;
// import java.io.*;


/**
 * Class for solution..
 */

final class Solution {
    /**
     * { function_description }.
     *
     * @param      args         The arguments
     *
     * @throws     IOException  { exception_description }
     */
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * { function_description }.
	 *
	 * @param      args         The arguments
	 *
	 * @throws     IOException  { exception_description }
	 */
	public static void main(final String[] args) throws IOException {
		double max = 0;
		int a = 0;
		int b = 0;
		StringMatching match = new StringMatching();
        Scanner input = new Scanner(System.in);
        try {
        	String x = input.nextLine();
        	File file = new File(x);
			File[] files = file.listFiles();
			System.out.print("      		");
			for (int i = 1; i <= files.length; i++) {
				System.out.print("File" + i + ".txt"
					+ "	");
			}
			System.out.println();

		    for (int i = 0; i < files.length; i++) {
		    	int h = i + 1;
                   System.out.print("File" + h + ".txt" + "	");
		    	for (int j = 0; j < files.length; j++) {
                        BagOfWords bags = new BagOfWords();
                        // StringMatching match = new StringMatching();
                        try {
                        Scanner s = new Scanner(files[i]);
		String line = s.useDelimiter("\\A").next();
		String[] tokens = line.toLowerCase().split(" ");
		    			bags.addDic1(tokens);
                        } catch (Exception e) {
                           System.out.print("NoFile          ");
                        }
                        try {
                        	Scanner s1 = new Scanner(files[j]);
		String line1 = s1.useDelimiter("\\A").next();
		    		    // match.str2(line1);
		    			String[] tokens1 =
		    			line1.toLowerCase().split(" ");
		    			bags.addDic2(tokens1);
                        } catch (Exception e) {
                        	System.out.print("NoFile");
                        }
                        if (bags.getDistance() != 0) {
                        double p = bags.getDistance();
		    			System.out.format("%.0f", p);
		    			System.out.print("		");
		    			if (p > max && i != j) {
		    				 a = i + 1;
		    				 b = j + 1;
		    				 max = p;
		    			    }
                        }
                    // match.compare();
		    	}
		    	System.out.println();
		    }
		    System.out.println("Maximum similarity is between "
		    	+ "File" + a
		    	+ ".txt and File" + b + ".txt");

        } catch (NoSuchElementException e) {
        	System.out.println("empty directory");
        }
    }

}

