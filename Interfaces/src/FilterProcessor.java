
public class FilterProcessor {
	public static void main(String[] args) {
		Waveform w = new Waveform();
		Apply.process(new FilterAdapter(new LowPass(1.0)), w);
		Waveform w1 = new Waveform();
		Apply.process(new FilterAdapter(new HighPass(2.0)), w1);
		Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
		String s = "Have a good day!";
		Apply.process(new Upcase(), s);
		Apply.process(new Downcase(), s);
	}

}
