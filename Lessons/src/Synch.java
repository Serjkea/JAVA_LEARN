
public class Synch {
	public static void main(String[] args) {
		Callme target = new Callme();
//		Caller ob1 = new Caller(target, "Welcome");
//		Caller ob2 = new Caller(target, "in synchronized");
//		Caller ob3 = new Caller(target, "world!");
		
		try {
			Caller ob1 = new Caller(target, "Welcome");
			ob1.t.join();
			Caller ob2 = new Caller(target, "in synchronized");
			ob2.t.join();
			Caller ob3 = new Caller(target, "world!");
			ob3.t.join();
		} catch(InterruptedException e) {
			System.out.println("Aborted");
		}

	}

}
