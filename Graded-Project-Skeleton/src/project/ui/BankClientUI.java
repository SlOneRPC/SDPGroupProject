package project.ui;


import project.utilities.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.actors.BankClient;
import project.utilities.StdInput;
import project.transaction.*;
 

public class BankClientUI {
	
	public static void main( String[] args ) throws ParseException {

		List<BankClient> bankClients = new ArrayList<>();
		String adminName = "X", employeeName = "Y";
		StdInput input = new StdInput();
		
		while(true){
			print(bankClients);

			System.out.println( "\n0. Exit" );
			System.out.println( "1. Register" ); //--> Create Profile --> Create Account --> Create Further Accounts
			System.out.println( "2. Login" );
			String choice = input.read( "choice" );

			if( choice.equals( "0" ) ) break;

			else if( choice.equals( "1" ) ) {
				BankClient bankClient;
			
				//TODO Requirement 1
				RegisterTransaction rt = new RegisterTransaction(bankClients);
				bankClient = bankClients.get(bankClients.size() -1);//perhaps change the transaction return type
				
				
				//TODO Requirement 2
				CreateProfileTransaction cpt = new CreateProfileTransaction(bankClient);

				//TODO Requirement 3
				while( true ){
					CreateAccountTransaction cat = new CreateAccountTransaction(bankClient, adminName);
					
					System.out.println( "\n0. NO extra account" );
					System.out.println( "1. Extra account" );
					String choice2 = StdInput.read( "choice" );
					if( choice2.equals( "0" ) ) break;
				}
			}

			else if( choice.equals( "2" ) ) {

				String username;
				String password;//TODO move these into the BankClient class
				//TODO Requirement 4
			
				LoginTransaction lt = new LoginTransaction(bankClients);
				int pos = lt.executeLoginTransaction();//Not sure about this, but it still works
				if( pos < 0 || pos >= bankClients.size() ) System.err.println( "Invalid username or password" );

				else {

					bankClients.get( pos ).toPrint();

					int accountNumber = Integer.parseInt(input.read( "account number" ));

					bankClients.get( pos ).toPrintAccount( accountNumber );


					System.out.println( "\n0. Exit" );
					System.out.println( "5. Change Bank Client Details" );
					System.out.println( "6. Delete Bank Account" );
					System.out.println( "7. Money transfer" );
					System.out.println( "8. Book Appoinment" );
					choice = input.read( "choice" );


					//TODO Requirement 5
					if( choice.equals( "5" ) ) {
						new ChangeDetailsTransaction(bankClients, pos);
					}

					//TODO Requirement 6
					else if( choice.equals( "6" ) ) {
						new DeleteTransaction(bankClients, pos);
					}

					//TODO Requirement 7
					else if( choice.equals( "7" ) ) {
						new MoneyTransferTransaction(bankClients.get(pos));
					}

					//Requirement 8 - DONE
                    else if( choice.equals( "8" ) ) {
                        BookAppointmentTransaction transaction = new BookAppointmentTransaction(bankClients.get(pos));
                    }
				}
			}
		}
	}
	
	public static void print(List<BankClient> bankClients) {

		System.out.println( "Bank Clients:\n" );

		for( int i = 0; bankClients != null && i < bankClients.size(); ++i ) bankClients.get( i ).toPrint();
	}
}
