package bankaccountapp;

public abstract class Account implements IBaseRate{
	//List properties specific for savings and checking account
	private String name;
	private String SSN;
	private double balance;
	protected String accountNumber;
	protected double rate;
	
	static int number = 10000;
	
	//Constructor to set base properties and initialize the account
	public Account(String name, String SSN, double initDeposit)
	{
		this.name = name;
		this.SSN = SSN;
		this.balance = initDeposit;
		
		number++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
	public abstract void setRate();
		
	//List common methods
	private String setAccountNumber()
	{
		String lastTwoOfSSN = SSN.substring(SSN.length()-2, SSN.length());
		int uniqueID = number;
		int randomNUmber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNUmber;
	}
	
	public void deposit(double amount) 
	{
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	public void withdraw(double amount)
	{
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}

	public void transfer(String toWhere, double amount)
	{
		balance = balance - amount;
		System.out.println("Transferring $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void printBalance() 
	{
		System.out.println("Your balance is now $" + balance);
	}
	
	public void compound()
	{
		double accuredInterest = balance * (rate/100);
		balance = balance + accuredInterest;
		System.out.println("Accured Interest: $" + accuredInterest);
		printBalance();
	} 
	
	public void showInfo()
	{
		System.out.println("NAME: " + name +
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nBALANCE: " + balance + 
				"\nRATE: " + rate + "%");
	}

}
