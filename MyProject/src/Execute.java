
public class Execute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayClass	A = new ArrayClass();
		ArrayClass	B = new ArrayClass();
		
		A.setArray();
		System.out.println("*****************************");
		A.getArray();
		System.out.println("*****************************");
		A.sortArray();
		System.out.println("*****************************");
		A.getArray();
		System.out.println("*****************************");
		B.setArray();
		System.out.println("*****************************");
		B.getArray();
		System.out.println("*****************************");
		B.sortArray();
		System.out.println("*****************************");
		B.getArray();
		System.out.println("*****************************");
		if (A.powerArray() > B.powerArray()){
			System.out.println("A powerfull then B");
		} else {
			if (A.powerArray() < B.powerArray()){
			System.out.println("B powerfull then A");
		}
		else if (A.powerArray() == B.powerArray()){
			System.out.println("A power equals B power");
		}
		}
		
	}
	

}
