import java.util.Scanner;
import edu.uga.cs1302.txtbuff.*;

/**
 * This class imports the source files in the package edu.uga.cs1302.txtbuff
 * to utilize those public methods. In this class, the user will be prompted
 * to enter a line and a fragment of a line. Different methods will be tested
 * on the inputed string and fragment, and the output will be displayed.
 * @author Kristin Ottofy
 */
public class Tester {

    /**
     * The main method holds the instructions.
     * @param args  main method param
     */
    public static void main(String[] args)
    {
        String line, str; //will be assigned to input from user

        Scanner scan = new Scanner(System.in);  //create new Scanner for System.in

        System.out.println("Please enter a line of text:");
        line = scan.nextLine();

        //create new EditableTextLine and initialize is to the inputed line
        EditableTextLine eLine = new EditableTextLine(line);

        //print the eLine, its length, and its capacity
        System.out.println("eLine: " + eLine.toString());
        System.out.println("length: " + eLine.length());
        System.out.println("capacity: " + eLine.capacity());

        //ask for a string of characters and assign them to string str
        System.out.println("Please enter a string of characters:");
        str = scan.nextLine();


/***************PRINT ALL OCCURENCES OF STR****************/
        System.out.println("Print all occurences of str:");

        boolean isFirstSearch = true;   //keeps track of if in first search

        //loop through the eLine starting at index 0 to find str
        for (int count = eLine.indexOf(str,0); count >= 0 && count < eLine.stringLength; count++)
        {
            // if count return -1 at the first search, then str is not in the text line
            //if it's not, exit the program
            if (count == -1 && isFirstSearch == true)
            {
                System.out.println("Fragment not found");
                System.exit(1);
            }

            //if str is found, print at what index
            System.out.println("occurance at: " + count);
            isFirstSearch = false;  //set to false since first search is finished

            //search again at the next index if not at end of string
            if (count + 1 < eLine.stringLength)
                count = eLine.indexOf(str, count+1);

            //if str is is not in the file past the last time it was found, then end the loop
            if (count == -1 && isFirstSearch == false)
                break;                 
        }

/****************APPEND STR AND PRINT WITH TOSTRING*****************/
        System.out.println("Append str:");

        //add str to the end of eLine
        eLine.append(str);

        //print out new eLine with appended string
        System.out.println("eLine is: " + eLine.toString());

/***************INSERT STR AT INDEX 0 AND PRINT ELINE******************/
            
        System.out.println("Insert str at index 0");

        //try to insert the string str at index 0 of eLine and print eLine
        //if no exceptions were thrown
        try
        {
            eLine.insert(0, str);
            System.out.println("eLine is: " + eLine.toString());
        }
        //if an exception was thrown, catch the exception
        catch (TextLineIndexOutOfBoundsException e)
        {
            e = new TextLineIndexOutOfBoundsException();
        }


/***********INSERT STR AT INDEX STR.LENGTH() AND PRINT ELINE***********/
    
        System.out.println("Insert str at index str.length():");

        //try to insert the string str at index at length of str in eLine
        //and print eLine if no exceptions were thrown
        try
        {
            eLine.insert(str.length(), str);
            System.out.println("eLine is: " + eLine.toString());
        }
        //if an exception was thrown, catch the exception and print a message
        catch (TextLineIndexOutOfBoundsException e)
        {
            e = new TextLineIndexOutOfBoundsException("Index is out of Bounds");
        } 

/*********REPLACE ALL OCCURENCES OF STR WITH ABC AND PRINT ELINE***********/
       
        System.out.println("Replace all occurences of str with \"abc\":");

        //try to replace in eLine from index at start to index at end with fragment
        try
        {
            String fragment = "abc";    //the string that will replace part of eLine

            boolean isFirstSearch2 = true;//keeps track of if in first search

            //loop through the eLine starting at index 0 to find str
            for (int count = eLine.indexOf(str,0); count >= 0 && count < eLine.stringLength; )
            {
                // if count return -1 at the first search, then str is not in the text line
                //if it's not, exit the program
                if (count == -1 && isFirstSearch2 == true)
                {
                    System.out.println("Fragment not found");
                    System.exit(1);
                }

                //if str is found, print at what index
                System.out.println("occurance at: " + count);
                isFirstSearch = false;  //set to false since first search is finished
                
                //replace str with fragment
                eLine.replace(count, count + str.length()-1, fragment);
                
                //search again at the next index if not at end of string
                if (count + 1 < eLine.stringLength)
                    count = eLine.indexOf(str, count+1);

                //if str is is not in the file past the last time it was found, then end the loop
                if (count == -1 && isFirstSearch == false)
                    break;
            }

            //print out eLine with the replaced parts
            System.out.println("eLine is: " + eLine.toString());
        }
        //if an exception was thrown, print a message and exit
        catch (TextLineIndexOutOfBoundsException e)
        {
            e = new TextLineIndexOutOfBoundsException("Index is out of Bounds");
        }
    }

}
