import java.util.Random;
import javax.swing.*;

class Store {
	
	private static final int MAX = 10;
	
	private int goods;
	public boolean isFull;
	public boolean isEmpty;
	
	Store() {
		goods = 0;
		isFull = false;
		isEmpty = true;
		System.out.println("Store");
	}
	
	public synchronized void putGood() {
		if (!isFull) {
			notify();
			goods++;
			if (goods == MAX) {
				isFull = true; 
			}
			if (goods > 0) isEmpty = false;
			System.out.println("Put good in store: " + goods);
		} else {
			System.out.println("Store is Full");
			try{
				wait();
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public synchronized void getGood() {
		if (!isEmpty) {
			notify();
			goods--;
			if (goods == 0) {
				isEmpty = true;
			}
			if (goods < MAX) isFull = false;
			System.out.println("Get good from store: " + goods);
		} else {
			System.out.println("Store is Empty"); 
			try{
				wait();
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public String toString() {
		return "Current number of goods: " + goods;
	}
}

class Producer implements Runnable{
	
	private Store store;
	
	Producer(Store store){
		this.store = store;
		System.out.println("Producer");
	}
	
	public void run() {
		while(true){//!store.isFull
			try{
				Thread.sleep(new Random().nextInt(1000));
		    } catch(InterruptedException e) {
		    	System.out.println(e.getMessage());
		    }
		    store.putGood();
		}
	}
	
}

class Consumer implements Runnable {
	
	private Store store;
	
	Consumer(Store store) {
		this.store = store;
	}
	
	public void run() {
		while(true){//!store.isEmpty
			try{
				Thread.sleep(new Random().nextInt(1000));//new Random().nextInt(1000)
		    } catch(InterruptedException e) {
		    	System.out.println(e.getMessage());
		    }
		    store.getGood();
		} 
		
	}
	
}


public class Sychronize {

	static Store store = new Store();
	
	public static void main(String[] args)/*{synchronized(store)*/{
		new Thread(new Producer(store)).start();
		new Thread(new Producer(store)).start();
		new Thread(new Producer(store)).start();
		new Thread(new Consumer(store)).start();
		new Thread(new Consumer(store)).start();
		JOptionPane.showMessageDialog(null, "OK");
	}//}
	
}
