package ru.practics.sort.algoritms;

public class SelectSort {
	
	public static Integer[] sort(Integer[] array) {
		int min = 0;
		Integer tmp;
		for(int i=0;i<array.length;i++) {
			min = i;
			for(int j=i;j<array.length;j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			tmp = array[i];
			array[i] = array[min];
			array[min] = tmp;
		}
		return array;
	}

}
