package project.utilities;
import java.util.Date;

public abstract class Appointment {

	public Date appointmentDate;
	public String interviewerName;
	public boolean scheduled;
	
	public Appointment(Date date, String interviewerName, boolean scheduled) {
		boolean initialized = securityManagerCheck(date);
		if(initialized) init(date, interviewerName, scheduled);
		else throw new SecurityException("Appointment date is not correctly initialised");
	}
	
	private boolean securityManagerCheck(Date dateToValidate) {
		Date date = new Date();//current date
		if(dateToValidate.compareTo(date) < 0) {
			return true;
		}
		return false;
	}
	
	
	private void init(Date date, String interviewerName, boolean scheduled) {
		this.appointmentDate = date;
		this.interviewerName = interviewerName;
		this.scheduled = scheduled;
	}
	
	public void toPrint() {
		System.out.println("Date: " + appointmentDate);
	}
}
