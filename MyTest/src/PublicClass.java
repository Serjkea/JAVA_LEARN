
public class PublicClass {

	private int a;
	
	public PublicClass(int b){
		this.a = b;
	}
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int a_method(){
		a++;
		return a;
	}
	
}
