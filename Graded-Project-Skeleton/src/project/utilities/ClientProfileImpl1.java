package project.utilities;

import java.util.Date;

public class ClientProfileImpl1 extends ClientProfile{
	int clientID; 
	String name, address;
	Date birthDate;
	
	public ClientProfileImpl1(int clientID, String name, String address, Date birthDate) {
		super(name, address, birthDate, clientID);
		this.clientID = clientID;
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
	}
	
	public void toPrint() {
		if(name != null || address != null || birthDate != null) {
			System.out.println( "client id = " + clientID);
			System.out.println( "name = " + name);
			System.out.println( "address = " + address);
			System.out.println( "birthDate = " + birthDate);
		}
	}
}
