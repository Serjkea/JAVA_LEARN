import java.util.*;

enum MySingleton {
	INSTANCE;
	
		private List<String> list = new ArrayList<String>();
		
		public void add(String s) {
			this.list.add(s);
		}
		
		public String get() {
			Iterator iterator = list.iterator();
			return (String)iterator.next();
		}
}

public class EnumSingleton {
	public static void main(String[] args) {
		MySingleton.INSTANCE.add("Hello");
		System.out.println(MySingleton.INSTANCE.get());
	}
}
