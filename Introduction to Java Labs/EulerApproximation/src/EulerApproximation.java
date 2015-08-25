/**
 * EulerApproximation.java
 * @author Kristin Ottofy
 * Last Edited: 02/27/2009
 */
import java.util.Scanner;

public class EulerApproximation {
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println("Please enter an integer >=1: ");
        int originalNum = scan.nextInt();
        int num = originalNum;

        while (num < 1)
        {
            System.out.println("Please enter an integer greater than 1.");
            num = scan.nextInt();
        }

        double fact = 1;
        double count = 1;
        double euler = 1;
        double sum = 0;
        

        while ( count <= num)
        {
            fact = fact * count;
            count ++;           
            sum = 1 / fact;
            euler = euler + sum;        
        }
            System.out.println ( "The approximation of the number e for n=" + num + " is " + euler);
    }

}
