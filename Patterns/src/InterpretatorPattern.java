
interface Expression {
	String interpret(Context1 context);
}

class Context1 {
	
	public String getLoverCase(String s) {
		return s.toLowerCase();
	}
	
	public String getUpperCase(String s) {
		return s.toUpperCase();
	}
	
}

class LoverExpression implements Expression {
	
	private String s;
	
	public LoverExpression(String s) {
		this.s = s;
	}
	
	public String interpret(Context1 context) {
		return context.getLoverCase(s);
	}
}

class UpperExpression implements Expression {
	
	private String s;
	
	public UpperExpression(String s) {
		this.s = s;
	}
	
	public String interpret(Context1 context) {
		return context.getUpperCase(s);
	}
}

public class InterpretatorPattern {
	
	public static void main(String[] args) {
		String text = "TesT";
		Context1 context = new Context1();
		Expression loverExpression = new LoverExpression(text);
		text = loverExpression.interpret(context);
		System.out.println(text);
		Expression upperExpression = new UpperExpression(text);
		text = upperExpression.interpret(context);
		System.out.println(text);
	}

}
