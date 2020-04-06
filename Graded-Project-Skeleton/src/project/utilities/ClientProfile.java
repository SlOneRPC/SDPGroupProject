package project.utilities;

import java.util.Date;

public abstract class ClientProfile {

	private String name;
	private String address;
	private Date birthDate;
	private int clientID;
	
	
	public abstract void toPrint();
	
	public ClientProfile(String name, String address, Date birthDate, int clientID) {
		boolean initialised = securityManagerCheck(birthDate);
		if(initialised) init(name, address, birthDate, clientID);
		else throw new SecurityException("Birthdate is not correctly initialised");			
	}
	
	private void init(String name, String address, Date birthDate, int clientID) {
		this.setAddress(address);
		this.name = name;
		this.setBirthDate(birthDate);
		this.clientID = clientID;
	}
	
	private boolean securityManagerCheck(Date dateToValidate) {		
		Date date = new Date();//current date
		if(dateToValidate.compareTo(date) < 0) {
			return true;
		}
		return false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		if(birthDate.compareTo(new Date()) < 0) {
			this.birthDate = birthDate;
		}
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
}
