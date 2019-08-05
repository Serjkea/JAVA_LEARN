
public class UsingThrowDemo {

	public static void main(String[] args) {
		MyClass objA=new MyClass(15);
		MyClass objB=new MyClass(-1);
		try {
			objA.set(100);
		} catch (MyException e) {
			System.out.println(e);
			objA.show();
		}
		MyException objE=new MyException("Unexist Error!");
		try {
			throw objE;
		} catch (MyException e) {
			System.out.println(e);
		}

	}

}
