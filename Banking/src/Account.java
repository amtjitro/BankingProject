import java.util.ArrayList;

public class Account{
	
	String username;
	String password;
	Double balance;
	ArrayList accounts;
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password.toString();
		this.balance = 0.0;
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
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return this.balance;
	}
	
}
