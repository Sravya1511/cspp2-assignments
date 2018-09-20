import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.*;
import java.io.*;

class BagOfWords {
	Map<String, Integer> dictionary1 = new HashMap<String, Integer>();
	Map<String, Integer> dictionary2 = new HashMap<String, Integer>();
	Map<String, List<Integer>> dictionary3 = new HashMap<String, List<Integer>>();
	BagOfWords() {
	}

	public void addDic1(String[] list) {
        for(String i : list) {
         	if(dictionary1.containsKey(i)) {
         		int k = dictionary1.get(i);
         		dictionary1.put(i, k+1);
         	}
         	else {
         		dictionary1.put(i, 1);
         	}
        }
        // for(String key: dictionary1.keySet())
        // System.out.println(key+" "+dictionary1.get(key));
	}
	public void addDic2(String[] list) {
        for(String i : list) {
         	if(dictionary2.containsKey(i)) {
         		int k = dictionary2.get(i);
         		dictionary2.put(i, k+1);
         	}
         	else {
         		dictionary2.put(i, 1);
         	}
        }
        // for(String key: dictionary2.keySet())
        // System.out.println(key+" "+dictionary2.get(key));
	}

	public void getDistance() {
		float num = 0;
		float a = 0;
		double den = 0;
		double res;
		for(String i:dictionary1.keySet()){
			if(dictionary2.containsKey(i)) {
                num += dictionary1.get(i)*dictionary2.get(i);
			}
		}
		for(String i:dictionary1.keySet()) {
            a += Math.pow(dictionary1.get(i), 2);
		}
		float c = 0;
		for(String i:dictionary2.keySet()) {
            c += Math.pow(dictionary2.get(i), 2);
		}
		den = Math.sqrt(a)*Math.sqrt(c);
		res = (num/den)*100;
		System.out.format("%.0f",res);
		System.out.print("  ");
		}
}

class Solution {
	public static void main(String[] args) throws IOException {

		try {
			File file = new File("Test");
			File[] files = file.listFiles();
			System.out.print("     ");
			for(int i = 0; i<files.length; i++) {
				System.out.print(files[i]+"    ");
			}
			System.out.println();

		    for(int i = 0; i<files.length; i++) {

		    	for(int j = 0; j<files.length; j++) {
                        BagOfWords bags = new BagOfWords();
		    			Scanner s = new Scanner(files[i]);
		    			// System.out.println(files[i]);
		    			String line = s.useDelimiter("\\A").next();
		    			String[] tokens = line.toLowerCase().split(" ");
		    			// System.out.println(tokens);
		    			bags.addDic1(tokens);


		    			Scanner s1 = new Scanner(files[j]);
		    			// System.out.println(files[j]);
		    			String line1 = s1.useDelimiter("\\A").next();
		    			String[] tokens1 = line1.toLowerCase().split(" ");
		    			bags.addDic2(tokens1);

		    			bags.getDistance();
		    			// System.out.println(i+" "+j);
		    	}
		    	System.out.println();
		    }
		}
		catch(Exception e) {
			System.out.println("File not found");

		}


	}
}
  //       try {
		// 	File file2 = new File("input1.txt");
		// String inputLine2 = null;
		// BufferedReader reader2 = new BufferedReader(new FileReader(file2));
		// while((inputLine2 = reader2.readLine())!=null) {
  //            String[] words1 = inputLine2.toLowerCase().split(" ");
  //            bags.addDic2(words1);
		//     }
		// }
  //       catch(FileNotFoundException e) {
		// 	System.out.println("File not Found");
		// }
  // //Scanner input1 = new Scanner(files[i]);
		//     		String[] words1 = input1.nextLine().toLowerCase().split(" ");
		//     		System.out.println(words1);
		//     		bags.addDic1(words1);

		//     		Scanner input2 = new Scanner(files[j]);
		//     		String[] words2 = input2.nextLine().toLowerCase().split(" ");
		//     		bags.addDic2(words2);