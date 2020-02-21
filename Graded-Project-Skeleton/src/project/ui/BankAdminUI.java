package project.ui;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import project.actors.*;
import project.transaction.*;
import project.utilities.*;


public class BankAdminUI {

	public static void main( String[] args ) {
		//Requirement 9: Verifying Profiles
		BankAdmin bankAdmin = new BankAdmin();
		
		//Hard-Coded Data
		bankAdmin.bankClientsToVerify = new ArrayList<BankClient>();
		bankAdmin.accountNumbersToVerify = new ArrayList<Integer>();

		//CLIENT 1
		BankClient bankClient1 = new BankClient("u1", "p1");
		int accountNumber1 = bankClient1.addAccount("primary");
		
		try {
			bankClient1.setClientProfile(new ClientProfileImpl1(accountNumber1, "A", "Address A", 
					new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2000")));
		} catch (ParseException e) {e.printStackTrace();} 
		
		bankAdmin.bankClientsToVerify.add(bankClient1);
		bankAdmin.accountNumbersToVerify.add(accountNumber1);

		//CLIENT 2
		BankClient bankClient2 = new BankClient("u2", "p2");
		int accountNumber2 = bankClient2.addAccount("savings");
		try {
			bankClient2.setClientProfile(new ClientProfileImpl1(accountNumber2, "B", "Address B", 
					new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2000")));
		} catch (ParseException e) {e.printStackTrace();} 
		
		bankAdmin.bankClientsToVerify.add(bankClient2);
		bankAdmin.accountNumbersToVerify.add(accountNumber2);
		
		print(bankAdmin.bankClientsToVerify);
		
		for( int i = 0; i < bankAdmin.accountNumbersToVerify.size(); i++ ) {

			int accountNumber = bankAdmin.accountNumbersToVerify.get(i);
		
			System.out.println("\nAccount number = " + accountNumber);
			System.out.println("1. Verify the opening" );
			System.out.println("2. Do not verify the opening");
			String choice = StdInput.read("choice");
			
			if(choice.equals("1")) {
				VerifyBankAccountTransaction vbt  = new VerifyBankAccountTransaction();
				vbt.verifyBankAccountTransaction(bankAdmin, i);
			}
		}	
	}
	
	public static void print(List<BankClient> bankClients) {

		for(int i = 0; bankClients != null && i < bankClients.size(); i++) {
			bankClients.get(i).toPrint();
		}
	}
	
}
