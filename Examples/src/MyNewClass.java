import java.util.*;

public class MyNewClass {

	private int count;
	
	MyNewClass() {
		count=0;
	}
	
	void set(int count, String name) {
		this.count=count;
		System.out.println(name+" Set value "+ count+" : "+new Date());
	}
	
	int get(String name) {
		System.out.println(name+" Read value "+count+" : "+new Date());
		return count;
	}
	
}
