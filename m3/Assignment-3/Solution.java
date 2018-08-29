import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        gcd(n1,n2);
        System.out.println(gcd(n1, n2));
    }
    /*
	Need to write the gcd function and print the output.
	*/
	static int gcd(int n1, int n2) {
		while(n2 != 0) { 
			int r = n1%n2;
			if (r == 0)
				return n2;
			else {
				n1 = n2;
				n2 = r;
			}
		}
		return n2;
	}

}
