/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Time.java
 * @author Kristin Ottofy
 * Last Edited: 01/03/2009
 */

import java.util.Scanner;

public class TimeTwo
{
        public static final int SECONDS_X_HOUR = 3600;
        public static final int SECONDS_X_MINUTE = 60;
        public static final int AM_PERIOD = 43199;

    public static void main(String[]args)

    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the time in seconds:");
        int userSeconds = keyboard.nextInt();

            int hours = userSeconds / SECONDS_X_HOUR;
            int minutesRemaining = userSeconds % SECONDS_X_HOUR;
            int minutes = minutesRemaining / SECONDS_X_MINUTE;
            int secondsRemaining = minutesRemaining % SECONDS_X_MINUTE;


            if ((userSeconds < 0) || (userSeconds > 86399))

            {
                System.out.println("Sorry, the number of second must be an integer between 0 and 86399. Bye.");
                System.exit(0);
            }
            else
            {
                System.out.println("Would you like the time in AM/PM format (yes/no)?");
            }

            String yesOrNo = keyboard.next();

            if (yesOrNo.equalsIgnoreCase("yes"))
            {
                if (userSeconds <= AM_PERIOD)
                {
                    if (hours == 0)
                    {
                        hours = 12;
                    }
                System.out.println("Format: " + hours + " h., " + minutes + " m., " + secondsRemaining + " s. AM");
                }
                else
                {
                    int standardHours = hours % 12;
                    System.out.println("Format: " + standardHours + " h., " + minutes + " m., " + secondsRemaining + " s. PM");
                }
            }

            
                else
            {
                System.out.println("Format: " + hours + " h., " + minutes + " m., " + secondsRemaining + " s.");
            }
    }
    
}
