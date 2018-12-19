

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class MedicalClinic implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList <Appointment> appointments=new ArrayList <Appointment>();   //creating appointments arraylist
	private ArrayList <Patient> patients=new ArrayList <Patient>();   //creating patients array
	//creating patients arraylist
	private ArrayList <Doctor> doctors=new ArrayList <Doctor>();   //creating doctors array
	//creating doctors arraylist


	private  static int numberAppointments;                          
	private  static int numberPatients;
	private  static int numberDoctors;
	private static int MAX_APPOINTMENTS=5;
	private static int MAX_DOCTORS =5;
	private static int MAX_PATIENTS=5;
	OurDate bd1=new OurDate();
	//default constructor
	public MedicalClinic() {


		doctors.add(new Doctor("Vikas","Singh","Physician"));
		doctors.add(new Doctor("Susan","Miller","Dermatologist"));
		doctors.add(new Doctor("Thanh","Do","Neurologist"));
		doctors.add(new Doctor("Francois","Dasilva","Cardiologist"));
		doctors.add(new Doctor("Judy","Chin","Pediatrician"));

	}

	//method to add patient with given parameters
	public void addPatient(String lastName,String firstName, String healthCardNumber, OurDate date) {
		boolean foundPatient = false;
		//searching  for patient using health card number
		for(int i = 0; i < numberPatients; i++)
		{
			if(patients.get(i).getHealthCardNumber().equals(healthCardNumber)) //  patient is found 
			{ 
				System.out.println(firstName +" " +lastName +"  is already in the system");
				foundPatient = true;  //   use this boolean to enter/not enter the if selection structure below 
				i = numberPatients; // get out of loop 
			}
		}
		if(!(foundPatient)) {

			patients.add(new Patient(lastName, firstName , healthCardNumber, date));
		}

		numberPatients++;
	}

	public void addPatient(String lastName,String firstName,String healthCardNumber,OurDate date,boolean mobility,double distance) {
		boolean foundPatient2 = false;
		//searching  for patient using health card number
		for(int i = 0; i < numberPatients; i++)
		{
			if(patients.get(i).getHealthCardNumber().equals(healthCardNumber)) //  patient is found 
			{ 
				System.out.println(firstName +" " +lastName +"  is already in the system");
				foundPatient2 = true;  //   use this boolean to enter/not enter the if selection structure below 
				i = numberPatients; // get out of loop 
			}
		}
		if(!(foundPatient2)) {
			patients.add(new OutPatient(firstName,lastName,healthCardNumber,date,distance,mobility));
		}
		numberPatients++;
	}

	public void addPatient(String lastName,String firstName,String healthCardNumber,OurDate date,OurDate dueDate,boolean nutritionTesting) {
		boolean foundPatient2 = false;
		//searching  for patient using health card number
		for(int i = 0; i < numberPatients; i++)
		{
			if(patients.get(i).getHealthCardNumber().equals(healthCardNumber)) //  patient is found 
			{ 
				System.out.println(firstName +" " +lastName +"  is already in the system");
				foundPatient2 = true;  //   use this boolean to enter/not enter the if selection structure below 
				i = numberPatients; // get out of loop 
			}
		}
		if(!(foundPatient2)) {
			patients.add(new MaternityPatient(firstName,lastName,healthCardNumber,date,dueDate,nutritionTesting));
		}
		numberPatients++;
	}


	//method to add appointments
	public void addAppointments(Patient patient,Doctor doctor,OurDate date) {

		appointments.add(new Appointment(patient,doctor,date));
		numberAppointments++;
	}
	//method to cancel appointment with given index
	public void cancelAppointment(int index) {
		appointments.remove(index);
		numberAppointments--;
		//numberPatients--;
	}



	public void filePatientsOut() {
		ObjectOutputStream sout=null;
		FileOutputStream f=null;
		try {
			f = new FileOutputStream("patientData.ser");
			sout=new ObjectOutputStream(f);

			for(Patient p:patients) {
				sout.writeObject(p);
			}
			f.close();
			sout.close();

		}
		catch (IOException e) {
			System.out.println("vajskf");
			e.printStackTrace();
		}
	}
	/*File file = new File("PatientData.ser");
		public void filePatientOut() throws IOException, FileNotFoundException{		

			FileOutputStream fileOutput = new FileOutputStream(file);		
			ObjectOutputStream output = new ObjectOutputStream(fileOutput);			
			for(Patient p : patients) {
				output.writeObject(p);
			}
			output.close();
			fileOutput.close();

		}
	 */




	public void filePatientsIn() {
		ObjectInputStream sin=null;
		ArrayList <Patient> p= new ArrayList<Patient>();
		FileInputStream f=null;
		try {
			f=new FileInputStream("patientData.ser");
			sin=new ObjectInputStream(f);
			// int i=0;
			while(true) {
			p.add((Patient) sin.readObject());
				//p.add((Patient)sin.readObject());
				
				
			}
		
			
			
			

		}
		catch(EOFException e) {}
		catch( IOException e ) {
			e.printStackTrace();
		}
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		for( Patient ps: p) {
			System.out.println(ps.toString());
		}
		
		try {
			sin.close();
		}
		catch (IOException e) {
			System.out.println("bbyre");
		}


	}











	//various getter and setters
	public int getNumberAppointments() {
		return numberAppointments;
	}
	public int getNumberPatients() {
		return numberPatients;
	}
	public int getNumberDoctors() {
		return numberDoctors;
	}
	public int maxAppointments() {
		return MAX_APPOINTMENTS;

	}
	public int getMaxPatients() {
		return MAX_PATIENTS;
	}
	public int getMaxDoctors() {
		return MAX_DOCTORS;
	}
	public Doctor getDoctors(int i) {

		return doctors.get(i);

	}
	public Patient getPatients(int i) {

		return patients.get(i);

	}
	public Appointment getAppointments(int i) {

		return appointments.get(i);

	}


}



