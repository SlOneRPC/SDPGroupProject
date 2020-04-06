package project.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import project.actors.*;
import project.transaction.*;
import project.utilities.*;


public class BankAdminUI {

	public static void main( String[] args ) {
		//Requirement 9: Verifying Profiles
		BankAdmin bankAdmin = new BankAdmin("Fake Admin");
		
		//Hard-Coded Data
		bankAdmin.bankClientsToVerify = new ArrayList<BankClient>();
		bankAdmin.accountNumbersToVerify = new ArrayList<Integer>();

		//CLIENT 1
		BankClient bankClient1 = new BankClient("u1", "p1");
		int accountNumber1 = bankClient1.addAccount("primary");
		
		try {
			bankClient1.setClientProfile(new ClientProfileImpl1(accountNumber1, "D1", "AS1", 
					new SimpleDateFormat("dd/MM/yyyy").parse("23/10/2000")));
		} catch (ParseException e) {e.printStackTrace();} 
		
		bankAdmin.bankClientsToVerify.add(bankClient1);
		bankAdmin.accountNumbersToVerify.add(accountNumber1);

		//CLIENT 2
		BankClient bankClient2 = new BankClient("u2", "p2");
		int accountNumber2 = bankClient2.addAccount("savings");
		try {
			bankClient2.setClientProfile(new ClientProfileImpl1(accountNumber2, "D2", "AS2", 
					new SimpleDateFormat("dd/MM/yyyy").parse("10/12/2001")));
		} catch (ParseException e) {e.printStackTrace();} 
		
		bankAdmin.bankClientsToVerify.add(bankClient2);
		bankAdmin.accountNumbersToVerify.add(accountNumber2);
		
		ListPrint.printBankClientsAccountsToVerify(bankAdmin.bankClientsToVerify, bankAdmin.accountNumbersToVerify);
				
		for( int i = 0; i < bankAdmin.accountNumbersToVerify.size(); i++ ) {

			int accountNumber = bankAdmin.accountNumbersToVerify.get(i);
		
			System.out.println("\nAccount number = " + accountNumber + 
			"\n1. Verify the opening" + 
			"\n2. Do not verify the opening");
			String choice = StdInput.read("choice");
			
			if(choice.equals("1")) {
				VerifyBankAccountTransaction vbt  = new VerifyBankAccountTransaction();
				vbt.verifyBankAccountTransaction(bankAdmin, i);
			}
			System.out.println("Account number " + accountNumber + ", verified: " + (choice.equals("1")));
		}	
	}
	
}
