import java.util.*;

public class Model implements IModel {
	
	private static int count = 0;
	
	private IView view;
	private Map<Integer,People> list = new HashMap<Integer,People>();
	
	Model() {
	}
	
	public void setView(IView view) {
		this.view = view;
	}
	
	public void addPeople(People people) {
		if(list.containsValue(people)) System.out.println("People already in the list!");
		else list.put(++count, people);
		view.change();
	}
	
	public People getPeople(int id) {
		People result = list.get(id);
		delPeople(id);
		view.change();
		return result;
	}
	
	public void delPeople(int id) {
		list.remove(id);
		view.change();
	}
	
	public String getAllPeoples() {
		StringBuilder sb = new StringBuilder(list.values().toString());
		sb.replace(sb.indexOf("["),sb.indexOf("[")+1," ");
		sb.replace(sb.indexOf("]"),sb.indexOf("]")+1," ");
		while(sb.indexOf(",")!=-1) sb.replace(sb.indexOf(","),sb.indexOf(",")+1,"\n");
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return getAllPeoples();
	}
	
}
