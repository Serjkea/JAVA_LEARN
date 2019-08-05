import java.util.ArrayList;
import java.util.List;


public class B {
	
	private List<U> myArray = new ArrayList<U>();
	
	public void push(U u) {
		myArray.add(u);
	}
	
	public void pop(int n) {
		if (!myArray.isEmpty() && (myArray.size() < n))	myArray.remove(n);
		else System.out.println("Error! Array is Empty or Index is Fault.");
	}
	
	public void run() {
		for(U u: myArray) {
			u.method1();
			u.method2();
			u.method3();
		}
	}
	
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		B b = new B();
		b.push(a1.getU());
		b.push(a2.getU());
		b.push(a3.getU());
		b.run();
		
	}

}
