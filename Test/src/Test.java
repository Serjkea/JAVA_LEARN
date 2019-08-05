import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		String str = "This is a test";
		System.out.println(str);

		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println(str);
		
		int num = 100;
		pw.println("Value of num = " + num);
		pw.println("Value of num * 2 = " + num*2);
		pw.println("Value of num = " + num);
		pw.println("Value of num * 2 = " + (num*=2));
		pw.println("Value of num = " + num);
		
		String s;
		
		Values vals = new Values(1,2,3,4,5);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do { 
			s = br.readLine();
			if (s.equals("length")) vals.getLength();
			else if (s.equals("change")) vals.changeValue(1, 0);
			else if (s.equals("get")) vals.getVals();
		} while (!s.equals("exit"));
		
		
	}
}
