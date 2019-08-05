package ru.practics.worriedmommysblog.model;

import java.util.Date;

public class Publication {
	
	private Long id;
	private String name;
	private String text;
	private int likesCount;
	private String date;
	
	Publication(Long id, String name, String text) {
		this.name=name;
		this.text = text;
		this.likesCount = 0;
		this.date = new Date().toString();
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
		this.date = new Date().toString();
	}
	
	public String getName() {
		return name;
	}
	
	public void setText(String text) {
		this.text = text;
		this.date = new Date().toString();
	}
	
	public String getText() {
		return text;
	}
	
	public String getDate() {
		return date;
	}
	
	public void putLike() {
		likesCount++;
	}
	
	public int getLikes() {
		return likesCount;
	}
	
	public Long getId() {
		return id;
	}
	

}
