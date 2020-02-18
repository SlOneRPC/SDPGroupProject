package gradedGroupProject.nonPrincipledDesign.v0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class BankClient {

	public static final AtomicInteger clientCount = new AtomicInteger( 0 );
	public static final AtomicInteger accountCount = new AtomicInteger( 0 );

	public int clientID;
	public String name;
	public String address;
	public Date birthDate;

	public String username;
	public String password;

	public List<Integer> accountNumbers;
	public List<String> accountTypes;
	public List<Boolean> accountVerified;
	public List<Double> accountBalances;

	public List<Date> appointments;
	public List<String> bankEmployeesWithAppointments;


	public BankClient( String username, String password ){
		this.username = username;
		this.password = password;
	}

	public void createProfile( String name, String address, Date birthDate ){
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
	}

	public int addAccount( String accountType ){

		//TODO
		this.accountNumbers.add(this.accountNumbers.size() + 1);
		this.accountTypes.add(accountType);
		this.accountVerified.add(false);
		this.accountBalances.add(0.00);
		
		return 0;
	}

	public boolean askForVerification( int clientID, int accountNumber, String adminName ){

		//Assume we sent a message to bank admin
		//verify(accountNumber,true);
		
		return true;
	}

	public void verify( int accountNumber, boolean verified ){
		this.accountVerified.set(accountNumber, verified);
	}

	public void changeClientDetails( String name, String address, Date birthDate, String username, String password ){
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
		this.username = username;
		this.password = password;
	}

	public void toPrint() {

		//TODO
	}

	public void toPrintAccount( int accountNumber ) {

		//TODO
	}

	public void printAccounts() {
		for (int i = 1; i <= accountNumbers.size(); i++) {
			toPrintAccount(i);
		}
	}

	public void deleteAccount( int accountNumber ) {
		this.accountNumbers.remove(accountNumber);
		this.accountBalances.remove(accountNumber);
		this.accountTypes.remove(accountNumber);
		this.accountVerified.remove(accountNumber);
		
		
		//TODO update account numbers
	}

	public void transfer( int fromAccountNumber, int toAccountNumber, double amount ) {
		double accountBalance1 = this.accountBalances.get(fromAccountNumber);
		double accountBalance2 = this.accountBalances.get(toAccountNumber);
		this.accountBalances.set(fromAccountNumber,accountBalance1-amount);
		this.accountBalances.set(toAccountNumber, accountBalance2+amount);
	}

	public boolean askForSchedulingAppointment( int clientID, Date date, String employeeName ){

		//TODO

		return false;
	}

	public void bookAppointment( Date date, String  employeeName ){

		//TODO
	}



	public static void main( String[] args ) throws ParseException {

		List<BankClient> bankClients = new ArrayList<>();

		String adminName = "X", employeeName = "Y";


		while( true ){

			print( bankClients );

			System.out.println( "\n0. Exit" );
			System.out.println( "1. Register" ); //--> Create Profile --> Create Account --> Create Further Accounts
			System.out.println( "4. Login" );
			System.out.println( "5. Change Bank Client Details" );
			System.out.println( "6. Delete Bank Account" );
			System.out.println( "7. Money transfer" );
			System.out.println( "8. Book Appoinment" );
			String choice = read( "choice" );


			if( choice.equals( "0" ) ) break;

			else if( choice.equals( "1" ) ) {

				BankClient bankClient = new BankClient("test", "test");//todo ask user for username / password
				bankClients.add(bankClient);
				
				
				while( true ){

					System.out.println( "\n0. NO extra account" );
					System.out.println( "1. Extra account" );
					String choice2 = read( "choice" );
					
					if( choice2.equals( "0" ) ) break;

			
					//boolean verified = bankClient.askForVerification( bankClient.clientID, accountNumber, adminName ); //TODO: contact bank admin

					//bankClient.verify( accountNumber, verified );
					
				}
			}

			else if( choice.equals( "2" ) ) {

				//TODO


					System.out.println( "\n0. Exit" );
					System.out.println( "5. Change Bank Client Details" );
					System.out.println( "6. Delete Bank Account" );
					System.out.println( "7. Money transfer" );
					System.out.println( "8. Book Appoinment" );
					choice = read( "choice" );


					if( choice.equals( "5" ) ) {

						//TODO
					}

					else if( choice.equals( "6" ) ) {

						//TODO
					}

					else if( choice.equals( "7" ) ) {

						//TODO
					}

					else if( choice.equals( "8" ) ) {

						//boolean scheduled = bankClients.get( pos ).askForSchedulingAppointment( bankClients.get( pos ).clientID, appointmentDate, employeeName );

						//if( scheduled ) bankClients.get( pos ).bookAppointment( appointmentDate, employeeName );

						//else System.err.println( "The appointment has not been booked" );
					}
				//}
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

	public static void print( List<BankClient> bankClients ) {

		System.out.println( "Bank Clients:\n" );

		for( int i = 0; bankClients != null && i < bankClients.size(); ++i ) bankClients.get( i ).toPrint();
	}
}
