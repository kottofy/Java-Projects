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


public class integers

{
        public static void main (String[]args)

    {
        System.out.println("Hello Please enter two numbers below seperated");
        System.out.println("by a space and I will add them together for you");

        int num1, num2;

        Scanner keyboard = new Scanner(System.in);
        num1=keyboard.nextInt();
        num2=keyboard.nextInt();

        System.out.println("The sum of those two numbers is..");
        System.out.println(num1 + num2);
        


    }
}
