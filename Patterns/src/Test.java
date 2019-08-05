
public class Test {
	
	public enum Singleton{
		INSTANCE;
		public void doSomething(){
			System.out.println("Enum Singleton");
			};
		};

	public static void main(String[] args) {

		CacheSingletonBean csb = new CacheSingletonBean();
		try{
			csb.start();
			csb.addUser(1, "User1");
			csb.addUser(2, "User2");
			csb.addUser(3, "User3");
			System.out.println(csb.getName(1));
			System.out.println(csb.getName(2));
			System.out.println(csb.getName(3));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		MySingleton single = MySingleton.getInstance();
		MySingleton.getInstance();
		
		Singleton single1 = Singleton.INSTANCE;
		System.out.println("-----");
		single1.doSomething();
		
		User user = new User();
		UserServiceFactory usf = new UserServiceFactory();
		usf.getInstance().persistUser(user);
		
		
		
				
	}

}
