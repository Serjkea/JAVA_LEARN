
abstract class AbstractBase {
	
	String operation;
	
	AbstractBase(String str){
		operation=str;
	}
	
	abstract int F(int n);
	
	void show(int n) {
		System.out.println("Operation: "+operation);
		System.out.println("Argument: "+n);
		System.out.println("Value: "+F(n));
	}

}
