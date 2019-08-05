import java.util.*;

public class CollectionTest {
	
	public static void main(String[] args) {
/*		
  		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(1);
		for(Integer i : list) {
			System.out.println(i);
		}
*/
		LinkedList<Integer> linkList = new LinkedList<Integer>();
		linkList.add(3);
		linkList.add(2);
		linkList.add(4);
		linkList.add(5);
		linkList.add(1);
		for(Integer i : linkList) {
			System.out.println(i);
		}
		System.out.println();
		System.out.println();
		for(Integer i : linkList) {
			System.out.println(i);
		}
		
	}

}
