
public class SuperClass {
	
	public static int i = 1;
	
	SuperClass() {
		this("");
		System.out.println("1");
	}
	
	SuperClass(String s) {
		this("",1);
		System.out.println("2");
	}
	
	SuperClass(String s, int i) {
		
		System.out.println("3");
	}
	
	public void print() {
		System.out.println("SuperClass");
	}
	
	public static void sPrint() {
		System.out.println("Static SuperClass");
	}

}
