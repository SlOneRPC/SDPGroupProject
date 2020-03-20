package project.transaction;

import project.actors.BankClient;
import project.actors.BankClientDictionarySingleton;
import project.utilities.ListBankAccount;
import project.utilities.StdInput;

public class DeleteTransaction {
	
	private BankClient bankClient;
	private BankClientDictionarySingleton bankClientDictionarySingleton;
	private ListBankAccount listBankAccount = new ListBankAccount();	
	private int accountNum;
	private int accountIndex;

	public void deleteTransaction(BankClient bankClient,BankClientDictionarySingleton bankClientDictionarySingleton) {
		this.bankClient = bankClient;
		this.bankClientDictionarySingleton = bankClientDictionarySingleton;
		
		provideAccountNumber();
		String error = checkTransactionStructure();
		if(error != null) {
			printErrorMessage(error);
		}
		else {
			executeDeleteTransaction();
		}
	}
	
	private void provideAccountNumber() {
		listBankAccount.printAllAccounts(bankClient.getAccounts());
		accountNum = Integer.parseInt(StdInput.read("account number"));
	}
	
	private String checkTransactionStructure() {	
		for( int index = 0; index < bankClient.getAccounts().size(); index++ ) {
			if(bankClient.getAccounts().get(index).getAccountNumber() ==  accountNum) {
				accountIndex = index;
				return null;
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
			bankClientDictionarySingleton.removeBankClient(bankClient);
		}	
	}
}
