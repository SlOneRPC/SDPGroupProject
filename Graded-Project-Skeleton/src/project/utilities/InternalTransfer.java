package project.utilities;

import java.util.ArrayList;

public class InternalTransfer {

	private ArrayList<BankAccount> accounts;
	private int from, to;
	
	public void transfer( int fromAccountNumber, int toAccountNumber, double amount, ArrayList<BankAccount> accounts ) {

		this.accounts = accounts;
		BankAccount fromAccount = getFromAccount(fromAccountNumber), toAccount = getToAccount(toAccountNumber);
	
		if( from >= 0 && from < accounts.size() && to >= 0 && to < accounts.size() && fromAccount.getBalance() >= amount ) {	
			fromAccount.setBalance(fromAccount.getBalance() - amount);
			toAccount.setBalance(toAccount.getBalance() + amount);
			//System.out.println( "Transfer is completed" );
		}
		
		else System.out.println( "Transfer cannot be made" );
	}
	
	private BankAccount getFromAccount(int targetAccount) {
		from = 0;
		BankAccount result = null;
		for( from = 0; from < accounts.size(); from++ ) {

			if( accounts.get( from ).getAccountNumber() == targetAccount  ) {
				result = accounts.get(from);
				/*
				 * System.out.println( "\tFrom accountNumber: " + result.getAccountNumber());
				 * System.out.println( "\tFrom accountType: " + result.toString());
				 * System.out.println( "\tFrom accountVerified: " + result.getVerified() );
				 * System.out.println( "\tFrom accountBalance: " + result.getBalance() );
				 */
				return result;
			}
		}
		return result;
	}
	
	private BankAccount getToAccount(int targetAccount) {
		to = 0;
		BankAccount result = null;
		for( to = 0; to < accounts.size(); to++ ) {

			if( accounts.get( to ).getAccountNumber() == targetAccount) {
				result = accounts.get(to);
				/*
				 * System.out.println( "\tTo accountNumber: " + result.getAccountNumber());
				 * System.out.println( "\tTo accountType: " + result.toString());
				 * System.out.println( "\tTo accountVerified: " + result.getVerified() );
				 * System.out.println( "\tTo accountBalance: " + result.getBalance() );
				 */	
				return result;
			}
		}
		return result;
	}
}
