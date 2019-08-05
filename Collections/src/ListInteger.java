import java.util.*;


public class ListInteger {
	
	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();
	List<Integer> list3 = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		ListInteger li = new ListInteger();
		li.list1.add(1);
		li.list1.add(2);
		li.list1.add(3);
		li.list1.add(4);
		li.list1.add(5);
		li.list2.add(10);
		li.list2.add(20);
		li.list2.add(30);
		li.list2.add(40);
		li.list2.add(50);
		ListIterator iterator1 = li.list1.listIterator();
		ListIterator iterator2 = li.list2.listIterator(li.list2.size());
		while(iterator1.hasNext()){
			iterator2.previous();
			iterator2.set(iterator1.next());
		}
		while(iterator2.hasNext()){
			System.out.println(iterator2.next());
		}
		ListIterator iter = li.list3.listIterator();
		iter.add(100);
		iter.add(200);
		iter.add(300);
		iter.add(400);
		li.list3.set(li.list3.size()/2, 1);
		li.list3.set(li.list3.size()/2, 2);
		li.list3.set(li.list3.size()/2, 3);
		li.list3.set(li.list3.size()/2, 4);
		
		while(iter.hasPrevious()) {
			System.out.println(iter.previous().toString());
		}
		while(iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
		
	}

}
