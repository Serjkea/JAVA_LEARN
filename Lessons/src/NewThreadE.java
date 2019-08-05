
public class NewThreadE extends Thread {

	NewThreadE() {
		super("DemoThread");
		System.out.println("New thread : " + this);
		start();
	}	

public void run() {
		try {
			for(int i=5;i>0;i--) {
				System.out.println("New thread: " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("New thread is aborted");
		}
		System.out.println("New thread is end");

    }

}
