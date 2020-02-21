package project.utilities;

import java.util.ArrayList;

public class AccountVerification {

	public boolean askForVerification(int clientID, int accountNumber, String adminName) {
		//Assume we sent a message to bank admin
		return true;
	}
	
	public void verify(int accountNumber, boolean verified, ArrayList<BankAccount> accounts) {
		for( int i = 0; i < accounts.size(); ++i ) if( accounts.get( i ).getAccountNumber() == accountNumber ) accounts.get(i).setVerified(verified);
	}
}
