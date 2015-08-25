/**
 *
 * @author Anousha
 * FactorialFor.java
 * This class calculates the factorial of a number using for loop
 */
import java.util.Scanner;
public class factorial
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println ("Please enter a number : ");
        int num = scan.nextInt();
        int fact = 1;
        int count ;
        for ( count = num  ; count > 0 ;  count -- )
        {
            fact *= count; // fact = fact * count;
        }
        System.out.println ( num + "!= " + fact);
    }
}
