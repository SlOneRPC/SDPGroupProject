package project.transaction;

import java.util.Date;

import project.actors.BankClient;
import project.actors.BankEmployee;

public class ScheduleTransaction {

	Date appointmentDate = null;
	String adminName = "X", employeeName = "Y";
	BankEmployee employee;
	BankClient client;
	
	public ScheduleTransaction(BankEmployee currentEmployee, BankClient client,Date AppointmentDate,String employeeName) {
		
		this.appointmentDate = AppointmentDate;
		this.employeeName = employeeName;
		this.employee = currentEmployee;
		this.client = client;
		
		if(checkTransactionStructure() ) 
			executeChangeTransaction(client);
		else
			notifyClient(false);//print error
	}


	public boolean checkTransactionStructure() {
		if(appointmentDate != null && adminName != null && employeeName != null) {
			
			int i = 0;
			for(Date date:employee.appointmentDates) //ensure no two appointments are on the same day
			{
				if(date == appointmentDate && employee.bankClientsWithAppointments.get(i) != client) {
					return false;
				}
				i++;
			}
			return true;
		}
		return false;
	}
	
	public void executeChangeTransaction(BankClient client) {
		client.bookAppointment( appointmentDate, employeeName );
		notifyClient(true);
	}
	
	public void notifyClient(boolean booked) {
		if(booked)
			System.out.println("Appointment successfully booked!");
		else 
			System.err.println("The appointment has not been booked" );
	}
}
