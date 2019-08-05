
public class C extends A {
  
	private int c;
	
	C(){
	    super(10);
	    c = -77;
	}
	
	C(int a, int v){
		super(a);
		c = v;
	}
	
	public void show(){
		System.out.println("From class C:" + c);
	}
}
