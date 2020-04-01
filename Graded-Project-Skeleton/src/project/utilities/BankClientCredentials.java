package project.utilities;

public class BankClientCredentials {
	
	private String username;
	private String password;
	
	public BankClientCredentials(String username,String password) {
		if(validateUsername(username)) {
			this.username = username;
		}
		if(validatePassword(password)) {
			this.password = password;
		}
	}
	
	private boolean validateUsername(String username) {
		if(!username.startsWith("$")) {
			return true;
		}
		return false;
	}
	
	private boolean validatePassword(String password) {
		if(!password.endsWith(".")) {
			return true;
		}
		return false;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
