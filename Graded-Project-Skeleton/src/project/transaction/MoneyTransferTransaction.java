package project.transaction;

import project.actors.BankClient;
import project.utilities.ListBankAccount;
import project.utilities.BankAccount;
import project.utilities.InternalTransfer;
import project.utilities.StdInput;

public class MoneyTransferTransaction {
	
	private BankClient bankClient;
	private ListBankAccount accountDetail;
	
	private int fromAccountNum;
	private int toAccountNum;
	private double amount;
	private InternalTransfer internalTransfer = new InternalTransfer();

	public void moneyTransferTransaction(BankClient bankClient) {
		this.bankClient = bankClient;
		accountDetail = new ListBankAccount();
		internalTransfer = new InternalTransfer();
		
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
		amount = Integer.parseInt(StdInput.read("amount"));
	}
	
	private String checkTransactionStructure() {	
		if(!checkIfAmountValid()) {
			return "Not enough amount in the source account.";
		}
		if(fromAccountNum != toAccountNum && amount > 0 && bankClient.getAccounts().stream().anyMatch(o -> o.getAccountNumber() == fromAccountNum) 
				&& bankClient.getAccounts().stream().anyMatch(o -> o.getAccountNumber() == fromAccountNum)) {
			return null;
		}
		return "Error Money Transfer Transaction";
	}
	
	private boolean checkIfAmountValid() {
		for(BankAccount account : bankClient.getAccounts()) {
			if(account.getAccountNumber() == this.fromAccountNum) {
				if(account.getBalance() >= amount) {
					return true;
				}
			}
		}
		return false;
	}
	
	private void printErrorMessage(String message) {
		System.err.println(message);
	}
	
	private void executeMoneyTransferTransaction() {
		internalTransfer.transfer(fromAccountNum, toAccountNum, amount, bankClient.getAccounts());
	}
	
}
