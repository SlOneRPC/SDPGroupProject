package project.transaction;

import java.util.List;

import project.actors.BankClient;
import project.utilities.AccountDetail;
import project.utilities.StdInput;

public class DeleteTransaction {
	BankClient bankClient;
	List<BankClient> bankClients;
	AccountDetail accDetail;
	
	private int accountNum;

	public DeleteTransaction(BankClient bankClient, List<BankClient> bankClients) {
		this.bankClient = bankClient;
		this.bankClients = bankClients;
		
		provideAccountNumber();
		if(checkTransactionStructure() != null) {
			printErrorMessage(checkTransactionStructure());
		}
		else {
			executeDeleteTransaction();
		}
	}
	
	private void provideAccountNumber() {
		//bankClient.printAccounts();
		accDetail.printAllAccounts(bankClient.getAccounts());
		accountNum = Integer.parseInt(StdInput.read("account number"));
		
	}
	
	private String checkTransactionStructure() {
		//TODO look into this, look for a workaround
		if(bankClients != null) {
			for( int index = 0; index < bankClient.getAccounts().size(); index++ ) {
				if( bankClient.getAccounts().get(index).getAccountNumber() ==  accountNum) {
					return null;
				}
			}
		}
		return "Invalid Bank Account Number";
	}
	
	private void printErrorMessage(String message) {
		System.err.println(message);
	}
	
	private void executeDeleteTransaction() {
			bankClients.remove(bankClient);
	}
	
}
