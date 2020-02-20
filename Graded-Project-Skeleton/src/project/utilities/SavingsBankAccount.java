package project.utilities;

public class SavingsBankAccount extends BankAccount {

	public SavingsBankAccount(int accNum, boolean verified, Double balance) {
		super( accNum, verified,  balance);
	}
	
	@Override
	public String toString() {
		return "Savings";
	}
}
