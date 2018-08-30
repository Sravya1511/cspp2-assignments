import java.util.*;
public class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	public static void main(String[] args) {
		
		// System.out.println("Enter size of array 1");
		Scanner input = new Scanner(System.in);
		int r1 = input.nextInt();
		int c1 = input.nextInt();
		int arr1[][];
		arr1 = new int[r1][c1];
		for (int i = 0; i<arr1.length; i++)
			for (int j = 0; j<arr1[i].length; j++)
				arr1[i][j] = input.nextInt();
		// System.out.println(Arrays.toString(arr1));
		// System.out.println("Enter size of array 2");
		int r2 = input.nextInt();
		int c2 = input.nextInt();
		int arr2[][];
		arr2 = new int[r2][c2];
		for (int i = 0; i<arr2.length; i++)
			for (int j = 0; j<arr2[i].length; j++)
				arr2[i][j] = input.nextInt();

		if ((r1!=r2) || (c1!=c2)) {
			System.out.println("not possible");
		}
		int arr3[][];
		arr3 = new int[r1][c1];
		for (int i = 0; i<arr1.length; i++) {
			for (int j = 0; j<arr1[i].length; j++){
				arr3[i][j] = arr1[i][j] + arr2[i][j];
				System.out.print(arr3[i][j]+" ");
			}
            System.out.println();
		}
			



        
		

		// arr = new int[size];
		// System.out.println("Enter array elements");
		// for (int i=0; i<arr.length; i++) {

		// 	arr[i] = input.nextInt();
		// }
		
	}
}