/**
 * Drawing.java
 * @author Kristin Ottofy
 * Last Edited: 03/16/2009
 */

import java.util.Scanner;

public class Drawing
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        
        int count;
        int times;
        
        System.out.println ("Please enter the number of times you would like the design to be displayed: ");
        int num = scan.nextInt();
        
        if ( num < 1)
        {
            System.out.println("Number must be greater than 1.");
            System.out.println("Good Bye.");
            System.exit(0);
        }
         
        for (times = num; times > 0; times--)
        {
            for (count = 16; count > 0; count--)
            {
                    for (count = 16;;)
                    {
                        System.out.println("***************");
                        break;
                    }
                    for (count = 15;;)
                    {
                        System.out.println("*******#*******");
                        break;
                    }
                    for (count = 14;;)
                    {
                        System.out.println("****** # ******");
                        break;
                    }
                    for (count = 13;;)
                    {
                        System.out.println("*****  #  *****");
                        break;
                    }
                    for (count = 12;;)
                    {
                        System.out.println("****   #   ****");
                        break;
                    }
                    for (count = 11;;)
                    {
                        System.out.println("***    #    ***");
                        break;
                    }
                    for (count = 10;;)
                    {
                        System.out.println("**     #     **");
                        break;
                    }
                    for (count = 9;;)
                    {
                        System.out.println("*      #      *");
                        break;
                    }
                    for ( count = 8;;)
                    {
                        System.out.println("*      #      *");
                        break;
                    }
                    for (count = 7;;)
                    {
                        System.out.println("**     #     **");
                        break;
                    }
                    for (count = 6;;)
                    {
                        System.out.println("***    #    ***");
                        break;
                    }
                    for (count = 5;;)
                    {
                        System.out.println("****   #   ****");
                        break;
                    }
                    for (count = 4;;)
                    {
                        System.out.println("*****  #  *****");
                        break;
                    }
                    for (count = 3;;)
                    {
                        System.out.println("****** # ******");
                        break;
                    }
                    for (count = 2;;)
                    {
                        System.out.println("*******#*******");
                        break;
                    }
                    for (count = 1;;)
                    {
                        System.out.println("***************");
                        break;
                    }

            }
        }
    }
}