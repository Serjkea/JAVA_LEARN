
public class Base {
	private String name;
	private int number;
	
	Base(String name, int number) {
		this.name=name;
		this.number=number;
	}
	
	private void show() {
		System.out.println("Object name: "+name);
	}
	
	void showAll() {
		show();
		System.out.println("Number field: "+ number);
	}
	
	void setAll(String name, int number) {
		this.name=name;
		this.number=number;
	}

}
