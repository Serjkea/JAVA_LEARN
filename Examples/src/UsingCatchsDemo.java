import java.util.*;
public class UsingCatchsDemo {
	
	public static void main(String[] args) {
		Random rnd=new Random();
		int[] array=new int[]{0,1,2,3,5,6,0,8,10,12,15};
		int n=120;
		int count=0;
		while (count<5) {
			try {
				System.out.println(n/array[rnd.nextInt(array.length+2)-1]+" ");
			} catch (ArithmeticException eObj) {
				System.out.println("\nError: divide by zero! Description: "+eObj);
				count++;
			} catch (ArrayIndexOutOfBoundsException eObj) {
				System.out.println("\nError: invalid index! Description: "+eObj);
				count++;
			}
		}
	}

}
