package project.utilities;

import java.util.Date;

import project.actors.BankClient;

public class CandidateAppointment extends Appointment{
	public BankClient bankClient;


	public CandidateAppointment(Date date, BankClient bankClient) {
		super(date);
		this.bankClient = bankClient;
	}

	public void toPrint() {
		super.toPrint();
		bankClient.toPrint();
	}
}
