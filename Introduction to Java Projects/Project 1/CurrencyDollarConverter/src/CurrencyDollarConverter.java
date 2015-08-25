/* 
* CurrencyDollarConverter.java 
* Author: Kristin Ottofy 
* Last edited: 01/30/2009 
* 
* Purpose: 
*    This program is designed for a user to convert any kind of currency
* to US Dollars, with an exchange fee, of course. The user will be asked 
* to input their First Name, their Last Name, the type of currency they
* would like to convert from, and the current exchange rate, and how
* much of their currency would they like to change to Dollars. This program
* will display the inputted information clearly and orderly after 
* computations have been made. It will also display exactly how many bills and
* coins the customer should recieve.
*   I have designed this program to first compute the US Dollar amount by
* multiplying the exchange rate by the currency amount. The program will then
 * compute 1.2% of the US Dollar amount and subtract that from the Total
 * US Dollar amount the customer will receive as the exchange fee. The program
 * will then take the Total US Dollar amount, multiply it by 100, convert it
 * to an integer, then divide it back by 100. This will allow the Total US
 * Dollar to have only 2 numbers after the decimal. However, for computing
 * the amount of bills the customer will receive, I have multiplied the
 * Total US Dollar once more by 100 so the number will automatically be an
 * integer. For instance, if the Total US Amount is 130.97, to compute
 * the number of bills and coins, the number will be 13,097. In order to
 * compute the number of bills and coins, I created constants for each bills.
 * For instance, a twenty dollar bill would normally be worth 20 out of 100,
 * but since I multiplied my Total US Amount by 100, I need to multiply the
 * amount a twenty would be worth by 100, so a twenty dollar bill now equals
 * 2,000, and so forth for the other bills and coins. This way, I can easily
 * divide the Total Us Dollar by the new amount for a twenty dollar bill,
 * convert that to an integer, and receive the desired number of twenty dollar
 * bills, which for this instance would be 6. For the following bills and
 * coins, it was necessary to subtract the amount of each of the previous
 * totals to compute the other bills or coins. For instance, if I have 6 twenty
 * dollar bills in 13,097, the total amount would 12,000 for those twenties.
 * This means I would subtract 12,000 from 13,097 to be able to compute the
 * number of necessary ten bills, and so on.
* 
* 
* Statement of Academic Honesty: 
* 
* The following code represents my own work. I have neither 
* received nor given inappropriate assistance. I have not copied 
* or modified code from any source other than the course webpage 
* or the course textbook. I recognize that any unauthorized 
* assistance or plagiarism will be handled in accordance with 
* the University of Georgia's Academic Honesty Policy and the 
* policies*/

// importing the class Scanner
import java.util.Scanner;

// creating the class CurrencyDollarConverter
public class CurrencyDollarConverter
{
    //establishing final constants for the exchange fee calculations
    public static final double EXCHANGE_FEE = 1.2;
    public static final double EXCHANGE_FEE_CALCULATION = .012;
    
    //establishing a final double for manipulating the total US DOllar
    //to the desired number with only 2 digits behind the decimal
     public static final double HUNDREDTH = 100;
     
    //establishing final integers for the calculations to determine
    //the total number of each bill or coin needed
    public static final int TWENTY_DOLLAR_BILLS = 2000;
    public static final int TEN_DOLLAR_BILLS = 1000;
    public static final int FIVE_DOLLAR_BILLS = 500;
    public static final int ONE_DOLLAR_BILLS = 100;
    public static final int QUARTER_COIN = 25;
    public static final int DIME_COIN = 10;
    public static final int NICKEL_COIN = 5;

    //creating the main method
    public static void main(String[]args)           
    {
        //creating a scanner object
        Scanner keyboard = new Scanner(System.in);

        //prompting the user to enter their first name and storing the input
        //in a string called firstName
        System.out.println("First Name:");
        String firstName = keyboard.nextLine();

        //prompting the user to enter their last name and storing the input
        //as a srting called lastName
        System.out.println("Last Name:");
        String lastName = keyboard.nextLine();

        //prompting the user to enter the currency and storing the input
        //as a string called currencyName
        System.out.println("Currency:");
        String currencyName = keyboard.nextLine();

        //prompting the user to enter the currency exchange rate and storing
        //the input as a doube called exchangeRate
        System.out.println("Currency Exchange Rate:");
        double exchangeRate = keyboard.nextDouble();

        //prompting the user to enter the currency amount and storing the
        //input as a double called currencyAmount
        System.out.println("Currency Amount:");
        double currencyAmount = keyboard.nextDouble();

            //creating doubles for calculating the exchange fee and
            //the new total from subtracting the exchange fee from the old total
            double dollarAmount = exchangeRate * currencyAmount;
            double exchangeFee = dollarAmount * EXCHANGE_FEE_CALCULATION;
            double totalAmount = dollarAmount - exchangeFee;

        //displaying the information for the customer
        System.out.println("");
        System.out.println("Currency transaction Summary");
        System.out.println("Customer\t\t:\t" + lastName + ", " + firstName);
        System.out.print("Currency Amount\t\t:\t" + currencyAmount);
        System.out.println(" (" + currencyName + ")");
        System.out.print("Currency Exchange Rate\t:\t" + exchangeRate);
        System.out.println(" US Dollar Per " + currencyName);
        System.out.println("US Dollar Amount\t:\t" + dollarAmount);
        System.out.print("Exchange Fee(" + EXCHANGE_FEE + "%)\t:\t");
        System.out.println(exchangeFee);
        System.out.println("Total US Dollar\t\t:\t" + totalAmount);
        System.out.println("");

            //typecasting the Amount Paid to the customer
            double amountPaid = ((int)(totalAmount * HUNDREDTH)) / HUNDREDTH;

        //displaying the Amount Paid before the Exact Change Paid
        System.out.println("\tAmount paid to the customer: " + amountPaid);
        System.out.println("\tExact Change Paid to customer:");


            //multiplying the amount paid by 100 to have a value with no decimal
            double changeAmount = amountPaid * HUNDREDTH;
            int changeTotal = (int)(changeAmount);

            //calculating how many twenty dollar bills the customer needs
            int twentyBills = (int)(changeTotal / TWENTY_DOLLAR_BILLS);

        //printing the amount of twenty dollar bills for the customer
        System.out.println("\t\t" + twentyBills + " twenty dollar bills");

            //calculating how many ten dollar bills the customer needs
            int twentyTotal = TWENTY_DOLLAR_BILLS * twentyBills;
            int tenBillsRemainder = changeTotal - twentyTotal;
            int tenBills = tenBillsRemainder / TEN_DOLLAR_BILLS;

        //printing the amount of ten dollar bills for the customer
        System.out.println("\t\t" + tenBills + " ten dollar bills");

            //calculating how many five dollar bills the customer needs
            int tenTotal = TEN_DOLLAR_BILLS * tenBills;
            int fiveBillsRemainder = tenBillsRemainder - tenTotal;
            int fiveBills = fiveBillsRemainder / FIVE_DOLLAR_BILLS;

        //printing the amount of five dollar bills for the customer
        System.out.println("\t\t" + fiveBills + " five dollar bills");

            //calculating how many one dollar bills the customer needs
            int fiveTotal = FIVE_DOLLAR_BILLS * fiveBills;
            int oneBillsRemainder = fiveBillsRemainder - fiveTotal;
            int oneBills = oneBillsRemainder / ONE_DOLLAR_BILLS;

        //printing the amount of one dollar bills for the customer
        System.out.println("\t\t" + oneBills + " one dollar bills");

            //calculating the number of quarters the customer needs
            int oneTotal = ONE_DOLLAR_BILLS * oneBills;
            int quarterCoinsRemainder = oneBillsRemainder - oneTotal;
            int quarterCoins = quarterCoinsRemainder / QUARTER_COIN;

        //printing the number of quarters to give the customer
        System.out.println("\t\t" + quarterCoins + " quarters");

            //calculating the number of dimes the customer needs
            int quarterTotal = QUARTER_COIN * quarterCoins;
            int dimeCoinsRemainder = quarterCoinsRemainder - quarterTotal;
            int dimeCoins = dimeCoinsRemainder / DIME_COIN;

        //printing the number of dimes to give the customer
        System.out.println("\t\t" + dimeCoins + " dimes");

            //calculating the number of nickels the customer needs
            int dimeTotal = DIME_COIN * dimeCoins;
            int nickelCoinsRemainder = dimeCoinsRemainder - dimeTotal;
            int nickelCoins = nickelCoinsRemainder / NICKEL_COIN;

        //printing the number of nickels to give the customer
        System.out.println("\t\t" + nickelCoins  + " nickels");

            //calculating the number of pennies the customer needs
            int nickelTotal = NICKEL_COIN * nickelCoins;
            int pennyCoinsRemainder = nickelCoinsRemainder - nickelTotal;
            
        //printing the number of pennies to give the customer
        System.out.println("\t\t" + pennyCoinsRemainder + " pennies");

    //end of code by Kristin Ottofy
    }
}
