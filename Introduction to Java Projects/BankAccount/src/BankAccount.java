//*********************************************************************************************
// BankAccount.java
// Author: Kristin Ottofy
// Last Editied: 04/01/2009
// A bank account class with methods to deposit to, withdraw from,
// change the name on, get balance, get account owner, get account number
// and toString.
//*********************************************************************************************
public class BankAccount {

    // Declare the instance variables
    private String ownerName;
    private long accountNumber;
    private double balance;
    //-----------------------------------------------------------------------------------------
    //Constructor -
    //It takes three parameters: ownerName, acctNumber and initialBalance
    // It then initializes balance, owner, and account number to the value of parameters
    //-----------------------------------------------------------------------------------------

        // Your code goes here
        public BankAccount (String ownerName, long accountNumber, double balance) {
            this.ownerName = ownerName;
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

    //-----------------------------------------------------------------------------------------
    // withdraw -
    // it takes a parameter : amount
    // If the amount of money to withdraw is greater than zero and the account's balance is
    // sufficient for withdrawal, the method decrements the balance and returns true, otherwise
    // the method returns false.
    //-----------------------------------------------------------------------------------------

        public boolean withdrawal (double amount)
        {
            if (amount > 0 && amount <= balance )
            {
                balance = balance - amount;
                return true;
            }
            else
                return false;
        }

    //-----------------------------------------------------------------------------------------
    // deposit - takes as parameter the amount of money to deposit
    // If the amount of money to deposit is greater than zero, the method increments the
    // balance and returns true, otherwise the method returns false.
    //-----------------------------------------------------------------------------------------

		// Your code goes here
        public boolean deposit (double deposit)
        {
            if (deposit > 0)
            {
                balance = balance + deposit;
                return true;
            }
            else
                return false;
        }

    //-----------------------------------------------------------------------------------------
    //getBalance
    //Returns the account's balance.
    //-----------------------------------------------------------------------------------------

		 // Your code goes here
         public double getBalance()
         {
             return this.balance;
         }

    //-----------------------------------------------------------------------------------------
    // getOwnerName
    // Returns the account's owner's name.
    //-----------------------------------------------------------------------------------------

		// Your code goes here
        public String getOwnerName ()
        {
            return this.ownerName;
        }

    //-----------------------------------------------------------------------------------------
    // getAccountNumber
    // Returns the account's number.
    //-----------------------------------------------------------------------------------------

		// Your code goes here
        public double getAccountNumber ()
        {
            return this.accountNumber;
        }

    //-----------------------------------------------------------------------------------------
    // changeName
    // Changes the name on the account
    //-----------------------------------------------------------------------------------------

		 // Your code goes here
         public String changeName (String changeName)
         {
             this.ownerName = changeName;
             return ownerName;
         }

    //-----------------------------------------------------------------------------------------
    // toString
    // Returns a String containing the name, account number, and balance separated by
    // semicolons like name; account number; balance
    //-----------------------------------------------------------------------------------------

        // Your code goes here
        public String toString ()
        {
            String toString = "Name: " + ownerName + " ; Account Number: " + accountNumber + " ; Balance: " + balance;
            return toString;
        }
}
