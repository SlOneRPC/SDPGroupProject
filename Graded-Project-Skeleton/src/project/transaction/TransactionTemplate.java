package project.transaction;

import project.actors.BankClient;

public abstract class TransactionTemplate {
	
	public void exampleTransaction(BankClient client) {
		provideDetails();
		String error = checkTransactionStructure();
		if( error != null ) {
			printErrorMessage(error);
		}
		else {
			executeTransaction(client);
		}
	}
	
	public abstract void provideDetails();
	
	public abstract String checkTransactionStructure();
	
	public abstract void printErrorMessage(String error);
	
	public abstract void executeTransaction(BankClient client);

}
