
class Singleton {
	
	private static Singleton instance = null;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(instance == null) instance = new Singleton();
		return instance;
	}
	
	public void setUp() {
		System.out.println("setUp");
	}
	
}

public class SingletonPattern {
	
	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		instance.setUp();
	}

}
