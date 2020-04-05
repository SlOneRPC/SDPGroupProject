package project.utilities;

import java.util.Date;
import java.util.List;

import project.actors.BankClient;

public class ListPrint {
	
	public static void print(List<BankClient> bankClients) {

		for(int i = 0; bankClients != null && i < bankClients.size(); i++) {
			bankClients.get(i).toPrint();
		}
	}
	
	public static void printBankClientsAccountsToVerify(List<BankClient> bankClients, List<Integer> accountNumbersToVerify) {
		for(int i = 0; accountNumbersToVerify != null && i < accountNumbersToVerify.size(); i++) {
			BankClient client = findClientWithAccountNumber(bankClients, accountNumbersToVerify.get(i));
			BankAccount account = getAccount(client, accountNumbersToVerify.get(i));
			String accountType = getAccountType(account);
			System.out.println("Account number = " + account.getAccountNumber() + ", account type = " + accountType);
			client.printAllDetails();
		}
	}
	
	public static void printBankClientsWithAppointmentsToBook(List<BankClient> bankClientsWithAppointments, List<Date> appointmentDates) {
		for(int i = 0; bankClientsWithAppointments != null && i < bankClientsWithAppointments.size(); i++) {
			System.out.println("Appointment date: " + appointmentDates.get(i));
			bankClientsWithAppointments.get(i).printDetailsForAppointment();
		}
	}
	
	public static void printAllAccounts(List<BankAccount> accounts) {
		for(BankAccount account : accounts) {
			printAccount(account);
		}
	}
	
	public static void printAccount(BankAccount account){
		String type = getAccountType(account);
		System.out.println("Account type: " + type + "\n\naccount number = " + account.getAccountNumber() + ", account verified = " + account.getVerified() + 
				", account balance = " + account.getBalance()); 
	}
	
	public static void printAllAppointments(List<Appointment> appointments) {
		for(Appointment appointment : appointments) {
			String output = "Appointment date: " + appointment.appointmentDate.toString() + "\nbankEmployee: " + appointment.interviewerName 
					+ ", scheduled = " + appointment.scheduled;
			System.out.println(output);
		}
	}
	
	private static BankClient findClientWithAccountNumber(List<BankClient> bankClients, int target) {
		for(BankClient client : bankClients) {
			for(BankAccount account : client.getAccounts()) {
				if(account.getAccountNumber() == target) {
					return client;
				}
			}
		}
		return null;
	}	
	
	private static String getAccountType(BankAccount account) {
		String type = account.getClass().getSimpleName();
		if(type.equals("PrimaryBankAccount")) {
			return "Primary";
		}else if(type.equals("SavingsBankAccount")) {
			return "Savings";
		}
		return null;
	}
	
	private static BankAccount getAccount(BankClient client, int accountNumber) {
		for(BankAccount account : client.getAccounts()) {
			if(account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}
}
