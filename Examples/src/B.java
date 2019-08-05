
public class B  extends A{
	
	String text;
	
	B() {
		super();
		text="Without arguments";
		showText();
	}
	
	B(int number) {
		super(number);
		text="With one argument";
		showText();
	}

	B(int number,char symbol,String text) {
		super(number,symbol);
		this.text=text;
		showText();
	}
	
	void showText(){
		System.out.println("Result: " + text);
	}
}
