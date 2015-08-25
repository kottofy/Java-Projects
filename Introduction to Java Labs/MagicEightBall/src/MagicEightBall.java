/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author instructor
 */

import java.util.Scanner;
import java.util.Random;

public class MagicEightBall
{
    public static void main (String [] args)
    {
        System.out.println ("Please ask a question: ");
        Scanner scan = new Scanner (System.in);
        Random random = new Random();
        String question = scan.nextLine();

        int num = random.nextInt(4); //[0-3]
        //num = random.nextInt(5)+1  //[1-5]
        /*
        if (num == 0 )
            System.out.println ("Concentrate and ask again");
        else if (num == 1 )
            System.out.println ("Signs point to yes");
        else if (num == 2)
            System.out.println ("Better not tell you now");
        else if (num == 3)
            System.out.println ("Reply hazy. Try again");
         */
        switch (num)
        {
            case 0:
                System.out.println ("Concentrate and ask again");
                break;
            case 1:
                System.out.println ("Signs point to yes");
                break;
           case 2:
                System.out.println ("Better not tell you now");
                break;
            case 3:
                System.out.println ("Reply hazy. Try again");
                break;
        }


    }

}
