
public class Account {
	
	String username;
	String password;
	Double balance;
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password.toString();
	}

	
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
}
