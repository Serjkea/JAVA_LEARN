
class Mediator {
	public static void sendMessage(User user,String msg) {
		System.out.println(user.getName() + " " + msg);
	}
}

class User {
	
	private String name;
	
	User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void sendMessage(String msg) {
		Mediator.sendMessage(this, msg);
	}
	
}

public class MediatorPattern {
	
	public static void main(String[] args) {
		User user1 = new User("Mike");
		User user2 = new User("Bob");
		user1.sendMessage("Hello");
		user2.sendMessage("Hi");
	}
	

}
