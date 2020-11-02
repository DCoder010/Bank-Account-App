package bankaccountapp;

public class Checking extends Account{
	//List properties specific for Checking account
	private int debitCardNumber;
	private int debitCardPIN;
	
	//Constructor to initialize checking account properties
	public Checking(String name,String SSN, double initDeposit)
	{
		super(name,SSN,initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() * 0.15;
	}
	
	//List any methods specific to the checking account
	private void setDebitCard()
	{
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo()
	{
		super.showInfo();
		System.out.println(" Your Savings Account Features " + 
							"\n Debit Card Number: " + debitCardNumber + 
							"\n Debit Card PIN: " + debitCardPIN);
	}

}
