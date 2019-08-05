package ru.practics.collections;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		MyArrayList<Integer> array = new MyArrayList<Integer>();
		array.add(1);
		System.out.println(array.size());
		array.add(2);
		System.out.println(array.size());
		array.add(3);
		System.out.println(array.size());
		array.add(4);
		System.out.println(array.size());
		array.add(5);
		System.out.println(array.size());
		array.add(6);
		System.out.println(array.size());
		array.add(7);
		System.out.println(array.size());
		array.add(8);
		System.out.println(array.size());
		array.add(9);
		System.out.println(array.size());
		array.add(10);
		System.out.println(array.size());
		array.add(11);
		System.out.println(array.size());
		System.out.println();
		for(int i=0; i<array.size();i++) {
			System.out.println(array.get(i));
		}
		array.remove(5);
		System.out.println();
		for(int i=0; i<array.size();i++) {
			System.out.println(array.get(i));
		}
		System.out.println();
		System.out.println(array.size());
		for(Integer item: array) {
			System.out.println(item);
		}
		System.out.println();
		for(Integer item: array) {
			System.out.println(item);
		}
		
	}

}
