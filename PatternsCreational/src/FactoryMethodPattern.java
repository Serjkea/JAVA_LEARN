interface OS {
	void getOS();
}

class Windows implements OS {
	public void getOS() {
		System.out.println("Windows");
	}
}

class Linux implements OS {
	public void getOS() {
		System.out.println("Linux");
	}
}

class MacOS implements OS {
	public void getOS() {
		System.out.println("MacOS");
	}
}

class Factory {
	
	public OS getCurrentOS(String name) {
		if(name.equals("win")) return new Windows();
		else if(name.equals("lin")) return new Linux();
		else if(name.equals("mac")) return new MacOS();
		else return null;
	}
}

public class FactoryMethodPattern {
	
	public static void main(String[] args) {
		Factory factory = new Factory();
		factory.getCurrentOS("lin").getOS();
		factory.getCurrentOS("win").getOS();
		factory.getCurrentOS("mac").getOS();
	}

}
