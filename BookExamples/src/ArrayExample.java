import java.util.Iterator;
import java.util.Arrays;

public class ArrayExample {
	
	public static void main(String[] args) {
		/*
		for (String str: args) {
			System.out.println(str);
		}
		int newNum;
		int[] myIntArray = new int[10];
		boolean equal = false;
		for(int i=0; i<myIntArray.length;i++) {
			newNum = (int)(Math.random()*100);
			for (int j=0;j<i;j++) {
				if (myIntArray[j] == newNum) {
					equal = true;
					System.out.println("Equal find! " + i + " " + newNum + " " + myIntArray[j]);
					j = i;
				} else {
					equal = false;
				} 
			}
			System.out.println(equal);
			if (equal == false) myIntArray[i] = newNum;
			else i--;
		}
		for(int l : myIntArray) {
			System.out.print(l + " ");
		}
		
	/*	int[] myInt = {1,2,3,4,5};
		for(int l : myInt) {
			System.out.println(l);
		}
		int[] copyMyInt;// = myInt;
		copyMyInt = myInt.clone();
		myInt[2] = 10;
		for(int l : myInt) {
			System.out.printf("%2d ", l);
		}
		System.out.println("");
		for(int l : copyMyInt) {
			System.out.printf("%2d ", l);
		}
	*/	
	/*	int[][] myArray = new int[5][5];
		
		for(int i=0; i<myArray.length;i++) {
			for(int j=0; j<myArray[i].length;j++) {
				myArray[i][j] = (int)(Math.random()*100);	
			}
		}
		
		for(int[] row: myArray) {
			System.out.println(row + " ");
			for(int value: row){
				System.out.println(value);
			}
		}
		
		System.out.println(Arrays.deepToString(myArray));
		*/
		
		final int HEAD_COL = 10;
		final int BODY_COL = 10;
		final int NUM_ROWS = 5;
		
		final double START_RATE = 10;
		
		double[] rates = new double[HEAD_COL];
		for(int j=0;j<rates.length;j++) {
			rates[j] = (START_RATE + j)/100;
		}

		final double start = 10000;
		
		double balance[][] = new double[NUM_ROWS][BODY_COL];
		for(int i=0; i<balance.length;i++) {
			for(int j=0;j<balance[i].length;j++) {
				balance[i][j] = start * (i+1) + (start * (i+1) * rates[j]);
			}
		}

		for(double d : rates) {
			System.out.printf("%9.0f%%", 100 * d);
		}
		System.out.println();
		for(double[]row : balance) {
			for(double element : row) {
				System.out.printf("%10.2f", element);
			}
			System.out.println();
		}
		
		double[] temp = balance[1];
		balance[2] = new double[] {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.1,9.3,10.0};
		System.out.println(Arrays.deepToString(balance));		
		
		final int NMAX = 10;
		int[][] ar = new int[NMAX+1][];
		System.out.println(Arrays.deepToString(ar));
		for(int l=0;l<=NMAX;l++) {
			ar[l] = new int[NMAX-l+1];
		}
		
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[i].length;j++) {
				int lot = 1;
				for(int x=1;x<=j;x++){
					lot = lot * (i-x+1)/x;
				}
				ar[i][j]=lot;
			}
		}
		
		for(int[] rows : ar){
			for(int el : rows){
				System.out.printf("%4d",el);
			}
			System.out.println();
		}

	}

}
