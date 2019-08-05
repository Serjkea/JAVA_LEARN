import java.util.*;
public class SwitchCase {
	
	public static void main(String[] args) {
		String message;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int choice = in.nextInt();
		switch (choice) {
		case 1: message = "One"; break;
		case 2: message = "Two"; break;
		case 3: message = "Three"; break;
		case 4: message = "Four"; break;
		default: message = ""; break;
		}
		System.out.println(message);
	}

}
