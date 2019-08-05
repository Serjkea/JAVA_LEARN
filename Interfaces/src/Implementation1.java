
public class Implementation1 implements Service{
	Implementation1() {};
	public void method1(){
		System.out.println("Implementation1 method1");
	}
	public void method2() {
		System.out.println("Implementation1 method2");
	}
	public static ServiceFactory factory = new ServiceFactory() {
		public Service getService() {
			return new Implementation1();
		}
	};
}
