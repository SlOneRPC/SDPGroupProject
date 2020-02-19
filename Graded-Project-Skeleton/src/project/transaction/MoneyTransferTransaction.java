package project.transaction;

import java.util.List;

import project.actors.BankClient;
import project.utilities.StdInput;

public class MoneyTransferTransaction {
	
	private List<BankClient> bankClients;
	private int pos;
	
	private int fromAccountNum;
	private int toAccountNum;
	private double amount;
	

	public MoneyTransferTransaction(List<BankClient> bankClients, int pos) {
		this.bankClients = bankClients;
		this.pos = pos;
		
		provideTransferDetails();
		if(checkTransactionStructure() != null) {
			printErrorMessage(checkTransactionStructure());
		}
		else {
			executeMoneyTransferTransaction();
		}
	}
	
	private void provideTransferDetails() {
		bankClients.get(pos).printAccounts();
		fromAccountNum = Integer.parseInt(StdInput.read( "from account number" ) );
		toAccountNum = Integer.parseInt(StdInput.read( "to account number" ) );
		amount = Integer.parseInt(StdInput.read("amount" ));
	}
	
	private String checkTransactionStructure() {	
		//inefficient code
		int accountsChecked = 0;
		if (fromAccountNum != toAccountNum && amount > 0) {
			for(int accountNumIndex = 0; accountNumIndex < bankClients.get(pos).accountNumbers.size(); accountNumIndex++) {
				if((fromAccountNum == bankClients.get(pos).accountNumbers.get(accountNumIndex)) && accountsChecked == 1){
					accountsChecked++;
					if (bankClients.get(pos).accountBalances.get(accountNumIndex) < 0) {
						break;
					}
					return null;
				}
				else if(toAccountNum == bankClients.get(pos).accountNumbers.get(accountNumIndex) && accountsChecked == 1) {
					accountsChecked++;
					return null;
				}
			}
		}
		return "Error Money Transfer Transaction";
	}
	
	private void printErrorMessage(String message) {
		System.err.println(message);
	}
	
	private void executeMoneyTransferTransaction() {
		bankClients.get(pos).transfer(fromAccountNum, toAccountNum, amount);
	}
	
}
