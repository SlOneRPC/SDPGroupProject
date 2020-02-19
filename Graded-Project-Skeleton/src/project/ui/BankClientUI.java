package project.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.actors.BankClient;

public class BankClientUI {
	
	public static void main( String[] args ) throws ParseException {

		List<BankClient> bankClients = new ArrayList<>();

		String adminName = "X", employeeName = "Y";


		while(true){

			print(bankClients);

			System.out.println( "\n0. Exit" );
			System.out.println( "1. Register" ); //--> Create Profile --> Create Account --> Create Further Accounts
			System.out.println( "4. Login" );
			String choice = read( "choice" );


			if( choice.equals( "0" ) ) break;

			else if( choice.equals( "1" ) ) {

				String username = read( "username" );
				String password = read( "password" );


				BankClient bankClient = new BankClient( username, password );

				bankClients.add( bankClient );


				String name = read( "name" );
				String address = read( "address" );

				Date birthDate = null;
				try { birthDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( read( "birthDate" ) ); }
				catch( ParseException ex ){ ex.printStackTrace(); }

				bankClient.createProfile( name, address, birthDate );


				while( true ){

					String accountType = read( "account type (primary, savings)" );

					int accountNumber = bankClient.addAccount( accountType );

					
					boolean verified = bankClient.askForVerification( bankClient.clientID, accountNumber, adminName ); //TODO: contact bank admin

					bankClient.verify( accountNumber, verified );


					System.out.println( "\n0. NO extra account" );
					System.out.println( "1. Extra account" );
					String choice2 = read( "choice" );

					if( choice2.equals( "0" ) ) break;
				}
			}

			else if( choice.equals( "2" ) ) {

				String username = read( "username" );
				String password = read( "password" );


				int pos = 0;

				for( pos = 0; pos < bankClients.size(); ++pos ) if( bankClients.get( pos ).username.equals( username ) && bankClients.get( pos ).password.equals( password ) ) break;

				if( pos < 0 || pos >= bankClients.size() ) System.err.println( "Invalid username or password" );

				else {

					bankClients.get( pos ).toPrint();

					int accountNumber = Integer.parseInt( read( "account number" ) );

					bankClients.get( pos ).toPrintAccount( accountNumber );


					System.out.println( "\n0. Exit" );
					System.out.println( "5. Change Bank Client Details" );
					System.out.println( "6. Delete Bank Account" );
					System.out.println( "7. Money transfer" );
					System.out.println( "8. Book Appoinment" );
					choice = read( "choice" );


					if( choice.equals( "5" ) ) {

						String name = read( "new name" );
						String address = read( "new address" );

						Date birthDate = null;
						try { birthDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( read( "new birthDate" ) ); }
						catch( ParseException ex ){ ex.printStackTrace(); }

						username = read( "new username" );
						password = read( "new password" );

						bankClients.get( pos ).changeClientDetails( name, address, birthDate, username, password );
					}

					else if( choice.equals( "6" ) ) {

						bankClients.get( pos ).printAccounts();

						accountNumber = Integer.parseInt( read( "account number" ) );

						bankClients.get( pos ).deleteAccount( accountNumber );

						if( bankClients.get( pos ).accountNumbers.size() == 0 ) bankClients.remove( pos );
					}

					else if( choice.equals( "7" ) ) {

						bankClients.get( pos ).printAccounts();

						int fromAccountNumber = Integer.parseInt( read( "from account number" ) );
						int toAccountNumber = Integer.parseInt( read( "to account number" ) );
						double amount = Integer.parseInt( read( "amount" ) );

						bankClients.get( pos ).transfer( fromAccountNumber, toAccountNumber, amount );
					}

					else if( choice.equals( "8" ) ) {

						Date appointmentDate = null;
						try { appointmentDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( read( "apppoinment date" ) ); }
						catch( ParseException ex ){ ex.printStackTrace(); }


						boolean scheduled = bankClients.get( pos ).askForSchedulingAppointment( bankClients.get( pos ).clientID, appointmentDate, employeeName );

						if( scheduled ) bankClients.get( pos ).bookAppointment( appointmentDate, employeeName );

						else System.err.println( "The appointment has not been booked" );
					}
				}
			}
		}
	}
	
	public static String read( String label ) {

		System.out.println( "\nProvide your " + label + ":" );

		System.out.println( ">" );


		BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

		String value = null;

		try {

			value = input.readLine();
		}

		catch (IOException ex) { ex.printStackTrace(); }


		return value;
	}
	
	public static void print(List<BankClient> bankClients) {

		System.out.println( "Bank Clients:\n" );

		for( int i = 0; bankClients != null && i < bankClients.size(); ++i ) bankClients.get( i ).toPrint();
	}
}
