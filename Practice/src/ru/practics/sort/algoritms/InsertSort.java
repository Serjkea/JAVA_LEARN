package ru.practics.sort.algoritms;

public class InsertSort {
	
	public static Integer[] sort(Integer[] array) {
		for(int i=1; i<array.length;i++) {
			Integer temp = array[i];
			int index = i;
			while(index>0 && array[index-1] >=temp) {
				array[index] = array[index-1];
				index--;
			}
			array[index] = temp;
		}
		return array;
	}

}
