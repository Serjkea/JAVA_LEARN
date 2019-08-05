
interface Copyable {
	Copyable copy();
}

class MyCopyableObject implements Copyable {
	
	private String type;
	
	MyCopyableObject(String type) {
		this.type = type;
	}
	
	public MyCopyableObject copy() {
		MyCopyableObject object = new MyCopyableObject(type);
		return object;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void getType() {
		System.out.println(type);
	}
	
}

public class PrototypePattern {
	
	public static void main(String[] args) {
		MyCopyableObject obj1 = new MyCopyableObject("A");
		MyCopyableObject obj2 = obj1.copy();
		obj1.setType("B");
		obj1.getType();
		obj2.getType();
	}

}
