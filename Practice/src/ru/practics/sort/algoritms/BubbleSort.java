package ru.practics.sort.algoritms;

public class BubbleSort {

	public static Integer[] sort(Integer[] array) {
		Integer tmp = 0;
		for(int i=array.length;i>0;i--) {
			for(int j=1;j<array.length;j++) {
				if(array[j] < array[j-1]) {
					tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
				}
			}
		}
		return array;
	}

}
