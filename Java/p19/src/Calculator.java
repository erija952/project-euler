import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calculator {
	
	Calculator() {
	}
	public static void main(String[] args) {
		
		Calendar cal = new GregorianCalendar(1901, 00, 01);
		Date date = cal.getTime();
	    System.out.println("Initial date is : " + date + " day of the week " + cal.get(Calendar.DAY_OF_MONTH));
		int nrsundays = 0;
		while(!date.toString().contains("Dec 31 00:00:00 CET 2000")) {
			cal.add(Calendar.DATE, +1);
			date = cal.getTime();
			if(cal.get(Calendar.DAY_OF_MONTH) == 1) {
				if(cal.get(Calendar.DAY_OF_WEEK) == 1) {
					nrsundays +=1;
				}
			}
		}
		System.out.println("Good Morning! Now it is: " + date);
		System.out.println("The number of Sundays on the first of the month inbetween were " + nrsundays);
	}
	
}
