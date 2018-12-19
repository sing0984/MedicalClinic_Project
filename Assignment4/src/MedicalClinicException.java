

import java.io.Serializable;

public class MedicalClinicException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MedicalClinicException() {

	}
	public MedicalClinicException(String message) {
		super(message);

	}
}
