import java.lang.reflect.*;


public class MyNewClass {
	
	private int mn = 10;
	
	public void met() {
		
	}
	
	enum MyEnum {
		MyEnumClass1, MyEnumClass2, MyEnumClass3;
		public void doPrint() {
			System.out.println("COOL! " + this.name());
		}
	}

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("Thread name: " + t.getName());
		System.out.println(Thread.activeCount());
		Thread t1 = new Thread("demo"){
			public void run() {
				System.out.println("Thread t1");
				
			}
		};
		System.out.println(t1.isAlive());
		t1.start();
		System.out.println(t1.isAlive());			
		System.out.println("Thread name: " + t1.getName());
		System.out.println(Thread.activeCount());
		Thread t2 = new Thread("mythread"); 
		System.out.println("Thread name: " + t2.getName());
		System.out.println(Thread.activeCount());	
		System.out.println(t.isAlive());			
		System.out.println(t1.isAlive());			
		System.out.println(t2.isAlive());	
		
		MyNewThread t3 = new MyNewThread("my first");
		MyNewThread t4 = new MyNewThread("my second"){
			public void run() {
				try {
					System.out.println("New thread " + t.getName() + " is working!");
					Thread.sleep(100);
				} catch(InterruptedException e) {
					System.out.println(e);
				}

			}
		};
		MyNewThread t5 = new MyNewThread("my third");
		System.out.println(Thread.activeCount());
		try {
			t3.t.join();
			System.out.println(Thread.activeCount());
			t4.t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.activeCount());

		MyNewClass ob = new MyNewClass();
		Class<?> c = ob.getClass();
		System.out.println(c);
		try {
			Method m = c.getMethod("met");
			System.out.println(m.getName());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyEnum.MyEnumClass1.doPrint();
		MyEnum.MyEnumClass2.doPrint();
		MyEnum.MyEnumClass3.doPrint();
		
		
	}

}
