package project.utilities;

import java.util.Date;

public class ClientProfileImpl1 implements ClientProfile{

	private int clientID;
	private String name; 
	private String address;
	private Date birthDate;
	
	public ClientProfileImpl1(int clientID, String name, String address, Date birthDate) {
		this.clientID = clientID;
		this.name= name;
		this.address = address;
		this.birthDate = birthDate;
	}
	
	public void toPrint() {
		System.out.println( "clientID = " + clientID );
		if( name != null ) System.out.println( "name = " + name );
		if( address != null ) System.out.println( "address = " + address );
		if( birthDate != null ) System.out.println( "birthDate = " + birthDate);
	}
	
}
