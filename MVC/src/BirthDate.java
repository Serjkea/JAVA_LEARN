import java.util.Date;
import java.util.Formatter;

public class BirthDate {
	
	private int day;
	private int month;
	private int year;
	
	BirthDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	
	@SuppressWarnings("deprecation")
	public int getAge() {
		return new Date().getYear() - this.year + 1900;
	}
	
	@Override
	public String toString() {
		Formatter f = new Formatter();
		return f.format("%2d.%2d.%4d", this.day, this.month, this.year).toString();
	}

}
