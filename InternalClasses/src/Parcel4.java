
public class Parcel4 {
	private class PContents implements Contents{
		private int i = 10;
		public int value() {
			return i;
		}
	}
	protected class PDestination implements Destination{
		private String label;
		private PDestination(String whereTo) {
			label = whereTo;
		}
		public String readLabel() {
			return label;
		}
	}
	public Destination destination(String s) {
		return new PDestination(s);
	}
	public Contents contents() {
		return new PContents();
	}

	public static void main(String[] args) {
		Parcel4 p = new Parcel4();
		Contents c = p.contents();
		Destination d = p.destination("Home");
		System.out.println(c.value());
		System.out.println(d.readLabel());
		Parcel4.PContents pc = p.new PContents();
		System.out.println(pc.value());
	}


}
