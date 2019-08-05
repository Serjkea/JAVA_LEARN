
public class Parcel7 {
	
	Contents contents() {
		return new Contents() {
			
			private int i = 10;
			
			public int value() {
				return i;
			}
		};
	}
	
	public static void main(String[] ags) {
		Parcel7 p = new Parcel7() ;
		p.contents();
		System.out.println(p.contents().value());
		Contents c = p.contents();
		c.value();
	}

}
