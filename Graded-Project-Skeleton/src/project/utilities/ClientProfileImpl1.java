package project.utilities;

import java.util.Date;

public class ClientProfileImpl1 extends ClientProfile{
	
	public ClientProfileImpl1(int clientID, String name, String address, Date birthDate) {	
		super(name, address, birthDate, clientID);
	}
		
	public void toPrint() {
		if(super.getName() != null || super.getAddress() != null || super.getAddress() != null) {
			System.out.println( "Client ID: " + super.getClientID() + 
					"\nName: " + super.getName() + 
					"\nAddress: " + super.getAddress() + 
					"\nBirth Date: " + super.getBirthDate());
		}
	}
}
