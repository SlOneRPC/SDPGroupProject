package project.ui;

import java.text.ParseException;
import project.actors.BankClient;
import project.actors.BankClientDictionarySingleton;
import project.utilities.StdInput;
import project.transaction.*;
 

public class BankClientUI {
	
	public static void main( String[] args ) throws ParseException {

		//List<BankClient> bankClients = new ArrayList<>();
		BankClientDictionarySingleton bankClientDictionarySingleton = BankClientDictionarySingleton.getInstance();
		
		while(true){
			//ListPrint.print(bankClients);
			bankClientDictionarySingleton.printBankClients();
			System.out.println("\n0. Exit" + 
			"\n1. Register" + 
			"\n2. Login");
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
				//bankClient = bankClients.get(bankClients.size() -1);
				bankClient = bankClientDictionarySingleton.get(bankClientDictionarySingleton.size() - 1);
											
				//Requirement 2: Create Profile
				TransactionTemplate cpt = new CreateProfileTransaction();
				cpt.exampleTransaction(bankClient);

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
					System.err.println( "\n\n(!) Invalid username or password");
					break;
				}
				BankClientSubUI loggedInUI = new BankClientSubUI();
				loggedInUI.LogInMenu(bankClientDictionarySingleton, pos);
				break;
			}
		}
	}
}
