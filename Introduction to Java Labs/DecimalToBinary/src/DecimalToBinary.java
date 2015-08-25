/**
 * DecimalToBinary.java
 * @author Kristin Ottofy
 * Last Edited: 02/23/2009
 *
 */

import java.util.Scanner;

public class DecimalToBinary
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);

        System.out.println("Please enter an integer >=0 (<0 to terminate): ");
        int originalNum = scan.nextInt();
        int num = originalNum;
        String binary = "";
        String nextBinary ="";
        String newBinary = "";

        if (num < 0)
        {
            System.out.println("Sorry, you have entered a negative number.");
            System.exit(0);
        }

        else if (num == 0)
        {
            System.out.println("The binary representation of 0 is 0.");
            System.exit(0);
        }
        
        else
        {
            while (num > 0)
            {


                if (num % 2 == 1)
                    nextBinary = "1";
                else
                    nextBinary = "0";


                binary = binary + nextBinary;
                num = num / 2;

            }

            for (int i = binary.length()-1 ; i >= 0 ; i--)
                newBinary += binary.charAt(i);

            System.out.println("The binary representation of " + originalNum + " is " + newBinary);
        }
    }
}
