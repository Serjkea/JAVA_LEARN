
public class Reverser {
	
	private String str;
	
	public String reverse(String inputStr){
		String reverseStr="";
		str = inputStr;
		StackArray stack = new StackArray(str.length());		
		for (int i=0; i<str.length();i++){
			stack.push(str.charAt(i));
		}
		for (int i=0; i<str.length();i++){
			reverseStr += stack.pop(); 
		}
		return reverseStr;
	}

}
