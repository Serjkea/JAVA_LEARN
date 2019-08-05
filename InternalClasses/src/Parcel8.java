
public class Parcel8 {
	
	Wrapping wrapping(int x) {
		return new Wrapping(x) {
			public int value() {
				return super.value();
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel8 p = new Parcel8();
		Wrapping w = p.wrapping(10);
		System.out.println(w.value());
	}

}
