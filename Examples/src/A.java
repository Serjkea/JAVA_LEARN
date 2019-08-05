
public class A {

	int number;
	char symbol;
	
	A(){
		number=0;
		symbol='a';
		System.out.println("Without arguments");
		show();
	}
	
	A(int number){
		this.number=number;
		symbol='b';
		System.out.println("With one argumnet");
		show();
	}
	
	A(int number, char symbol){
		this.number=number;
		this.symbol=symbol;
		System.out.println("With two arguments");
		show();
	}
	
	void show(){
		System.out.println("Result: "+number+" "+symbol);
	}
	
}
