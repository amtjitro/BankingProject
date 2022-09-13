
public class MoneyMarket implements Accnt{

	Double balance;
	
	public MoneyMarket () {
		this.balance = 0.0;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getBalance() {
		return this.balance;
	}
	
	public boolean sufficientFunds(Double requested) {
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
			System.out.println("Successful withdrawal. Checkings Account Balance is: $" + getBalance());
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
		System.out.println("Successful deposit. Checkings Account Balance is: $" + getBalance());
		return this.balance;
	}
	
	public boolean transferFunds(Double transferAmount, Accnt accnt) {
		return false;
	}
	
}
