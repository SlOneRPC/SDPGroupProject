package project.ui;

import java.util.List;
import project.actors.BankClient;
import project.transaction.BookAppointmentTransaction;
import project.transaction.ChangeDetailsTransaction;
import project.transaction.DeleteTransaction;
import project.transaction.MoneyTransferTransaction;
import project.utilities.ListBankAccount;
import project.utilities.StdInput;

public class BankClientLoggedInUI {
	
	//This class is only used through BankClientUI - hence no main method
	
	public void LogInMenu(List<BankClient> bankClients, int pos) {
		BankClient bankClient;
		ListBankAccount accountDetail = new ListBankAccount();
		
		bankClient = bankClients.get(pos);
		bankClient.toPrint();

		int accountNumber = Integer.parseInt(StdInput.read("account number"));				
		accountDetail.printAccount(bankClient.getAccounts(), accountNumber);
		
		System.out.println("\n0. Exit");
		System.out.println("5. Change Bank Client Details");
		System.out.println("6. Delete Bank Account");
		System.out.println("7. Money transfer" );
		System.out.println("8. Book Appoinment");
		String choice = StdInput.read("choice");

		//Requirement 5: Change Details
		if(choice.equals("5")) {
			ChangeDetailsTransaction dt = new ChangeDetailsTransaction();
			dt.changeDetailsTransaction(bankClients, pos);
		}

		//Requirement 6: Delete Bank Account
		else if(choice.equals("6")) {
			DeleteTransaction dt = new DeleteTransaction();
			dt.deleteTransaction(bankClients.get(pos), bankClients);
		}

		//Requirement 7: Internal Money Transfer
		else if(choice.equals("7")) {
			MoneyTransferTransaction mt = new MoneyTransferTransaction();
			mt.moneyTransferTransaction(bankClients.get(pos));
		}

		//Requirement 8: Book an Appointment
        else if(choice.equals("8")) {
            BookAppointmentTransaction transaction = new BookAppointmentTransaction();
            transaction.bookAppointmentTransaction(bankClients.get(pos));
        }
	}
}
