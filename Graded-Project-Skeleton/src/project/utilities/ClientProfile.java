package project.utilities;

import java.util.Date;

public abstract class ClientProfile {

	private String name;
	private String address;
	private Date birthDate;
	private int clientID;
	
	
	public abstract void toPrint();
	
	public ClientProfile(String name, String address, Date birthDate, int clientID) {
		this.setAddress(address);
		this.name = name;
		this.setBirthDate(birthDate);
		this.clientID = clientID;
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
		this.birthDate = birthDate;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
}
