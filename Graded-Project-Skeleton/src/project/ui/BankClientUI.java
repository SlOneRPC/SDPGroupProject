package project.ui;

import java.text.ParseException;
import project.actors.BankClient;
import project.actors.BankClientDictionarySingleton;
import project.utilities.ListBankAccount;
import project.utilities.StdInput;
import project.transaction.*;
 

public class BankClientUI {
	
	public static void main( String[] args ) throws ParseException {

		BankClientDictionarySingleton bankClientDictionarySingleton = BankClientDictionarySingleton.getInstance();
		TransactionTemplate transactionTemplate = null;
		
		
		while(true){
			bankClientDictionarySingleton.printBankClients();
			System.out.println("\n0. Exit" + 
			"\n1. Register" + 
			"\n4. Login");
			String choice = StdInput.read("choice");
			
			switch (choice) {
			case "0":
				System.out.println("\n(!) Application Exited");
				System.exit(0);
			
			case "1":
				BankClient bankClient;
				
				//Requirement 1: Register Bank Client
				RegisterTransaction rt = new RegisterTransactionImpl1();
				rt.registerBankClient(bankClientDictionarySingleton);		
				bankClient = bankClientDictionarySingleton.get(bankClientDictionarySingleton.size() - 1);
											
				//Requirement 2: Create Profile
				transactionTemplate = new CreateProfileTransaction();
				transactionTemplate.exampleTransaction(bankClient);

				//Requirement 3: Create Account + Further Accounts
				String choice2;
				do {
					CreateAccountTransaction cat = new CreateAccountTransaction();
					cat.createAccountTransaction(bankClient, "Fake Admin");
					System.out.println( "\n0. No extra account" + 
					"\n1. Extra account");
					choice2 = StdInput.read("choice");
	
					} while(choice2.equals("1"));
				break;	
			
			default:
				//Requirement 4: Login 
				LoginTransaction lt = new LoginTransaction();
				lt.loginTransaction(bankClientDictionarySingleton);
				int pos = lt.executeLoginTransaction();
				if(pos < 0 || pos >= bankClientDictionarySingleton.size()) {
					System.err.println( "\nBank client credentials were not found.");
					break;
				}

				subUI(bankClientDictionarySingleton, pos, transactionTemplate);
				break;				
			}
		}
	}
	
	private static void subUI(BankClientDictionarySingleton bankClientDictionarySingleton, int pos, TransactionTemplate transactionTemplate) {
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
							transactionTemplate = new ChangeDetailsTransaction();
							transactionTemplate.exampleTransaction(bankClient);
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
