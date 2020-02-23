package project.actors;

import java.util.List;

public class BankAdmin extends User {

	public List<BankClient> bankClientsToVerify;
	public List<Integer> accountNumbersToVerify;
	
	public BankAdmin(String name) {
		super.name = name;
	}
	
}
