
public class MyNeException extends Exception {
	
	private int detail;
	
	MyNeException(int a) {
		detail = a;
	}
	
	public String toString() {
		return "MyNeException["+detail+"]";
	}

}
