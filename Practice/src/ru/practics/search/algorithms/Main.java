package ru.practics.search.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	private static long time;
	
	private static boolean linearSearch(Integer[] inputArray, int searchNum) {
		for(int i=0; i<inputArray.length;i++) {
			if (inputArray[i] == searchNum) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean recBinarySearch(Integer[] inputArray, int startIndex, int lastIndex, int searchNum) {
		if (startIndex<=lastIndex) {
			int middleIndex = startIndex + (lastIndex - startIndex)/2;
			if(inputArray[middleIndex] == searchNum) return true;
			else if (inputArray[middleIndex] > searchNum) return recBinarySearch(inputArray,startIndex,middleIndex-1,searchNum);
			else return recBinarySearch(inputArray,middleIndex+1,lastIndex,searchNum);
		}
		return false;
	}
	
	private static boolean binarySearch(Integer[] inputArray, int searchNum) {
		int startIndex = 0;
		int lastIndex = inputArray.length - startIndex;
		while(startIndex<=lastIndex) {
			int middleIndex = (startIndex + lastIndex)/2;
			if(inputArray[middleIndex] == searchNum) return true;
			else if (inputArray[middleIndex] < searchNum) startIndex = middleIndex + 1;
			else lastIndex = middleIndex - 1;
		}
		return false;
	}
	
	private static int[] compilePatternArray(String pattern) {
		int patternLength = pattern.length();
		int len = 0;
		int i = 1;
		int[] compliedPatternArray = new int[patternLength];
		compliedPatternArray[0] = 0;
		while(i<patternLength) {			
//			System.out.println(i + " " + len);
			if(pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				compliedPatternArray[i] = len;
				i++;
			} else {
				if(len != 0) {
					len = compliedPatternArray[len - 1];
				} else {
					compliedPatternArray[i] = len;
					i++;
				}
			}
//			System.out.println(i + " " + len);
		}
		System.out.println("Compiled Pattern Array " + Arrays.toString(compliedPatternArray));
		return compliedPatternArray;
	}
	
	private static List<Integer> performKMPSearch(String text, String pattern) {
		int[] compliedPatternArray = compilePatternArray(pattern);
		int textIndex = 0;
		int patternIndex = 0;
		List<Integer> foundIndexes = new ArrayList<Integer>();
//		System.out.println(text);
//		System.out.println(pattern);
		while(textIndex < text.length()) {			
//			System.out.println("input  " + patternIndex + " " + textIndex);
			if(pattern.charAt(patternIndex) == text.charAt(textIndex)) {
				patternIndex++;
				textIndex++;
//				System.out.println("pattern.charAt(patternIndex) == text.charAt(textIndex) " + patternIndex + " " + textIndex);
			}
			if(patternIndex == pattern.length()) {
				foundIndexes.add(textIndex - patternIndex);
				patternIndex = compliedPatternArray[patternIndex-1];
//				System.out.println("patternIndex == pattern.length " + patternIndex + " " + textIndex);
			}
			else if (textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
//				System.out.println("textIndex < text.length " + patternIndex + " " + textIndex);
	            if (patternIndex != 0)
	                patternIndex = compliedPatternArray[patternIndex - 1];
	            else
	                textIndex = textIndex + 1;
			}
//			System.out.println("output " + patternIndex + " " + textIndex);
		}
		return foundIndexes;
	}
	
	private static boolean jumpSearch(Integer[] inputArray, int searchNum) {
		int arrayLength = inputArray.length;
		int jumpStep = (int)Math.sqrt(inputArray.length);
		int prevStep = 0;
		while(inputArray[Math.min(jumpStep, arrayLength)-1] < searchNum) {
			prevStep = jumpStep;
			jumpStep += (int)Math.sqrt(arrayLength);
			if (prevStep >= arrayLength) return false;
		}
		while(inputArray[prevStep] < searchNum) {
			prevStep++;
			if (prevStep == Math.min(jumpStep, arrayLength)) return false;
		}
		if (inputArray[prevStep] == searchNum) return true;
		return false;
	}
	
	public static boolean interpolationSearch(Integer[] integers, int elementToSearch) {
		int startIndex = 0;
	    int lastIndex = (integers.length - 1);
 	    while ((startIndex <= lastIndex) && (elementToSearch >= integers[startIndex]) &&
	           (elementToSearch <= integers[lastIndex])) {
	        int pos = startIndex + (((lastIndex-startIndex) /
	          (integers[lastIndex]-integers[startIndex]))*
	                        (elementToSearch - integers[startIndex]));
	        if (integers[pos] == elementToSearch)
	            return true;;
	        if (integers[pos] < elementToSearch)
	            startIndex = pos + 1;
	        else
	            lastIndex = pos - 1;
	    }
	    return false;
	}
	
	public static int exponentialSearch(Integer[] integers, int elementToSearch) {
	    if (integers[0] == elementToSearch)
	        return 0;
	    if (integers[integers.length - 1] == elementToSearch)
	        return integers.length;
	    int range = 1;
	    while (range < integers.length && integers[range] <= elementToSearch) {
	        range = range * 2;
	    }
	    return Arrays.binarySearch(integers, range / 2, Math.min(range, integers.length), elementToSearch);
	}	
	
	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9,10,
						   11,12,13,14,15,16,17,18,19,20,
						   21,22,23,24,25,26,27,28,29,30,
						   31,32,33,34,35,36,37,38,39,40,
						   41,42,43,44,45,46,47,48,49,50,
						   51,52,53,54,55,56,57,58,59,60,
						   61,62,63,64,65,66,67,68,69,70,
						   71,72,73,74,75,76,77,78,79,80,
						   81,82,83,84,85,86,87,88,89,90,
						   91,92,93,94,95,96,97,98,99,100};
		
		int searchNum = 50;

		time = System.nanoTime();
		System.out.println("LinearSearch    " + linearSearch(array,searchNum) + " " + (System.nanoTime() - time));

		time = System.nanoTime();
		System.out.println("LinearSearch    " + linearSearch(array,searchNum) + " " + (System.nanoTime() - time));
	
		time = System.nanoTime();
		System.out.println("BinarySearch    " + binarySearch(array,searchNum) + " " + (System.nanoTime() - time));

		time = System.nanoTime();
		System.out.println("RecBinarySearch " + recBinarySearch(array,0,array.length,searchNum) + " " + (System.nanoTime() - time));
		
		jumpSearch(array,searchNum);

		time = System.nanoTime();
		System.out.println("JumpSearch      " + jumpSearch(array,searchNum) + " " + (System.nanoTime() - time));

		time = System.nanoTime();
		System.out.println("InterpolSearch  " + interpolationSearch(array,searchNum) + " " + (System.nanoTime() - time));

		time = System.nanoTime();
		System.out.println("ExponentSearch  " + exponentialSearch(array,searchNum) + " " + (System.nanoTime() - time));

		time = System.nanoTime();
		System.out.println("ExponentSearch  " + exponentialSearch(array,searchNum) + " " + (System.nanoTime() - time));

		String text = "AAABBACBAAB";
		String pattern = "AAB";
		System.out.println(performKMPSearch(text,pattern));
		
	}

}
