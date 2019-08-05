
interface Vehicle {
	void start();
	void stop();
}

class EngineClass implements Vehicle {
	
	public void start() {
		System.out.println("Start engine!");
	}
	
	public void stop() {
		System.out.println("Stop engine!");
	}
}

class KeyClass implements Vehicle {
	
	public void start() {
		System.out.println("Enter the key!");
	}
	
	public void stop() {
		System.out.println("Eject the key!");
	}
}

class Facade {
	
	private EngineClass engine;
	private KeyClass key;
	
	Facade() {
		engine = new EngineClass();
		key = new KeyClass();
	}
	
	public void startVehicle() {
		key.start();
		engine.start();
	}
	
	public void stopVehicle() {
		engine.stop();
		key.stop();
	}
}

public class FacadePattern {
	
	public static void main(String[] args) {
		Facade vehicle = new Facade();
		vehicle.startVehicle();
		vehicle.stopVehicle();
	}

}
