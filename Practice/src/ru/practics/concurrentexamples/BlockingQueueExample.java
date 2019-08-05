package ru.practics.concurrentexamples;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

class Producer extends Thread{
	
	private BlockingQueue<Integer> queue = null;
	
	Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			queue.put(1);
			System.out.println("Producer put 1");
			sleep(1000);
			queue.put(2);
			System.out.println("Producer put 2");
			sleep(1000);
			queue.put(3);
			System.out.println("Producer put 3");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Consumer extends Thread {
	
	private BlockingQueue<Integer> queue = null;
	
	Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Consumer take " + queue.take());
			System.out.println("Consumer take " + queue.take());
			System.out.println("Consumer take " + queue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class DelayedElement implements Delayed {

	@Override
	public int compareTo(Delayed arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getDelay(TimeUnit arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

public class BlockingQueueExample {
	
	public static void main(String[] args) {
		BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(10);
		
		Producer producer = new Producer(arrayBlockingQueue);
		Consumer consumer = new Consumer(arrayBlockingQueue);
		new Thread(producer).start();
		new Thread(consumer).start();
		
		BlockingQueue delayQueue = new DelayQueue();
		
		Delayed element1 = new DelayedElement();
		try {
			delayQueue.put(element1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<Integer>(10);
		
		BlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
		
		BlockingQueue synchronousQueue = new SynchronousQueue();
		
		BlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
		
		ConcurrentMap<Integer, String> concurrentHAshMap = new ConcurrentHashMap<Integer, String>();
		
		ConcurrentNavigableMap<Integer, String> concurrentNavigableMap = new ConcurrentSkipListMap<Integer, String>();
		
		
		
	}

}
