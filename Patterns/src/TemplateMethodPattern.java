
abstract class Car {
	abstract void startEngine();
	abstract void stopEngine();
	
	final void start() {
		startEngine();
		stopEngine();
	}
}

class OneCar extends Car {
	public void startEngine() {
		System.out.println("Start Engine!");
	}
	
	public void stopEngine() {
		System.out.println("Stop Engine!");
	}
}

class TwoCar extends Car {
	public void startEngine() {
		System.out.println("Start Engine");
	}
	
	public void stopEngine() {
		System.out.println("Stop Engine");
	}
}

public class TemplateMethodPattern {
	
	public static void main(String[] args) {
		Car car = new OneCar();
		car.start();
		car = new TwoCar();
		car.start();
	}

}
