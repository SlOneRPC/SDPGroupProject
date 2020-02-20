package project.transaction;

import project.utilities.StdInput;
import project.actors.*;

public class CreateAccountTransaction {

	String accountType;
	int accountNumber;
	BankClient bankClient;
	
	public CreateAccountTransaction(BankClient bankClient, String adminName) {		
		this.bankClient = bankClient;
		provideDetails(adminName);
		String error = checkTransactionStructure();
		if( error != null ) printErrorMessage( error );	
		else {executeCreateAccountTransaction(adminName);}
	}
	
	private void provideDetails(String adminName) {
		 accountType = StdInput.read( "account type (primary, savings)" );
		 accountNumber = bankClient.addAccount( accountType );				 
	}
	
	private String checkTransactionStructure() {
		//NOTE: IDK ABOUT THE -1 PART
		if( accountType == null || accountNumber == -1 ) return "Error register transaction" ;
		return null;
	}
	
	private void printErrorMessage( String message ) {
		System.err.println( message );
	}
	
	private void executeCreateAccountTransaction(String adminName) {
		//hold on, the bankClient holds onto the account even if it's not verified?
		 //note: this is always true
		boolean verified = bankClient.askForVerification( bankClient.clientID, accountNumber, adminName ); 
		bankClient.verify(accountNumber, verified);
	}	
}
