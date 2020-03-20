package project.transaction;

import project.actors.*;
import project.utilities.StdInput;

public class RegisterTransactionImpl1 implements RegisterTransaction{

	private String username;
	private String password;
			
	public void registerBankClient(BankClientDictionarySingleton bankClientDictionarySingleton) {
		provideDetails();
		String error = checkTransactionStructure();
		if( error != null ) printErrorMessage( error );
		else {executeRegisterTransaction(bankClientDictionarySingleton);}	
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
	
	private void executeRegisterTransaction(BankClientDictionarySingleton bankClientDictionarySingleton) {
		BankClientDictionarySingleton.getInstance().addBankClient(new BankClient(username, password));
	}
}
