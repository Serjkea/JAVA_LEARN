package two;

import one.MyInterface;

public class MyClass {
	
	protected class Inner implements MyInterface {
		
		public Inner() {
		}

		public void method() {
			System.out.println("Method in Inner class");
		}
		
	}
	
	

}
