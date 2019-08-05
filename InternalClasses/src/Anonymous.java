
abstract class AnonymousOne {
	
	public int x;
	public int y;
	
	AnonymousOne(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	abstract public void getValue();

}

public class Anonymous {
	
	public AnonymousOne getAnonymous(final int a, final int b) {
		return new AnonymousOne(a,b){
			public void getValue() {
				System.out.println(x + y);
			}
		};
	}
	
	public static void main(String[] args) {
		Anonymous a = new Anonymous();
		AnonymousOne ao = a.getAnonymous(5, 6);
		ao.getValue();
	}

}
