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

		if( date == null || employeeName == null ) System.err.println( "Error book appointment transaction" );

		else { //Employee Name may be needed here or list of appointments
			appointments.add(new CandidateAppointment(date, bankClient));
		}
	}
	
}
