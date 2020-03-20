package project.transaction;

import project.utilities.StdInput;

import project.actors.*;

public class LoginTransaction {

	private String username;
	private String password;
	private int pos = 0;
	
	public void loginTransaction(BankClientDictionarySingleton bankClientDictionarySingleton) {
		provideDetails();
		String error = checkTransactionStructure();
		
		if(error != null) { 
			printErrorMessage(error);
		}
		else {		
			pos = bankClientDictionarySingleton.searchBankClient(username, password);
		}	
	}
	
	private void provideDetails() {
		 username = StdInput.read( "username" );
		 password = StdInput.read( "password" );
	} 
	
	private String checkTransactionStructure() {
		if( username == null || username == null ) return "Error register transaction" ;
		return null;
	}
	
	private void printErrorMessage( String message ) {
		System.err.println( message );
	}
	
	public int executeLoginTransaction () {
		return pos;
	}
}
