
class Mediator {
	public static void sendMessage(UserClass user, String msg) {
		System.out.println(user.getName() + ": " + msg);
	}
}

class UserClass {
	
	private String name;
	
	UserClass(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void sendMessage(String msg) {
		Mediator.sendMessage(this, msg);
	}
	
}

public class MediatorPattern {
	
	public static void main(String[] args) {
		UserClass user1 = new UserClass("Mike");
		UserClass user2 = new UserClass("Bob");
		user1.sendMessage("Hello!");
		user2.sendMessage("Hi!");
	}

}
