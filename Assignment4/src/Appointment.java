


import java.io.Serializable;

public class Appointment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Doctor doctor;
	private Patient patient;
	private OurDate date;

	public Appointment() {                      //default constructor
		this(new Patient(),new Doctor(),new OurDate());
	}
	public Appointment(Patient patient,Doctor doctor,OurDate AppointmentDate) {    //initial construtor
		this.setPatient(patient);
		this.setDoctor(doctor);
		this.setAppointmentDate(AppointmentDate);
	}
	public Doctor getDoctor() {                //return doctor object
		return doctor;
	}
	private void setDoctor(Doctor doctor) {      //set doctor object
		this.doctor=doctor;
	}

	public Patient getPatient() {              //return doctor object
		return patient;
	}
	private void setPatient(Patient patient) {     //set doctor object
		this.patient=patient;
	}


	public OurDate getAppointmentDate() {         //return appointment date 
		return date;
	}
	private void setAppointmentDate(OurDate date) {       //return  appointment date
		this.date=date;
	}
	//prints appointment info
	public String toString() {            
		return "Appointment[appointments= day = "+date.getDay()+" month= "+date.getMonth()+" year= "+date.getYear()+" "+doctor.toString()+" "+patient.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(!(obj instanceof Appointment))
			return false;
		Appointment a=(Appointment)obj;
		return (this.getDoctor().equals(a.getDoctor()) && this.getPatient().equals(a.getPatient()) && this.getAppointmentDate().equals(a.getAppointmentDate()));
	}


}

