
public class SubSubOneClass extends SubClass{
	
	{
		System.out.println("SUBSUBONECLASS was created!");
	}
	
	SubSubOneClass() {
		super("");
		System.out.println("Constructor of SubSubOneClass");
	}
	
	public String name = "SubSubOneClass";
	
	public void print() {
		System.out.println("I'm a SUBSUBONECLASS!!!");
	}

}
