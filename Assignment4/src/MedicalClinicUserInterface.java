



import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MedicalClinicUserInterface {

	//static fields of the class
	private static final int ADD_PATIENT =1;
	private static final int ADD_APPOINTMENT=2;
	private static final int CANCEL_APPOINTMENT=3;
	private static final int LIST_APPOINTMENT=4;
	private static final int WRITE_PATIENT=5;
	private static final int LOAD_PATIENT=6;
	private static final int QUIT=7;
	//private static final Calendar CALENDAR =Calendar.getInstance();

	private Scanner in=new Scanner(System.in);
	MedicalClinic clinic=new MedicalClinic();

	//default constructor
	public MedicalClinicUserInterface() {

	}

	//menu method to interact with user
	public void menu() {
		int choice=0;

		while(choice!=QUIT) {
			System.out.println("\nPlease make a choice\n1. Enter a new patient\n2. Make an appointment\n3. Cancel appointment\n4. List appointments\n5. Write patient data to file\n6. Load patient data\n7. quit");
			choice=in.nextInt();
			switch(choice) {

			// takes information regarding patient and add patient in the array
			case ADD_PATIENT:  

				addPatient();
				break;

			case ADD_APPOINTMENT:
				addAppointment();
				break;

			case CANCEL_APPOINTMENT:
				cancelAppointment();
				break;

			case LIST_APPOINTMENT:
				listAppointments();
				break;

			case WRITE_PATIENT:

				writePatientsOut();

				break;

			case LOAD_PATIENT:
				readPatientsIn();
				break;

			case QUIT:
				System.out.println("Goodbye");
				break;
			case 9:
				listPatients();
				break;


			default:
				System.out.println("Invalid");
				break;

			}

		}


	}
	// method to add patient
	//@SuppressWarnings("deprecation")
	public void addPatient() {


		// helper local variables
		String bDate;
		String hcn="0";
		int day, month, year,day1,month1,year1;


		System.out.print("Enter first name: ");
		String firstName = in.next();
		System.out.print("Enter last name: ");
		String lastName = in.next();
		System.out.println();
		System.out.print("Enter health card number: ");
		hcn = in.next();

		// ensures that health card number should be of only 9 digits only
		boolean good=false;
		while(!good) {
			//checks whether health card number consists of 9 characters
			if( !Pattern.matches("[0-9]+",hcn)) {
				System.out.println("Please enter 9 digit numeric health card number");
				System.out.print("Enter health card number: ");
				hcn = in.next();
			}
			// checks whether health card number consists anything else other than nine numbers
			else  if(hcn.length()!=9) {
				System.out.println("Please enter 9 digit health card number");
				System.out.print("Enter health card number: ");
				hcn = in.next();

			}

			else {
				good=true;
			}

		}
		// input for patient birthdate
		System.out.print("Enter birth date DDMMYYYY: ");
		bDate = in.next();
		day = Integer.parseInt((bDate.substring(0, 2)));
		month = Integer.parseInt((bDate.substring(2, 4)));
		year = Integer.parseInt((bDate.substring(4, 8)));

		while(year<1900) {
			System.out.println("Congratulations CENTENARIAN! PLEASE SIGN UP WITH GERIATRICS");
			System.out.print("Enter birthdate for another patient: ");
			bDate = in.next();
			day = Integer.parseInt((bDate.substring(0, 2)));
			month = Integer.parseInt((bDate.substring(2, 4)));
			year = Integer.parseInt((bDate.substring(4, 8)));

		}

		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		Date date =null;
		boolean goodDate=false;
		while(!goodDate) {
			try {
				sdf.setLenient(false);               // handles invalid date like 30 in february or 29 in february in non-leap year
				date = sdf.parse(bDate);
				goodDate=true;
				Date todayDate=new Date();

				//checks whether birthdate is today or in future
				while(sdf.format(date).equals(sdf.format(todayDate ) ) || date.after(todayDate)) {

					System.out.println("Birthdate cannot be today or in the future");

					System.out.print("Enter birth date DDMMYYYY: ");
					bDate = in.next();
					try {
						date = sdf.parse(bDate);
					} catch (ParseException e) {
						System.out.print("Please enter valid birthdate");	
						bDate = in.next();
						goodDate=false;
						date = sdf.parse(bDate);
					}
				}
				day = Integer.parseInt((bDate.substring(0, 2)));
				month = Integer.parseInt((bDate.substring(2, 4)));
				year = Integer.parseInt((bDate.substring(4, 8)));
				break;

			} catch (ParseException e) {
				System.out.print("Please enter a valid birthdate: ");
				bDate = in.next();
				goodDate=false;
			}
		}


		OurDate d1=new OurDate(day,month,year);

		System.out.println("Enter the type of patient");
		System.out.println("1. Maternity\n2. Out Patient\n3. Regular Patient");
		int patientType=in.nextInt();
		// asks for patient type and accordingly add type of patient
		switch (patientType) {
		//adds maternity patient
		case 1:                
			System.out.print("Enter due date of patient: ");
			String dueDate=in.next();

			day1 = Integer.parseInt((dueDate.substring(0, 2)));
			//extract month
			month1 = Integer.parseInt((dueDate.substring(2, 4)));
			//extract year
			year1 = Integer.parseInt((dueDate.substring(4, 8)));		

			Date date1 =null;
			boolean goodDate1=false;
			while(!goodDate1) {
				try {
					sdf.setLenient(false);
					date1 = sdf.parse(dueDate);
					goodDate1=true;
					Date todayDate=new Date();
					while(sdf.format(date1).equals(sdf.format(todayDate ) ) || date1.before(todayDate)) {

						System.out.println("Due date cannot be today or in the past");

						System.out.print("Enter due date DDMMYYYY: ");
						dueDate = in.next();
						try {
							date1 = sdf.parse(dueDate);
						} catch (ParseException e) {
							System.out.print("Please enter valid due date");	
							dueDate = in.next();
							goodDate1=false;
							date1 = sdf.parse(dueDate);
						}
					}
					day1 = Integer.parseInt((bDate.substring(0, 2)));
					month1 = Integer.parseInt((bDate.substring(2, 4)));
					year1 = Integer.parseInt((bDate.substring(4, 8)));
					break;

				} catch (ParseException e) {
					System.out.print("Please enter a valid due date: ");
					dueDate = in.next();
					goodDate1=false;
				}
			}

			System.out.print("Enter nutrition testing: ");
			String nT=in.next();
			boolean nutritionTesting=false;
			if(nT.compareToIgnoreCase("yes")==0 || nT.compareToIgnoreCase("y")==0 ||nT.compareToIgnoreCase("true")==0||nT.compareToIgnoreCase("t")==0) {
				nutritionTesting=true;
			}
			else {
				nutritionTesting=false;
			}

			clinic.addPatient(lastName, firstName, hcn,d1 ,new OurDate(day1,month1,year1),nutritionTesting);
			break;
		case 2: 
			//adds out patient
			System.out.print("Enter mobility: ");
			String m=in.next();
			boolean mobility=false;
			if(m.compareToIgnoreCase("yes")==0 || m.compareToIgnoreCase("y")==0 ||m.compareToIgnoreCase("true")==0||m.compareToIgnoreCase("t")==0) {
				mobility=true;
			}
			else {
				mobility=false;
			}

			System.out.print("Enter distance from hospital: ");
			double distance=in.nextDouble();

			clinic.addPatient(lastName, firstName, hcn, d1,mobility,distance);
			break;
		case 3:
			//add regular patient
			clinic.addPatient(firstName, lastName, hcn,d1);
			break;
		default:
			System.out.println("Invalid option");


		}

	}


	//adding appointments
	public void addAppointment() {

		//helper local variable
		OurDate appointmentDate;

		//checking if maxAppointments has not reached
		if(clinic.getNumberAppointments() ==clinic.maxAppointments()) {
			System.out.println("Cannot add more appointments");	
		}
		else
		{
			//  if there is room for appointments, then continue to collect patient data 
			System.out.print("Enter health card number: ");
			String hcn = in.next();

			boolean good=false;
			while(!good) {
				//checks whether health card number consists of 9 characters
				if( !Pattern.matches("[0-9]+",hcn)) {
					System.out.println("Please enter 9 digit numeric health card number");
					System.out.print("Enter health card number: ");
					hcn = in.next();
				}
				// checks whether health card number consists anything else other than nine numbers
				else  if(hcn.length()!=9) {
					System.out.println("Please enter 9 digit health card number");
					System.out.print("Enter health card number: ");
					hcn = in.next();

				}

				else {
					good=true;
				}

			}



			int patientIndex = 0;
			boolean foundPatient = false;

			for(int i = 0; i < clinic.getNumberPatients(); i++)
			{
				if(clinic.getPatients(i).getHealthCardNumber().equals(hcn))                   
				{ 
					patientIndex = i;  // i is the position of the patient in the array 
					foundPatient = true;
					i = clinic.getNumberPatients(); // get out of loop 
				}
			}

			//patient is found - collect data to make appointment
			if (foundPatient) {
				System.out.println(clinic.getPatients(patientIndex)); //  the variable patientIndex holds the position of the patient in the array 
				System.out.println();
				// print out the list of doctors, ask user for number option - just one of several methods that can be used to fetch doctor info 
				printDoctors();

				System.out.print("Enter number for doctor selection: ");
				int doctorSelection = in.nextInt(); // use this to serve as the index for the doctor array  
				in.nextLine();

				// get date of desired appointment  
				System.out.print("Enter desired appointment date DDMMYYYY: ");
				String aDate = in.nextLine();
				int day = Integer.parseInt((aDate.substring(0, 2)));
				int month = Integer.parseInt((aDate.substring(2, 4)));
				int year = Integer.parseInt((aDate.substring(4, 8)));

				// handling appointment date			
				SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
				Date date =null;
				boolean goodDate=false;
				while(!goodDate) {
					try {
						sdf.setLenient(false);
						date = sdf.parse(aDate);
						goodDate=true;
						Date todayDate=new Date();

						//checks whether appointment date is today or in past
						while(sdf.format(date).equals(sdf.format(todayDate ) ) || date.before(todayDate)) {

							System.out.println("Appointment date cannot be today or in the past");

							System.out.print("Enter Appointment date DDMMYYYY: ");
							aDate = in.next();
							try {
								date = sdf.parse(aDate);
							} catch (ParseException e) {
								System.out.print("Please enter valid Appointment date: ");	
								aDate = in.next();
								goodDate=false;
								date = sdf.parse(aDate);
							}
						}
						day = Integer.parseInt((aDate.substring(0, 2)));
						month = Integer.parseInt((aDate.substring(2, 4)));
						year = Integer.parseInt((aDate.substring(4, 8)));
						break;

					} catch (ParseException e) {
						System.out.print("Please enter a valid Appointment date: ");
						aDate = in.next();
						goodDate=false;
					}
				}




				appointmentDate = new OurDate(day, month, year);

				// helper variable to determine next action taken if the appointment is already in database 
				boolean found = false;
				// verify that appointment does not have a doctor/date conflict 
				for (int k = 0; k < clinic.getNumberAppointments(); k++) {
					if (clinic.getAppointments(k).getAppointmentDate().equals(appointmentDate) && clinic.getAppointments(k).getDoctor().equals(clinic.getDoctors(doctorSelection - 1))   ) {
						found = true;
						appointmentDate = null;
						k = clinic.getNumberAppointments();
						System.out.print("Doctor already has an appointment that day\n");	
					}
				}
				if (found == false) { // make the new appointment 
					clinic.addAppointments(clinic.getPatients(patientIndex), clinic.getDoctors(doctorSelection - 1), appointmentDate);
				} 
			} 	
			else {
				System.out.println("Patient not in clinic database - first add patient to database before an appointment is made");
			}
		}
	} //END addAppointment() 

	//cancel appointments
	public void cancelAppointment() {
		System.out.println("Enter health card number: ");
		String hcn1=in.next();
		//searching for given health card number
		for(int i = 0; i < clinic.getNumberPatients(); i++)
		{
			if(clinic.getPatients(i).getHealthCardNumber().equals(hcn1)) //  patient is found 
			{ 
				System.out.println(clinic.getPatients(i));

				i=clinic.getNumberPatients(); // get out of loop 
			}
		}
		//printing doctors
		printDoctors();
		System.out.print("Enter number for doctor selection: ");
		int s1=in.nextInt();
		System.out.print("Enter Appointment Date DDMMYYYY: ");
		String ad=in.next();

		//extracting day,month,year
		int day = Integer.parseInt((ad.substring(0, 2)));
		int month = Integer.parseInt((ad.substring(2, 4)));
		int year = Integer.parseInt((ad.substring(4, 8)));


		OurDate d1=new OurDate(day,month,year);
		for (int k = 0; k < clinic.getNumberAppointments(); k++) {

			if (clinic.getPatients(k).getHealthCardNumber().equals(hcn1) && clinic.getAppointments(k).getAppointmentDate().equals(d1) && clinic.getAppointments(k).getDoctor().equals(clinic.getDoctors(s1 - 1))  ) {
				clinic.cancelAppointment(k);	
			}
		}

	}
	//method  to print appointments
	public void listAppointments() {
		for(int i=0;i<clinic.getNumberAppointments();i++) {
			System.out.println(clinic.getAppointments(i));
		}
	}

	public void writePatientsOut(){

		 clinic.filePatientsOut();

	}

	public void readPatientsIn() {
		clinic.filePatientsIn();
	}

	//method to print doctors
	public void printDoctors() {
		for(int i=0;i<clinic.getMaxDoctors();i++) {
			System.out.println(i+1+". "+clinic.getDoctors(i));
		}	
	}
	public void listPatients() {
		for(int i=0;i<clinic.getNumberPatients();i++)
			System.out.println(clinic.getPatients(i));
	}
	//main method
	public static void main(String[]args) {
		MedicalClinicUserInterface mcu1=new MedicalClinicUserInterface();
		mcu1.menu();
	}

}
