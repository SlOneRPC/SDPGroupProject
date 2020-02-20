package project.utilities;

public class PrimaryBankAccount extends BankAccount {

	public PrimaryBankAccount(int accNum, boolean verified, Double balance) {
		super(accNum, verified, balance);
	}
	
	@Override
	public String toString() {
		return "Primary";
	}
}
