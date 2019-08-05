package ru.practics.guiapp;

public class Task {
	
	private long id;
	public final String name;
	
	public Task(String name) {
		this.name = name;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return id + " : " + name;
	}
}
