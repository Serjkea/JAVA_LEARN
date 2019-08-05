import java.util.Date;

public class Calendar {
	
	private Date date = new Date();
	
	@SuppressWarnings("deprecation")	
	Calendar() {
		int curDay = this.date.getDate();
		this.date.setDate(1);
		int startDay = this.date.getDay();
		int startMonth = this.date.getMonth();
		System.out.println("Year " + (this.date.getYear() + 1900));
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        String start = "";
	    int incr = 1;
		for (int i = 1; i < startDay; i++) {
			start = start + "    ";
			incr++;
		}
		System.out.print(start);
		while (this.date.getMonth() == startMonth) {
			if (this.date.getDate() < 10) { 
				if (this.date.getDate() == curDay) System.out.print("  " + this.date.getDate() + "*"); 
				else System.out.print("  " + this.date.getDate() + " "); 
			} else { 
				if (this.date.getDate() == curDay) System.out.print(" " + this.date.getDate() + "*");
				else System.out.print(" " + this.date.getDate() + " ");
			}
			if ((incr % 7)==0) System.out.println("");
			this.date.setDate(this.date.getDate() + 1);
			incr++;
		}
	}
}
