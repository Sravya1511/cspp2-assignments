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

	public double getDistance() {
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
		//System.out.print("HHHHHH"+res);
        if (Double.isNaN(res)) {
        	return 0;
        }
        else {
        	return res;
        }
	}
}

class StringMatching {
	String l1;
	String l2;
	int len1;
	int len2;
	StringMatching() {

	}
	public void str1(String tokens) {
		l1 = tokens;
		len1 = tokens.length();
		System.out.println(len1);
	}
	public void str2(String tokens1) {
		l2 = tokens1;
		len2 = tokens1.length();
		System.out.println(len2);
	}
	 public void compare() {
	 	double total = len1+len2;
	 	double max = 0;
        for(int i = 0; i<l1.length(); i++) {
        	for(int j = 0; j<l2.length(); j++) {
        		int k = 0;
        		if(l1.charAt(i) == l2.charAt(j)) {
        			double c = 1;
        			while((k+i)<l1.length() && (k+j)<l2.length()) {
        				if(l1.charAt(i+k) == l2.charAt(j+k)) {
        					c++;
        					if(c>max) {
        						max = c;
        					}
        				}
        				else{
        					c = 0;
        					break;
        				}
        				k++;
        			}
        		}
        	}
        }
        System.out.println(max);
        double res = (max*2)/total;
        double res1 = res*100;
        System.out.println(res1);
	}
}

