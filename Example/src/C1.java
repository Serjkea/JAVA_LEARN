
class A1 {
	A1(String s) {
		System.out.println("A Constructor " + s);
	}
}

class B1 {
	B1(String s) {
		System.out.println("B Constructor " + s);
	}
}

public class C1 extends A1{

	private B1 field = new B1("Hi");

	C1(){
		super("Hello");
		System.out.println("C Constructor ");
	}
	
	public static void main(String[] args) {
		C1 c = new C1();
	}
	
}