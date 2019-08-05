
public class NestedClass {
	
	private static class InnerStatic {
		InnerStatic() {
			System.out.println("InnerStatic class");
		}
	}
	
	class Inner {
		class InnerInner{ 
			
		}
	}
	
	static class InnerS {
		static class InnerInnerS{ 
			class InnerInnerP{ 
			}
		}
	}
	
	public static void main(String[] str) {
		new InnerStatic();
		new NestedClass.InnerStatic();
		new NestedClass().new Inner();
		new NestedClass().new Inner().new InnerInner();
		new InnerS();
		new InnerS.InnerInnerS();
		new NestedClass.InnerS();
		new NestedClass.InnerS.InnerInnerS();	
		new InnerS.InnerInnerS().new InnerInnerP();
	}

}
