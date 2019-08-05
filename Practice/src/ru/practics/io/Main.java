package ru.practics.io;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Pattern pattern = Pattern.compile("\\d");
		if (pattern.matcher(scanner.next()).find()) {
			System.out.println("Number");
		} else {
			System.out.println("Text");
		}
		
	}

}
