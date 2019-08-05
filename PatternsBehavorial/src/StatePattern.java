
interface State {
	void handle();
}

class SleepState implements State {
	public void handle() {
		System.out.println("I'm sleep!");
	}
}

class PlayState implements State {
	public void handle() {
		System.out.println("I'm play!");
	}
}

class Context {
	
	private State state;
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void handle() {
		state.handle();
	}
}

public class StatePattern {
	
	public static void main(String[] args) {
		Context context = new Context();
		context.setState(new SleepState());
		context.handle();
		context.setState(new PlayState());
		context.handle();
	}
}
