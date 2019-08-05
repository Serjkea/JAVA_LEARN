
public class OuterClass {
	{
		System.out.println("OuterClass was created");
	}
	
	public String pubStrOuter = "Public Field of OuterClass";
	private String prvStrOuter = "Private Field of OuterClass";
	
	class InnerClass {
		{
			System.out.println("InnerClass was created");
		}
		
		public String pubStrInner = "Public Field of InnerClass";
		private String prvStrInner = "Private Field of InnerClass";
		private final static String prvSInner = "Static Private Field of InnerClass";
		
		public void pubPrintInner() {
			System.out.println("Public Method of InnerClass");
		}
		
		private void prvPrintInner() {
			System.out.println("Private Method of InnerClass");
			prvPrintOuter();
		}
	}
	
	public void pubPrintOuter() {
		System.out.println("Public Method of OuterClass" + new InnerClass().prvStrInner);
		new InnerClass().prvPrintInner();
	}
	
	private void prvPrintOuter() {
		System.out.println("Private Method of OuterClass");
		new InnerClass().pubPrintInner();
	}
	
	public InnerClass getInner(){
		return new InnerClass();
	}
	
	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		oc.pubPrintOuter();
		InnerClass ic = oc.getInner();
		System.out.println(oc.getInner().prvStrInner);
		System.out.println(InnerClass.prvSInner);
	}

}
