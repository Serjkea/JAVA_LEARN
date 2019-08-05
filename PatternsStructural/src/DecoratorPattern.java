
interface Fly{
	void fly();
}

class Bird implements Fly {
	
	public void fly() {
		System.out.println("Bird is fly!");
	}
}

class Plane implements Fly {
	
	public void fly() {
		System.out.println("Plane is fly!");
	}
}

abstract class FlyDecorator implements Fly {
	
	protected Fly flyObject;
	
	FlyDecorator(Fly flyObject) {
		this.flyObject = flyObject;
	}
	
	abstract public void fly();
}

class ReactiveFly extends FlyDecorator {
	
	ReactiveFly(Fly flyObject) {
		super(flyObject);
	}
	
	public void fly() {
		flyObject.fly();
		reactiveFly();
	}
	
	private void reactiveFly() {
		System.out.println("Reactive fly!");
	}
}

public class DecoratorPattern {
	
	public static void main(String[] args){
		Fly bird = new Bird();
		Fly plane = new Plane();
		Fly rflyObject = new ReactiveFly(plane);
		plane.fly();
		bird.fly();
		rflyObject.fly();
	}

}
