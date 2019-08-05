import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateExamples {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		date.setYear(100);
		date.setMonth(0);
		date.setDate(1);
		System.out.println(date);
		
	}

}
