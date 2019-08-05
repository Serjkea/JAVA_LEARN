class Coin implements Drop {
	
	public void drop() {
		System.out.println(this + " was dropped!");
	}
	
	public String toString() {
		return getClass().getSimpleName();
	}
	
}

class Cube implements Drop {
	
	public void drop() {
		System.out.println(this + " was dropped!");
	}
	
	public String toString() {
		return getClass().getSimpleName();
	}
	
}

class CoinGameFactory implements DropGameFactory {
	
	public Coin getDropGame() {
		return new Coin();
	}
	
}

class CubeGameFactory implements DropGameFactory {
	
	public Cube getDropGame() {
		return new Cube();
	}
	
}

public class DropGameControl {
	
	public static void getGame(DropGameFactory df) {
		Drop dr = df.getDropGame();
		dr.drop();
	}
	
	public static void main(String[] args) {
		getGame(new CoinGameFactory());
		getGame(new CubeGameFactory());		
	}

}
