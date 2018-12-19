
import java.io.Serializable;

public class Doctor implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String speciality;

	//default constructor
	public Doctor() {
		this("unknown","unknown","unknown");

	}
	//initial constructor with string,string,string as parameter
	public Doctor(String firstName,String lastName,String speciality) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setSpeciality(speciality);
	}
	//return info for doctor
	public String toString() {
		return  lastName+","+firstName+","+speciality;
	}
	// return first name of doctor
	public String getFirstName() {
		return firstName;
	}
	// set first name of doctor
	private void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	// returns last name of doctor
	public String getLastName() {
		return lastName;
	}
	// set last name of doctor
	private void setLastName(String lastName) {
		this.lastName=lastName;
	}
	// return speciality of doctor
	public String getSpeciality() {
		return speciality;
	}
	// set speciality of doctor
	private void setSpeciality(String speciality) {
		this.speciality=speciality;
	}
	//equals method for doctor class
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
		return result;
	}
	//equals method for doctor class
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(!(obj instanceof Doctor))
			return false;
		Doctor d1=(Doctor) obj;
		
		return(this.getFirstName().equals(d1.getFirstName()) &&this.getLastName().equals(d1.getLastName())&&this.getSpeciality().equals(d1.getSpeciality()) );
	}
	

}
