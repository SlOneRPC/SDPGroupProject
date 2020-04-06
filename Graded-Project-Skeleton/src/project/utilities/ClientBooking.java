package project.utilities;

import java.util.ArrayList;
import java.util.Date;

import project.actors.BankClient;

public class ClientBooking {

	public boolean askForSchedulingAppointment( int clientID, Date date, String employeeName){
		
		if( date == null || employeeName == null ) {
			System.err.println( "Error schedule appointment transaction" );
			return false;
		}
		else {
			//Assume we sent a message to bank employee
			return true;
		}
	}
	
	public void bookAppointment( Date date, String  employeeName, ArrayList<Appointment> appointments, BankClient bankClient){
		//The appointment has beem scheduled
		if( date == null || employeeName == null ) System.err.println( "Error book appointment transaction" );

		else {
			appointments.add(new CandidateAppointment(date, bankClient, employeeName, true));
		}
	}
	
}
