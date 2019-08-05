
interface Visitor {
	void visit(SportCar sportCar);
	void visit(Engine1 engine);
	void visit(Wheel wheel);
}

interface Car1 {
	void accept(Visitor visitor);
}

class Engine1 implements Car1 {
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class Wheel implements Car1 {
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class SportCar implements Car1 {
	Car1[] cars;
	public SportCar() {
		cars = new Car1[]{new Engine1(), new Wheel()};
	}
	public void accept(Visitor visitor) {
		for(int i=0;i<cars.length;i++){
			cars[i].accept(visitor);
		}
		visitor.visit(this);
	}
}

class CarVisitor implements Visitor {
	public void visit(SportCar computer) {
		print("car");
	}
	public void visit(Engine1 engine) {
		print("engine");
	}
	public void visit(Wheel wheel) {
		print("wheel");
	}
	private void print(String s) {
		System.out.println(s);
	}
}

public class VisitorPattern {
	
	public static void main(String[] args) {
		Car1 computer = new SportCar();
		computer.accept(new CarVisitor());
	}
}
