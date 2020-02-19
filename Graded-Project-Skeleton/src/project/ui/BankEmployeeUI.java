package project.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.actors.BankClient;
import project.actors.BankEmployee;
import project.transaction.BookAppointmentTransaction;
import project.utilities.*;


public class BankEmployeeUI {

	public static void main( String[] args ) throws ParseException {

		//TODO Requirement 10
		BankEmployee bankEmployee = new BankEmployee();
		
		bankEmployee.bankClientsWithAppointments = new ArrayList<BankClient>();
		bankEmployee.appointmentDates = new ArrayList<Date>();

		BankClient bankClient1 = new BankClient( "u1", "p1" );
		bankClient1.name = "A";
		bankEmployee.bankClientsWithAppointments.add( bankClient1 );
		bankEmployee.appointmentDates.add( new SimpleDateFormat( "dd/MM/yyyy" ).parse( "20/12/2000" ) );

		BankClient bankClient2 = new BankClient( "u2", "p2" );
		bankClient2.name = "B";
		bankEmployee.bankClientsWithAppointments.add( bankClient2 );
		bankEmployee.appointmentDates.add( new SimpleDateFormat( "dd/MM/yyyy" ).parse( "22/12/2000" ) );


		print( bankEmployee.bankClientsWithAppointments );

		new BookAppointmentTransaction(bankEmployee);
	}
	
	public static void print( List<BankClient> bankClients ) {

		for( int i = 0; bankClients != null && i < bankClients.size(); ++i ) bankClients.get( i ).toPrint();
	}
}
