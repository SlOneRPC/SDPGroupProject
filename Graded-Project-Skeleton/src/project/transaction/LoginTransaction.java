package project.transaction;

import project.utilities.StdInput;

import java.util.List;

import project.actors.*;

public class LoginTransaction {

	String username;
	String password;
	int pos = 0;
	
	public LoginTransaction(List<BankClient> bankClients) {

		provideDetails();
		String error = checkTransactionStructure();
		if(error != null) printErrorMessage(error);
		else {
			for( pos = 0; pos < bankClients.size(); pos++ ){
				if( bankClients.get( pos ).getUsername().equals( username ) && bankClients.get( pos ).getPassword().equals( password ) )
					break;
			}
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
