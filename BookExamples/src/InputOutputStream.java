import java.io.Console;
import java.io.PrintWriter;
import java.util.Scanner;
//import java.nio.file.Paths;
public class InputOutputStream {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = in.nextLine();
		System.out.println("Hello " + name + "!");
		System.out.println("Enter a some text " + name +" :");
		String oneWord = in.next();
		String twoWord = in.next();
		System.out.println(oneWord + "\n" + twoWord);
		
/*		Console cons = System.console();
		String user = cons.readLine("Enter name: ");
		char[] pass = cons.readPassword("Password: ");*/
		
		System.out.printf("My format string with %8.2f, and some %s\n", 500.0, "text");
		System.out.printf("%5.2f\n", 3.143);	
		System.out.printf("%5.2f\n", 24.567);
		
	//	Scanner infile = new Scanner(Paths.get("text.txt"), "UTF-8");
	//	PrintWriter pw = new PrintWriter("text.txt","UTF-8");
		
	}
	
}
