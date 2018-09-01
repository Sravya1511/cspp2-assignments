import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : 
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a, final int rows, final int columns) {

	// write your code here
        int[][] res;
        res = new int[rows][columns];
        for(int i = 0; i<a.length; i++) {
            for (int j = 0; j<a[i].length; j++) {
                if ((a[i][j]>0) && (a[i][j]<50)) {
                    res[i][j] = 0;
                }
                else if ((a[i][j]>=50) && (a[i][j]<=100)) {
                    res[i][j] = 100;
                }
                else if ((a[i][j]>100) && (a[i][j]<150)) {
                    res[i][j] = 100;
                }
                else if ((a[i][j]>=150) && (a[i][j]<=200)) {
                    res[i][j] = 200;
                }
                else if ((a[i][j]>200) && (a[i][j]<250)) {
                    res[i][j] = 200;
                }
                else if ((a[i][j]>=250) && (a[i][j]<=300)) {
                    res[i][j] = 300;
                }
                else if ((a[i][j]>300) && (a[i][j]<350)) {
                    res[i][j] = 300;
                }
                else if ((a[i][j]>=350) && (a[i][j]<=400)) {
                    res[i][j] = 400;
                }
                else if ((a[i][j]>400) && (a[i][j]<450)) {
                    res[i][j] = 400;
                }
                else if ((a[i][j]>=450) && (a[i][j]<=500)) {
                    res[i][j] = 500;
                }
                else if ((a[i][j]>500) && (a[i][j]<550)) {
                    res[i][j] = 500;
                }
                else if ((a[i][j]>=550) && (a[i][j]<=600)) {
                    res[i][j] = 600;
                }

            }
        }
        return res;
	
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
