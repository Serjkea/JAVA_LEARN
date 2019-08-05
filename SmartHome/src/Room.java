
public class Room {
	
	private String name;
	private static int id;
	
	static{
		id++;
	}
	
	Room(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}

}
