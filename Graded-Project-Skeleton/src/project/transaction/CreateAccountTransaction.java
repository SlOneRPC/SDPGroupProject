package project.transaction;

import project.utilities.AccountVerification;
import project.utilities.StdInput;
import project.actors.*;

public class CreateAccountTransaction {

	private String accountType;
	private int accountNumber;
	private BankClient bankClient;
	private AccountVerification accVerification = new AccountVerification();
	
	public void createAccountTransaction(BankClient bankClient, String adminName) {		
		this.bankClient = bankClient;
		accVerification = new AccountVerification();
		
		provideDetails(adminName);
		String error = checkTransactionStructure();
		if( error != null ) {
			printErrorMessage( error );	
		}
		else {
			executeCreateAccountTransaction(adminName);
		}
	}
	
	private void provideDetails(String adminName) {
		 accountType = StdInput.read( "account type (primary, savings)" );
		 accountNumber = bankClient.addAccount( accountType );				 
	}
	
	private String checkTransactionStructure() {
		if( accountType == null || accountNumber == -1 ) {
			return "Error register transaction" ;
		}
		return null;
	}
	
	private void printErrorMessage( String message ) {
		System.err.println( message );
	}
	
	private void executeCreateAccountTransaction(String adminName) {
		boolean verified = accVerification.askForVerification(bankClient.getClientProfile().getClientID(), accountNumber, adminName);
		accVerification.verify(accountNumber, verified, bankClient.getAccounts());
	}	
}