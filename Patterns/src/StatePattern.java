
interface State {
	void doAction();
}

class StartPlay implements State {
	
	public void doAction() {
		System.out.println("Play!");
	}
	
}

class StopPlay implements State {
	
	public void doAction() {
		System.out.println("Stop!");
	}
	
}

class PlayContext implements State{
	
	private State state;
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void doAction() {
		this.state.doAction();
	}
	
}

public class StatePattern {
	
	public static void main(String[] args) {
		PlayContext playContext = new PlayContext();
		StartPlay start = new StartPlay();
		StopPlay stop = new StopPlay();
		playContext.setState(start);
		playContext.doAction();
		playContext.setState(stop);
		playContext.doAction();
	}

}
