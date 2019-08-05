
public class SuperClass {
	
	{
		System.out.println("SUPERCLASS was created!");
	}
	
	SuperClass() {
		System.out.println("Constructor of SUPERCLASS");
	}
	
	public String name = "SuperClass";
	
	private void print() {
		System.out.println("I'm a SUPERCLASS!!!");
	}
	
	public final static void staticMethod() {
		System.out.println("SUPERCLASS STATIC METHOD");
	}
	
/*	public static void main(String[] args) {
		SuperClass sc = new SuperClass();
	}*/

}
