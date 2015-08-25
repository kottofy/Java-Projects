// ****************************************************************
// Reverse.java
// Author: Kristin Ottofy
// Last Edited: 04/20/2009
//
// A java program that reads in several integers, stores them
// in an array, print its elements. Then reverse the elements
// of the array and print the array again.
//
// ****************************************************************

import java.util.Scanner;
public class Reverse
{
	public static void main(String[] args)
	{
        int[] numbers = readInNumbers();

        System.out.println("\nDisplaying the array");
        printArray(numbers);
        reverseArray(numbers);
	}

	/************************************************************************
	 * readInNumbers : private static method that does the following:
	 *                 i)   prompts a user to enter an integer greater than zero
	 *                      and reads that number
	 *                 ii)  creates an int array with as many elements as the
	 *                      number specified by the user
	 *                 iii)	reads in as many integers and stores them in the array
	 *                 iv)  returns the array of integers
	 ****************************************************************************/

    private static int[] readInNumbers()
    {
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter the number of elements to reverse: ");
        int elements = scan.nextInt();

        int [] normalArray = new int [elements];
        int number;

        for (int count = 0; count < elements; count++)
        {
            System.out.println("Enter a number: ");
            number = scan.nextInt();
            normalArray[count] = number;
        }

        return normalArray;
    }

	/*****************************************************************************
	 * printArray: private static void method that takes an int array as a
	 *             parameter and displays the elements of that array.
	 ******************************************************************************/

     private static void printArray (int[] array)
     {
         
         for (int count = 0; count < array.length; count++)
         {
            System.out.println("number " + count + ": " + array[count]);
         }
     }

	/********************************************************************************
	 * reverseArray: a private static void method that takes an int array as a
	 *             parameter and reversed the elements of that array.
	 ********************************************************************************/

    private static void reverseArray (int[] array)
    {
        System.out.println("\nAfter reversing the array");

        int count = 0;
        int index = array.length - 1;
        
        while (count < index)
        {
            int temp = array[count];
            array[count] = array[index];
            array[index] = temp;

            count++;
            index--;
        }
        printArray(array);
    }
}