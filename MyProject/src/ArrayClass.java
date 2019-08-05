import java.util.*;

public class ArrayClass {
	
	int[] inputArray;

	public void setArray() {
		inputArray = new int[10];
		Scanner in = new Scanner(System.in);
		for (int i = 0; i<10; i++){
		System.out.println("Enter the " + i + " number of array: ");
		inputArray[i] = in.nextInt();
		}
	}
	
	public void getArray() {
		for (int i = 0; i<10; i++){
		System.out.println("The " + i + " number of array is: " + inputArray[i]);
	    }
	}		
	
	public void sortArray() {
		int temp;
		for (int i = 0; i<10; i++){
			for (int j = 0; j<10; j++){
				if (inputArray[i] > inputArray[j]) {
					temp = inputArray[i];
					inputArray[i] = inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
	}
	
	public int powerArray (){
		int power;
		power = 0;
		for (int i = 0; i<10; i++){
			power = power + inputArray[i];
		}
		return power;
	}
		
}

