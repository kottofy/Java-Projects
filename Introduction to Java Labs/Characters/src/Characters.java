/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kristin Ottofy
 * Last Edited: 01.21.2009
 */

import java.util.Scanner;

public class Characters {

    public static void main (String[]args)

    {
        System.out.println("Please input an integer of 4 digits");

        String str1;

        Scanner keyboard = new Scanner (System.in);

        str1 = keyboard.nextLine();

        System.out.println("You typed: " + str1);

        char A;
        char B;
        char C;
        char D;

        A = str1.charAt(0);
        B = str1.charAt(1);
        C = str1.charAt(2);
        D = str1.charAt(3);

        System.out.println("I have now separated each digit and will display");
        System.out.println("them separated by tabs");

        System.out.print(A + "\t");
        System.out.print(B + "\t");
        System.out.print(C + "\t");
        System.out.print(D);

    }


}
