
public class MyCLass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Stack mystack1 = new Stack(10);
		Stack mystack2 = new Stack(10);
		
		for(int i=0; i<10; i++) mystack1.push(i);
		for(int i=10; i<20; i++) mystack2.push(i);
		
		System.out.println("Stack1:");
		for(int i=0; i<10; i++) 
			System.out.println(mystack1.pop());
		
		System.out.println("Stack2:");
		for(int i=10; i<20; i++) 
			System.out.println(mystack2.pop());
		
		
		
		Test obj1 = new Test(100, 200);
		Test obj2 = new Test(10, 20);
		Test obj3 = new Test(100, 200);
		Test obj4 = new Test(obj1);
		
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.equals(obj3));
		System.out.println(obj2.equals(obj3));
		System.out.println(obj4.equals(obj1));
		
		Test obj = new Test(10,20);
		int a = 5;
		int b = 6;
		System.out.println(a + " " + b);
		obj.sum(a, b);
		System.out.println(a + " " + b);
		
		Test newObj = new Test(10,20);
		System.out.println(newObj.a + " " + newObj.b);
		newObj.sum(newObj);
		System.out.println(newObj.a + " " + newObj.b);
		
		Test ref;
		
		ref = obj1.returnObj();
		System.out.println(ref.a + " " + ref.b);
		ref = obj2.returnObj();
		System.out.println(ref.a + " " + ref.b);
		
		Factorial f = new Factorial();
		
		System.out.println("Factorial at 3 = " + f.fact(3));
		System.out.println("Factorial at 4 = " + f.fact(4));
		System.out.println("Factorial at 5 = " + f.fact(5));
		
		Array ar = new Array(10);
		int i;
		
		for (i=0; i<10; i++) ar.values[i] = i;
		
		ar.printArray(10);
		
		UseStatic.meth(55);
		
		String s = "This is a text";
		
		System.out.println(s + " String with lenght = " + s.length() +  " hash-code = " + s.hashCode());
		
		int n1[] = { 10 };
		int n2[] = { 1, 2, 3 };
		int n3[] = { };
		PassArray pa = new PassArray();
		pa.vaTest(n1);
		pa.vaTest(n2);
		pa.vaTest(n3);
		VarArray va = new VarArray();
		va.vaTest(10);
		va.vaTest(1, 2, 3);
		va.vaTest();
		
		A objA = new A();
		B objB = new B();
		C objC = new C();
		A refA;
		B refB;
		
		objA.show();
		objB.show();
		objC.show();
		
		System.out.println();
				
		refA = objA;
		refA.show();
		refA = objB;
		refA.show();
		refA = objC;
		refA.show();

		System.out.println();

		refA = objA;
		refA.show();
		refB = objB;
		refB.show("String");
		refA = objC;
		refA.show();
		
		AbsA abs = new AbsA();
		abs.callme();
		abs.callmetoo();
		
		Callback c = new Client();
		c.callback(5);
		AnotherClient ac = new AnotherClient();
		c = ac;
		c.callback(10);
		Client bb = new Client();
		bb.meth();
		
	}

}
