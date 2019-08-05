
public class B extends A{

	private int a;
	
	B(int i, int j){
		super(j);
		a = i;
	}
	
	B(){
		super(-33);
		a = -10;
	}
	
	public void show(String s){
		System.out.println("From class B: " + a + " " + s);
	}
}
