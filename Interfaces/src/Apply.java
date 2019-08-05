
public class Apply {
	
	public static void process(Processor p, Object s) {
		System.out.println("Using a Processor " + p.name());
		System.out.println(p.process(s));
	}
	
	public static String s = "Hi my dear friend!";

	public static void main(String[] args) {
		process(new Upcase(), s);
		process(new Downcase(), s);
		process(new Splitter(), s);
		process(new ReverseAdapter(new Reverse()), s);

	}

}
