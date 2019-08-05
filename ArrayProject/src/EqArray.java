import java.util.ArrayList;
import java.util.Scanner;


public class EqArray {

	public static void main(String[] args) {
		
      int myArray[];
      myArray = new int[5];
      
      int eq_num = 0;
      int neq_num = 0;
    
      Scanner in = new Scanner(System.in);
      
      System.out.println("Enter array of 5 elements:");
      for (int i=0;i<myArray.length; i++) {
    	  myArray[i] = in.nextInt();
      }
      
      for (int i=0;i<myArray.length; i++) {
    	  System.out.print(myArray[i]);
      }
      
      System.out.println("");
      
      for (int i=0;i<myArray.length; i++) {
    	  eq_num = 0;
    	  for (int j=0;j<myArray.length; j++) {
    		  if ((myArray[i] == myArray[j])&&(i!=j)) {eq_num++; break;}
          }
    	  if (eq_num == 0) neq_num++;
      }

      System.out.println("Not equal number: " + neq_num);
     
	}

}
