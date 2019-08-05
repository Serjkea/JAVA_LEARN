import java.util.*;

public class PrintFDemo {

	public static void main(String[] args) {

		String text="Text string";
		double x=100.0/7.0;
		double z=130;
		int n=-1234567;
		int k=7654321;
		int m=0xABC;
		int l=0123;
		Date now=new Date();
		System.out.printf("%s\t%d\t%f\n",text,k,z);
		System.out.printf("Decimal numbers: \n%1$g\t%2$e\t%1$07.2f\n",x,z);
		System.out.printf("Negative number: %,(d\n",n);
		System.out.printf("Positive number: %+,d\n",k);
		System.out.printf("16 value %x is 10 number %<d\n",m);
		System.out.printf("10 value %d is 16 number %<X\n",k);
		System.out.printf("8 value %o is 10 number %<d\n",l);
		System.out.printf("Month: %tB\n",now);
		System.out.printf("Date: %te\n",now);
		System.out.printf("Day: %tA\n",now);
		System.out.printf("Time: %tT\n",now);
	}

}
