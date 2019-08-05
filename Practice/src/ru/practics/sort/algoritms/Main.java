package ru.practics.sort.algoritms;

public class Main {
	
	public static void main(String[] args) {
		Integer[] array = {4,2,3,5,1,7,9,8,10,6};
		for(Integer i: array) {
			System.out.print(i + " ");
		}
/*		System.out.println();
		for(Integer i: BubbleSort.sort(array)) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(Integer i: SelectSort.sort(array)) {
			System.out.print(i + " ");
		}*/
		System.out.println();
		for(Integer i: InsertSort.sort(array)) {
			System.out.print(i + " ");
		}
	}

}
