package ru.practics.verilogpatterns;

import java.io.IOException;

public class Main {
	
	private final static String PREFIX_PATHNAME = "/home/kostenko/Projects/Java/VerilogPatterns/";
	private final static String PROJECT_FILENAME = "pattern";
	private final static String SUFFIX_FILENAME = ".v";
	
	private final static String TIMESCALE_BLOCK = "`timescale ";
	private final static String TRIGGER_INITIAL = "reg ";
	private final static String TRIGGER_HEADER = "always @";
	private final static String BRACKET_OPEN = "(";
	private final static String BRACKET_CLOSE = ")";
	private final static String QBRACKET_OPEN = "[";
	private final static String QBRACKET_CLOSE = "]";
	private final static String TRIGGER_POSEDGE = "posedge ";
	private final static String TRIGGER_NEGEDGE = "negedge ";
	private final static String BEGIN_BLOCK = "begin";
	private final static String END_BLOCK = "end";
	private final static String IF_BLOCK = "if ";
	private final static String ELSE_BLOCK = "else ";
	private final static String DELAY_BLOCK = "#";
	
	private static String CLOCK_NAME;
	private static String RESET_NAME;
	private static String TRIGGER_NAME;
	private static String INPUT_SIGNAL;
	private static String TIMESCALE_VALUE;
	private static String DELAY_VALUE;
	private static String OFFSET_VALUE = "  ";
	private static String NBITS_VALUE;
	
	private static FileBuilder fBuilder;
	
	public static void getRDTrigger() throws IOException{
		fBuilder.write(TIMESCALE_BLOCK + TIMESCALE_VALUE);
		fBuilder.write("");
		if ((NBITS_VALUE != null)&&(!NBITS_VALUE.equals("1"))) {
			fBuilder.write(OFFSET_VALUE + TRIGGER_INITIAL + QBRACKET_OPEN + NBITS_VALUE + "-1:0" + QBRACKET_CLOSE + " " + TRIGGER_NAME + ";");
		} else {
			fBuilder.write(OFFSET_VALUE + TRIGGER_INITIAL + TRIGGER_NAME + ";");
		}
		fBuilder.write(OFFSET_VALUE + TRIGGER_HEADER + BRACKET_OPEN + TRIGGER_POSEDGE + CLOCK_NAME + ", " + TRIGGER_NEGEDGE + RESET_NAME + BRACKET_CLOSE);
		fBuilder.write(OFFSET_VALUE + OFFSET_VALUE + BEGIN_BLOCK);
		if ((DELAY_VALUE != null)&&(!NBITS_VALUE.equals("1"))) {
			fBuilder.write(OFFSET_VALUE + OFFSET_VALUE + OFFSET_VALUE + IF_BLOCK + BRACKET_OPEN + "!" + RESET_NAME + BRACKET_CLOSE + " " + TRIGGER_NAME + " <= " + DELAY_BLOCK + DELAY_VALUE + " " + NBITS_VALUE + "'h0" + ";");
			fBuilder.write(OFFSET_VALUE + OFFSET_VALUE + OFFSET_VALUE + ELSE_BLOCK + TRIGGER_NAME + " <= " + DELAY_BLOCK + DELAY_VALUE + " " + INPUT_SIGNAL + ";");
		} else {
			fBuilder.write(OFFSET_VALUE + OFFSET_VALUE + OFFSET_VALUE + IF_BLOCK + BRACKET_OPEN + RESET_NAME + BRACKET_CLOSE + " " + TRIGGER_NAME + " <= 1'b0" + ";");
			fBuilder.write(OFFSET_VALUE + OFFSET_VALUE + OFFSET_VALUE + ELSE_BLOCK + TRIGGER_NAME + " <= " + INPUT_SIGNAL + ";");
		}
		fBuilder.write(OFFSET_VALUE + OFFSET_VALUE + END_BLOCK);
	}

	
	public static void main(String[] args) {
		TIMESCALE_VALUE = "1ns/10ps";
		CLOCK_NAME = "clk";
		TRIGGER_NAME = "register";
		RESET_NAME = "reset";
		INPUT_SIGNAL = "data";
		DELAY_VALUE = "1";
		NBITS_VALUE = "2";
		try {
			fBuilder = new FileBuilder(PREFIX_PATHNAME + PROJECT_FILENAME + SUFFIX_FILENAME);
			getRDTrigger();
			fBuilder.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
