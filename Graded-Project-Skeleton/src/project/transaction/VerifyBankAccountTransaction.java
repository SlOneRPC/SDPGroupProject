package project.transaction;

import project.actors.BankAdmin;
import project.actors.BankClient;
import project.utilities.StdInput;

public class VerifyBankAccountTransaction {
	
	int accountNumber = -1;
	
	public VerifyBankAccountTransaction(BankAdmin bankAdmin,int clientIndex) {
		
			accountNumber = bankAdmin.accountNumbersToVerify.get( clientIndex );

			if(checkTransactionStructure()) {
				executeVerifyBankAccountTransaction(bankAdmin.bankClientsToVerify.get( clientIndex ));
			}
			else
				printErrorMsg();
		
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
