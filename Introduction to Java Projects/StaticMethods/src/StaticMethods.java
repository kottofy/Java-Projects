/*Hi all,

Please have a look at StaticMethods.java under course conter -> In class
programs
I have asked you to write two methods in that class file.
One method takes a string as a parameter and reverses it.
Another method determines if a string is a palindrome string.

Please write the bodies of these two methods and we will discuss them
tomorrow in class.

Anousha */

/*
 * StaticMethods.java
 */
/**
 *
 * @author Anousha
 */
import java.util.Scanner;

public class StaticMethods
{
    /***************************************************************
     * This  method takes a string as an input and returns a string
     *  that is the reverse of the given string.
     *****************************************************************/

    // write the method here.
    public static String reverseString(String input)
    {
        String newString="";

        for (int index = 0; index <= input.length() - 1; index++)
        {
            newString = input.charAt(index) + newString;
        }

        return newString;

    }



    /**************************************************************
     * public static boolean  isPalindrome (String )
     *  This method  takes a string as an input and determines if it
     *  is a palindrome.
     * **************************************************************/


    // write the method here.

    public static boolean isPalindrome (String str)
    {
        String reverseString = reverseString(str);

        boolean palindrome = false;

        if (reverseString.equals(str))
            palindrome = true;
        else
            palindrome = false;

        return palindrome;
    }



    /**********************************************************/
    /* Static method display
        /* Displays all the numbers in interval [m-n]
        ************************************************************/
    public static void display ()
    {
        Scanner scan = new Scanner (System.in);
        System.out.println ("Please enter m and n: ");
        int m = scan.nextInt();
        int n = scan.nextInt();

        for ( int count= m    ;  count <=n     ; count++    )
        {
            System.out.print (count + " ");
        }

    }
    /**********************************************************/
    /* Static method Sum
        /* Displays the sum of all the numbers in interval [m-n]
        ************************************************************/
    public static void Sum ()
    {
        Scanner scan = new Scanner (System.in);
        System.out.println ("Please enter m and n: ");
        int m = scan.nextInt();
        int n = scan.nextInt();
        int sum = 0;
        for (int count = m ; count <=n; count++)
        {
            sum += count;
        }
        System.out.println ("The sum of all the numbers between "+m + " and "+ n +" is " + sum);
    }
    /**********************************************************************
     * show(int a,int b,float c)
     * This method takes three parameters and display them on the screen
     ************************************************************************/
    public static void show (int a , int b , float c )
    {
        System.out.println ( a + " " + b +" "+c );
        a = 6;
    }

    public static void discount (int price)
    {
        double amount  =price *15/100;
        System.out.println ("The discount will be "+ amount +" $");
    }
    /********************************************************************
     * add (int a, int b)
     * This method takes two parameters and adds them up.
     * It then printst the result on the screen
     ************************************************************************/
    public static void addNumber (int a, int b)
    {
        int c = a+b;
        System.out.println (c);
    }
    /*********************************************************************
     *  subtract (double,double)
     * This method takes two parameters and subtract them. it returns
     * the result.
     ************************************************************************/
    public static double subtract (double x, double y)
    {
        double result = x - y;
        return result;
    }
    /*******************************************************************
     * calculator (double,double,char)
     * This method takes two numbers a and b, and a character,
    *   if the character is
    *   '+' it will return a+b
    *   '-' it will return a-b
    *   '*' it will return a*b
    *   '/' it will return a/b
    *********************************************************************/

    public static double calculator (double a, double b, char c)
    {
        switch (c)
        {
            case '+':
                return a+b; //note that since we return a value right after the appropriate case , we don't need to use the break
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                if ( b != 0)// avoiding division by zero
                 return a/b;
            default:
                return 1;
        }


    }
    /*************************************************************
     *  main method
     ****************************************************************/
    public static void main (String [] args)
    {
        //calling the method display
        display();
        int num = 3;
        show (num , 2, 4);
        System.out.println (num);
        int price = 100;
        discount (price);
        double number = subtract (43,10);
        System.out.println (number);

    }

}