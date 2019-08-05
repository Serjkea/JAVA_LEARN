
public class TopClass {
	
	public static void main(String[] args) {
		
		SuperClass super_c = new SuperClass();
		SubClass sc = new SubClass("");
		SubSubOneClass ssoc = new SubSubOneClass();
		SubSubTwoClass sstc = new SubSubTwoClass();

/*		
		super_c.print();
		System.out.println(super_c.name);
		sc.print();
		System.out.println(sc.name);
		ssoc.print();
		System.out.println(ssoc.name);
		sstc.print();
		System.out.println(sstc.name);
		
		System.out.println();
		
		super_c.staticMethod();
		super_c = sc;
		super_c.print();
		super_c.staticMethod();
		System.out.println(super_c.name);
		super_c = ssoc;
		super_c.print();
		super_c.staticMethod();
		System.out.println(super_c.name);
		super_c = sstc;
		super_c.print();
		super_c.staticMethod();
		super_c = new SuperClass();
		System.out.println(super_c.name);
		
		System.out.println();
		
		sc.staticMethod(5);
		sc = ssoc;
		sc.print();
		sc.staticMethod();
		System.out.println(sc.name);
		sc = sstc;
		sc.print();
		sc.staticMethod();
		System.out.println(sc.name);
		//sc = (SubClass)super_c; //ClassCastException!!!
		sc = new SubClass();
		if (super_c instanceof SubClass)
			sc = (SubClass)super_c;
		sc.print();
		sc.staticMethod();
		System.out.println(sc.name);
		
		System.out.println();
		
		//ssoc = (SubSubOneClass)sstc; //ClassCastException!!!
		//sstc = (SubSubTwoClass)ssoc; //ClassCastException!!!
		//ssoc = (SubSubOneClass)sc; //ClassCastException!!!
		//sstc = (SubSubTwoClass)sc; //ClassCastException!!!	
		
		new SubClass().staticMethod();
		*/
	}

}
