
interface Expression {
	String interpret(CurrentContext context);
}

class TerminalExpression implements Expression {
	
	private String s;
	
	TerminalExpression(String s) {
		this.s = s;
	}
	
	public String interpret(CurrentContext context) {
		return context.getOneResult(s);
	}
}

class NonterminalExpression implements Expression {
	
	private String s;
	
	NonterminalExpression(String s) {
		this.s = s;
	}
	public String interpret(CurrentContext context) {
		return context.getTwoResult(s);
	}
}

class CurrentContext {
	
	public String getOneResult(String s) {
		return "Hello " + s;
	}
	
	public String getTwoResult(String s) {
		return "Hi " + s;
	}
}

public class InterpretatorPattern {
	
	public static void main(String[] args) {
		String str = "Mike";
		CurrentContext context = new CurrentContext();
		System.out.println(new TerminalExpression(str).interpret(context));
		System.out.println(new NonterminalExpression(str).interpret(context));
		
	}
}
