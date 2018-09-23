import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.*;
import java.io.*;


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
		// System.out.println(len1);
	}
	public void str2(String tokens1) {
		l2 = tokens1;
		len2 = tokens1.length();
		// System.out.println(len2);
	}
	 public double compare() {
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
        // System.out.println(max);
        double res = (max*2)/total;
        double res1 = res*100;
        return Math.round(res1);
	}
}
