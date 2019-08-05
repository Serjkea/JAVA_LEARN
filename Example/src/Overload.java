
public class Overload extends NewOverload {
	
	void print() {
		System.out.println("1");
	}
	
	void print(int i) {
		System.out.println("2");
	}
	
	void print(String s) {
		System.out.println("3");
	}
	
	public static void main(String[] args) {
		new Overload().print();
		new Overload().print(5);
		new Overload().print("");
		new Overload().print(1.2f);
	}

}

class NewOverload {
	
	void print(float f) {
		System.out.println("4");
	}
	
}
