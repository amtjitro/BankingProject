import java.util.ArrayList;
import java.util.LinkedList;

public class Savings implements Accnt{
	
	String username;
	String password;
	Double balance;
	//LinkedList<Accnt> accounts = new LinkedList<Accnt>();
	ArrayList<Accnt> accounts = new ArrayList<Accnt>();

	public Savings(String username, String password) {
		this.username = username;
		this.password = password.toString();
		this.balance = 0.0;
		this.accounts.add(new Checkings());
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
	
	public boolean sufficientFunds(Double requested) {
		if (this.balance < requested) {
			System.out.println("Insufficient funds. Current Savings Balance: $" + getBalance() + ". Requested Balance: $" + requested);
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
			System.out.println("Successful withdrawal. Savings account Balance is: $" + getBalance());
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
		System.out.println("Successful deposit. Savings account Balance is: $" + getBalance());
		return this.balance;
	}
	
	public void OpenMM() {
		MoneyMarket newAcc = new MoneyMarket();
		accounts.add(newAcc);
	}
	
	public boolean transferFunds(Double amount, Accnt to) {
		if (sufficientFunds(amount)) {
			this.balance-= amount;
			to.setBalance(to.getBalance()+amount);
		}
		return false;
	}
	

}
