package project.utilities;

import java.util.ArrayList;

public class ListBankAccount {

	public void printAllAccounts(ArrayList<BankAccount> accounts) {	
		ListPrint.printAllAccounts(accounts);
	}
	
	public void printAccount(ArrayList<BankAccount> accounts, int accountNumber) {
		for( int i = 0; accounts != null && i < accounts.size(); i++ ) {

			if( accounts.get( i ).getAccountNumber() == accountNumber ) {
				BankAccount account = accounts.get(i);
				ListPrint.printAccount(account);			
			}
		}
	}
}
