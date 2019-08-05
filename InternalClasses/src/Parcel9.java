
public class Parcel9 {
	
	Destination destination(final String text, final int x) {	//!!! FINAL!!!
		return new Destination() {

			private String label = text;	// <--- initialization !!!
			
			private int i = x;
			
			public String readLabel() {
				return label;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel9 p = new Parcel9();
		System.out.println(p.destination("Hello",5).readLabel());
	}

}
