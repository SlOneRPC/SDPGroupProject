package project.transaction;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import project.actors.BankClient;
import project.actors.BankEmployee;
import project.utilities.StdInput;

public class BookAppointmentTransaction {

	Date appointmentDate = null;
	String adminName = "X", employeeName = "Y";
	
	public BookAppointmentTransaction(BankClient client) 
	{
		try { appointmentDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( StdInput.read( "apppoinment date" ) ); }
		catch( ParseException ex ){ ex.printStackTrace(); }
		
		if(checkTransactionStructure()) {
			
			boolean scheduled = client.askForSchedulingAppointment( client.clientID, appointmentDate, employeeName );
	
			if( scheduled )  executeChangeTransaction(client);
	
			else printErrorMsg();
		}
		else
			printErrorMsg();
	}
	
	public boolean checkTransactionStructure() {
		if(appointmentDate != null && adminName != null && employeeName != null)
			return true;
		return false;
	}
	
	public void executeChangeTransaction(BankClient client) {
		client.bookAppointment( appointmentDate, employeeName );
		notifyEmployee();
	}
	
	public void notifyEmployee() {
		System.out.println("Appointment successfully booked!");	
	}
	
	public void printErrorMsg() {
		System.err.println( "The appointment has not been booked" );
	}
}
