
class ObjectA {
	
	private String name;
	
	ObjectA(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
}

class ObjectB {
	
	private String name;
	
	ObjectB(String name) {
		this.name = name;
	}
	
	public String getInfo() {
		return this.name;
	}
}

class ObjectAAdapter {
	
	private ObjectB objectB;
	
	ObjectAAdapter(ObjectB objectB) {
		this.objectB = objectB;
	}
	
	public String getName() {
		return objectB.getInfo();
	}
}

public class AdapterPattern {
	
	public static void main(String[] args) {
		ObjectA objA = new ObjectA("Object A");
		System.out.println(objA.getName());
		ObjectAAdapter objB = new ObjectAAdapter(new ObjectB("Object B"));
		System.out.println(objB.getName());
	}

}
