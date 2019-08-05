
public abstract class StringProcessor implements Processor {
	public String name() {
		return getClass().getSimpleName();
	}
	public abstract String process(Object input);
	public static String s = "What a beautiful day!";
	public static void main(String[] args) {
		Apply.process(new Upcase(), s);
		Apply.process(new Downcase(), s);
		Apply.process(new Splitter(), s);
	}

}
