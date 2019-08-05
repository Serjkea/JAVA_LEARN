
public class GenDemo {


	public static void main(String[] args) {
		Gen<Integer> i;
		
		i = new Gen<Integer>(88);
		
		i.showType();
		
		int v = i.getob();
		System.out.println(v);
		System.out.println();
		
		Gen<String> str = new Gen<String> ("Text");
		
		str.showType();
		
		String s = str.getob();
		System.out.println(s);

	}

}
