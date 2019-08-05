
public class Reverse {
	
	public String reverse(String str) {
		char[] temp = str.toCharArray();
		for(int i = 0; i < str.length();i += 2){
			char tmp;
			tmp = temp[i];
			temp[i] = temp[i+1];
			temp[i+1] = tmp;
		}
		return String.valueOf(temp);
	}
	
	public static void main(String[] args) {
		System.out.println(new Reverse().reverse("Hello!"));
	}

}
