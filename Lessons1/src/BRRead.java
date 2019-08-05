import java.io.*;
public class BRRead {
	public static void main(String[] args) throws IOException {
//		char c;
		int i;
		i = 'A';
		
		System.out.write(i);
		System.out.write('\n');
		
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println("This is a string");
		int a = -7;
		pw.println(a);
		double d = 3.45e-7;
		pw.println(d);
		
/*		
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Input chars, q - for exit.");
		System.out.println("Input text, stop - for exit.");
		do {
//			c = (char) br.read();
			str = br.readLine();
//			System.out.println(c);
			System.out.println(str);
//		} while (c != 'q');
    	} while (!str.equals("stop"));
*/
		
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do { str = br.readLine(); }
		while (!str.equals("a"));
	}

}
