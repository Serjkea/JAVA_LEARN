
import java.math.*;

public class DataTypes {

	public static void main(String[] args) {
		
		System.out.println("Data type: Byte");
		
		Byte b = 10;
		
		System.out.println("Method: getClass    result: " + b.getClass());
		System.out.println("Method: TYPE        result: " + b.TYPE);
		System.out.println("Method: SIZE        result: " + b.SIZE);
		System.out.println("Method: MAX_VALUE   result: " + b.MAX_VALUE);
		System.out.println("Method: MIN_VALUE   result: " + b.MIN_VALUE);
		System.out.println("Method: compareTo   result: " + b.compareTo(b));
		System.out.println("Method: byteValue   result: " + b.byteValue());
		System.out.println("Method: doubleValue result: " + b.doubleValue());
		System.out.println("Method: floatValue  result: " + b.floatValue());
		System.out.println("Method: hashCode    result: " + b.hashCode());
		System.out.println("Method: intValue    result: " + b.intValue());
		System.out.println("Method: longValue   result: " + b.longValue());
		System.out.println("Method: shortValue  result: " + b.shortValue());
		System.out.println("Method: toString    result: " + b.toString());
		System.out.println("Method: parseByte   result: " + Byte.parseByte("10"));
		System.out.println("Method: decode      result: " + Byte.decode("15"));
		System.out.println("Method: equals      result: " + b.equals(b));

		System.out.println("Data type: Short");
		
		Short s = 200;
		
		System.out.println("Method: getClass    result: " + s.getClass());
		System.out.println("Method: TYPE        result: " + s.TYPE);
		System.out.println("Method: SIZE        result: " + s.SIZE);
		System.out.println("Method: MAX_VALUE   result: " + s.MAX_VALUE);
		System.out.println("Method: MIN_VALUE   result: " + s.MIN_VALUE);
		System.out.println("Method: compareTo   result: " + s.compareTo(s));
		System.out.println("Method: byteValue   result: " + s.byteValue());
		System.out.println("Method: doubleValue result: " + s.doubleValue());
		System.out.println("Method: floatValue  result: " + s.floatValue());
		System.out.println("Method: hashCode    result: " + s.hashCode());
		System.out.println("Method: intValue    result: " + s.intValue());
		System.out.println("Method: longValue   result: " + s.longValue());
		System.out.println("Method: shortValue  result: " + s.shortValue());
		System.out.println("Method: toString    result: " + s.toString());
		System.out.println("Method: parseByte   result: " + Short.parseShort("10"));
		System.out.println("Method: decode      result: " + Short.decode("15"));
		System.out.println("Method: equals      result: " + s.equals(s));
		System.out.println("Method: reverseByte result: " + Short.reverseBytes(s));

		System.out.println("Data type: Integer");
		
		Integer i = 120001;
		
		System.out.println("Method: getClass      result: " + i.getClass());
		System.out.println("Method: TYPE          result: " + i.TYPE);
		System.out.println("Method: SIZE          result: " + i.SIZE);
		System.out.println("Method: MAX_VALUE     result: " + i.MAX_VALUE);
		System.out.println("Method: MIN_VALUE     result: " + i.MIN_VALUE);
		System.out.println("Method: bitCount      result: " + Integer.bitCount(i));
		System.out.println("Method: highestOneBit result: " + Integer.highestOneBit(i));
		System.out.println("Method: lowestOneBit  result: " + Integer.lowestOneBit(i));
		System.out.println("Method: numberOfLeadingZeros result: " + Integer.numberOfLeadingZeros(i));
		System.out.println("Method: numberOfTrailingZeros result: " + Integer.numberOfTrailingZeros(i));
		System.out.println("Method: reverse result: " + Integer.reverse(i));
		System.out.println("Method: reverseBytes result: " + Integer.reverseBytes(i));
		System.out.println("Method: rotateLeft result: " + Integer.rotateLeft(i, 10));
		System.out.println("Method: rotateRight result: " + Integer.rotateRight(i, 10));
		System.out.println("Method: signum result: " + Integer.signum(i));
		System.out.println("Method: toBinaryString result: " + Integer.toBinaryString(i));
		System.out.println("Method: toHexString result: " + Integer.toHexString(i));
		System.out.println("Method: toOctalString result: " + Integer.toOctalString(i));
		
		System.out.println("Data type: Long");
		
		Long l = (long)10000;
		
		System.out.println("Method: getClass      result: " + l.getClass());
		System.out.println("Method: TYPE          result: " + l.TYPE);
		System.out.println("Method: SIZE          result: " + l.SIZE);
		System.out.println("Method: MAX_VALUE     result: " + l.MAX_VALUE);
		System.out.println("Method: MIN_VALUE     result: " + l.MIN_VALUE);
		
		System.out.println("Data type: Float");
		
		Float f = (float)5.54;
		
		System.out.println("Method: getClass      result: " + f.getClass());
		System.out.println("Method: TYPE          result: " + f.TYPE);
		System.out.println("Method: SIZE          result: " + f.SIZE);
		System.out.println("Method: MAX_VALUE     result: " + f.MAX_VALUE);
		System.out.println("Method: MIN_VALUE     result: " + f.MIN_VALUE);

		System.out.println("Data type: Double");
		
		Double d = (double)55.5;
		
		System.out.println("Method: getClass      result: " + d.getClass());
		System.out.println("Method: TYPE          result: " + d.TYPE);
		System.out.println("Method: SIZE          result: " + d.SIZE);
		System.out.println("Method: MAX_VALUE     result: " + d.MAX_VALUE);
		System.out.println("Method: MIN_VALUE     result: " + d.MIN_VALUE);

		System.out.println("Data type: Char");
		
		Character c = 'a';
		
		System.out.println("Method: getClass      result: " + c.getClass());
		System.out.println("Method: TYPE          result: " + c.TYPE);
		System.out.println("Method: SIZE          result: " + c.SIZE);
		System.out.println("Method: MAX_VALUE     result: " + c.MAX_VALUE);
		System.out.println("Method: MIN_VALUE     result: " + c.MIN_VALUE);
		System.out.println("Method: hashCode      result: " + c.hashCode());

		System.out.println("Data type: Boolean");
		
		Boolean bool = false;
		
		System.out.println("Method: getClass      result: " + bool.getClass());
		System.out.println("Method: TYPE          result: " + bool.TYPE);
		System.out.println("Method: hashCode      result: " + bool.hashCode());

		System.out.println("Data type: String");
		
		String str = "Hello";

		System.out.println("Method: getClass      result: " + str.getClass());
		System.out.println("Method: hashCode      result: " + str.hashCode());
		
		System.out.println("Data type: BigInteger");
		
		BigInteger bi;
		
		bi = BigInteger.valueOf(i);
		
		System.out.println(" " + bi);
		
		System.out.println("Data type: BigDecimal");
		
		BigDecimal bd;
		
		bd = BigDecimal.valueOf(i);
		
		System.out.println(" " + bd);
		
		System.out.println("Data type: Object");
		
		Object obj = new Object();
		
		System.out.println(obj.toString());
		System.out.println(obj.hashCode());
		System.out.println(obj.getClass());
		
		Object obj1;
		
		obj1 = i;
		
		System.out.println(obj1);
		System.out.println(obj1.toString());
		System.out.println(obj1.hashCode());
		System.out.println(obj1.getClass());
		System.out.println(Integer.bitCount(Integer.parseInt(obj1.toString())));
		
	}

}
