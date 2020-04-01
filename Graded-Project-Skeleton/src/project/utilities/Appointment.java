package project.utilities;
import java.util.Date;

public abstract class Appointment {

	public Date appointmentDate;
	
	public Appointment(Date date) {
		if(validateDate(date)) {
			this.appointmentDate = date;
		}
	}
	
	private boolean validateDate(Date dateToValidate) {
		Date date = new Date();//current date
		if(dateToValidate.compareTo(date) < 0) {
			return true;
		}
		return false;
	}
	
	public void toPrint() {
		System.out.println("Date: " + appointmentDate);
	}
	
}
