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


public class BankClient extends Person{

	public static final AtomicInteger clientCount = new AtomicInteger( 0 );
	public static final AtomicInteger accountCount = new AtomicInteger( 0 );

	//TODO create getters and setters for each of these
	private int clientID;
	private String name; 
	private String address;
	private Date birthDate;

	private String username;
	private String password;

	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
	
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
	
	//leave this
		public void deleteAccount( int accountNumber ) {

			int pos = 0;

			for( pos = 0; pos < accounts.size(); ++pos ) if( accounts.get( pos ).getAccountNumber() == accountNumber )break;

			if( pos >= 0 && pos < accounts.size() ) {
				accounts.remove(pos);
			}
		}
		
	//don't include this
	public void toPrint() {

		System.out.println( "clientID = " + clientID );
		if( name != null ) System.out.println( "name = " + name );
		if( address != null ) System.out.println( "address = " + address );
		if( address != null ) System.out.println( "birthDate = " + birthDate );

		for( int i = 0; accounts != null && i < accounts.size(); ++i ) System.out.println( "\taccountNumber: " + accounts.get(i).getAccountNumber() );
	}
		
		//dont include this
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

//	//TODO start of new Class start here
//	public boolean askForVerification( int clientID, int accountNumber, String adminName ){
//		//Assume we sent a message to bank admin
//		return true;
//	}
//
//	//comment this out as well 
//	public void verify( int accountNumber, boolean verified ){
//		for( int i = 0; i < accounts.size(); ++i ) if( accounts.get( i ).getAccountNumber() == accountNumber ) accounts.get(i).setVerified(verified);
//	}

	//TODO comment this out 
//	public void toPrintAccount( int accountNumber ) {
//
//		for( int i = 0; accounts != null && i < accounts.size(); ++i ) {
//
//			if( accounts.get( i ).getAccountNumber() == accountNumber ) {
//				BankAccount account = accounts.get(i);
//				System.out.println( "\taccountNumber: " + account.getAccountNumber() );
//				System.out.println( "\taccountType: " + account.toString() );
//				System.out.println( "\taccountVerified: " + account.getVerified());
//				System.out.println( "\taccountBalance: " + account.getBalance());
//			}
//		}
//	}
//
//	//TODO comment this out
//	public void printAccounts() {
//
//		for( int i = 0; accounts != null && i < accounts.size(); ++i ) {
//			BankAccount account = accounts.get(i);
//			System.out.println( "\taccountNumber: " + account.getAccountNumber() );
//			System.out.println( "\taccountType: " + account.toString() );
//			System.out.println( "\taccountVerified: " + account.getVerified() );
//			System.out.println( "\taccountBalance: " + account.getBalance() );
//		}
//	}

//	//TODO this is a class - comment it out
//	public void transfer( int fromAccountNumber, int toAccountNumber, double amount ) {
//
//		int from = 0;
//		BankAccount fromAccount = new BankAccount(), toAccount = new BankAccount();
//		
//		for( from = 0; from < accounts.size(); ++from ) {
//
//			if( accounts.get( from ).getAccountNumber() == fromAccountNumber  ) {
//				fromAccount = accounts.get(from);
//				System.out.println( "\tFrom accountNumber: " + fromAccount.getAccountNumber());
//				System.out.println( "\ttFrom accountType: " + fromAccount.toString());//TODO test this out
//				System.out.println( "\ttFrom accountVerified: " + fromAccount.getVerified() );
//				System.out.println( "\ttFrom accountBalance: " + fromAccount.getBalance() );		
//			}
//		}
//
//		int to = 0;
//
//		for( to = 0; to < accounts.size(); ++to ) {
//
//			if( accounts.get( to ).getAccountNumber() == toAccountNumber  ) {
//				toAccount = accounts.get(to);
//				
//				System.out.println( "\tFrom accountNumber: " + toAccount.getAccountNumber());
//				System.out.println( "\ttFrom accountType: " + toAccount.toString());//TODO test this out
//				System.out.println( "\ttFrom accountVerified: " + toAccount.getVerified() );
//				System.out.println( "\ttFrom accountBalance: " + toAccount.getBalance() );
//			}
//		}
//
//		//if( from >= 0 && from < accountNumbers.size() && to >= 0 && to < accountNumbers.size() && accountBalances.get( from ) >= amount ) {
//		if( from >= 0 && from < accounts.size() && to >= 0 && to < accounts.size() && fromAccount.getBalance() >= amount ) {
//			
//			fromAccount.setBalance(fromAccount.getBalance() - amount);
//
//			toAccount.setBalance(toAccount.getBalance() - amount);
//			
//			System.out.println( "Transfer is completed" );
//		}
//
//		else System.out.println( "Transfer cannot be made" );
//	}

//	//TODO the next two are for appointments - comment this
//	public boolean askForSchedulingAppointment( int clientID, Date date, String employeeName ){
//
//		if( date == null || employeeName == null ) {
//
//			System.err.println( "Error schedule appointment transaction" );
//
//			return false;
//		}
//
//		else {
//
//			//Assume we sent a message to bank employee
//
//			return true;
//		}
//	}
//
//	//comment this
//	public void bookAppointment( Date date, String  employeeName ){
//
//		if( date == null || employeeName == null ) System.err.println( "Error book appointment transaction" );
//
//		else {
//			appointments.add(new Appointment(employeeName, date));
//		}
//	}

	//getters and setters
	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<BankAccount> accounts) {
		this.accounts = accounts;
	}
	
	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}
	
}
