package project.transaction;

import java.util.List;

import project.actors.BankClient;

public interface RegisterTransaction {

	public void registerBankClient(List<BankClient> bankClients);
}
