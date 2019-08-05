
public class Outer {
	
	private String str;
	
	Outer() {
		str = "Hello";
	}
	
	class Inner {
		
		public String toString() {
			return str;
		}
		
	}
	
	public Inner getInner() {
		return new Inner();
	}
	
	public static void main(String[] args) {
		Inner inner = new Outer().getInner();
		System.out.println(inner);
	}

}
