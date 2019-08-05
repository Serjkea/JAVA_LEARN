import java.util.*;

public class TryCatchDemo {

	public static void main(String[] args) {
		int n=3;
		int count=0;
		int nums=0;
		int a,b;
		Random rnd=new Random();
		while (count<n) {
			nums++;
			a=rnd.nextInt(10);
			b=rnd.nextInt(6);
			System.out.print(nums+") Result of divide: "+a+"/"+b+" = ");
			try {
/*				a=rnd.nextInt(10);
				b=rnd.nextInt(6);
				System.out.print(nums+") Result of divide: "+a+"/"+b+" = ");
*/				System.out.println(a/b);
			} catch (ArithmeticException eObj) {
				System.out.println("infinity");
				System.out.println("Warning! Error: "+eObj);
				count++;
			}
		}
		System.out.println("Number of errors: "+n+". Program is aborted!");
	} 

}
