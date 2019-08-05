
public class EnumDemo {

	enum List {
		One(1), Two(2), Three(3), Four(4), Five(5);
		
		private int num;
		
		List(int i) {num = i;}

		List() {num = -1;}
		
		int getNum() {return num;}
	}

	
	public static void main(String[] args) {
	//	List ls;
		
		System.out.println("One is " + List.One.getNum());
		System.out.println("All numbers:");
		for(List a : List.values()) {
			System.out.println(a + " is " + a.getNum());
		}
			

	}

}
