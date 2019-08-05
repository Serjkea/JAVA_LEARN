package com.my;

import java.util.*;
import static java.lang.System.out;

public class NewClass extends Radius {
	
	private int num;
	Object obj = new Object();
	private static int id = 0;
	
	static {
		Random gen = new Random();
		id = gen.nextInt(100);
	}
	
	public NewClass(int num, Object obj){
	    super();
		this.num = num;
		this.obj = obj;
	}
	
	public NewClass(){
		this(5, null);
	}
	
	public static int getId(){
		return id++;
	}

	public static void main(String[] args) {

	}

}
