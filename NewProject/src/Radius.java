import java.util.Scanner;

public class Radius {
	int getRadius(){
		int r;	
		
		Scanner newScanner = new Scanner(System.in);
		System.out.print("Please enter the radius of circus: ");
		r = newScanner.nextInt();
		
		return r;
	}

}
