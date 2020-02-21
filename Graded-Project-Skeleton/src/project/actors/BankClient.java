package project.actors;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import project.utilities.*;


public class BankClient extends User{

	public static final AtomicInteger clientCount = new AtomicInteger(0);
	public static final AtomicInteger accountCount = new AtomicInteger(0);

	private ClientProfile clientProfile;
	
	private String username;
	private String password;

	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
	
	public BankClient(String username, String password){
	
		this.username = username;
		this.password = password;

	}

	public void createProfile(String name, String address, Date birthDate){

		if( name == null || address == null || birthDate == null ) System.err.println( "Error create profile transaction" );
		else {
			clientProfile = new ClientProfileImpl1(clientCount.incrementAndGet(), name, address, birthDate);
		}
	}

	public int addAccount(String accountType){
		if( accountType == null || (accountType != null && ! accountType.equals( "primary" ) && ! accountType.equals( "savings" ) ) ) {
			System.err.println( "Error create account transaction" );
			return -1;
		}

		else {		
			if(accountType.equals("primary")) {
				accounts.add(new PrimaryBankAccount(accountCount.incrementAndGet(), false, 0.0));
			} else if(accountType.equals("savings")) {
				accounts.add(new SavingsBankAccount(accountCount.incrementAndGet(), false, 0.0));
			}		
			return accountCount.get();
		}
	}
	
	public void deleteAccount( int accountNumber ) {
		int pos = 0;

		for( pos = 0; pos < accounts.size(); ++pos ) {
			if( accounts.get( pos ).getAccountNumber() == accountNumber ) {
				break;
			}
		}
		
		if( pos >= 0 && pos < accounts.size() ) {
			accounts.remove(pos);
		}
	}
		
	public void toPrint() {
		clientProfile.toPrint();
		for( int i = 0; accounts != null && i < accounts.size(); i++ ) {
			System.out.println( "\tAccount Number: " + accounts.get(i).getAccountNumber() );
		}
	}
		
	public void changeClientDetails( String name, String address, Date birthDate, String username, String password ){

		if( name == null || address == null || birthDate == null || username == null || password == null ) System.err.println( "Error change details transaction" );

		else {
			//this.name = name;
			this.clientProfile.setName(name);
					
			//this.address = address;
			this.clientProfile.setAddress(address);
			
			//this.birthDate = birthDate;
			this.clientProfile.setBirthDate(birthDate);
			
			this.username = username;
			this.password = password;
		}
	}
	
	//Getters & Setters (Encapsulation) - TODO Check if needed
	
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
	
	public void setClientProfile(ClientProfile clientProfile) {
		this.clientProfile = clientProfile;
	}
	
	public ClientProfile getClientProfile() {
		return this.clientProfile;
	}
	
}
