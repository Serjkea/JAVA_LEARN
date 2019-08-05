
public class Frog extends Amphibian{
	
	public void frog() {
		System.out.println("Frog");
	}
	
	public void print() {
		System.out.println("Frog");
	}
	
	public void method() {
		System.out.println("Jump and Swim");
	}
	
	public static void main(String[] args) {
		Frog f = new Frog();
		Amphibian am = new Amphibian();
		am.print();
		am.method();
//		Frog fr = (Frog)am;
		f.frog();
		f.print();
		f.method();
		Amphibian a = (Amphibian) f;
		a.print();
		a.method();
		
	}

}
