import java.util.Scanner;


public class EnumTest {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a size: ");
		String input = in.next().toUpperCase();
		Size size = Enum.valueOf(Size.class, input);
		System.out.println("Size = " + size);
		System.out.println("Abbreviation = " + size.getAbbreviation());
		if (size == Size.EXTRA_LARGE) System.out.println("OK");
		
	}

	enum Size {
		SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
		
		private String abbreviation;
		
		private Size(String abbreviation) {
			this.abbreviation = abbreviation;
		}
		
		public String getAbbreviation() {
			return this.abbreviation;
		}
	}
	
}
