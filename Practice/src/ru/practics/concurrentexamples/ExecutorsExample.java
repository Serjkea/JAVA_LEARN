package ru.practics.concurrentexamples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsExample {
	
	public static void main(String[] args) {
		ExecutorService executors = Executors.newFixedThreadPool(2);
	//	ExecutorService executors = Executors.newSingleThreadExecutor();
	//	ExecutorService executors = Executors.newScheduledThreadPool(2);
		executors.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("Task 1");
				try {
					Thread.currentThread().sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Start task 1");
				try {
					Thread.currentThread().sleep(800);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("End task 1");
			}
			
		});
		executors.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("Task 2");
				try {
					Thread.currentThread().sleep(700);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Start task 2");
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("End task 2");
			}
			
		});
		executors.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("Task 3");
				try {
					Thread.currentThread().sleep(1200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Start task 3");
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("End task 3");
			}
			
		});
		
		Future future = executors.submit(new Runnable() {

			@Override
			public void run() {
				System.out.println("Task 4");
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Start task 4");
				try {
					Thread.currentThread().sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("End task 4");
			
			}
			
		});
		
		Future future1 = executors.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.currentThread().sleep(1000);
				return "Task 5 was end";
			}
			
		});
		
		try {
			System.out.println("wait");
			System.out.println(future.get());
			System.out.println("ok");
			System.out.println(future1.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executors.shutdown();
		
		
	}

}
