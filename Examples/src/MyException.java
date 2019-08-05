
public class MyException extends Exception{
	static int count=0;
	String name;
	MyException(String name) {
		count++;
		this.name=name;
	}
	public String toString() {
		String text="Error!\n";
		text+="Description: "+name+"\n";
		text+="Number of error: "+count;
		return text;
	}

}
