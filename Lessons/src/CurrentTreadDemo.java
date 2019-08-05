
public class CurrentTreadDemo {
	
	public static void main(String[] args) {
	/*	Thread t = Thread.currentThread();
		System.out.println("Current thread: " + t);
		
		t.setName("My Thread");
		System.out.println("Current thread: " + t);
		
		try {
			for(int i = 5; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread is aborted!");
		}
	*/	
	/*	new NewThreadE();
		
		try {
			for(int i = 5;i>0;i--) {
				System.out.println("Main thread: " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread is aborted!");
		}
		
		System.out.println("Main thread is end!");
		*/
	/*	
		new NewThread("One");
		new NewThread("Two");
		new NewThread("Three");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Main thread is end!");
		}
		
		System.out.println("Main thread is end!");
*/
		NewThread nt1 = new NewThread("One");
		NewThread nt2 = new NewThread("Two");
		NewThread nt3 = new NewThread("Three");

		System.out.println("Thread One is start: " + nt1.t.isAlive());
		System.out.println("Thread Two is start: " + nt2.t.isAlive());
		System.out.println("Thread Three is start: " + nt3.t.isAlive());
		
		try {
			System.out.println("Waiting ends of threads");
			nt1.t.join();
			nt2.t.join();
			nt3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread is aborted!");
		}
		
		System.out.println("Thread One is started: " + nt1.t.isAlive());
		System.out.println("Thread Two is started: " + nt2.t.isAlive());
		System.out.println("Thread Three is started: " + nt3.t.isAlive());
		
		System.out.println("Main thread is end!");		
		
	}

}
