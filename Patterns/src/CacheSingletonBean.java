import java.util.*;
import javax.annotation.*;

public class CacheSingletonBean {
	
	private Map<Integer, String> myCache;
	
	public void start() {
		myCache = new HashMap<Integer, String>();
//		System.out.println("myCache is created!");
	}
	
	public void addUser(Integer id, String name){
		myCache.put(id,name);
//		System.out.println("User " + id + " is added!");
	}
	
	public String getName(Integer id){
		return myCache.get(id);
	}

}
