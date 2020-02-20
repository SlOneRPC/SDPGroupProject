package project.actors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import project.utilities.*;


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

	public List<BankAccount> accounts = new ArrayList<BankAccount>();
	public List<Appointment> appointments1 = new ArrayList<Appointment>();
	
	
	public BankClient( String username, String password ){
//String username, String password
		
		
		this.username = username;
		this.password = password;
//
//		if( username == null || username == null ) System.err.println( "Error register transaction" );
//
//
//		this.clientID = clientCount.incrementAndGet();
	}

	public void createProfile( String name, String address, Date birthDate ){

		if( name == null || address == null || birthDate == null ) System.err.println( "Error create profile transaction" );

		else {

			this.name = name;
			this.address = address;
			this.birthDate = birthDate;
		}
	}

	public int addAccount( String accountType ){

		if( accountType == null || (accountType != null && ! accountType.equals( "primary" ) && ! accountType.equals( "savings" ) ) ) {

			System.err.println( "Error create account transaction" );

			return -1;
		}

		else {

//			if( accountNumbers == null ) accountNumbers = new ArrayList<Integer>();
//			if( accountTypes == null ) accountTypes = new ArrayList<String>();
//			if( accountVerified == null ) accountVerified = new ArrayList<Boolean>();
//			if( accountBalances == null ) accountBalances = new ArrayList<Double>();
//
//			accountNumbers.add( accountCount.incrementAndGet() );
//			accountTypes.add( accountType );
//			accountVerified.add( false );
//			accountBalances.add( 0.0 );				
			if(accountType.equals("primary")) {
				accounts.add(new PrimaryBankAccount(accountCount.incrementAndGet(), false, 0.0));
			}else if(accountType.equals("savings")){
				accounts.add(new SavingsBankAccount(accountCount.incrementAndGet(), false, 0.0));
			}		
			return accountCount.get();
		}
	}

	public boolean askForVerification( int clientID, int accountNumber, String adminName ){
		//TODO should this be placed inside CreateAccountTransaction
		//Assume we sent a message to bank admin

		return true;
	}

	public void verify( int accountNumber, boolean verified ){

		//TODO maybe delete this/change into "addAccount"?
		for( int i = 0; i < accountNumbers.size(); ++i ) if( accountNumbers.get( i ) == accountNumber ) accountVerified.set( i , verified );
	}

	public void changeClientDetails( String name, String address, Date birthDate, String username, String password ){

		if( name == null || address == null || birthDate == null || username == null || password == null ) System.err.println( "Error change details transaction" );

		else {

			this.name = name;
			this.address = address;
			this.birthDate = birthDate;
			this.username = username;
			this.password = password;
		}
	}

	public void toPrint() {

		System.out.println( "clientID = " + clientID );
		if( name != null ) System.out.println( "name = " + name );
		if( address != null ) System.out.println( "address = " + address );
		if( address != null ) System.out.println( "birthDate = " + birthDate );

		for( int i = 0; accountNumbers != null && i < accountNumbers.size(); ++i ) System.out.println( "\taccountNumber: " + accountNumbers.get( i ) );
	}

	public void toPrintAccount( int accountNumber ) {

		for( int i = 0; accountNumbers != null && i < accountNumbers.size(); ++i ) {

			if( accountNumbers.get( i ) == accountNumber ) {

				System.out.println( "\taccountNumber: " + accountNumbers.get( i ) );
				System.out.println( "\taccountType: " + accountTypes.get( i ) );
				System.out.println( "\taccountVerified: " + accountVerified.get( i ) );
				System.out.println( "\taccountBalance: " + accountBalances.get( i ) );
			}
		}
	}

	public void printAccounts() {

		for( int i = 0; accountNumbers != null && i < accountNumbers.size(); ++i ) {

			System.out.println( "\taccountNumber: " + accountNumbers.get( i ) );
			System.out.println( "\taccountType: " + accountTypes.get( i ) );
			System.out.println( "\taccountVerified: " + accountVerified.get( i ) );
			System.out.println( "\taccountBalance: " + accountBalances.get( i ) );
		}
	}

	public void deleteAccount( int accountNumber ) {

		int pos = 0;

		for( pos = 0; pos < accountNumbers.size(); ++pos ) if( accountNumbers.get( pos ) == accountNumber ) break;

		if( pos >= 0 && pos < accountNumbers.size() ) {

			accountNumbers.remove( pos );
			accountTypes.remove( pos );
			accountVerified.remove( pos );
			accountBalances.remove( pos );
		}
	}

	public void transfer( int fromAccountNumber, int toAccountNumber, double amount ) {

		int from = 0;

		for( from = 0; from < accountNumbers.size(); ++from ) {

			if( accountNumbers.get( from ) == fromAccountNumber  ) {

				System.out.println( "\tFrom accountNumber: " + accountNumbers.get( from ) );
				System.out.println( "\ttFrom accountType: " + accountTypes.get( from ) );
				System.out.println( "\ttFrom accountVerified: " + accountVerified.get( from ) );
				System.out.println( "\ttFrom accountBalance: " + accountBalances.get( from ) );
			}
		}

		int to = 0;

		for( to = 0; to < accountNumbers.size(); ++to ) {

			if( accountNumbers.get( to ) == toAccountNumber  ) {

				System.out.println( "\tTo accountNumber: " + accountNumbers.get( to ) );
				System.out.println( "\tTo accountType: " + accountTypes.get( to ) );
				System.out.println( "\tTo accountVerified: " + accountVerified.get( to ) );
				System.out.println( "\tTo accountBalance: " + accountBalances.get( to ) );
			}
		}

		if( from >= 0 && from < accountNumbers.size() && to >= 0 && to < accountNumbers.size() && accountBalances.get( from ) >= amount ) {

			accountBalances.set( from, accountBalances.get( from ) - amount );

			accountBalances.set( to, accountBalances.get( to ) + amount );

			System.out.println( "Transfer is completed" );
		}

		else System.out.println( "Transfer cannot be made" );
	}

	public boolean askForSchedulingAppointment( int clientID, Date date, String employeeName ){

		if( date == null || employeeName == null ) {

			System.err.println( "Error schedule appointment transaction" );

			return false;
		}

		else {

			//Assume we sent a message to bank employee

			return true;
		}
	}

	public void bookAppointment( Date date, String  employeeName ){

		if( date == null || employeeName == null ) System.err.println( "Error book appointment transaction" );

		else {

			if( appointments == null ) appointments = new ArrayList<Date>();

			appointments.add( date );


			if( bankEmployeesWithAppointments == null ) bankEmployeesWithAppointments = new ArrayList<String>();

			bankEmployeesWithAppointments.add( employeeName );
		}
	}
}
