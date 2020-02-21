package project.transaction;

import project.actors.BankClient;
import project.utilities.ListBankAccount;
import project.utilities.InternalTransfer;
import project.utilities.StdInput;

public class MoneyTransferTransaction {
	
	BankClient bankClient;
	ListBankAccount accountDetail;
	
	private int fromAccountNum;
	private int toAccountNum;
	private double amount;
	InternalTransfer internalTransfer;

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
		accountDetail.printAllAccounts(bankClient.getAccounts());
		
		fromAccountNum = Integer.parseInt(StdInput.read( "from account number" ) );
		toAccountNum = Integer.parseInt(StdInput.read( "to account number" ) );
		amount = Integer.parseInt(StdInput.read("amount" ));
	}
	
	private String checkTransactionStructure() {	
		if(fromAccountNum != toAccountNum && amount > 0 && bankClient.getAccounts().stream().anyMatch(o -> o.getAccountNumber() == fromAccountNum) 
				&& bankClient.getAccounts().stream().anyMatch(o -> o.getAccountNumber() == fromAccountNum) && bankClient.getAccounts().get(fromAccountNum).getBalance() > 0) {
			return null;
		}
		return "Error Money Transfer Transaction";
	}
	
	private void printErrorMessage(String message) {
		System.err.println(message);
	}
	
	private void executeMoneyTransferTransaction() {
		internalTransfer.transfer(fromAccountNum, toAccountNum, amount, bankClient.getAccounts());
	}
	
}
