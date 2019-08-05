
public class FinalClass {
	
	static final int sf = 1;
	final int f;
	final A a;
	
	FinalClass() {
		f = 1;
		a = new A();
	}
	
	public static void main(String[] args) {
		FinalClass fc = new FinalClass();
		System.out.println(fc.f);
		System.out.println(sf);
		System.out.println(fc.a);
		
		
	//	fc.f = 5;
	//	sf = 0;
	//	fc.a = null;
	}

}
