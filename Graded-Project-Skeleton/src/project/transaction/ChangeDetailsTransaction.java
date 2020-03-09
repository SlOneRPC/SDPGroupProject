package project.transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import project.actors.BankClient;
import project.utilities.StdInput;

public class ChangeDetailsTransaction extends TransactionTemplate{
	
	private String name;
	private String address;
	private Date birthDate = null;
	private String username;
	private String password;
	
	public void provideDetails() {
		name = StdInput.read("new name");
		address = StdInput.read("new address");
		
		try { 
			birthDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse(StdInput.read( "new birthDate" )); 
		}
		catch(ParseException ex ) { 
			ex.printStackTrace(); 
		}
		
		username = StdInput.read("new username");
		password = StdInput.read("new password");
	}
	
	public String checkTransactionStructure() {
		if (name == null || address == null || birthDate == null) {
			return "Error Change Details Transaction";
		}
		return null;
	}
	
	public void printErrorMessage(String message) {
		System.err.println(message);
	}
	
	public void executeTransaction(BankClient client) {
		client.changeClientDetails(name, address, birthDate, username, password);
	}
}
