
public class NewThread implements Runnable{
	String name;
	Thread t;
	
	NewThread(String threadName) {
		name = threadName;
		t = new Thread(this, name);
		System.out.println("New thread is created: "+t);
		t.start();
	}
	
	public void run() {
		try {
			for(int i=5;i>0;i--) {
				System.out.println("New thread: " + t.getName() + " step " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("New thread is aborted: " + t.getName());
		}
		System.out.println("New thread is end: " + t.getName());
	}

}
