package ru.practics.collections;

import java.util.*;

public class CollectionsAnalysis {
	
	public static void main(String[] args) {
		Element el1 = new Element("1");
		Element el2 = new Element("2");
		Element el3 = new Element("3");
		Element el4 = new Element("4");
		Element el5 = new Element("5");

/*		
//		List<Element> list = new ArrayList<Element>();
		List<Element> list = new LinkedList<Element>();
		list.add(el1);
		list.add(el2);
		list.add(el3);
		list.add(el4);
		list.add(el5);
		for(Element e: list) {
			System.out.println(e);
		}
		list.add(list.size()/2, new Element("10"));
		for(Element e: list) {
			System.out.println(e);
		}
		System.out.println();
		System.out.println(list.contains(el3));
		System.out.println();
		System.out.println(list.indexOf(el4));
		System.out.println();
		Element tmp = list.set(2, new Element("25"));
		System.out.println(tmp);
		System.out.println();
		
		for(Element e: list) {
			System.out.println(e);
		}
*/		
	
//		Set<Element> set = new HashSet<Element>();
		Set<Element> set = new TreeSet<Element>();
		set.add(el1);
		set.add(el2);
		set.add(el3);
		set.add(el4);
		set.add(el5);
		for(Element e: set) {
			System.out.println(e);
		}
		System.out.println();
		set.add(new Element("10"));
		System.out.println();
		set.add(new Element("4"));
		for(Element e: set) {
			System.out.println(e);
		}
		
		
	}

}
