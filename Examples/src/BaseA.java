
public class BaseA extends AbstractBase {
	
	BaseA() {
		super("factorial");
	}
	
	int F(int n) {
		if (n==1) return 1;
		else return n*F(n-1);
	}

}
