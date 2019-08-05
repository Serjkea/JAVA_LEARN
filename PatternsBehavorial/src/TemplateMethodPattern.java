
abstract class Template {
	abstract void start();
	abstract void stop();
	
	public final void doIt(){
		start();
		stop();
	}
}

class MethodOne extends Template {
	public void start() {
		System.out.println("Start by Method One");
	}
	public void stop() {
		System.out.println("Stop by Method One");
	}
}

class MethodTwo extends Template {
	public void start() {
		System.out.println("Start by Method Two");
	}
	public void stop() {
		System.out.println("Stop by Method Two");
	}
}

public class TemplateMethodPattern {
	
	public static void main(String[] args) {
		Template method = new MethodOne();
		method.doIt();
		method = new MethodTwo();
		method.doIt();
	}

}
