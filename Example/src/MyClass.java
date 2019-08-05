import java.util.Scanner;
import java.util.*;

public class MyClass {

	public static void main(String[] args) { 
		System.out.println("Enter a text:");
		char[] c = (new Scanner(System.in).next().toCharArray());
		Arrays.sort(c);
		System.out.println(c);
	}

}
