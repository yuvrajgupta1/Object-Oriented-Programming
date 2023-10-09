public class Account implements Comparable<Account> {
	
	private int accountNumber;
	private String name;
	private double balance;
	
	// parametrized constructor
	public Account( int accountNumber, String name, double balance ) {
		
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	
	//accessor methods
	public int getAccountNumber() {
		
		return accountNumber;	// returns the account number
	}
	
	public String getName() {
		
		return name;			// returns the account holder name
	}
	
	public double getBalance() { 
		
		return balance;			// returns the account balance
	}
	
	// modification methods
	public void setAccountNumber( int number ) {
		
		accountNumber = number;	// sets new value of account number
	}	
	
	public void setName( String name ) {
		
		this.name = name;		// sets new value of account holder name
	}
	
	public void setBalance( double balance ) {
		
		this.balance = balance;	// sets new value of account balance
	}
	
	// checks if 2 accounts are equal
	public boolean equals( Account other ) {
		
		// checks if the other account in null
		if ( other == null ) {
			return false;
		}
		
		// compares the attributes of the account
		return this.accountNumber == other.accountNumber
					&& this. balance == balance
							&& this.name.equals( other.name );
	}
	
	//compares 2 account numbers
	public int compareTo( Account other ) {
		
		// checks if account number is equal
		if ( this.getAccountNumber() == other.getAccountNumber() ) {
			return 0;
			
		// checks if account number is greater than the other
		} else if ( this.getAccountNumber() > other.getAccountNumber() ) {
			return 1;
			
		// if all conditions are false then it returns -1
		} else {
			return -1;
		}
	}
	
	// returns information of Account
	public String toString() { 
		
		return "Accout number: " + getAccountNumber() + ", Name: " + getName() + ", Balance: " + getBalance();
	}
}