
public class MySingleton {
	
//	private static MySingleton instance;
	private final static MySingleton instance = new MySingleton();
	
	private MySingleton(){
		System.out.println("Constructor!");
	}
	
	public static MySingleton getInstance() {
		if (instance == null) {
//			instance = new MySingleton();
//			System.out.println("Object is created!");
		}
		else {System.out.println("Object is here!");}
		return instance;
	}

}
