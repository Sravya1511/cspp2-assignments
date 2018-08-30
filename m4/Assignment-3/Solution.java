
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		for(int i=0;i<=n;i++){
			String s=sc.nextLine();
			binaryToDecimal(s);//Write binaryToDecimal function
			// System.out.println(res);
		}
	}
	static void binaryToDecimal(String s) {
		
	  double sum =  0;
      int count = 0;
      for(int i=s.length()-1; i>=0 ;i--) {
        char ch = s.charAt(i);
        // System.out.println("Character at "+i+" Position: "+ch);
        int x = Character.getNumericValue(ch);
        // System.out.println(x);
        sum = sum+(x*Math.pow(2,count));
        count++;
      } 
      System.out.format("%.0f", sum);
	}
}


