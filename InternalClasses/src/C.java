
public class C {
	
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		B b =  new B();
		b.push(a1.getU());
		b.push(a2.getU());
		b.push(a3.getU());
		b.exec();
		b.pop(2);
	}

}
