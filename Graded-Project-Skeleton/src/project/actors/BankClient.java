package project.actors;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import project.utilities.*;


public class BankClient extends User{

	private static final AtomicInteger clientCount = new AtomicInteger(0);
	private static final AtomicInteger accountCount = new AtomicInteger(0);

	private ClientProfile clientProfile;
	
	private BankClientCredentials clientCredentials;

	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
	
	public BankClient(String username, String password){
		clientCredentials = new BankClientCredentials(username,password);
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
				accounts.add(new PrimaryBankAccount(accountCount.incrementAndGet(), false, 100.0));
			} else if(accountType.equals("savings")) {
				accounts.add(new SavingsBankAccount(accountCount.incrementAndGet(), false, 100.0));
			}		
			return accountCount.get();
		}
	}
		
	public void toPrint() {
		printAllDetails();
		ListPrint.printAllAccounts(this.accounts);
		ListPrint.printAllAppointments(this.appointments);
	}
		
	public void printAllDetails() {
		String output = "ClientID = " + this.clientProfile.getClientID() + "\nName = " + this.clientProfile.getName() +
				"\nUsername = " + this.getUsername() + "\nPassword = " + this.getPassword() + "\nAddress = " + this.clientProfile.getAddress()
				+ "\nBirthdate = " + this.clientProfile.getBirthDate();
		System.out.println(output);
	}
	
	public void printDetailsForAppointment() {
		String output = "ClientID = " + this.clientProfile.getClientID() + "\nName = " + this.clientProfile.getName() +
				"\nUsername = " + this.getUsername() + "\nPassword = " + this.getPassword();
		System.out.println(output);
				
	}
	
	public void changeClientDetails( String name, String address, Date birthDate, String username, String password ){

		if( name == null || address == null || birthDate == null || username == null || password == null ) System.err.println( "Error change details transaction" );

		else {
			clientProfile.setName(name);
			clientProfile.setAddress(address);
	        clientProfile.setBirthDate(birthDate);
			
	        clientCredentials = new BankClientCredentials(username,password);
		}
	}
	
	//Getters & Setters
	
	public String getUsername() {
		return clientCredentials.getUsername();
	}

	public String getPassword() {
		return clientCredentials.getPassword();
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
