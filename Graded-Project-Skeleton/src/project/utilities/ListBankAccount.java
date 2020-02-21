package project.utilities;

import java.util.ArrayList;

public class ListBankAccount {

	public void printAllAccounts(ArrayList<BankAccount> accounts) {
		for( int i = 0; accounts != null && i < accounts.size(); i++ ) {
			BankAccount account = accounts.get(i);
			System.out.println( "\taccountNumber: " + account.getAccountNumber() );
			System.out.println( "\taccountType: " + account.toString() );
			System.out.println( "\taccountVerified: " + account.getVerified() );
			System.out.println( "\taccountBalance: " + account.getBalance() );
		}
	}
	
	public void printAccount(ArrayList<BankAccount> accounts, int accountNumber) {
		for( int i = 0; accounts != null && i < accounts.size(); i++ ) {

			if( accounts.get( i ).getAccountNumber() == accountNumber ) {
				BankAccount account = accounts.get(i);
				System.out.println( "\taccountNumber: " + account.getAccountNumber() );
				System.out.println( "\taccountType: " + account.toString() );
				System.out.println( "\taccountVerified: " + account.getVerified());
				System.out.println( "\taccountBalance: " + account.getBalance());
			}
		}
	}
}
