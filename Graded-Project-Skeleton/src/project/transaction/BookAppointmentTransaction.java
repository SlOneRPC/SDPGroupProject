package project.transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import project.actors.BankClient;
import project.utilities.ClientBooking;
import project.utilities.StdInput;

public class BookAppointmentTransaction {

	private Date appointmentDate = null;
	private String adminName = "X", employeeName = "Y";
	private ClientBooking clientBooking;
	
	public void bookAppointmentTransaction(BankClient client) {

		try { 
			appointmentDate = new SimpleDateFormat("dd/MM/yyyy").parse(StdInput.read("apppoinment date")); 
		}
		catch(ParseException ex) {
			ex.printStackTrace(); 
		}
		clientBooking = new ClientBooking();
		
		
		if(checkTransactionStructure()) {
			
			boolean scheduled = clientBooking.askForSchedulingAppointment(client.getClientProfile().getClientID(), appointmentDate, employeeName);
			
			if(scheduled) {
				executeChangeTransaction(client);
			}
			else {
				printErrorMsg();
			}
		}
		else {
			printErrorMsg();
		}
	}
	
	private boolean checkTransactionStructure() {
		if(appointmentDate != null && adminName != null && employeeName != null) {
			return true;
		}
		return false;
	}
	
	private void executeChangeTransaction(BankClient client) {
		clientBooking.bookAppointment(appointmentDate, employeeName, client.getAppointments(), client);
		System.out.println("Appointment date " + appointmentDate.toString() + ", scheduled: true");
	}
		
	private void printErrorMsg() {
		System.err.println( "\nThe appointment has not been booked" );
	}
}
