
public class ClassC {
	
	private class InnerC implements InterfaceA {

		public void method() {
			System.out.println("Method by InnerC Class");
		}
		
	}
	
	public InterfaceA getInnerC() {
		return new InnerC();
	}
	
	public static void main(String[] args) {
	}

}
