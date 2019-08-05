import java.util.*;

interface DrawCar {
	void draw(String color);
}

class DrawCarOne implements DrawCar {
	
	public void draw(String color) {
		System.out.println("Car One: " + color);
	}
}

class DrawCarTwo implements DrawCar {
	
	public void draw(String color) {
		System.out.println("Car Two: " + color);
	}
}

class CompositeCar implements DrawCar {
	
	private List<DrawCar> cars = new ArrayList();
	
	public void draw(String color) {
		for(DrawCar car: cars) {
			car.draw(color);
		}
	}
	
	public void add(DrawCar car) {
		cars.add(car);
	}
	
	public void clear() {
		System.out.println();
		this.cars.clear();
	}
	
}

public class CompositePattern {
	
	public static void main(String[] args) {
		DrawCar car1 = new DrawCarOne();
		DrawCar car2 = new DrawCarTwo();
		CompositeCar cc = new CompositeCar();
		cc.add(car1);
		cc.add(car2);
		cc.draw("red");
		cc.clear();
		cc.add(car1);
		cc.add(car2);
		cc.draw("green");
		cc.clear();
	}

}
