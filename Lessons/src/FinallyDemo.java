
public class FinallyDemo {

	static void procA() {
		try {
			System.out.println("procA()");
			throw new RuntimeException("Demonstration");
		} finally {
			System.out.println("Block finally in procA()");
		}
	}
	
	static void procB() {
		try {
			System.out.println("procB()");
			return;
		} finally {
			System.out.println("Block finally in procB()");
		}
	}
	
	static void procC() {
		try {
			System.out.println("procC()");			
		} finally {
			System.out.println("Block finally in procC()");
		}
	}

	static void demoOne() throws IllegalAccessException {
		System.out.println("demoOne()");
		throw new IllegalAccessException("Demo");
	}
	
	static void compute(int a) throws MyException {
		System.out.println("Method compute("+a+")");
		if (a>10) 
			throw new MyException(a);
		System.out.println("Correct end");
	}
	
	public static void main(String args[]) {
		try {
			procA();
		} catch (Exception e) {
			System.out.println("Exception is catched");
		}
	
		procB();
		procC();
		
		try {
			demoOne();
		} catch (IllegalAccessException e) {
			System.out.println("Exception is catched: " + e);
		}
		
		try {
			compute(1);
			compute(20);
		} catch (MyException e) {
			System.out.println("Exception is catched:" + e);
		}
	}
}
