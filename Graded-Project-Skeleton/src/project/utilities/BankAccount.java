package project.utilities;

public class BankAccount {

	int accountNumber;
	boolean verified;
	Double balance;
	
	//TODO turn this into a Interface or Abstract class or whatever
	
	public BankAccount(int accNum, boolean verified, Double balance) {
		this.accountNumber = accNum;
		this.verified = verified;
		this.balance = balance;
	}
	
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
}
