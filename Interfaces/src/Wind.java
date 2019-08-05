
public class Wind implements Instrument{
	public void play(String n) {
		System.out.println(this + ".play() " + n);
	}
	public String toString(){
		return "Wind";
	}
	public void adjust(){
		System.out.println(this + ".adjust() ");
		};

}
