package ru.practics.collections;

public class Element implements Comparable<Element>{
	
	private String value;
	
	public Element() {
		System.out.println("Constructor without args!");
	}
	
	public Element(String value) {
		this.value = value;
		System.out.println("Constructor with args!");
	}
	
	public void setValue(String value) {
		this.value = value;
		System.out.println("setValue: " + value);
	}
	
	public String getValue() {
		System.out.println("getValue: " + value);
		return this.value;
	}
	
	@Override
	public String toString() {
		System.out.println("toString");
		return this.value;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		if (obj == null) return false;
		else if (obj == this) return true;
		else if (obj instanceof Element) {
			Element tmp = (Element) obj;
			return this.value.equals(tmp.value);
		} return false;
	}
	
	@Override
	public int hashCode() {
		System.out.println("hashCode");
		return this.value.hashCode()*31;
	}

	@Override
	public int compareTo(Element obj) {
		if (obj == null) return 1;
		else if (obj == this) return 0;
		else {
			if (this.hashCode() > obj.hashCode()) return 1;
			else return -1;
		} 
	}


}
