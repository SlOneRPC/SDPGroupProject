package project.transaction;

import project.actors.BankAdmin;
import project.actors.BankClient;
import project.utilities.StdInput;

public class VerifyBankAccountTransaction {
	
	int accountNumber = -1;
	
	public VerifyBankAccountTransaction(BankAdmin bankAdmin) {
		for( int i = 0; i < bankAdmin.accountNumbersToVerify.size(); ++i ) {

			accountNumber = bankAdmin.accountNumbersToVerify.get( i );
			
			System.out.println( "\nAccount number = " + accountNumber );

			System.out.println( "1. Verify the opening" );
			System.out.println( "2. Do not verify the opening" );
			String choice = StdInput.read( "choice" );
			
			if(checkTransactionStructure()) {
				if( choice.equals( "1" ) ) executeVerifyBankAccountTransaction(bankAdmin.bankClientsToVerify.get( i ));
			}
			else
				printErrorMsg();
		}
	}
	
	public boolean checkTransactionStructure() {
		if(accountNumber != -1)
			return true;
		return false;
	}
	public void executeVerifyBankAccountTransaction(BankClient clientToVerify) {
		clientToVerify.verify( accountNumber, true );//we assume that we are answering to the client with this call
	}
	
	public void printErrorMsg() {
		System.err.println("Verify Bank Account error!");
	}
	
}
