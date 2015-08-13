/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kottofy
 */

// PROGRAM DOES NOT WORK

import java.util.Scanner;
public class StaticMethodTester {

    public static void main (String [] args)
    {

        Scanner scan = new Scanner (System.in);
        System.out.println("Please enter a word: ");
        String input = scan.next();
        // int num = Math.max(3, 4);

        if (StaticMethods.isPalindrome(input))
            System.out.println(input + " is a palindrome string");
        else
            System.out.println(input + " is a palindrome string");

    }

}
