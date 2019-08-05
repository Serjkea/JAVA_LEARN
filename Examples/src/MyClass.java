
public class MyClass {
	
	private int number;
	
	void show() {
		System.out.println("Value: "+number);
	}
	
	MyClass(int number) {
		try {
			if (number>10) {
				number=10;
				throw new MyException("Very big number!");
			}
			if (number<0) {
				number=0;
				throw new MyException("Very small number");
			}
		} catch (MyException eObj) {
			System.out.println(eObj);
		}
		this.number=number;
		show();
	}
	
	void set(int number) throws MyException {
		if (number>10||number<0) throw new MyException("Invalid argument!");
		this.number=number;
		System.out.println("OK!");
		show();
	}

}
