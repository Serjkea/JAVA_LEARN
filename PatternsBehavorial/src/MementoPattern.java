
class Memento {
	
	private int state;
	
	Memento(int state) {
		this.state = state;
	}
	
	public int getState() {
		return state;
	}
	
}

class Originator {
	
	private int state;
	private Memento caretaker;
	
	Originator(int state) {
		this.state = state;
	}
	
	public void save() {
		caretaker = new Memento(state);
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public void getState() {
		System.out.println(state);
	}
	
	public void undo() {
		this.state = caretaker.getState();
	}
	
}

public class MementoPattern {
	
	public static void main(String[] args) {
		Originator service = new Originator(1);
		service.save();
		service.getState();
		service.setState(0);
		service.getState();
		service.undo();
		service.getState();
	}

}
