
public class Cycle {
	
	public void ride() {
		System.out.println("Cycle");
	}
	
	public static void main(String[] args) {
		Cycle c = new Cycle();
		Unicycle u = new Unicycle();
		Bicycle b = new Bicycle();
		Tricycle t = new Tricycle();
		for(Cycle test: new Cycle[]{c,u,b,t}){
			test.ride();
		}
	}

}

class Unicycle extends Cycle {

	public void ride() {
		System.out.println("Unicycle");
	}
	
}

class Bicycle extends Cycle {

	public void ride() {
		System.out.println("Bicycle");
	}
	
}

class Tricycle extends Cycle {
	
	public void ride() {
		System.out.println("Tricycle");
	}
	
}