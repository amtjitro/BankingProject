
public interface Accnt {
	
	Double balance = 0.0;

	public void setBalance(Double balance);

	public Double getBalance();
	
	public boolean sufficientFunds(Double requested);
	
	public Double withdraw(Double amount);
	
	public Double deposit(Double amount);

	public boolean transferFunds(Double transferAmount, Accnt accnt);
	
}
