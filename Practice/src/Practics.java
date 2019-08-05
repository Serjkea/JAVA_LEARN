import java.util.Scanner;


public class Practics {

	public static void main(String[] args) {
		int a;
		System.out.println("Input value: ");
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		System.out.println((a%10 + (a/10)%10));

	}

}
