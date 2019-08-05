package ru.practics.concurrentexamples.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;


class Store {
	
	private int store;
	private int max;
	
	public boolean isEmpty;
	public boolean isFull;
	
	private Lock lock;
	private Semaphore sem = new Semaphore(1);
	
	Store(int max) {
		this.store = 5;
		this.max = max;
		this.isEmpty = false;
		this.isFull = false;
	}
	
	public void add() {
		if (store < max) {
			this.store++;
			if (store == max) {
				isFull = true;
				isEmpty = false;
				System.out.println("Store is full!");
			} else {
				isFull = false;
			}
		} else {
			isFull = true;
			isEmpty = false;
			System.out.println("Store is full!");
		}
	}

	public void get() {
		if (!isEmpty) {
			this.store--;
			if (this.store == 0) {
				System.out.println("Store is empty!");
				isEmpty = true;
				isFull = false;
			} else {
				isEmpty = false;
			}
		} else {
			isEmpty = false;
			isFull = false;
		}
	}
	
	@Override 
	public String toString() {
		return Integer.toString(store);
	}
}

class Producer implements Runnable{
	
	private Store store;
	private String name;
	
	Producer(String name) {
		this.name = name;
	}
	
	public void addStore(Store store) {
		this.store = store;
	}
	public void work() throws InterruptedException {
		while(!store.isFull) {
			Thread.currentThread().sleep(new Random().nextInt(5000));
			store.add();
			System.out.println(this.name + " " + store);
		}
	}
	@Override
	public void run() {
		try {
			work();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable{
	
	private Store store;
	private String name;
	
	Consumer(String name) {
		this.name = name;
	}
	
	public void addStore(Store store) {
		this.store = store;
	}

	@Override
	public void run() {
		try {
			buy();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void buy() throws InterruptedException {
		while(!store.isEmpty) {
			Thread.currentThread().sleep(new Random().nextInt(5000));
			store.get();
			System.out.println(this.name + " " + store);
		}
	}
}

public class Shop {
	
	private static List<Producer> producers = new ArrayList<Producer>();
	private static List<Consumer> consumers = new ArrayList<Consumer>();
	private static Store store = new Store(20);
	
	public static void addProducer(Producer producer) {
		producer.addStore(store);
		producers.add(producer);
	}
	
	public static void addConsumer(Consumer consumer) {
		consumer.addStore(store);
		consumers.add(consumer);
	}
	
	public static void work() {
		ExecutorService workers = Executors.newFixedThreadPool(producers.size());
		for (Producer p: producers) {
			workers.execute(p);
		}
	}
	
	public static void buy() {
		ExecutorService buyers = Executors.newSingleThreadScheduledExecutor();
		for (Consumer c: consumers) {
			buyers.execute(c);
		}
	}
	
	public static void main(String[] args) {
		addProducer(new Producer("prod1"));
		addProducer(new Producer("prod2"));
		addConsumer(new Consumer("cons1"));
		new Thread(new Runnable() {
			@Override
			public void run() {
				work();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				buy();
			}
		}).start();
	}

}
