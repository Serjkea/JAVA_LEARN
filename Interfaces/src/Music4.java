
public class Music4 {
	
	static final String Note = "MIDDLE_C";
	
	static void tune(Instrument i) {
		i.play(Note);
	}
	static void tuneAll(Instrument[] e) {
		for (Instrument i : e)
			tune(i);
	}
	public static void main(String[] args) {
		Instrument[] orchestra = {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Brass(),
				new Woodwind()
		};
		tuneAll(orchestra);
		System.out.println();
		System.out.println(new Wind().toString());
		System.out.println(new Brass().i);
		new Wind().adjust();
	}

}
