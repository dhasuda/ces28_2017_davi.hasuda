package Depois;

public abstract class BankAccount {
	public double Balance() {return _balance;};
	public void Deposit(double amount) {};
	public void Withdraw(double amount) {};
	
	private double _balance;
}
