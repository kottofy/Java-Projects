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

public class hatetolove {

    public static void main (String[]args)

    {

        System.out.println("Enter a line of text");

        String hate;

        Scanner keyboard = new Scanner(System.in);
        hate = keyboard.nextLine();
        
        String love;
        
        love = hate.replaceFirst("hate","love");
        

        System.out.println("I have rephrased the line to read:");
        System.out.println(love);


    }
}
