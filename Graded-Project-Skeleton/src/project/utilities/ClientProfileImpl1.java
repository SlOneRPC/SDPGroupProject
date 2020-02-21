package project.utilities;

import java.util.Date;

public class ClientProfileImpl1 extends ClientProfile{

	public ClientProfileImpl1(int clientID, String name, String address, Date birthDate) {
		super(name, address, birthDate, clientID);
	}
	
	public void toPrint() {
		System.out.println( "clientID = " + super.getClientID() );
		if( super.getName() != null ) System.out.println( "name = " + super.getName() );
		if( super.getAddress() != null ) System.out.println( "address = " + super.getAddress() );
		if( super.getBirthDate() != null ) System.out.println( "birthDate = " + super.getBirthDate());
	}
}
