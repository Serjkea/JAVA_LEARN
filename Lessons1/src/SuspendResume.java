
public class SuspendResume {

	public static void main(String[] args) {
		NewThread ob1 = new NewThread("One");
		NewThread ob2 = new NewThread("Two");
		
		try {
			Thread.sleep(1000);
			ob1.mysuspend();
			System.out.println("One is stopped");
			Thread.sleep(1000);
			ob1.myresume();
			System.out.println("One is started");
			ob2.mysuspend();
			System.out.println("Two is stopped");
			Thread.sleep(1000);
			ob2.myresume();
			System.out.println("Two is started");
		} catch (InterruptedException e) {
			System.out.println("Main thread is stopped");
		}
		
		try {
			System.out.println("Waiting for a stop thread");
			ob1.t.join();
			ob2.t.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread is stopped");
		}
		
		System.out.println("Main thread is end");
	}

}
