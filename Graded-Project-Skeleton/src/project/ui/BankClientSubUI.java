package project.ui;

import java.util.List;
import project.actors.BankClient;
import project.transaction.BookAppointmentTransaction;
import project.transaction.ChangeDetailsTransaction;
import project.transaction.DeleteTransaction;
import project.transaction.MoneyTransferTransaction;
import project.utilities.ListBankAccount;
import project.utilities.StdInput;

public class BankClientSubUI {
	
	//This class is only used through BankClientUI - hence no main method
	
	public void LogInMenu(List<BankClient> bankClients, int pos) {
		BankClient bankClient;
		ListBankAccount accountDetail = new ListBankAccount();
		
		bankClient = bankClients.get(pos);
		bankClient.toPrint();

		int accountNumber = Integer.parseInt(StdInput.read("account number"));				
		accountDetail.printAccount(bankClient.getAccounts(), accountNumber);
		
		System.out.println("\n0. Exit" + 
		"\n5. Change Bank Client Details" + 
		"\n6. Delete Bank Account" +
		"\n7. Money transfer" +
		"\n8. Book Appoinment");
		String choice = StdInput.read("choice");

		//Requirement 5: Change Details
		switch (choice){
			case "0": 
				break;
			case "5":
				ChangeDetailsTransaction cd = new ChangeDetailsTransaction();
				cd.changeDetailsTransaction(bankClients, pos);
				break;
			
			case "6":
				DeleteTransaction dt = new DeleteTransaction();
				dt.deleteTransaction(bankClients.get(pos), bankClients);
				break;
			
			case "7":
				MoneyTransferTransaction mt = new MoneyTransferTransaction();
				mt.moneyTransferTransaction(bankClients.get(pos));
				break;
				
			default:
				BookAppointmentTransaction transaction = new BookAppointmentTransaction();
	            transaction.bookAppointmentTransaction(bankClients.get(pos));
	            break;
				
		}
	}
}
