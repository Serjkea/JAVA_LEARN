
public class SpaceShip extends SpaceShipControls { //Not correct inheritance
	private String name;
	public SpaceShip(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
	public static void main(String[] args) {
		SpaceShip protector = new SpaceShip("NSEA Protector");
		protector.forward(100);
	}

}
