
public class MyClass {
	
	public class InnerClass {
		InnerClass(int i) {
			
		}
	}

}

class MyClassNew {
	public class InnerClassNew extends MyClass.InnerClass {
		InnerClassNew(MyClass mc){
			mc.super(5);
		}
	}
}