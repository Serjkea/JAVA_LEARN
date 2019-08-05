import one.*;
import two.*;


public class MyClassNew extends MyClass{
	
	public MyInterface getMyClassObject() {
		return new Inner();
	}
	
	public static void main(String[] args) {
		MyClassNew mc = new MyClassNew();
		mc.new Inner();
		
	}

}
