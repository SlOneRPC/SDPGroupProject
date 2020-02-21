package project.utilities;

public abstract class BankAccount {
	
	int accountNumber;
	boolean verified;
	Double balance;
		
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
	
	public Double getBalance() {
		return this.balance;
	}
	
	public boolean getVerified() {
		return this.verified;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public abstract String toString();
}
