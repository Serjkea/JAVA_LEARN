
public class B {
	private U[] uArray = new U[3];
	private int i = 0;
	
	public void push(U u) {
		if(i < uArray.length){
			uArray[i] = u;
			i++;
		} else {
			System.out.println("Array is full!");
		}
	}
	
	public void pop(int num) {
		uArray[num] = null;
	}
	
	public void exec() {
		for(U u: uArray){
			u.method1();
			u.method2();
			u.method3();
		}
	}

}
