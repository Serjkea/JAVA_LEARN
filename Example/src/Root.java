
class Component1 {
	Component1() {
		System.out.println("Component1");
	}
}

class Component2 {
	Component2() {
		System.out.println("Component2");
	}
}

class Component3 {
	Component3() {
		System.out.println("Component3");
	}
}

public class Root {

	Component1 comp1 = new Component1();
	Component2 comp2 = new Component2();
	Component3 comp3 = new Component3();
	
	void dispose(){
		System.out.println("Root Ending");
	}
	
	Root() {
		System.out.println("Root");
	}
	
}
