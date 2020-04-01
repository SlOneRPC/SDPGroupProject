package project.utilities;
import java.util.Date;

public abstract class Appointment {

	public Date appointmentDate;
	
	public Appointment(Date date) {
		boolean initialized = securityManagerCheck(date);
		if(initialized) init(date);
		else throw new SecurityException("Appointment date is not correctly initialised");
	}
	
	private boolean securityManagerCheck(Date dateToValidate) {
		Date date = new Date();//current date
		if(dateToValidate.compareTo(date) < 0) {
			return true;
		}
		return false;
	}
	
	
	private void init(Date date) {
		this.appointmentDate = date;
	}
	
	public void toPrint() {
		System.out.println("Date: " + appointmentDate);
	}
	
}
