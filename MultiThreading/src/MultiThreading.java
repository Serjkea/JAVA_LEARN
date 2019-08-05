import java.util.Random;

class A implements Runnable{
	
	private boolean findOK = false; 
	
	A() {
		System.out.println("Constructor class A");
	}
	
	public void run() {
		System.out.println("A class Thread");
		int i = 0;
		while (new Random().nextInt(100000000) != 50){
			i++;
		}
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("A class Find equal, step " + i);
		findOK = true;
	}
	
}
class B implements Runnable {

	private boolean findOK = false; 
	
	B() {
		System.out.println("Constructor class B");
	}
	
	public void run() {
		System.out.println("B class Thread");
		int i = 0;
		while (new Random().nextInt(100000000) != 50){
			i++;
		}
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("B class Find equal, step " + i);
		findOK = true;
	}
}


public class MultiThreading {
	
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		new Thread(a).start();
		new Thread(b).start();
		
	}

}
