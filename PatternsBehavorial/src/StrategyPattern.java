
interface Strategy {
	void execute();
}

class AStrategy implements Strategy {
	public void execute() {
		System.out.println("A - Strategy!");
	}
}

class BStrategy implements Strategy {
	public void execute() {
		System.out.println("B - Strategy!");
	}
}

class ContextStrategy {
	
	private Strategy strategy;
	
	ContextStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void doIt() {
		this.strategy.execute();
	}
}

public class StrategyPattern {
	
	public static void main(String[] args) {
		ContextStrategy context = new ContextStrategy(new AStrategy());
		context.doIt();
		context = new ContextStrategy(new BStrategy());
		context.doIt();
	}

}
