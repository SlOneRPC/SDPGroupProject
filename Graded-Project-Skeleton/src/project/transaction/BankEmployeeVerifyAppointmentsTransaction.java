package project.transaction;

import java.util.Date;
import java.util.List;

import project.actors.BankClient;
import project.utilities.Appointment;
import project.utilities.CandidateAppointment;
import project.utilities.StdInput;

public class BankEmployeeVerifyAppointmentsTransaction {
	
	public void book( List<Appointment> candidateAppointments, String bankEmployeeName ) {

		iterate( candidateAppointments, bankEmployeeName );
	}

	public void iterate( List<Appointment> candidateAppointments, String bankEmployeeName ) {

		for( int pos = 0; pos < candidateAppointments.size(); ++pos ) {

			Date date = candidateAppointments.get(pos).appointmentDate; //public but was in appendix 

			BankClient bankClient = ((CandidateAppointment)candidateAppointments.get(pos)).bankClient;

			String choice = askForVerification( date, bankClient.name );

			execute( choice, bankClient, date, bankEmployeeName );
		}
	}

	public String askForVerification( Date date, String name ) {

		System.out.println( "\nCandidate date = " + date + " with client = " + name );

		System.out.println( "1. Book it" );
		System.out.println( "2. Do not book it" );


		return StdInput.read( "choice" );
	}

	public void execute(String choice, BankClient bankClient, Date date, String bankEmployeeName) {
		Appointment appointment = bankClient.addAppointment(date, bankEmployeeName); //we assume that we answer with this call to the client. (appendix comment)

		boolean scheduled = false;

		if( choice.equals("1")) {
			scheduled = true;
		}
		bankClient.setScheduled(appointment, scheduled); //leave this not working for it to be fixed when debugged (appendix stuff means we have to change other stuff)
		
	}	
}