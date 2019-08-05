import java.util.*;


public class WorkList {
	
	private static int count = 0;
	private int id = ++count;
	
	static WorkList[] wl;
	
	public void getId() {
		System.out.println(id);
	}
	
	public static void main(String[] args) {
		wl = new WorkList[]{new WorkList(),new WorkList(),new WorkList(),new WorkList(),new WorkList()};
		List<WorkList> container = new ArrayList<WorkList>(Arrays.<WorkList>asList(wl));
		System.out.println(container);
		for(WorkList w:container){
			w.getId();
		}
		System.out.println();
		List<WorkList> sub = container.subList(0, 2);
		for(WorkList w:sub){
			w.getId();
		}
		System.out.println("Iterator");
		Iterator<WorkList> wi = container.iterator();
		while(wi.hasNext()){
			wi.next().getId();
			wi.remove();
		}
		
		container.removeAll(sub);
		System.out.println();
		for(WorkList w:container){
			w.getId();
		}
		
	}

}
