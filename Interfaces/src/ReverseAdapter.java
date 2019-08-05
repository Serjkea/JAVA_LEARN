
public class ReverseAdapter implements Processor {

	Reverse reverse;
	
	public ReverseAdapter(Reverse reverse) {
		this.reverse = reverse;
	}
	
	@Override
	public String name() {
		return reverse.getClass().getSimpleName();
	}

	@Override
	public String process(Object input) {
		return reverse.reverse((String)input);
	}

}
