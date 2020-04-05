package project.utilities;

import java.util.Date;

import project.actors.BankClient;

public class CandidateAppointment extends Appointment{
	public BankClient bankClient;
	public String bankEmployeeName;

	public CandidateAppointment(Date date, BankClient bankClient, String bankEmployeeName, boolean scheduled) {
		super(date, bankEmployeeName, scheduled);
		this.bankClient = bankClient;
	}

	public void toPrint() {
		super.toPrint();
		bankClient.toPrint();
	}
}
