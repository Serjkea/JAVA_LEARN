
public class UsingInterfaceDemo {

	public static void main(String[] args) {
		MyMath obj=new MyMath();
		int n=Mathematica.TEN/3;
		double x=(double)MyMath.TEN/n-n;
		obj.show(x, n);
	}

}
