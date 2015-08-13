/*
 * Factorion.java
 * Author: Kristin Ottofy
 * Last Edited: 03/04/2009
 *
 */

import java.util.Scanner;

public class Factorion {

    /** A program to determine if an integer is a factorion. */
  public static void main(String[] args)  {
        int inputNumber;
        int number;
        int digit;
        int total;
        int factorial;

        Scanner keyboard= new Scanner(System.in);

        System.out.print("Please enter an integer greater than or equal to zero: ");
        inputNumber=keyboard.nextInt();

        if (inputNumber < 0) {          // Set a break point here
            System.out.println("You must enter an integer greater than or equal to zero.");
            System.exit(0);
        }
        total=0;
        number=inputNumber;
        do {

             digit = number % 10;
             // Write a java statment to display the value of the variable digit
             System.out.println("digit is: " + digit);

             factorial=1;
             for (int i=digit; i >0; i--) { // Set the cursor here and click on Run to Cursor
                 factorial = factorial * i;    	   // Set a breakpoint here

                 // Write a java statement to display the value of the variable i
                 System.out.println("i is: " + i);
                 // Write a java statement to display the value of the variable factorial
                 System.out.println("factorial is: " + factorial);
             }

                 total = total + factorial;
                 // Write a java statement to display the value of the variable total
                 System.out.println("total is: " + total);
             
             number = number / 10;
             // Write a java statement to display the value of the variable number
             System.out.println("number is: " + number);

        } while (number > 0);

        // Write a java statement to display the value of the variable total after the loop terminates
        System.out.println("total after loop is: " + total);

        if (total == inputNumber) {
            System.out.println(inputNumber +" is a factorion");
        }
        else {
            System.out.println(inputNumber +" is a not factorion");
        }
    }
}

