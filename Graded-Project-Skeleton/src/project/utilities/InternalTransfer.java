package project.utilities;

import java.util.ArrayList;

public class InternalTransfer {

	public void transfer( int fromAccountNumber, int toAccountNumber, double amount, ArrayList<BankAccount> accounts ) {

		int from = 0;
		BankAccount fromAccount = new BankAccount(), toAccount = new BankAccount();
		
		for( from = 0; from < accounts.size(); ++from ) {

			if( accounts.get( from ).getAccountNumber() == fromAccountNumber  ) {
				fromAccount = accounts.get(from);
				System.out.println( "\tFrom accountNumber: " + fromAccount.getAccountNumber());
				System.out.println( "\ttFrom accountType: " + fromAccount.toString());//TODO test this out
				System.out.println( "\ttFrom accountVerified: " + fromAccount.getVerified() );
				System.out.println( "\ttFrom accountBalance: " + fromAccount.getBalance() );		
			}
		}

		int to = 0;

		for( to = 0; to < accounts.size(); ++to ) {

			if( accounts.get( to ).getAccountNumber() == toAccountNumber  ) {
				toAccount = accounts.get(to);
				
				System.out.println( "\tFrom accountNumber: " + toAccount.getAccountNumber());
				System.out.println( "\ttFrom accountType: " + toAccount.toString());//TODO test this out
				System.out.println( "\ttFrom accountVerified: " + toAccount.getVerified() );
				System.out.println( "\ttFrom accountBalance: " + toAccount.getBalance() );
			}
		}

		//if( from >= 0 && from < accountNumbers.size() && to >= 0 && to < accountNumbers.size() && accountBalances.get( from ) >= amount ) {
		if( from >= 0 && from < accounts.size() && to >= 0 && to < accounts.size() && fromAccount.getBalance() >= amount ) {
			
			fromAccount.setBalance(fromAccount.getBalance() - amount);

			toAccount.setBalance(toAccount.getBalance() - amount);
			
			System.out.println( "Transfer is completed" );
		}

		else System.out.println( "Transfer cannot be made" );
	}
}
