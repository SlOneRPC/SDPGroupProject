package project.actors;

import java.util.ArrayList;

public class BankClientDictionarySingleton {

	
	private static BankClientDictionarySingleton theInstance;
	private ArrayList<BankClient> allBankClients = new ArrayList<BankClient>();
	
	public static BankClientDictionarySingleton getInstance() {
		if(theInstance == null) theInstance = new BankClientDictionarySingleton();
		return theInstance;
	}
		
	public void addBankClient( BankClient bankClient ) {
		if(bankClient != null) {
			allBankClients.add(bankClient);
		}
	}
	
    public void printBankClients() {
    	for(BankClient bankClient : allBankClients) {
    		bankClient.toPrint();
    	}
    }
    
    public int searchBankClient( String username, String password ) {      	
    	for (int i = 0; i < allBankClients.size(); i++) {
    		BankClient client = allBankClients.get(i);
    		if(client.getUsername().compareTo(username) == 0 && client.getPassword().compareTo(password)==0) {
    			return i;
    		}
    	}
    	return -1;   
    }
    
    public int size() {
    	return allBankClients.size();
    }
    
    public BankClient get( int pos ) {
    	if(pos <= allBankClients.size() && pos > 0) {
    		return allBankClients.get(pos);
    	}
    	return null;
    }
}
