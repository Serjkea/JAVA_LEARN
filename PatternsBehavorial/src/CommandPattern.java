import java.util.*;

interface Command {
	void execute();
}

class Jump implements Command {
	public void execute() {
		System.out.println("Jump!");
	}
}

class Run implements Command {
	public void execute() {
		System.out.println("Run!");
	}
}

class Walk implements Command {
	public void execute() {
		System.out.println("Walk!");
	}
}

class CommandExecutor {
	
	private List<Command> commandList = new ArrayList();
	
	public void addCommand(Command command) {
		commandList.add(command);
	}
	
	public void runCommands() {
		for(Command command: commandList) {
			command.execute();
		}
	}
}

public class CommandPattern {
	
	public static void main(String[] args) {
		CommandExecutor commandExecutor = new CommandExecutor();
		commandExecutor.addCommand(new Jump());
		commandExecutor.addCommand(new Walk());
		commandExecutor.addCommand(new Run());
		commandExecutor.runCommands();
	}
}
