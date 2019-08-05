class Unicycle implements Cycle {
	
	private static int wheels = 1;
	
	public void go() {
		System.out.println(this + " on " + wheels + " wheels");
	}
	
	public String toString() {
		return getClass().getSimpleName();
	}
}

class Bicycle implements Cycle {
	
	private static int wheels = 2;
	
	public void go() {
		System.out.println(this + " on " + wheels + " wheels");
	}
	
	public String toString() {
		return getClass().getSimpleName();
	}
}

class Tricycle implements Cycle {
	
	private static int wheels = 3;
	
	public void go() {
		System.out.println(this + " on " + wheels + " wheels");
	}
	
	public String toString() {
		return getClass().getSimpleName();
	}
}

class UnicycleFactory implements CycleFactory{
	public Unicycle getCycle() {
		return new Unicycle();
	}
}

class BicycleFactory implements CycleFactory{
	public Bicycle getCycle() {
		return new Bicycle();
	}
}

class TricycleFactory implements CycleFactory{
	public Tricycle getCycle() {
		return new Tricycle();
	}
}

public class CycleControl {
	
	public static void driveCycle(CycleFactory cf) {
		Cycle c = cf.getCycle();
        c.go();
	}
	
	public static void main(String[] args) {
		driveCycle(new UnicycleFactory());
		driveCycle(new BicycleFactory());
		driveCycle(new TricycleFactory());
	}

}
