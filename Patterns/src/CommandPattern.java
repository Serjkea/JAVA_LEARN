import java.util.*;


interface Command {
	public void execute();
}

class StartEngine implements Command {
	
	private Engine engine;
	
	StartEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void execute() {
		engine.start();
	}
	
}

class Engine {
	
	public void start() {
		System.out.println("Engine start!");
	}
	
}

class StartAirCleaner implements Command {
	
	private AirCleaner airCleaner;
	
	StartAirCleaner(AirCleaner airCleaner) {
		this.airCleaner = airCleaner;
	}
	
	public void execute() {
		airCleaner.start();
	}
	
}

class AirCleaner {
	
	public void start() {
		System.out.println("AirCleaner start!");
	}
}

class RemoteControl {
	
	private List<Command> buttons;
	
	RemoteControl() {
		buttons = new ArrayList();
	}
	
	public void setCommand(Command command, int numButton) {
		buttons.add(numButton,command);
	}
	
	public void pushButton(int numButton) {
		buttons.get(numButton).execute();
	}
	
}

class CompoundCommand implements Command {
	
	private List<Command> list = new ArrayList<Command>();
	
	CompoundCommand(List commands) {
		list = commands;
	}
	
	public void execute() {
		for(Command c : list) {
			c.execute();
		}
	}
	
}

public class CommandPattern {
	
	
	public static void main(String[] args) {
		Engine engine = new Engine();
		StartEngine startEngine = new StartEngine(engine);
		AirCleaner airCleaner = new AirCleaner();
		StartAirCleaner startAirCleaner = new StartAirCleaner(airCleaner);
		List<Command> list = new ArrayList();
		list.add(startEngine);
		list.add(startAirCleaner);
		CompoundCommand cc = new CompoundCommand(list);
		RemoteControl remoteControl = new RemoteControl();
		remoteControl.setCommand(startEngine, 0);
		remoteControl.setCommand(startAirCleaner, 1);
		remoteControl.pushButton(0);
		remoteControl.pushButton(1);
	}
	
}
