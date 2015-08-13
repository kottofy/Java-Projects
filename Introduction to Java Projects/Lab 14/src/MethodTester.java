/*
 *
 * MethodTester.java
 * Author: Kristin Ottofy
 * Last Edited: 03/18/2009
 *
 * */

import java.util.*; // import everything from java.util

//Class MethodTester implements methods 
public class MethodTester
{

	public static void main(String args [])
	{
        Scanner scan = new Scanner (System.in);

		/*Part 1 - using the changeCharCase(String,char) method from Babble class*/
		
		//We need to scan in two strings (separated by a whitespace)

		System.out.println("Input a string: ");
		
		//the first string is the input string - get it here

        String inputString = scan.nextLine();
		
		//the second string is the lowercase character - given here due to the complexity
		//if it is a string of length more than 1, we just take the first character
		/*char lowercase = (scan.next()).charAt(0);*/

        System.out.println("Enter a character: ");
        String str1 = scan.nextLine();
        char newChar = str1.charAt(0);

		//Set an outputString variable equal to the method Babble.changeCharCase(...)
		//We do this by using the static method from the Babble class 
		//ie  we only need to use the class name Babble to invoke the method (Babble.changeCharCase(...))
		
        String outputString = Babble.changeCharCase(inputString, newChar);
        
		//output the outputString here
		System.out.println(outputString);
		
		/*Part 2 - using the replaceChar(String,char,char) method from Babble class*/		
		
		//We need to scan in three strings
		
		//the first string is the input string - get it here
		
        System.out.println("Input a string: ");
        inputString = scan.nextLine();
        
		//the second string is the old character
		//if it is a string of length more than 1, we just take the first character
		/* char oldChar = (scan.next()).charAt(0); */

        System.out.println("Input the old character: ");
        String string1 = scan.nextLine();
        char oldChar = string1.charAt(0);

		//the third string is the replacement character
		//if it is a string of length more than 1, we just take the first character
		/* char newChar = (scan.next()).charAt(0); */

        System.out.println("Enter a new character: ");
        String string2 = scan.nextLine();
        newChar = string2.charAt(0);
		
		//Set an outputString variable equal to the method replaceChar(...)
		//We do this by using the static method from the Babble class 
		//ie  we only need to use the class name Babble to invoke the method (Babble.replaceChar(...))

        outputString = Babble.replaceChar(inputString, oldChar, newChar);
	
		//output the outputString here
		
		System.out.println(outputString);
	}

	


}