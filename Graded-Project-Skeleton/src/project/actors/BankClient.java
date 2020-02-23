package project.actors;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import project.utilities.*;


public class BankClient extends User{

	private static final AtomicInteger clientCount = new AtomicInteger(0);
	private static final AtomicInteger accountCount = new AtomicInteger(0);

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
				accounts.add(new PrimaryBankAccount(accountCount.incrementAndGet(), false, 10.0));
			} else if(accountType.equals("savings")) {
				accounts.add(new SavingsBankAccount(accountCount.incrementAndGet(), false, 10.0));
			}		
			return accountCount.get();
		}
	}
		
	public void toPrint() {
		clientProfile.toPrint();
		for( int i = 0; accounts != null && i < accounts.size(); i++ ) {
			System.out.println( "   Account Number: " + accounts.get(i).getAccountNumber() );
		}
	}
		
	public void changeClientDetails( String name, String address, Date birthDate, String username, String password ){

		if( name == null || address == null || birthDate == null || username == null || password == null ) System.err.println( "Error change details transaction" );

		else {
			clientProfile.setName(name);
			clientProfile.setAddress(address);
	        clientProfile.setBirthDate(birthDate);
			
			this.username = username;
			this.password = password;
		}
	}
	
	//Getters & Setters
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public ArrayList<BankAccount> getAccounts() {
		return accounts;
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
