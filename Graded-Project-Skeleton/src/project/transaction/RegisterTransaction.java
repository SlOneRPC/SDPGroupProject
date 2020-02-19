package project.transaction;
import java.util.List;

import project.actors.*;
import project.utilities.StdInput;

public class RegisterTransaction {

	String username;
	String password;
	
	public RegisterTransaction(List<BankClient> bankClients) {
		provideDetails();
		String error = checkTransactionStructure();
		if( error != null ) printErrorMessage( error );
		executeRegisterTransaction(bankClients);
	}
	
	private void provideDetails() {
		 username = StdInput.read( "username" );
		 password = StdInput.read( "password" );
	}
	
	private String checkTransactionStructure() {
		if( username == null || username == null ) return "Error register transaction" ;
		return null;
	}
	
	public void printErrorMessage( String message ) {
		System.err.println( message );
	}
	
	private void executeRegisterTransaction(List<BankClient> bankClients) {
		bankClients.add(new BankClient(username, password));
	}
}
