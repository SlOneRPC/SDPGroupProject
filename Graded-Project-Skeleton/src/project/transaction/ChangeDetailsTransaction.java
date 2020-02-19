package project.transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import project.actors.BankClient;
import project.utilities.StdInput;

public class ChangeDetailsTransaction {
	
	private List<BankClient> bankClients;
	private int pos;
	private String name;
	private String address;
	private Date birthDate = null;
	private String username;
	private String password;
	
	public ChangeDetailsTransaction(List<BankClient> bankClients, int pos) {
		this.bankClients = bankClients;
		this.pos = pos;
		
		provideNewBankClientDetails();
		if(checkTransactionStructure() != null) {
			printErrorMessage(checkTransactionStructure());
		}
		else {
			executeChangeDetailsTransaction();
		}
	}
	
	private void provideNewBankClientDetails() {
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
	
	private String checkTransactionStructure() {
		if (name == null || address == null || birthDate == null) {
			return "Error Change Details Transaction";
		}
		return null;
	}
	
	private void printErrorMessage (String message) {
		System.err.println(message);
	}
	
	private void executeChangeDetailsTransaction() {
		bankClients.get(pos).changeClientDetails(name, address, birthDate, username, password);
	}
}
