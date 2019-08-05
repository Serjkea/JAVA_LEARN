import java.math.*;
import static java.lang.Math.*;

public class Operations {
	
	enum Days {Monday, Tuesday, Wensday};
	
	public static void main(String[] args) {
		Days d = Days.Monday;
		System.out.println(d);
		int a = 5;
		int b = 3;
		double c;
	    c = Math.pow(a, b);
	    System.out.println(c);
	    System.out.println(Math.sqrt(a));
	    System.out.println(Math.PI + " " + Math.E);
	    System.out.println(pow(a,b));
	    c = a + b;
	    c = a - b;
	    c = a * b;
	    c = a / b;
	    c = a % b;
	    c += a;
	    c -= a;
	    c *= a;
	    c /= a;
	    c %= a;
	    a++;
	    ++a;
	    a--;
	    --a;
	    c = (a + b);
	    c = a > b ? a : b;
	    boolean tr = true;
	    boolean fl = false;
	    boolean rs;
	    rs = fl && tr;
	    rs = fl || tr;
	    rs = !fl && tr;
	    c = a & b;
	    c = a | b;
	    c = ~a ^ b;
	    c = a >> b;
	    c = a << b;
	    c = a >>> b;

	}
	
}
