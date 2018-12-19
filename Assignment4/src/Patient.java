

import java.io.Serializable;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

// this class handles the patients info
public class Patient implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String healthCardNumber;
	private OurDate birthDate;
	//private static final Calendar CALENDAR=Calendar.getInstance();
	
	//private Scanner in=new Scanner(System.in);
	//private SimpleDateFormat sdf = new SimpleDateFormat("DDMMYYYY");

	//default constructor
	public Patient() {
		
		this("unknown","unknown","-1",new OurDate());
}
	// overloaded constructor with string,string and OurDate as parameter 
	public Patient( String firstName,String lastName, String healthCardNumber,OurDate birthDate) {
		
		

		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setHealthCardNumber(healthCardNumber);
		this.setBirthDate(birthDate);
		
		
	}
	
	// prints info regarding patient
	public String toString() {	
			return "Patient[First Name= "+firstName+", Last Name= "+lastName+", Birthdate= "+birthDate.toString()+", Healthcard Number= "+healthCardNumber;	
	}
	// return first name of patient
	public String getFirstName() {
		return firstName;
	}
	//set first name of patient
	private void setFirstName(String firstName) {
		this.firstName=firstName;
	}

	//return last name of patient
	public String getLastName() {
		return lastName;
	}
	//set last name of patient
	private void setLastName(String lastName) {
		this.lastName=lastName;
	}

	//returns Health Card Number of patient
	public String getHealthCardNumber() {
		return healthCardNumber;
	}
	//set Health Card Number of patient
	private void setHealthCardNumber(String healthCardNumber) {
		//if( !(healthCardNumber.matches("[0-9]+"))) {
			//System.out.println("Enter 9 digit health card number");
		
		//}
		
	this.healthCardNumber=healthCardNumber;
	}

	//return birth date of patient
	public OurDate getBirthDate() {
		return birthDate;
	}
	//set birth date of patient
	//@SuppressWarnings("unlikely-arg-type")
	private void setBirthDate(OurDate birthDate) {

	
		
		this.birthDate=birthDate;
	}
	//return appointment date of patient
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + Integer.parseInt(healthCardNumber);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(!(obj instanceof Patient))
			return false;
		Patient p=(Patient)obj;
		
	return(this.getFirstName().equals(p.getFirstName()) && this.getLastName().equals(p.getLastName()) && this.getHealthCardNumber()==p.getHealthCardNumber() && this.getBirthDate().equals(p.getBirthDate()));
	}

}

