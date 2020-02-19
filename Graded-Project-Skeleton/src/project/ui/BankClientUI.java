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
			System.out.println( "4. Login" );
			String choice = input.read( "choice" );

			if( choice.equals( "0" ) ) break;

			else if( choice.equals( "1" ) ) {

			
				//TODO Requirement 1
				RegisterTransaction rt = new RegisterTransaction(bankClients);
								
				//TODO Requirement 2
				String name = input.read( "name" );
				String address = input.read( "address" );

				Date birthDate = null;
				try { birthDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( input.read( "birthDate" ) ); }
				catch( ParseException ex ){ ex.printStackTrace(); }

				bankClient.createProfile( name, address, birthDate );

				//TODO Requirement 3
				while( true ){

					String accountType = input.read( "account type (primary, savings)" );

					int accountNumber = bankClient.addAccount( accountType );
					
					boolean verified = bankClient.askForVerification( bankClient.clientID, accountNumber, adminName ); //TODO: contact bank admin

					bankClient.verify( accountNumber, verified );


					System.out.println( "\n0. NO extra account" );
					System.out.println( "1. Extra account" );
					String choice2 = input.read( "choice" );

					if( choice2.equals( "0" ) ) break;
				}
			}

			else if( choice.equals( "2" ) ) {

				//TODO Requirement 4
				String username = input.read( "username" );
				String password = input.read( "password" );

				int pos = 0;

				for( pos = 0; pos < bankClients.size(); ++pos ) if( bankClients.get( pos ).username.equals( username ) && bankClients.get( pos ).password.equals( password ) ) break;

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
						new MoneyTransferTransaction(bankClients, pos);
					}

					//Requirement 8 - DONE
                    else if( choice.equals( "8" ) ) {
                        BookAppointmentTransaction transaction = new BookAppointmentTransaction(bankClients, pos);
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
