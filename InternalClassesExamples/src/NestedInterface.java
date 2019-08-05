
public interface NestedInterface {
	
	static class NestedClass implements NestedInterface {
		NestedClass() {
			System.out.println("NestedClass");
		}
		
		static void nestedMethod() {
			new NestedClass().method1();
			new NestedClass().method2();
		}

		public void method1() {
			System.out.println("NestedClass method1");
		}


		public void method2() {
			System.out.println("NestedClass method2");
		}
	}
	
	void method1(); 
	void method2(); 

}
