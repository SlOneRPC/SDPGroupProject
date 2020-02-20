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

//	public List<Integer> accountNumbers;
//	public List<String> accountTypes;
//	public List<Boolean> accountVerified;
//	public List<Double> accountBalances;

//	public List<Date> appointments;
//	public List<String> bankEmployeesWithAppointments;

	public ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	public ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
	
	public BankClient( String username, String password ){
	
		this.username = username;
		this.password = password;
		this.clientID = clientCount.incrementAndGet();

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
			
			if(accountType.equals("primary")) {
				accounts.add(new PrimaryBankAccount(accountCount.incrementAndGet(), false, 0.0));
			}else if(accountType.equals("savings")){
				accounts.add(new SavingsBankAccount(accountCount.incrementAndGet(), false, 0.0));
			}		
			return accountCount.get();
		}
	}

	public boolean askForVerification( int clientID, int accountNumber, String adminName ){
		//Assume we sent a message to bank admin
		return true;
	}

	public void verify( int accountNumber, boolean verified ){
	
		for( int i = 0; i < accounts.size(); ++i ) if( accounts.get( i ).getAccountNumber() == accountNumber ) accounts.get(i).setVerified(verified);
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

		for( int i = 0; accounts != null && i < accounts.size(); ++i ) System.out.println( "\taccountNumber: " + accounts.get(i).getAccountNumber() );
	}

	public void toPrintAccount( int accountNumber ) {

		for( int i = 0; accounts != null && i < accounts.size(); ++i ) {

			if( accounts.get( i ).getAccountNumber() == accountNumber ) {

				BankAccount account = accounts.get(i);
				System.out.println( "\taccountNumber: " + account.getAccountNumber() );
				System.out.println( "\taccountType: " + account.toString() );
				System.out.println( "\taccountVerified: " + account.getVerified());
				System.out.println( "\taccountBalance: " + account.getBalance());
			}
		}
	}

	public void printAccounts() {

		for( int i = 0; accounts != null && i < accounts.size(); ++i ) {
			BankAccount account = accounts.get(i);
			System.out.println( "\taccountNumber: " + account.getAccountNumber() );
			System.out.println( "\taccountType: " + account.toString() );
			System.out.println( "\taccountVerified: " + account.getVerified() );
			System.out.println( "\taccountBalance: " + account.getBalance() );
		}
	}

	public void deleteAccount( int accountNumber ) {

		int pos = 0;

		for( pos = 0; pos < accounts.size(); ++pos ) if( accounts.get( pos ).getAccountNumber() == accountNumber )break;

		if( pos >= 0 && pos < accounts.size() ) {
			accounts.remove(pos);
		}
	}

	public void transfer( int fromAccountNumber, int toAccountNumber, double amount ) {

		int from = 0;
		BankAccount fromAccount = new BankAccount(), toAccount = new BankAccount();
		
		for( from = 0; from < accounts.size(); ++from ) {

			if( accounts.get( from ).getAccountNumber() == fromAccountNumber  ) {
				fromAccount = accounts.get(from);
//				System.out.println( "\tFrom accountNumber: " + accountNumbers.get( from ) );
//				System.out.println( "\ttFrom accountType: " + accountTypes.get( from ) );
//				System.out.println( "\ttFrom accountVerified: " + accountVerified.get( from ) );
//				System.out.println( "\ttFrom accountBalance: " + accountBalances.get( from ) );
				
				System.out.println( "\tFrom accountNumber: " + fromAccount.getAccountNumber());
				System.out.println( "\ttFrom accountType: " + fromAccount.toString());//TODO test this out
				System.out.println( "\ttFrom accountVerified: " + fromAccount.getVerified() );
				System.out.println( "\ttFrom accountBalance: " + fromAccount.getBalance() );		
			}
		}

		int to = 0;

		for( to = 0; to < accounts.size(); ++to ) {

			if( accounts.get( to ).getAccountNumber() == toAccountNumber  ) {
				toAccount = accounts.get(to);
//				System.out.println( "\tTo accountNumber: " + accountNumbers.get( to ) );
//				System.out.println( "\tTo accountType: " + accountTypes.get( to ) );
//				System.out.println( "\tTo accountVerified: " + accountVerified.get( to ) );
//				System.out.println( "\tTo accountBalance: " + accountBalances.get( to ) );
				
				System.out.println( "\tFrom accountNumber: " + toAccount.getAccountNumber());
				System.out.println( "\ttFrom accountType: " + toAccount.toString());//TODO test this out
				System.out.println( "\ttFrom accountVerified: " + toAccount.getVerified() );
				System.out.println( "\ttFrom accountBalance: " + toAccount.getBalance() );
			}
		}

		//if( from >= 0 && from < accountNumbers.size() && to >= 0 && to < accountNumbers.size() && accountBalances.get( from ) >= amount ) {
		if( from >= 0 && from < accounts.size() && to >= 0 && to < accounts.size() && fromAccount.getBalance() >= amount ) {
			
			//accountBalances.set( from, accountBalances.get( from ) - amount );
			fromAccount.setBalance(fromAccount.getBalance() - amount);

			//accountBalances.set( to, accountBalances.get( to ) + amount );
			toAccount.setBalance(toAccount.getBalance() - amount);
			
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
			appointments.add(new Appointment(employeeName, date));
//			if( appointments == null ) appointments = new ArrayList<Date>();
//
//			appointments.add( date );
//
//			
//			if( bankEmployeesWithAppointments == null ) bankEmployeesWithAppointments = new ArrayList<String>();
//
//			bankEmployeesWithAppointments.add( employeeName );
		}
	}
}
