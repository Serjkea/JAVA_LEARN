import java.util.Scanner;


public class Example {

	public static int[] changeElement (int[] array, int elementNumber) {
		array[elementNumber] = array[elementNumber] + (int)(array[elementNumber]*0.1);
		return array;
	}
	
	public static void main(String[] args) {
		int[] A = {10,20,30,40,50};
		int changeNumber = 0;
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		System.out.print("Enter the number of element to change: ");
		Scanner sc = new Scanner(System.in);
		changeNumber = sc.nextInt();
		A = changeElement(A,--changeNumber);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		
	}

}
