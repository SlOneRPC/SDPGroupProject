package project.utilities;

import java.util.Date;

public abstract class Appointment {

	public Date appointmentDate;
	
	public Appointment(Date date) {
		this.appointmentDate = date;
	}
	
	public void toPrint() {
		System.out.println("Date: " + appointmentDate);
	}
	
}
