
public class Parcel5 {
	
	public Destination destination(String s) {
		class PDestination implements Destination {
			
			private String label;
			
			private PDestination(String s) {
				label = s;
			}
			
			public String readLabel() {
				return label;
			}
		}
		return new PDestination(s);
	}
	
	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		Destination d = p.destination("Home");
		System.out.println(d.readLabel());
	//	Parcel4.PDestination pp = (Parcel4.PDestination) d;
	}

}
