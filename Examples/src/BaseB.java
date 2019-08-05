
public class BaseB extends AbstractBase {
	
	BaseB(){
		super("double factorial");
	}

	int F(int n) {
		if (n==1||n==2) return n;
		else return n*F(n-2);
	}
}
