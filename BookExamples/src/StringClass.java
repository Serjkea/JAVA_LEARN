
public class StringClass {

	public static void main(String[] args) {
		
		String str = "Hello";
		String newstr = " World";
		System.out.println(str.length());
		System.out.println(str.contains("l"));
		System.out.println(str.charAt(3));
		System.out.println(str.concat(newstr));
		System.out.println(str.toUpperCase());
		System.out.println(str);
		System.out.println(str.substring(1, 3));
		System.out.println(str.subSequence(1, 4));
		String message = newstr + 12;
		System.out.println(message);
		System.out.println(str.equals(newstr));
		System.out.println(" World".equalsIgnoreCase(newstr));
		String mystr = "";
		System.out.println(mystr == null);
		System.out.println(mystr.length() == 0);
		
		StringBuilder builder = new StringBuilder();
		builder.append(str);
		builder.append(newstr);
		String completeString = builder.toString();
		System.out.println(completeString);
		System.out.println(builder);
		builder.insert(5, "amn");
		System.out.println(builder);
	}
	
}
