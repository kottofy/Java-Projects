/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * MaxMinAvg.java
 *Last Edited: 02/16/2009
 * Author: Kristin Ottofy
 */

import java.util.Scanner;

public class MaxMinAvg
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);

        
        
        System.out.println("Please enter an integer >0 ( <=0 to terminate): ");
        int num = scan.nextInt();

            if (num<=0)
            {
                System.out.println("You have not entered a positive integer. Bye.");
                System.exit(0);
            }

        int count = 0;
        double sum = 0;
        int maximum = num;
        int minimum = num;

        
        while (num > 0)
        {
            sum = sum + num;
            count++;

            {
                if (num >= maximum)
                    maximum = num;
                if (num <= minimum)
                    minimum = num;
            }
            
            System.out.println("Please enter an integer >0 ( <=0 to terminate): ");
            num = scan.nextInt();
        }

        double average = sum / count;

        System.out.println();
        System.out.println("Minimum: " + minimum);
        System.out.println("Maximum: " + maximum);
        System.out.println("Average: " + average);
    }
}
