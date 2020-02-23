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
		String adminName = "X";
		//String employeeName = "Y"; - Not Used; Check Why Later
		
		while(true){
			ListPrint.print(bankClients);
			System.out.println("0. Exit");
			System.out.println("1. Register");
			System.out.println("2. Login");
			String choice = StdInput.read("choice");

			if(choice.equals("0")) {
				System.out.println("\n(!) Application Exited");
				break;
			}
			else if(choice.equals( "1" )) {
				BankClient bankClient;
			
				//Requirement 1: Register Bank Client
				RegisterTransaction rt = new RegisterTransactionImpl1();
				rt.registerBankClient(bankClients);		
				bankClient = bankClients.get(bankClients.size() -1);
				
				//Requirement 2: Create Profile
				CreateProfileTransaction cpt = new CreateProfileTransaction();
				cpt.createProfile(bankClient);

				//Requirement 3: Create Account + Further Accounts
				while(true) {
					CreateAccountTransaction cat = new CreateAccountTransaction();
					cat.createAccountTransaction(bankClient, adminName);
					System.out.println( "\n0. No extra account");
					System.out.println( "1. Extra account");
					String choice2 = StdInput.read("choice");
					
					if( choice2.equals("0")) {
						break;
					}
				}
			}
			else if(choice.equals("2")) {
				
				//Requirement 4: Login 
				LoginTransaction lt = new LoginTransaction();
				lt.loginTransaction(bankClients);
				int pos = lt.executeLoginTransaction();
				if(pos < 0 || pos >= bankClients.size()) {
					System.err.println( "Invalid username or password" );
				}
				else {
					BankClientLoggedInUI loggedInUI = new BankClientLoggedInUI();
					loggedInUI.LogInMenu(bankClients, pos);
				}
			}
		}
	}
}
