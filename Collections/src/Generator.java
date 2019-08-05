import java.util.*;


public class Generator {
	
	private List<String> l1;
	private List<String> l2;
	private Set<String> s1;
	private Set<String> s3;
	private Set<String> s2;
	
	Generator(String... str){
		l1 = new ArrayList<String>(Arrays.asList(str));
		l2 = new LinkedList<String>(Arrays.asList(str));
		s1 = new HashSet<String>(Arrays.asList(str));
		s2 = new LinkedHashSet<String>(Arrays.asList(str));
		s3 = new TreeSet<String>(Arrays.asList(str));
	}
	
	public String next(Collection<String> c) {
		String str = "";
		for(String s:c){
			str += s + " ";
		}
		return str;
	}
	
	public static void main(String[] args) {
		Generator generator = new Generator("Andy","Serg","Alex","Mike","Bob","Rob","Fred");
		System.out.println(generator.next(generator.l1));
		System.out.println(generator.next(generator.l2));
		System.out.println(generator.next(generator.s1));
		System.out.println(generator.next(generator.s2));
		System.out.println(generator.next(generator.s3));
	}

}
