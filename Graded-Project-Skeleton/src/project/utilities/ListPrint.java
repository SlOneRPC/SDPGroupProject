package project.utilities;

import java.util.List;

import project.actors.BankClient;

public class ListPrint {
	
	public static void print(List<BankClient> bankClients) {

		for(int i = 0; bankClients != null && i < bankClients.size(); i++) {
			bankClients.get(i).toPrint();
		}
	}
}
