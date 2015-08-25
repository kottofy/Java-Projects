/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kottofy
 */

import java.util.Scanner;

public class EvenOrOdd {

public static final int TWO = 2;
public static final int ZERO = 0;

    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please input a number");
        int num1 = scan.nextInt();
        
        int num2 = num1 % TWO;

        if (num2 == 0)
        {
            System.out.println(num1 + " is an even number");
        }
        else
        { System.out.println(num1 + " is an odd number");
        }
    }    
}
