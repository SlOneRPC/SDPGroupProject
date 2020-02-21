package project.transaction;

import java.util.List;

import project.actors.BankClient;
import project.utilities.ListBankAccount;
import project.utilities.StdInput;

public class DeleteTransaction {
	BankClient bankClient;
	List<BankClient> bankClients;
	ListBankAccount accDetail;	
	 int accountNum;
	 int accountIndex;

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
		accDetail.printAllAccounts(bankClient.getAccounts());
		accountNum = Integer.parseInt(StdInput.read("account number"));
	}
	
	private String checkTransactionStructure() {	
		if(bankClients != null) {
			for( int index = 0; index < bankClient.getAccounts().size(); index++ ) {
				if(bankClient.getAccounts().get(index).getAccountNumber() ==  accountNum) {
					accountIndex = index;
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
		bankClient.getAccounts().remove(accountIndex);
		if(bankClient.getAccounts().size() == 0) {
			deleteClientProfile();
		}	
	}
	
	private void deleteClientProfile() {
		bankClients.remove(bankClient);
	}
}
