
public class Apply {
	
	public static void process(Processor p, Object s) {
		System.out.println("Using a Processor " + p.name());
		System.out.println(p.process(s));
	}
	
	final static String s = "Hello, dear friend!";
	
	public static void main(String[] args) {
		process(new Upcase(), s);// Strategy pattern - method change way by Object
		process(new Downcase(), s);
		process(new Splitter(), s);
	}

}
