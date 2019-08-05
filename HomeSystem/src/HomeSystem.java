import java.util.Scanner;


public class HomeSystem {
	
	private final static String LOGIN = "admin";
	private final static String PASSWORD = "12345";
	
	static {
		System.out.println("Welcome");
	}
	
	public static void main(String[] args) {
		System.out.print("Login: ");
		String login = new Scanner(System.in).next();
		System.out.print("Password: ");
		String password = new Scanner(System.in).next();
		if (login.equals(LOGIN) && password.equals(PASSWORD)) {
			   System.out.println("Hello " + LOGIN + "!");
			   MainMenu menu = new MainMenu();
			   String input = "";
			   while(!input.equals("Exit")) {
				   input = new Scanner(System.in).next();
				   if (input.equals("Date")) menu.getDate();
				   else if (input.equals("Calendar")) menu.getCalendar();
			   }
			   System.out.println("Bye " + LOGIN + "!");
		} else System.out.println("Login or password is not correct!");
	}

}
