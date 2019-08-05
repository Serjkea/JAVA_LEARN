class Car implements TransportInterface {
	
	public void go() {
		System.out.println(this + " is Go!");
	}
	
	public void stop() {
		System.out.println(this + " is Stop!");
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
}

class Truck implements TransportInterface {
	
	public void go() {
		System.out.println(this + " is Go!");
	}
	
	public void stop() {
		System.out.println(this + " is Stop!");
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
}

class Bus implements TransportInterface {
	
	public void go() {
		System.out.println(this + " is Go!");
	}
	
	public void stop() {
		System.out.println(this + " is Stop!");
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
}

class Bike implements TransportInterface {
	
	public void go() {
		System.out.println(this + " is Go!");
	}
	
	public void stop() {
		System.out.println(this + " is Stop!");
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
}

public class TransportControl {

	public static void startAll(TransportInterface[] transport) {
		for(TransportInterface t : transport) {
			t.go();
		}
	}
	
	public static void stopAll(TransportInterface[] transport) {
		for(TransportInterface t : transport) {
			t.stop();
		}
	}
	
	public static void start(TransportInterface t) {
		t.go();
	}
	
	public static void stop(TransportInterface t) {
		t.stop();
	}
	
	public static void main(String[] args) {
		TransportInterface[] tArray = {new Car(),new Truck(),new Bus(), new Bike()};
		startAll(tArray);
		stopAll(tArray);
		start(new Car());
		stop(new Car());		
	}

}
