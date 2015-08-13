
/**
 *
 * @author Kristin Ottofy
 * Earnings.java
 * Last edit: 2009.01.21
 */

import java.util.Scanner;

public class Earnings {

 public static void main(String[]args)
    {
        //declaration of the variables and constants
        double grossEarnings;

         //creating Scanner object
        Scanner keyboard = new Scanner(System.in);

        //prompting user to enter gross earnings
        System.out.println("Please enter the gross earnings:");

        //assigns input from user to grossEarnings variable
        grossEarnings = keyboard.nextDouble();

        //declaration of the variables and constants
        double taxPercent = 35.0;
        double tax = ((grossEarnings * taxPercent) / 100);
        double netEarnings = grossEarnings - tax;

        //Below is telling the output of the program to print the results
        System.out.println("Gross Earnings:\t" + grossEarnings);
        System.out.println("Tax Percent:\t" + taxPercent);
        System.out.println("Tax:\t\t" + tax);
        System.out.println("Net Earnings:\t" + netEarnings);

    }

}

