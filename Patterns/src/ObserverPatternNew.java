import java.util.*;

interface Observer {
	void event(List<String> list);
}

class University {
	
	private List<String> students = new ArrayList();
	private List<Observer> observers = new ArrayList();
	
	public void addStudent(String name) {
		students.add(name);
		notifyObservers();
	}
	
	public void removeStudent(String name) {
		students.remove(name);
		notifyObservers();
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(Observer o: observers) {
			o.event(students);
		}
	}
	
}

class Director implements Observer {
	public void event(List<String> list) {
		System.out.println("List of students has changed! " + list);
	}
}

public class ObserverPatternNew {
	
	public static void main(String[] args) {
		University university = new University();
	    Director director = new Director();
	    Director directoress = new Director();
	    university.addObserver(director);
	    university.addStudent("Mike");
	    university.addStudent("Bob");
	    university.addStudent("Nik");
	    university.removeStudent("Bob");
	}
}
