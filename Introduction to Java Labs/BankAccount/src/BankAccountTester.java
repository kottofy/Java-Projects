// ****************************************************************
//   BankAccountTester.java
//   Author: Kristin Ottofy
//   Last Editied: 04/01/2009
//   Use Account class to create and manage two bank accounts
//
// ****************************************************************


public class BankAccountTester{

	public static void main(String[] args) {

		// a)	Declare two BankAccount class type variables: acct1 and acct2.

                    BankAccount acct1;
                    BankAccount acct2;

		//b)	Create a BankAccount object for Fred MacGraw with an initial balance of $568 and account number 123456.
		//      Assign its reference to the BankAccount variable acct1.

                    acct1 = new BankAccount("Fred MacGraw", 123456, 568);

		//c)	Create a BankAccount object for Beyonce Knowles with and initial balance of $650 and account number 123457.
		//      Assign its reference to the BankAccount variable acct2.

                    acct2 = new BankAccount("Beyonce Knowles", 123457, 650);

		//d)	Display Fred's account and Beyonce's account by calling the toString method.

                    System.out.println(acct1.toString() + "\n" + acct2.toString());

		//e)	Withdraw $120 dollars from Fred's account referred via acct1.If the withdrawal was completed successfully,
		//      i.e the call to the method withdraw returned true, then display the current state of Fred's account using
		//      the method toString implicitly in a System.out.println statement, otherwise display an error message
		//      indicating the withdrawal was not completed.

                    if (acct1.withdrawal(120) == true) {
                        System.out.println(acct1.toString());
                    }
                    else {
                        System.out.println("The withdrawal has not been completed.");
                    }

		//f)	Withdraw $702 dollars from Fred's account referred via acct1.If the withdrawal was completed successfully,
		//      i.e the call to the method withdraw returned true, then display the current state of Fred's account using
		//      the method toString implicitly in a System.out.println statement, otherwise display an error message
		//      indicating the withdrawal was not completed.

                    if (acct1.withdrawal(702) == true) {
                        System.out.println(acct1.toString());
                    }
                    else {
                        System.out.println("The withdrawal has not been completed.");
                    }

		//g)	Change the name of the BankAccount referred through acct1 to Shawn Corey Carter.

                    acct1.changeName("Shawn Corey Carter");

		//h)	Withdraw -$80 dollars from Beyonce's account, if the withdrawal was done then display Beyonce's account,
		//      otherwise display an error message indicating the withdrawal was not completed.

                    if (acct2.withdrawal(-80) == true) {
                        System.out.println(acct2.toString());
                    }
                    else {
                        System.out.println("The withdrawal has not been completed.");
                    }

        //i)	Deposit $300 dollars into Beyonce's account, if the deposit was completed successfully then display Beyonce's
        //      account, otherwise display an error message indicating the withdrawal was not completed.

                    if (acct2.deposit(300) == true) {
                         System.out.println(acct2.toString());
                    }
                    else {
                        System.out.println("The deposit has not been completed.");
                    }

        //j)	Deposit -$120 dollars into Beyonce's account, if the deposit was completed successfully then display Beyonce's
        //      account, otherwise display an error message indicating the withdrawal was not completed.

                    if (acct2.deposit(-120) == true) {
                        System.out.println(acct2.toString());
                    }
                    else {
                        System.out.println("The deposit has not been completed.");
                    }

        //k)	Get the balance of the BankAccount objects referred via acct1, acct2 and compute the difference between
        //      the highest balance and the lowest balance and deposit the difference to the account with the lowest balance.

                    double amount = 0;

                    if (acct1.getBalance() > acct2.getBalance()) {
                        amount = acct1.getBalance() - acct2.getBalance();
                        acct2.deposit(amount);
                    }
                    else {
                        amount = acct2.getBalance() - acct1.getBalance();
                        acct1.deposit(amount);
                    }

        //l)	Display a comparative summary of the BankAccount objects referred via acct1 and acct2. See the lab description

                System.out.println("Comparative Summary");
                System.out.println("Owner: " + acct1.getOwnerName() + "\t" + acct2.getOwnerName());
                System.out.println("Acct#: " + acct1.getAccountNumber() + "\t\t\t" + acct2.getAccountNumber());
                System.out.println("Balance: " + acct1.getBalance() + "\t\t\t" + acct2.getBalance());

    }
}