package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> account = new LinkedList<Account>();
	
		//Read a CSV file then create new accounts based on that data
		
		String file = "D:\\Java Workspace\\JavaProjects\\src\\utilities\\NewBankAccounts.csv";
		
		List<String[]> newAccountHolder = utilities.CSV.read(file);
		for(String[] accountHolder : newAccountHolder)
		{
			String name = accountHolder[0];
			String SSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			
			if(accountType.equals("Savings")) {
				account.add(new Savings(name, SSN, initDeposit));

			}
			else if(accountType.equals("Current")) {
				account.add(new Checking(name, SSN, initDeposit));
			}
			else
				System.out.println("ERROR READING ACCOUNT TYPE");
		}
		

		for(Account acc : account) {
			System.out.println("\n*********************");
			acc.showInfo();
		}

	}

}
