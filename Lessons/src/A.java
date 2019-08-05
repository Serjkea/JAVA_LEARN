
public class A {

	private int i;
	
    A(int a){
    	i = a;
    }
 
    A(){
    	i = 111;
    }
	
	public void show(){
		System.out.println("From class A:" + i);
	}
}
