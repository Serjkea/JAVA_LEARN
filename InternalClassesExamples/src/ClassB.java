
public class ClassB {
	
	public InterfaceA getInterfaceClassB(boolean flag) {
		if (flag) {
			class InnerB implements InterfaceA{
				public void method() {
					System.out.println("Method by InnerB Class");
				}
			}
			return new InnerB();
		} else return null;
	}

}
