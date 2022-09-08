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
	
	private boolean sufficientFunds(Double requested) {
		if (this.balance < requested) {
			System.out.println("Insufficient funds. Current Balance: $" + getBalance() + ". Requested Balance: $" + requested);
			return false;
		}
		return true;
	}
	
	public Double withdraw(Double amount) {
		
		//can't withdraw negative amount
		if (amount < 0) {
			System.out.println("Cannot withdraw negative amount.");
			return this.balance;
		}
		
		if (sufficientFunds(amount)) {
			this.balance -= amount;
			System.out.println("Successful withdrawal. Account Balance is: $" + getBalance());
		}
		return this.balance;

	}
	
	public Double deposit(Double amount) {
		
		//can't withdraw negative amount
		if (amount < 0) {
			System.out.println("Cannot deposit negative amount.");
			return this.balance;
		}
		
		this.balance+= amount;
		System.out.println("Successful deposit. Account Balance is: $" + getBalance());
		return this.balance;
	}
	
}
