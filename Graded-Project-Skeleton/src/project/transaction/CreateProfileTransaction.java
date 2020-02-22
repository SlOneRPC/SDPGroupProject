package project.transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

import project.utilities.StdInput;
import project.actors.*;

public class CreateProfileTransaction {

	private String name;
	private String address;
	private Date birthDate;
	
	public void createProfile(BankClient client) {
		provideDetails();
		String error = checkTransactionStructure();
		if( error != null ) {
			printErrorMessage( error );
		}
		else {
			executeCreateProfileTransaction(client);
		}
	}
	
	private void provideDetails() {
		 name = StdInput.read("name");
		 address = StdInput.read("address");
		 try {
			 birthDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( StdInput.read( "birthDate" ));
		 } catch(Exception ex) {
			 
		 }	 
	}
	
	private String checkTransactionStructure() {
		if( name == null || address == null || birthDate == null ) return "Error profile transaction" ;
		return null;
	}
	
	private void printErrorMessage(String message) {
		System.err.println("\n" + message);
	}
	
	private void executeCreateProfileTransaction(BankClient client) {
		client.createProfile(name, address, birthDate);
	}
}
