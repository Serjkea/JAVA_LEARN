
public class A {
	
	private static int count = 0;
	private int id;
	
	A(){
		count++;
		id = count;
	}
	
	public U getU() {
		return new U() {

			public void method1() {
				System.out.println("class A with id = " + id + " method1");
			}

			public void method2() {
				System.out.println("class A with id = " + id + " method2");
			}

			public void method3() {
				System.out.println("class A with id = " + id + " method3");
			}
			
		};
	}

}
