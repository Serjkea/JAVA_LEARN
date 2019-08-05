import java.util.*;

interface Observer {
	void update();
}

interface Subject {
	void attachObserver(Observer observer);
	void detachObserver(Observer observer);
	void doSomething();
}

class ConcreteObserver implements Observer {
	public void update() {
		System.out.println("He do something!");
	}
}

class ConcreteSubject implements Subject {
	
	private List<Observer> observers = new ArrayList();
	
	public void attachObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void detachObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void doSomething() {
		System.out.println("I do!");
		for(Observer observer: observers) {
			observer.update();
		}
	}
}

public class ObserverPattern {
	
	public static void main(String[] args) {
		Subject subject = new ConcreteSubject();
		Observer observer = new ConcreteObserver();
		subject.attachObserver(observer);
		subject.attachObserver(new ConcreteObserver());
		subject.attachObserver(new ConcreteObserver());
		subject.doSomething();
		subject.detachObserver(observer);
		subject.doSomething();		
		}
}
