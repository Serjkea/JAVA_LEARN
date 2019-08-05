
public class Zmey {
	
	private int length = 3;
	private String direction = "forward";
	
	public Zmey (int length, String direction) {
		this.length = length;
		this.direction = direction;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public String getDirection() {
		return this.direction;
	}
	
	public void addLength() {
		this.length++;
	}
	
	public void subLength() {
		if (this.length > 0) this.length--;
		else this.length = 0;
	}
	
	public void changeDirection(String direction) {
		this.direction = direction;
	}
	
	

}
