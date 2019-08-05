
public class NewBase extends Base{
	
	public void method1() {
		System.out.println("Method 1 NewBase");
		method2();
	}

	public void method2() {
		System.out.println("Method 2 NewBase");
	}
	
	public static void main(String[] args) {
		NewBase nb = new NewBase();
		Base b = (Base) nb;
		b.method1();
		((Base)new NewBase()).method1();
	}

}
