
public class SubClass extends SuperClass {

	{
		System.out.println("SUBCLASS was created!");
	}
	
	SubClass(String s){
		super();
		System.out.println("Constructor of SUBCLASS");
	}
	
	public String name = "SubClass";
	
	public void print() {
		System.out.println("I'm a SUBCLASS!!!");
	}
	
	public final static void staticMethod(int i) {
		System.out.println("SUBCLASS STATIC METHOD");
	}
	
	public static void main(String[] args) {
		
	}

}
