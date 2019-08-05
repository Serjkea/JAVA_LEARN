import java.util.ArrayList;

interface IWorker {
	void work();
	void stop();
}

class Person {
	private String name;
	private int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return "Name: "+this.name+" Age: "+this.age;
	}
}

class Worker extends Person implements IWorker {
	private int qualify;
	
	Worker(String name, int age, int qualify) {
		super(name, age);
		this.qualify = qualify;
	}
	
	public String toString() {
		return "Worker: "+super.toString()+" Qualify: "+this.qualify;
	}
	
	public int getQualify() {
		return this.qualify;
	}
	
	public void work() {
		System.out.println(this+" is working!");
	}
	
	public void stop() {
		System.out.println(this+" stop to work!");
	}
}

interface IFactory {
	void doWork();
	void result();
}

class Factory implements IFactory {
	
	private ArrayList<Worker> workerList = new ArrayList<Worker>();
	private ArrayList<Worker> activeWorkers = new ArrayList<Worker>();
	private int level;
	
	Factory(int level) {
		this.level = level;
	}
	
	public void addWorker(Worker worker) {
		workerList.add(worker);
	}
	
	public void doWork() {
		for(Worker worker : workerList) {
			if (worker.getQualify() >= this.level) activeWorkers.add(worker);
		}
		for(Worker worker : activeWorkers) {
			worker.work();
		}
	}
	
	public void result() {
		if (activeWorkers.isEmpty()) System.out.println("Work is not completed!");
		else System.out.println("Work can be completed!");
	}
	
	public void info() {
		System.out.println("Factory has level: " + this.level);
		System.out.println("At factory works: ");
		for(Worker worker: workerList) {
			System.out.println(worker+" "+(activeWorkers.contains(worker)?"*":""));
		}
	}
	
	public String toString() {
		return "At factory "+this.workerList.size()+" workers. Active workers number is " + this.activeWorkers.size();
	}
	
}

public class MyTest { 

	public static void main(String []args) {
		Worker worker1 = new Worker("Mike", 35, 6);
		Worker worker2 = new Worker("Nik", 25, 3);
		Worker worker3 = new Worker("Aron", 45, 10);
		Worker worker4 = new Worker("Bob", 37, 4);
		Worker worker5 = new Worker("Mitch", 28, 7);
		Factory factory6 = new Factory(6);
		Factory factory4 = new Factory(4);
		factory6.addWorker(worker1);
		factory6.addWorker(worker2);
		factory6.addWorker(worker3);
		factory4.addWorker(worker4);
		factory4.addWorker(worker5);
		factory6.doWork();
		factory4.doWork();
		factory6.result();
		factory4.result();
		System.out.println(factory6);
		System.out.println(factory4);
		factory6.info();
		factory4.info();
	}
	
}

