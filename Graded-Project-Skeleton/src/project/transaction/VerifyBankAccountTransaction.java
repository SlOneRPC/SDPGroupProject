package project.transaction;

import project.actors.BankAdmin;
import project.actors.BankClient;
import project.utilities.AccountVerification;
import project.utilities.BankAccount;

public class VerifyBankAccountTransaction {
	
	int accountNumber = -1;
	BankClient client;
	AccountVerification accVerification = new AccountVerification();
	
	public VerifyBankAccountTransaction(BankAdmin bankAdmin,int clientIndex) {
		
			accountNumber = bankAdmin.accountNumbersToVerify.get( clientIndex );
			this.client = bankAdmin.bankClientsToVerify.get( clientIndex );
			
			if(checkTransactionStructure()) {
				executeVerifyBankAccountTransaction(client);
			}
			else
				printErrorMsg();
		
	}
	
	public boolean checkTransactionStructure() {
		if(accountNumber != -1) {
			for(BankAccount bankAccount: client.getAccounts()) {
				if(bankAccount.getAccountNumber() == accountNumber)//check if the account exists
				{
					if(bankAccount.getVerified() == false) //TODO check if there is missing information
						return true;
				}
			}
		}
		return false;
	}
	public void executeVerifyBankAccountTransaction(BankClient clientToVerify) {
		//clientToVerify.verify( accountNumber, true );//we assume that we are answering to the client with this call
		accVerification.verify(accountNumber, true, clientToVerify.getAccounts());
	}
	
	public void printErrorMsg() {
		System.err.println("Verify Bank Account error!");
	}
	
}
