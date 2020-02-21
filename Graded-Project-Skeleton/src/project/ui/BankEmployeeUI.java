package project.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.actors.BankClient;
import project.actors.BankEmployee;
import project.transaction.ScheduleTransaction;
import project.utilities.*;


public class BankEmployeeUI {

	public static void main( String[] args ) throws ParseException {
		//TODO Requirement 10
		BankEmployee bankEmployee = new BankEmployee();
		
		//Hard-Coded Data
		bankEmployee.bankClientsWithAppointments = new ArrayList<BankClient>();
		bankEmployee.appointmentDates = new ArrayList<Date>();

		//CLIENT 1
		BankClient bankClient1 = new BankClient("u1", "p1");
		int accountNumber1 = bankClient1.addAccount("primary");
		
		try {
			bankClient1.setClientProfile(new ClientProfileImpl1(accountNumber1, "A", "Address A", 
					new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2000")));
		} catch (ParseException e) {e.printStackTrace();} 
		bankEmployee.bankClientsWithAppointments.add( bankClient1 );
		bankEmployee.appointmentDates.add( new SimpleDateFormat( "dd/MM/yyyy" ).parse( "20/12/2000" ) );

		//CLIENT 2
		BankClient bankClient2 = new BankClient("u2", "p2");
		int accountNumber2 = bankClient2.addAccount("savings");
		try {
			bankClient2.setClientProfile(new ClientProfileImpl1(accountNumber2, "B", "Address B", 
					new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2000")));
			
		} catch (ParseException e) {e.printStackTrace();} 
		bankEmployee.bankClientsWithAppointments.add( bankClient2 );
		bankEmployee.appointmentDates.add( new SimpleDateFormat( "dd/MM/yyyy" ).parse( "22/12/2000" ) );

		print( bankEmployee.bankClientsWithAppointments );

		for( int i = 0; i < bankEmployee.bankClientsWithAppointments.size(); ++i ) {

				Date appointmentDate = bankEmployee.appointmentDates.get( i );
				BankClient bankClient = bankEmployee.bankClientsWithAppointments.get( i );
	
				System.out.println("\nCandidate Date: " + appointmentDate + " with client: = " + bankClient.getClientProfile().getName());
				System.out.println("1. Book it");
				System.out.println("2. Do not book it");
				String choice = StdInput.read("choice");
				
				if(choice.equals("1")) {
					new ScheduleTransaction(bankEmployee, bankClient, appointmentDate,  bankEmployee.name);
				}
		}
	}
	public static void print( List<BankClient> bankClients ) {

		for( int i = 0; bankClients != null && i < bankClients.size(); i++ ) {
			bankClients.get( i ).toPrint();
		}
	}
}
