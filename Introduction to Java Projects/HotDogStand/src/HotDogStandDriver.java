/**
 * HotDogStandDriver.java
 * Author: Kristin Ottofy
 * Last Edited: 04/13/2009
 *
 * HotDogStandDriver: A driver class to test
 *                    the functionality of the class
 *                    HotDogStand and learn how to split
 *                    the main method into sub-taks implemented
 *                    as private static methods in thi driver
 *                    class
 */

import java.util.Scanner;

public class HotDogStandDriver
{

    public static void main(String[] args)
    {
        //Scanner scan = new Scanner (System.in);
        
        int id;
        HotDogStand hotDogStand1 = null;
        HotDogStand hotDogStand2 = null;
        HotDogStand hotDogStand3 = null;

        // Creates Three Hot Dog Stands
        id = getPositiveInteger("Please enter an ID for the first hot dog stand: ");
        hotDogStand1 = new HotDogStand(id);
        id = getPositiveInteger("Please enter an ID for the second hot dog stand: ");
        hotDogStand2 = new HotDogStand(id);
        id = getPositiveInteger("Please enter an ID for the third hot dog stand: ");
        hotDogStand3 = new HotDogStand(id);

        // Call the private static method getHotDogStandSales below
        // to update the hot dog sales of hotDogStand1

        getHotDogStandSales(hotDogStand1);

        // Call the private static method getHotDogStandSales below
        // to update the hot dog sales of hotDogStand2

        getHotDogStandSales(hotDogStand2);

        // Call the private static method getHotDogStandSales below
        // to update the hot dog sales of hotDogStand3

        getHotDogStandSales(hotDogStand3);

        // Display the  number of sales during the day of hotDogStand1
        // by calling the static method displayHotDogStandSales below

        displayHotDogStandSales(hotDogStand1);

        // Display the  number of sales during the day of hotDogStand2
        // by calling the static method displayHotDogStandSales below

        displayHotDogStandSales(hotDogStand2);

        // Display the  number of sales during the day of hotDogStand3
        // by calling the static method displayHotDogStandSales below

        displayHotDogStandSales(hotDogStand3);

        // Display the total  number of hot dogs sold by all the stands
        // by calling the static method getTotalHotDogsSold of the class HotDogStand

        int totalHotDogsSold = HotDogStand.getTotalHotDogsSold();
        System.out.println("Total number of Hot Dogs Sold: " + totalHotDogsSold);

        // Display the average number of hot dogs sold per stand
        // by calling the static method getavgHotDogSales  of the class HotDogStand

        int avgHotDogSales = HotDogStand.avgHotDogsales();
        System.out.println("Average Number of Hot Dogs Sold per Stand: " + avgHotDogSales);
    }

    // getPositiveInteger: prompts the user for an integer greater than or equal to zero
    // and returns such an integer.
    //
    // The method takes a String parameter that specifies a message
    // that should be displayed in order for the user to enter a positive integer.
    // The method will prompt the user and read in an integer.
    // If the user enters an integer number less than zero, the method should display an error message
    // and prompts the user for a positive number until the user enters a number greater than or equal to zero.

    private static int getPositiveInteger(String message)
    {
        Scanner scan = new Scanner (System.in);

        System.out.println(message);
        int num = scan.nextInt();
        
        while (num < 0)
        {
            System.out.println("The number must be greater than or equal to zero.");

            System.out.println(message);
            num = scan.nextInt();
        }
        
        return num;
    }

    // getHotDogStandSales: takes a HotDogStand object as a parameter,
    // prompts the user for an integer greater than or equal to zero that indicates
    // the number of hot dog sold by the stand in a day. If the user enters a number
    // less than zero, an error message should be displayed. Afterwards, the method will update
    // the sales of the HotDogStand object by calling its method JustSoldOne as many times as
    // the number of hot dogs indicated by the user.
    //
    // Important: Note that the method getPositiveInteger can be called from this method using the appropriate prompt to
    //            obtain the sales for the HotDogStand

    private static void getHotDogStandSales(HotDogStand hotDogStand)
    {
        Scanner scan = new Scanner (System.in);
        
        System.out.println("Please enter the number of hot dogs sold by the hot dog stand #" + hotDogStand.getID() + ": ");
        int num = scan.nextInt();
        
        while (num < 0)
        {
            System.out.println("The number must be greater than or equal to zero.");
            System.out.println("Please enter the number of hot dogs sold by the hot dog stand #" + hotDogStand.getID() + ": ");
            num = scan.nextInt();
        }
        
        for (int count = 0; count < num; count++)
        {
            hotDogStand.justSoldOne();
        }
    }

    // displayHotDogStandSales: Displays the stand's ID and the total number of hot dogs sold by a hot dog stand.
    // Please refer to the example output messages in PDF file.

    private static void displayHotDogStandSales(HotDogStand hotDogStand)
    {
        System.out.println("Total number of hot dogs sold by the hot dog stand #" + hotDogStand.getID() + ": " + hotDogStand.getHotDogsSold());
    }
}
