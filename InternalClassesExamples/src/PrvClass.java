
public class PrvClass {
	
	private String str = "Private Field";
	
	private void method() {
		System.out.println("Private Method");
	}
	
	class Inner {
		
		public void innerClassMethod(String s) {
			str = s;
			method();
		}
	}
	
	public void getInnerClassMethod() {
		new Inner().innerClassMethod("Changed Field");
	}
	
	public static void main(String[] args) {
		PrvClass pc = new PrvClass();
		System.out.println(pc.str);
		pc.getInnerClassMethod();
		System.out.println(pc.str);
		
	}

}
