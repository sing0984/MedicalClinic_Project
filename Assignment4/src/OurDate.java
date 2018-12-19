
import java.io.Serializable;
import java.util.Calendar;

public class OurDate implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final Calendar CALENDAR=Calendar.getInstance();
	
	private int day;
	private int month;
	private int year;
	//default constructor
	public  OurDate() {         
		this(CALENDAR.get(Calendar.DATE),CALENDAR.get(Calendar.MONTH),CALENDAR.get(Calendar.YEAR)  );
	}
	
	public OurDate(int day,int month,int year) {                 //initial constructor
		
		//CALENDAR.set(day,month,year);

		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	}
	// return day of date
	public int getDay() {
		return day;
	}
	// set day of date
	private void setDay(int day) {
		this.day=day;
	}
	// return month of date
	public int getMonth() {
		return month;
	}
	// set month of date
	private void setMonth(int month) {
		this.month=month;
	}
	// return year of date
	public int getYear() {
		return year;
	}
	// return  year of date
	private void setYear(int year) {
		
		this.year=year;
	}
	// print info of date
	public String toString() {
		return  "day ="+day+", month ="+month+", year = "+year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(!(obj instanceof OurDate))
			return false;
		OurDate d= (OurDate)obj;
		
		return (this.getDay()==d.getDay()&&this.getMonth()==d.getMonth()&&this.getYear()==d.getYear());
	}
	
}
