import java.io.Serializable;

//OutPatient extending Patient class 
public class OutPatient extends Patient implements Serializable  {

	private static final long serialVersionUID = 1L;
private double distanceFromClinic;
private boolean mobility;

//default constructor
public OutPatient() {
	this("unknown","unknown","-1",new OurDate(),-1.0,false);
}
// Initial constructor
public OutPatient(String firstName,String lastName,String healthCardNumber,OurDate birthDate,double distanceFromClinic,boolean mobility) {
super(firstName,lastName,healthCardNumber,birthDate);       //providing variables to patient class

//setting values for distanceFromClinic and mobility
this.setDistanceFromClinic(distanceFromClinic);                         
this.setMobility(mobility);
}

//getter method for distanceFromClinic
public double getDistanceFromClinic() {
	return distanceFromClinic;
}

//setting distanceFromClinic
private void setDistanceFromClinic(double distanceFromClinic) {
	this.distanceFromClinic = distanceFromClinic;
}

//getting mobility
public boolean getMobility() {
	return mobility;
}

//setting mobility
private void setMobility(boolean mobility) {
	this.mobility = mobility;
}

//toString method for OutPatient
public String toString() {
	return (super.toString()+ "+distanceFromClinic: "+distanceFromClinic + "mobility: "+mobility);
}

//hashcode for OutPatient
@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	long temp;
	temp = Double.doubleToLongBits(distanceFromClinic);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + (mobility ? 1231 : 1237);
	return result;
}

//equals method for equals
@Override
public boolean equals(Object obj) {
	if(obj==null)
	return false;
	
	if(!(obj instanceof OutPatient))
		return false;
	
	OutPatient oP= (OutPatient)obj;
	return (this.getFirstName().equals(oP.getFirstName()) && this.getLastName().equals(oP.getLastName()) && this.getHealthCardNumber()==oP.getHealthCardNumber() && this.getBirthDate().equals(oP.getBirthDate())&& this.getDistanceFromClinic()==oP.getDistanceFromClinic()&& this.getMobility()==oP.getMobility()  );

}






















}
