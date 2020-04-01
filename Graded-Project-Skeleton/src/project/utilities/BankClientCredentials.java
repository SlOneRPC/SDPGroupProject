package project.utilities;

public class BankClientCredentials {
	
	private String username;
	private String password;
	
	public BankClientCredentials(String username,String password) {

		boolean initialized = securityManagerCheck(username,password);
		if(initialized) init(username,password);
		else throw new SecurityException("Bank credentials is not correctly initialised");
	}
	
	private boolean securityManagerCheck(String username,String password)
	{
		if(!username.startsWith("$")) {
			if(!password.endsWith(".")) {
				return true;
			}
		}
		return false;
	}
	
	private void init(String username,String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
