import java.util.*;
public class MyNewThread extends Thread{
	
	private boolean UpDown;
	private String name;
	private MyNewClass obj;
	
	public void run() {
		Random rnd=new Random();
		int number;
		for (int i=1;i<=3;i++) {
			synchronized(obj) {
			try {
				number=obj.get(name);
				if (UpDown) number++;
				else number--;
				sleep(100+rnd.nextInt(9000));
				obj.set(number, name);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		}
		
	}
	
	MyNewThread(boolean UpDown,MyNewClass obj) {
		this.UpDown=UpDown;
		if (UpDown) name="Up-thread. ";
		else name="Down-thread. ";
		this.obj=obj;
		start();
	}

}
