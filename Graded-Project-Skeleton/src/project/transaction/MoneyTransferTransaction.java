package project.transaction;

import project.actors.BankClient;
import project.utilities.StdInput;

public class MoneyTransferTransaction {
	
	BankClient bankClient;
	
	private int fromAccountNum;
	private int toAccountNum;
	private double amount;
	

	public MoneyTransferTransaction(BankClient bankClient) {
		this.bankClient = bankClient;
		
		provideTransferDetails();
		if(checkTransactionStructure() != null) {
			printErrorMessage(checkTransactionStructure());
		}
		else {
			executeMoneyTransferTransaction();
		}
	}
	
	private void provideTransferDetails() {
		bankClient.printAccounts();
		fromAccountNum = Integer.parseInt(StdInput.read( "from account number" ) );
		toAccountNum = Integer.parseInt(StdInput.read( "to account number" ) );
		amount = Integer.parseInt(StdInput.read("amount" ));
	}
	
	private String checkTransactionStructure() {	
		//inefficient code
		//TODO look into the references , look for a workaround	
		if(fromAccountNum != toAccountNum && amount > 0 && bankClient.accounts.stream().anyMatch(o -> o.getAccountNumber() == fromAccountNum) 
				&& bankClient.accounts.stream().anyMatch(o -> o.getAccountNumber() == fromAccountNum) && bankClient.accounts.get(fromAccountNum).getBalance() > 0) {
			return null;
		}
		return "Error Money Transfer Transaction";
	}
	
	private void printErrorMessage(String message) {
		System.err.println(message);
	}
	
	private void executeMoneyTransferTransaction() {
		bankClient.transfer(fromAccountNum, toAccountNum, amount);
	}
	
}
