
public class Array {
	private int[] array;
	private int pos = 0;
	
	Array(int max) {
		array = new int[max];
	}
	
	public void add(int val) {
		if (pos <= array.length) {
			array[pos] = val;
			pos++;
			}
		else System.out.println("Array is full!");
	}
	
	public void show() {
		for (int i = 0; i < (array.length); i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public void bubbleSort() {
		int tmp;
		System.out.println("Bubble sort:");
		for (int j = 0; j < (array.length - 1); j++){
		for (int i = 1; i < (array.length - 1); i++){
			if (array[i] > array[i+1]) {
				tmp = array[i+1];
				array[i+1] = array[i];
				array[i] = tmp;
			}
		}
		}
		
	}
	
	public void selectSort() {
		int tmp;
		int min;
		System.out.println("Select sort:");
		for (int i = 0; i < (array.length-1 );i++){
			min = i;
			for (int j = i+1; j < (array.length ); j++){
				if (array[min] > array[j]) {
					min = j;
				} 
			}
			tmp = array[min];
			array[min] = array[i];
			array[i] = tmp;
		}
	}
	
	public void insertSort() {
		int tmp;
		int j;
		System.out.println("Insertion sort:");
		for (int i = 0; i < (array.length); i++){
			tmp = array[i];
			j = i;
			while (j>0 && array[j-1] >= tmp) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = tmp;
			show();
		}
	}
	
	

}
