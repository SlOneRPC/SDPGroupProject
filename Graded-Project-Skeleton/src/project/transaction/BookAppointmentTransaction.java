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
	
	public BookAppointmentTransaction(BankEmployee bankEmployee) {
		for( int i = 0; i < bankEmployee.bankClientsWithAppointments.size(); ++i ) {

			appointmentDate = bankEmployee.appointmentDates.get( i );
			employeeName = bankEmployee.name;
			if(checkTransactionStructure()) {
				BankClient bankClient = bankEmployee.bankClientsWithAppointments.get( i );
	
				System.out.println( "\nCandidate date = " + appointmentDate + " with client = " + bankClient.name );
	
				System.out.println( "1. Book it" );
				System.out.println( "2. Do not book it" );
				String choice = StdInput.read( "choice" );
				
				employeeName = bankEmployee.name ;
				if( choice.equals( "1" ) ) executeChangeTransaction(bankClient); //we assume that we answer with this call to the client.
			}
		}
	};
	
	public BookAppointmentTransaction(BankClient client) 
	{
		try { appointmentDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( StdInput.read( "apppoinment date" ) ); }
		catch( ParseException ex ){ ex.printStackTrace(); }
		
		if(checkTransactionStructure()) {
			
			boolean scheduled = client.askForSchedulingAppointment( client.clientID, appointmentDate, employeeName );
	
			if( scheduled )  executeChangeTransaction(client);
	
			else notifyEmployee(scheduled);
		}
		else
			 notifyEmployee(false);
	}
	
	public boolean checkTransactionStructure() {
		if(appointmentDate != null && adminName != null && employeeName != null)
			return true;
		return false;
	}
	
	public void executeChangeTransaction(BankClient client) {
		client.bookAppointment( appointmentDate, employeeName );
		notifyEmployee(true);
	}
	
	public void notifyEmployee(boolean booked) {
		if(booked)
			System.out.println("Appointment successfully booked!");
		else 
			System.err.println( "The appointment has not been booked" );
			
	}
}
