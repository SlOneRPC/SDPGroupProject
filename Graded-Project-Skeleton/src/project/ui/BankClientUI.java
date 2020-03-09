package project.ui;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import project.utilities.*;
import project.actors.BankClient;
import project.utilities.StdInput;
import project.transaction.*;
 

public class BankClientUI {
	
	public static void main( String[] args ) throws ParseException {

		List<BankClient> bankClients = new ArrayList<>();
		
		while(true){
			ListPrint.print(bankClients);
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
				rt.registerBankClient(bankClients);		
				bankClient = bankClients.get(bankClients.size() -1);
				
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
				lt.loginTransaction(bankClients);
				int pos = lt.executeLoginTransaction();
				if(pos < 0 || pos >= bankClients.size()) {
					System.err.println( "\n\n(!) Invalid username or password");
					break;
				}
				BankClientSubUI loggedInUI = new BankClientSubUI();
				loggedInUI.LogInMenu(bankClients, pos);
				break;
			}
		}
	}
}
