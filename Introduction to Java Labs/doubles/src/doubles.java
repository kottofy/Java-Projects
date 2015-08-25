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

public class doubles

{

    public static void main (String[]args)
    
    {

    System.out.println("Hello, please type two numbers below seperated");
    System.out.println("by a space and I will give you their average.");

    double num1, num2;

    Scanner keyboard = new Scanner(System.in);
    num1=keyboard.nextDouble();
    num2=keyboard.nextDouble();

    System.out.println("I added the two numbers together and then");
    System.out.println("divided them by two to give you the average.");
    System.out.println("The result is");
    System.out.println((num1 + num2) / 2);


    }
}
