package project.transaction;

import java.util.Date;

import project.actors.BankClient;
import project.actors.BankEmployee;
import project.utilities.ClientBooking;

public class ScheduleTransaction {

	private Date appointmentDate = null;
	private String adminName = "X", employeeName = "Y";
	private BankEmployee employee;
	private BankClient client;
	private ClientBooking clientBooking = new ClientBooking();
	
	public void scheduleTransaction(BankEmployee currentEmployee, BankClient client,Date AppointmentDate,String employeeName) {
		
		this.appointmentDate = AppointmentDate;
		this.employeeName = employeeName;
		this.employee = currentEmployee;
		this.client = client;
		clientBooking = new ClientBooking();
		
		if(checkTransactionStructure()) {
			executeChangeTransaction(client);
		}
		else {
			printErrorMsg();
		}
	}


	private boolean checkTransactionStructure() {
		if(appointmentDate != null && adminName != null && employeeName != null) {
			int i = 0;
			for(Date date : employee.appointmentDates) { //ensure no two appointments are on the same day (Conflicting Appointments)
				
				if(date == appointmentDate && employee.bankClientsWithAppointments.get(i) != client) {
					return false;
				}
				i++;
			}
			return true;
		}
		return false;
	}
	
	private void executeChangeTransaction(BankClient client) {
		clientBooking.bookAppointment(appointmentDate, employeeName, client.getAppointments());
		notifyClient();
	}
	
	private void notifyClient() {
			System.out.println("Appointment successfully booked!");
	}
	
	private void printErrorMsg() {
		System.err.println("The appointment has not been booked" );
	}
}
