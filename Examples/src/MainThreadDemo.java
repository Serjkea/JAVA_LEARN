
public class MainThreadDemo {

	public static void main(String[] args) throws InterruptedException{
		Thread t;
		long time=2500;
		t=Thread.currentThread();
		System.out.println(t);
		t.setName("Main thread!");
		int p=t.getPriority();
		t.setPriority(++p);
		System.out.println(t);
		System.out.println("Thread is paused on "+(double)time/1000+" seconds.");
		Thread.sleep(time);
		System.out.println("End of program");

	}

}
