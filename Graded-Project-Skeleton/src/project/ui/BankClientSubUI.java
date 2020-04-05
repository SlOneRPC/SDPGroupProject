package project.ui;

import project.actors.BankClient;
import project.actors.BankClientDictionarySingleton;
import project.transaction.BookAppointmentTransaction;
import project.transaction.ChangeDetailsTransaction;
import project.transaction.DeleteTransaction;
import project.transaction.MoneyTransferTransaction;
import project.transaction.TransactionTemplate;
import project.utilities.ListBankAccount;
import project.utilities.ListPrint;
import project.utilities.StdInput;

public class BankClientSubUI {
	
	//This class is only used through BankClientUI - hence no main method
	
	public void LogInMenu(BankClientDictionarySingleton bankClientDictionarySingleton, int pos) {
		BankClient bankClient;
		ListBankAccount accountDetail = new ListBankAccount();
		
		bankClient = bankClientDictionarySingleton.get(pos);
		bankClient.toPrint();

		int accountNumber = Integer.parseInt(StdInput.read("account number"));				
		accountDetail.printAccount(bankClient.getAccounts(), accountNumber);
		
		String choice = "";
		do {
			bankClient.toPrint();
			System.out.println("\n0. Exit" + 
					"\n5. Change Bank Client Details" + 
					"\n6. Delete Bank Account" +
					"\n7. Money transfer" +
					"\n8. Book Appoinment");
					choice = StdInput.read("choice");

					//Requirement 5: Change Details
					switch (choice){
						case "0": 
							break;
						case "5":
							TransactionTemplate cd = new ChangeDetailsTransaction();
							cd.exampleTransaction(bankClient);
							break;
						
						case "6":
							DeleteTransaction dt = new DeleteTransaction();
							dt.deleteTransaction(bankClientDictionarySingleton.get(pos), bankClientDictionarySingleton);
							break;
						
						case "7":
							MoneyTransferTransaction mt = new MoneyTransferTransaction();
							mt.moneyTransferTransaction(bankClientDictionarySingleton.get(pos));
							break;
							
						default:
							BookAppointmentTransaction transaction = new BookAppointmentTransaction();
				            transaction.bookAppointmentTransaction(bankClientDictionarySingleton.get(pos));
				            break;
							
					}
		}while(!choice.equals("0"));
			
	}
}
