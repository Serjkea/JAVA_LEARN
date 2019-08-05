
public class Stem extends Root {
	
	Component1 comp1 = new Component1();
	Component2 comp2 = new Component2();
	Component3 comp3 = new Component3();

	Stem() {
		System.out.println("Stem");
	}
	
	void dispose(){
		System.out.println("Stem Ending");
		super.dispose();
	}
	
	public static void main(String[] str) {
		new Stem().dispose();
	}
	
	

}
