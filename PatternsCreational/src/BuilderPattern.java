class House {
	
	public void getWalls(){
		System.out.println("Walls");
	}
	
	public void getWindows() {
		System.out.println("Windows");
	}
	
	public void getRoof(Roof roof) {
		System.out.println("Roof " + roof.getColor());
	}
	
}

interface Roof {
	String getColor();
}

class WhiteRoof implements Roof {
	public String getColor() {
		return "white";
	}
}

class RedRoof implements Roof {
	public String getColor() {
		return "red";
	}
}

abstract class HouseBuilder {
	protected House house;
	public abstract House buildHouse();
}

class FirstTypeHouse extends HouseBuilder {
	
	FirstTypeHouse() {
		house = new House();
	}
	
	public House buildHouse() {
		house.getWalls();
		house.getWindows();
		house.getRoof(new RedRoof());
		return house;
	}
}

class SecondTypeHouse extends HouseBuilder {
	
	SecondTypeHouse() {
		house = new House();
	}
	
	public House buildHouse() {
		house.getWalls();
		house.getWindows();
		house.getRoof(new WhiteRoof());
		return house;
	}
}

public class BuilderPattern {
	
	public static void main(String[] args) {
		HouseBuilder builder = new FirstTypeHouse();
		builder.buildHouse();
		builder = new SecondTypeHouse();
		builder.buildHouse();
	}

}
