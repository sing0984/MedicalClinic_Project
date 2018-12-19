

import java.io.Serializable;

public class MaternityPatient extends Patient implements Serializable  {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private OurDate dueDate;
private boolean nutritionTesting;

//default constructor
public MaternityPatient() {
	
	this("unknown","unknown","-1",new OurDate(),new OurDate(),false);
}

//initial constructor
public MaternityPatient(String firstName,String lastName,String healthCardNumber,OurDate birthDate,OurDate dueDate,boolean nutritionTesting){
	super(firstName,lastName,healthCardNumber,birthDate);
	this.setDueDate(dueDate);
	this.setNutritionTesting(nutritionTesting);
}


public OurDate getDueDate() {
	return dueDate;
}

private void setDueDate(OurDate dueDate) {
	this.dueDate = dueDate;
}

public boolean getNutritionTesting() {
	return nutritionTesting;
}

private void setNutritionTesting(boolean nutritionTesting) {
	this.nutritionTesting = nutritionTesting;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
	result = prime * result + (nutritionTesting ? 1231 : 1237);
	return result;
}

@Override
public boolean equals(Object obj) {
if(obj==null)
 return false;
if(!(obj instanceof MaternityPatient))
	return false;
MaternityPatient mP=(MaternityPatient)obj;
	return (this.getFirstName().equals(mP.getFirstName()) && this.getLastName().equals(mP.getLastName()) && this.getHealthCardNumber()==mP.getHealthCardNumber() && this.getBirthDate().equals(mP.getBirthDate()) && this.getDueDate().equals(mP.getDueDate()) &&this.getNutritionTesting()==mP.getNutritionTesting() );
	
	
	
}

public String toString() {
	return (super.toString()+" "+"Due Date: "+ dueDate+ "Nutrition Testing: "+ nutritionTesting);
}



}
