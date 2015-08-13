/*
 *
 * MethodTester.java
 * Author: Kristin Ottofy
 * Last Edited: 03/18/2009
 *
 * */

/* 
Class Babble has two static methods
 changeCharCase(String,char)
 replaceChar(String,char,char)
*/

public class Babble
{

	/*****************************************************************************************
        * Method changeCharCase(String,char)
	* takes a string and a lowercase char and replaces every instance of the char with a caps char 
        * 
        *                   DO NOT CHANGE ANYTHING IN THIS METHOD!!!!!!!!!!!!!!!!!!!
	*****************************************************************************************/
	public static String changeCharCase(String inputString,char lowercase)
	{
		String outputString = "";
		
		//The "uppercase" version of a char is found this way - do not worry about what is going on here!
		//But if you are curious, the char was converted into an int - if we subtract 32 we get 
		//the capitalized version of the char
   		char uppercase = (char)((int)lowercase - 32);
    	
   		
   		//Loop over each character in the inputString by increasing the "index"
   		//For example index 0 of String "String" is the character 'S'
   		//If the character at an index is the lowercase letter input, 
   		//then change it to its uppercase version
   		for( int currentIndex = 0; currentIndex < inputString.length(); currentIndex++)
                {
                    if( inputString.charAt(currentIndex) == lowercase)
                    {
                            outputString += uppercase;
                    } 
                    else
                    {
                            outputString += inputString.charAt(currentIndex);
                    }
                }   
      	
            //return the outputString here to the caller
            return outputString;
      	
        }
	
	/*************************************************************************************
        *  Method replaceChar(String,char,char)
	*  takes a string and two chars - every instance of the first char is replaced by the second char 
	*
	* reference the method changeCharCase for aid in creating this method
	***************************************************************************************/
	public static String replaceChar(String inputString,char oldChar,char newChar)
	{
		//declare an empty string here called outputString
		String outputString = "";
    	
   		//use a similar loop to what is used in changeCharCase except now replace every instance of the old char
   		//with a new one

        for( int currentIndex = 0; currentIndex < inputString.length(); currentIndex++)
                {
                    if( inputString.charAt(currentIndex) == oldChar)
                    {
                            outputString += newChar;
                    }
                    else
                    {
                            outputString += inputString.charAt(currentIndex);
                    }
                }

            //return the outputString here
            return outputString;
      	
        }	



}