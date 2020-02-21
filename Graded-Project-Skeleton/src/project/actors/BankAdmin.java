package project.actors;

import java.util.List;

public class BankAdmin extends User{

	public String name = "Y";

	public List<BankClient> bankClientsToVerify;
	public List<Integer> accountNumbersToVerify;
	
	public BankAdmin() {}
	
}
