
public class Test {

	int a;
	int b;
	
	Test (int i, int j) {
		this.a = i;
		this.b = j;
	}

	Test (Test obj) {
		this.a = obj.a;
		this.b = obj.b;
	}
	
	boolean equals(Test obj) {
		if ((obj.a == a)&&(obj.b == b)) {
			return true;
		} else {
			return false;
		}
	}
	
	void sum(int i, int j){
		i *= 2;
		j /= 2;
	}
	
	void sum(Test obj){
		obj.a *= 2;
		obj.b /= 2;
	}
	
	Test returnObj() {
		Test tmp = new Test(a+15,b+25);
		return tmp;
	}
}
