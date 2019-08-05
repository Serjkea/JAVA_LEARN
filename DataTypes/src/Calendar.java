import java.util.Date;
import java.util.Scanner;
import javax.swing.*;

public class Calendar {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		int year  = (new Scanner(JOptionPane.showInputDialog("Enter Year: "))).nextInt() - 1900;
		int month = (new Scanner(JOptionPane.showInputDialog("Enter Month: "))).nextInt() - 1;

		Date date = new Date();
		date.setYear(year);
		date.setMonth(month);
		date.setDate(1);
		
		int startDay = date.getDay()+1;
		
		System.out.println(date);

//		System.out.println(startDay);
		
		String output = "Mon Tue Wed Thu Fri Sat Sun";//\n";

		System.out.println(output);
		
		String start = "";
		int incr = 1;
		
		for (int i = 0; i < startDay; i++) {
			start = start + "    ";
			incr++;
		}
		
		System.out.print(start);
//		output += start; 
		
		while (date.getMonth() == month) {
			if (date.getDate() < 10) { System.out.print("  " + date.getDate() + " "); 
			                           //output += "  " + date.getDate() + " ";
			}
			else { System.out.print(" " + date.getDate() + " "); 
			       //output += " " + date.getDate() + " "; 
		    }
			if ((incr % 7)==0) { System.out.println("");
			                     //output += "\n"; 
			}  
			date.setDate(date.getDate() + 1);
			incr++;
		}
		
		
//		JOptionPane.showMessageDialog(null, output);

	}

}
