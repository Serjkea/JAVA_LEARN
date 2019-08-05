import java.util.*;
public class SimpleThreadDemo {

	public static void main(String[] args) throws InterruptedException{

		System.out.println("Main thread is started: "+new Date());
		Random rnd=new Random();
		new MyThread();
		for (int i=0;i<5;i++) {
			Thread.sleep(5000+rnd.nextInt(5000));
			System.out.println("Main thread: "+new Date());
		}
		System.out.println("Main thread is stopped: "+new Date());
		
	}

}
