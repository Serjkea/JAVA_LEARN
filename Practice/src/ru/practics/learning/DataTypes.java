package ru.practics.learning;

import java.util.Formatter;

public class DataTypes {
	
	private static Formatter formatter = new Formatter();
	private static final String PATTERN_INT = " type\nMin = %d\nMax = %d\nRange = %d\n ";
	private static final String PATTERN_REAL = " type\nMin = %f\nMax = %f\nRange = %f\n ";
	private static final String PREFIX_BYTE = "Byte";
	private static final String PREFIX_SHORT = "Short";
	private static final String PREFIX_INT = "Integer";
	private static final String PREFIX_LONG = "Long";
	private static final String PREFIX_FLOAT = "Float";
	private static final String PREFIX_DOUBLE = "Double";
	
	public static void getByteType() {
		byte max = Byte.MAX_VALUE;
		byte min = Byte.MIN_VALUE;
		int range = (max - min) + 1;
		formatter.format("  " + PREFIX_BYTE + PATTERN_INT + "\n", min, max, range);
	}
	
	public static void getShortType() {
		short max = Short.MAX_VALUE;
		short min = Short.MIN_VALUE;
		int range = (max - min) + 1;
		formatter.format("  " + PREFIX_SHORT + PATTERN_INT + "\n", min, max, range);
	}
	
	public static void getIntType() {
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		long range = (((Integer)max).longValue() -((Integer)min).longValue()) + 1L;
		formatter.format("  " + PREFIX_INT + PATTERN_INT + "\n", min, max, range);
	}
	
	public static void getLongType() {
		long max = Long.MAX_VALUE;
		long min = Long.MIN_VALUE;
		long range = (max - min) + 1;
		formatter.format("  " + PREFIX_LONG + PATTERN_INT + "\n", min, max, range);
	}
	
	public static void getFloatType() {
		float max = Float.MAX_VALUE;
		float min = Float.MIN_VALUE;
		double range = (max - min) + 1;
		formatter.format("  " + PREFIX_FLOAT + PATTERN_REAL + "\n", min, max, range);
	}
	
	public static void getDoubleType() {
		double max = Double.MAX_VALUE;
		double min = Double.MIN_VALUE;
		double range = (max - min) + 1;
		formatter.format("  " + PREFIX_DOUBLE + PATTERN_REAL + "\n", min, max, range);
	}
	
	
	public static String getInfo() {
		getByteType();
		getShortType();
		getIntType();
		getLongType();
		getFloatType();
		getDoubleType();
		
		return formatter.toString();
	}

}
