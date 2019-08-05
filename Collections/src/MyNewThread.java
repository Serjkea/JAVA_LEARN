
public class MyNewThread implements Runnable {
	
	Thread t;
	
	MyNewThread(String name){
		t = new Thread(this,name);
		t.start();
	}
	
	public void run() {
		try {
			System.out.println("New thread " + t.getName() + " is working!");
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			System.out.println(e);
		}
	}

}
