
public class Parcel11 {
	
	private static class ParcelContents implements Contents {

		private int i = 11;
		
		public int value() {
			return i;
		}
	}
	
	protected static class ParcelDestination implements Destination {

		private String label;
		
		private ParcelDestination(String s) {
			label = s;
		}

		public String readLabel() {
			return label;
		}
		
		public static void f() {System.out.println("Hi");}
		
		static int x = 15;
		
		static class AnotherLevel {
			public static void f() {}
			static int x = 20;
		}
		
		public static Destination destination(String dest) {
			return new ParcelDestination(dest);
		}
		
		public static Contents contents() {
			return new ParcelContents();
		}
		
		public static void main(String[] args) {
			Contents c = contents();
			Destination d = destination("Home");
			System.out.println(c.value());
			System.out.println(d.readLabel());
			ParcelDestination pd = (ParcelDestination) d;
			pd.f();
			ParcelDestination pd1 = new ParcelDestination("1235");
			System.out.println(pd1.readLabel());;
			
		}
		
	}

}
