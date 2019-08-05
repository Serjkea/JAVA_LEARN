
public class Parcel1 {
	class Contents {
		private int i = 11;
		public int value() {
			return i;
		}
	}
	class Destination {
		private String label;
		Destination(String whereTo) {
			label = whereTo;
		}
		String readLabel() {
			return label;
		}
	}
	public Destination to(String s) {
		return new Destination(s);
	}
	public Contents contents() {
		return new Contents();
	}
	public void ship(String dest) {
		Contents c = contents();
		Destination d = to(dest);
		System.out.println(d.readLabel());
	}
	public static void main(String[] args) {
		Parcel1 p = new Parcel1();
		p.ship("Cupris");
		Parcel1 s = new Parcel1();
		Parcel1.Contents c = s.contents();
		Parcel1.Destination d = s.to("Borneo");
		System.out.println(c.value());
		System.out.println(d.readLabel());

	}

}
