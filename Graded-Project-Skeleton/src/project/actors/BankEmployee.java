package project.actors;

import java.util.Date;
import java.util.List;


public class BankEmployee extends User{

	public List<BankClient> bankClientsWithAppointments;
	public List<Date> appointmentDates;
	
	public BankEmployee(String name) {
		super.name = name;
	}

}
