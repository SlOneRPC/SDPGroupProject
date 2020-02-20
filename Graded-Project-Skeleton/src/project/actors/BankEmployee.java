package project.actors;

import java.util.Date;
import java.util.List;


public class BankEmployee extends Person{
	
	public String name = "X";

	public List<BankClient> bankClientsWithAppointments;
	public List<Date> appointmentDates;
	
	public BankEmployee() { }
	
	public void toPrint() {}
}
