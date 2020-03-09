package project.transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

import project.utilities.StdInput;
import project.actors.*;

public class CreateProfileTransaction extends TransactionTemplate {
		
	private String name;
	private String address;
	private Date birthDate;
	
	public void provideDetails() {
		 name = StdInput.read("name");
		 address = StdInput.read("address");
		 try {
			 birthDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( StdInput.read( "birthDate" ));
		 } catch(Exception ex) {
			 
		 }	 
	}
	
	public String checkTransactionStructure() {
		if( name == null || address == null || birthDate == null ) return "Error profile transaction" ;
		return null;
	}
	
	public void printErrorMessage(String message) {
		System.err.println("\n" + message);
	}
	
	public void executeTransaction(BankClient client) {
		client.createProfile(name, address, birthDate);
	}
}
