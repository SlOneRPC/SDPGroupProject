package project.ui;

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

		BankClient bankClient1 = new BankClient("u1", "p1");
		int accountNumber1 = bankClient1.addAccount("primary");
		bankAdmin.bankClientsToVerify.add(bankClient1);
		bankAdmin.accountNumbersToVerify.add(accountNumber1);

		BankClient bankClient2 = new BankClient("u2", "p2");
		int accountNumber2 = bankClient2.addAccount("savings");
		bankAdmin.bankClientsToVerify.add( bankClient2 );
		bankAdmin.accountNumbersToVerify.add(accountNumber2);
		
		print(bankAdmin.bankClientsToVerify);
		
		for( int i = 0; i < bankAdmin.accountNumbersToVerify.size(); i++ ) {

			int accountNumber = bankAdmin.accountNumbersToVerify.get(i);
		
			System.out.println("\nAccount number = " + accountNumber);
			System.out.println("1. Verify the opening" );
			System.out.println("2. Do not verify the opening");
			String choice = StdInput.read("choice");
			
			if(choice.equals("1")) {
				new VerifyBankAccountTransaction(bankAdmin, i);
			}
		}	
	}
	
	public static void print(List<BankClient> bankClients) {

		for( int i = 0; i < bankClients.size(); i++ ) { //Deleted Null Condition
			bankClients.get(i).toPrint();
		}
	}
	
}
