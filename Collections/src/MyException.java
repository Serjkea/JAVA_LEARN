
public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private int detail;
	
	MyException(int a) {
		detail = a;
	}

	public String toString() {
		return "MyException[" + detail + "]";
	}
}
