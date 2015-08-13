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

public class typecast

{
    public static void main(String[]args)

    {  
            float x;
            
            System.out.println("Please enter a floating point value.");
            
            Scanner scan = new Scanner(System.in);

            x = scan.nextFloat();
            
            System.out.println("You enetered: " + x);
            
            int y = (int)x;
            
            System.out.println("I will now display this value as an int: ");
            System.out.println(y);

    }
}
