package project.actors;

import java.util.List;

public class BankAdmin extends Person{

	public String name = "Y";

	public List<BankClient> bankClientsToVerify;
	public List<Integer> accountNumbersToVerify;
	
	public BankAdmin() {}
	
	public void toPrint() {}
}
