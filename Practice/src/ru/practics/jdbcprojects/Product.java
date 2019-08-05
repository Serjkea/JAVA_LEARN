package ru.practics.jdbcprojects;

import java.io.Serializable;

public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static int counter = 0;

	private String name;
	private int price;
	private int id;
	
	Product() {}
	
	Product(String name, int price) {
		this.name = name;
		this.price = price;
		this.id = ++counter;
	}
	
	Product(int id, String name, int price) {
		this.name = name;
		this.price = price;
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;		
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getId() {
		return this.id;
	}

}
