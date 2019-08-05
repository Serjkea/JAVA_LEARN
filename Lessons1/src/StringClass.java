
public class StringClass {

	public static void main(String[] args) {
		char[] c = {'a','b','c'};
		String str = new String(c);
		char a;
		a = str.charAt(1);
		if (a=='b') str = str.replace("b","n");
		
		System.out.println(a + str);
		

	}

}
