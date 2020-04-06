package project.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import project.actors.BankClient;
import project.actors.BankEmployee;
import project.transaction.ScheduleTransaction;
import project.utilities.*;


public class BankEmployeeUI {

	public static void main( String[] args ) throws ParseException {
		//Requirement 10 
		BankEmployee bankEmployee = new BankEmployee("Fake Employee");
		
		//Hard-Coded Data
		bankEmployee.bankClientsWithAppointments = new ArrayList<BankClient>();
		bankEmployee.appointmentDates = new ArrayList<Date>();

		try { 
			//CLIENT 1
			BankClient bankClient1 = new BankClient("u1", "p1");
			int accountNumber1 = bankClient1.addAccount("primary");
			
				bankClient1.setClientProfile(new ClientProfileImpl1(accountNumber1, "A", "Address A", 
						new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2000")));
			bankEmployee.bankClientsWithAppointments.add(bankClient1);
			bankEmployee.appointmentDates.add( new SimpleDateFormat( "dd/MM/yyyy" ).parse( "20/12/2000" ) );
			
			//CLIENT 2
			BankClient bankClient2 = new BankClient("u2", "p2");
			int accountNumber2 = bankClient2.addAccount("savings");
						
			bankClient2.setClientProfile(new ClientProfileImpl1(accountNumber2, "B", "Address B", 
					new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2000")));			
			bankEmployee.bankClientsWithAppointments.add(bankClient2);
			bankEmployee.appointmentDates.add( new SimpleDateFormat( "dd/MM/yyyy" ).parse( "22/12/2000" ) );
			
		} catch (ParseException e) {e.printStackTrace();} 

		ListPrint.printBankClientsWithAppointmentsToBook(bankEmployee.bankClientsWithAppointments, bankEmployee.appointmentDates);

		for(int i = 0; i < bankEmployee.bankClientsWithAppointments.size(); i++) {

				Date appointmentDate = bankEmployee.appointmentDates.get(i);
				BankClient bankClient = bankEmployee.bankClientsWithAppointments.get(i);
	
				System.out.println("\nCandidate Date = " + appointmentDate + " with client = " + bankClient.getClientProfile().getName() +
				"\n1. Book it" +
				"\n2. Do not book it");
				String choice = StdInput.read("choice");
				Boolean scheduled = (choice.equals("1"));
				if(choice.equals("1")) {
					ScheduleTransaction st = new ScheduleTransaction();
					st.scheduleTransaction(bankEmployee, bankClient, appointmentDate,  bankEmployee.name);
				}
				System.out.println("Appointment date: " + appointmentDate.toString() + ", scheduled: " + scheduled);
		}
	}
}
