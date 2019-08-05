
public class SpaceShipDelegation {
	private String name;
	private SpaceShipControls controls = new SpaceShipControls();
	public SpaceShipDelegation(String name) {
		this.name = name;
	}
	public void back(int velocity) {
		controls.back(velocity);// Delegation to methods of another Object!!!
	}
	public void down(int velocity) {
		controls.down(velocity);// Delegation to methods of another Object!!!
	}
	public void forward(int velocity) {
		controls.forward(velocity);// Delegation to methods of another Object!!!
	}
	public void left(int velocity) {
		controls.left(velocity);// Delegation to methods of another Object!!!
	}
	public void right(int velocity) {
		controls.right(velocity);// Delegation to methods of another Object!!!
	}
	public void turboBoost() {
		controls.turboBoost();// Delegation to methods of another Object!!!
	}
	public void up(int velocity) {
		controls.up(velocity);// Delegation to methods of another Object!!!
	}
	public static void main(String[] args) {
		SpaceShipDelegation protector = new SpaceShipDelegation("NSEA Protector");
		protector.forward(100);// Delegation to methods of another Object!!!
	}

}
