package project.transaction;

import project.actors.BankAdmin;
import project.actors.BankClient;
import project.utilities.AccountVerification;
import project.utilities.BankAccount;

public class VerifyBankAccountTransaction {
	
	private int accountNumber = -1;
	private BankClient client;
	private AccountVerification accVerification;
	
	public void verifyBankAccountTransaction(BankAdmin bankAdmin,int clientIndex) {
		
			accountNumber = bankAdmin.accountNumbersToVerify.get( clientIndex );
			this.client = bankAdmin.bankClientsToVerify.get( clientIndex );
			accVerification = new AccountVerification();
			
			
			if(checkTransactionStructure()) {
				executeVerifyBankAccountTransaction(client);
			}
			else
				printErrorMsg();
		
	}
	
	private boolean checkTransactionStructure() {
		if(accountNumber != -1)//check if the account number if invalid
		{
			for(BankAccount bankAccount: client.getAccounts()) {
				if(bankAccount.getAccountNumber() == accountNumber)//check if the account exists
				{
					if(bankAccount.getVerified() == false) //Checked if account is already verified
						return true;
				}
			}
		}
		return false;
	}
	
	private void executeVerifyBankAccountTransaction(BankClient clientToVerify) {
		accVerification.verify(accountNumber, true, clientToVerify.getAccounts());
	}
	
	private void printErrorMsg() {
		System.err.println("Verify Bank Account error!");
	}	
}
