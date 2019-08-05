
public class ClassA {
	
	public InterfaceA getInterfaceType() {
		
		class InnerA implements InterfaceA {

			public void method() {
				System.out.println("Inner Class Method");
			}
			
		}
		
		return new InnerA();
	
	}

}
