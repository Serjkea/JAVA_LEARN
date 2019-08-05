import java.math.*;

public class DataTypes {
	
	public static final double M_PER_INCH = 2.54;	
	
	public static void main(String[] args) {
		byte b;
		short s;
		int i;
		long l;
		Byte bb;
		Short ss;
		Integer ii;
		Long ll;
		System.out.println("Byte min value: " + Byte.MIN_VALUE);
		System.out.println("Byte max value: " + Byte.MAX_VALUE);
		System.out.println("Short min value: " + Short.MIN_VALUE);
		System.out.println("Short max value: " + Short.MAX_VALUE);
		System.out.println("Integer min value: " + Integer.MIN_VALUE);
		System.out.println("Integer max value: " + Integer.MAX_VALUE);
		System.out.println("Long min value: " + Long.MIN_VALUE);
		System.out.println("Long max value: " + Long.MAX_VALUE);
		l = 4000000L;
		i = 0xABC;
//		b = 0b1111;
		
		float f;
		double d;
		Float ff;
		Double dd;
		System.out.println("Float min value: " + Float.MIN_VALUE);
		System.out.println("Float max value: " + Float.MAX_VALUE);
		System.out.println("Double min value: " + Double.MIN_VALUE);
		System.out.println("Double max value: " + Double.MAX_VALUE);
		f = 3.14F;
		d = 3.14D;
		
		if (f == Float.NaN) {
			System.out.println("Float Is NaN");
		} else {
			System.out.println("Float Not NaN");
		}
		
		d = Math.sqrt(4);
		if (Double.isNaN(d)) {
			System.out.println("Double Is NaN");
		} else {
			System.out.println("Double Not NaN");
		}
		
		char c = 'a';
		char uni = '\uFFFF';
		System.out.println(c);
		System.out.println(uni);
		System.out.println(Character.MAX_VALUE);
		
		final double CM_PER_INCH = 2.54;
		System.out.println(CM_PER_INCH);
		
		BigInteger aB = BigInteger.valueOf(100);
		BigInteger bB = BigInteger.valueOf(200);
		BigInteger cB = aB.add(bB);
		cB = aB.divide(bB);
		cB = aB.multiply(bB);
		cB = aB.subtract(bB);
		
	}

}
