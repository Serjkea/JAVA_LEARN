
abstract class Base {
	public Base(int i) {
		System.out.println("Base constructor, i = " + i);
	}
	public abstract void f();
}

public class AnonymousCoinstructor {
	public static Base getBase(int i) {// can be not FINAL!!!
		return new Base(i) {
			{System.out.println("Initialization");}
			public void f() {
				System.out.println("In anonymous f()");
			}
		};
	}
	public static void main(String[] args) {
		Base base = getBase(45);
		base.f();
	}

}
