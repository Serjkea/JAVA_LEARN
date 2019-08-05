package ru.practics.concurrentexamples;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource {
	
	public int counter = 0;
	private Lock lock = new ReentrantLock();
	
	Resource() {
	}				
	
	public void count() {
		try {
			if (lock.tryLock()) {
				counter++;
				System.out.println(counter);
				Thread.currentThread().sleep(new Random().nextInt(2000));
				lock.unlock();
			} else {
				System.out.println("No lock");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
//			lock.unlock();
		}
		
	}
	
}

class Worker extends Thread {
	
//	private Semaphore semaphore;
	private Resource resource;
	private static int counter = 0;
	private int id = ++counter;
	
	Worker(/*Semaphore semaphore, */Resource resource) {
//		this.semaphore = semaphore;
		this.resource = resource;
	}

	@Override
	public void run() {
		while(resource.counter < 50) {
			try {
//				semaphore.acquire();
				System.out.println("Worker with id: " + this.id);
				resource.count();
				sleep(new Random().nextInt(5000));
//				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}

public class Main {
	
	public static void main(String[] args) {
		Resource resource = new Resource();
	//	Semaphore semaphore = new Semaphore(4);
		for(int i = 0; i < 3; i++) {
			new Thread(new Worker(resource)).start();
		}
		
	}

}
