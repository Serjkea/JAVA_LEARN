import java.util.*;
public class MyThread implements Runnable {
	
	public void run() {
		System.out.println("Child thread is started: "+new Date());
		Random rnd=new Random();
		for (int i=0;i<=10;i++) {
			try {
				Thread.sleep(1000+rnd.nextInt(4000));
				System.out.println("Child thread: "+new Date());
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		System.out.println("Child thread is stopped: "+new Date());
	}
	
	MyThread() {
		new Thread(this).start();
	}

}
