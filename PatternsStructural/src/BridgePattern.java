
interface Engine {
	void setEngine();
}

abstract class Car {
	
	protected Engine engine;
	
	public Car(Engine engine) {
		this.engine = engine;
	}
	
	abstract void setEngine();
}

class SportCar extends Car {
	
	SportCar(Engine engine) {
		super(engine);
	}
	
	public void setEngine() {
		System.out.print("SportCar engine: ");
		engine.setEngine();
	}
}

class UnknowCar extends Car {
	
	UnknowCar(Engine engine) {
		super(engine);
	}
	
	public void setEngine() {
		System.out.print("UnknowCar engine: ");
		engine.setEngine();
	}
}

class SportEngine implements Engine {
	
	public void setEngine() {
		System.out.println("sport");
	}
}

class UnknowEngine implements Engine {
	
	public void setEngine() {
		System.out.println("unknow");
	}
}

public class BridgePattern {
	
	public static void main(String[] args) {
		Car sportCar = new SportCar(new SportEngine());
		sportCar.setEngine();
		Car unknowCar = new UnknowCar(new UnknowEngine());
		unknowCar.setEngine();
		Car sportCarNew = new SportCar(new UnknowEngine());
		sportCarNew.setEngine();
		Car unknowCarNew = new UnknowCar(new SportEngine());
		unknowCarNew.setEngine();
	}

}
