package edu.uga.cs1302.mp3manager;

import java.util.Scanner;
import java.io.File;

/**
 *  MyMP3Files holds the main method for this program.
 * @author Kristin Ottofy
 * Date: July 15, 2010
 * Program Name: MP3 File Collection
 */
public class MyMP3Files {

    /**
     * Main method: prompts the user to enter a directory that holds MP3 Files,
     * creates a list of MP3Files in that directory, and allows the user to
     * iterate through the directory. The user can play the current file,
     * select the next song, select the previous song, or get information about
     * the selected song. The user can also get a help menu or quit the program.
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);  //new Scanner object scan
        String directoryName;   //the name of the directory that holds the MP3s
        File directoryFile = null;     //the directory that holds the MP3s
        File[] files;           //array that will contain MP3 files
        LinkedList<Object>  list = new LinkedList<Object>();    //list that will hold the MP3File Objects
        java.util.ListIterator<Object> iter;  //iterator for list of MP3Files
        String input = "n";     //will be the action the user chooses to perform on the mp3 files
        int index = 0;          //index will help iterate through the list of files

        do
        {
            System.out.println("Please enter a valid directory name:"); //ask user for directory name
            directoryName = scan.nextLine();  //store the input in directoryName
            try
            {
                //create a new File for the directory
                directoryFile = new File(directoryName);
            }
            catch (Exception e)
            {
                continue;
            }
        }
        while (!directoryFile.exists());

        //store the MP3s in the directory in the array files
        files = directoryFile.listFiles();

        //create an MP3File for each MP3 and add to the list
        for (int i = 0; i < files.length; i++)
        {
            //check that the file is an MP3 file
            if (files[i].toString().endsWith(".mp3"));
            {
                //create a new MP3File for each mp3 file
                MP3File mp3file = new MP3File(files[i].toString());

                //add the MP3File to the list
                list.add(mp3file);
            }
        }

        //loop through the files and print information about each one
        //in the order they appear in the directory
        for (iter = list.listIterator();iter.hasNext();)
            System.out.println(iter.next().toString());

        //Loop until the user enters 'q' to quit
        while (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("b") ||
                input.equalsIgnoreCase("i") || input.equalsIgnoreCase("p") ||
                input.equalsIgnoreCase("h"))
        {
            //since the iter can be moved throughout the loop, reset the iter
            //at beginning of each loop to the correct index to print the current song
              if (index > 0)    //if iter is > 0
              {
                    iter = list.listIterator(index);            //move iter to the node at index
                    System.out.println("Current song:");
                    System.out.println(iter.next().toString()); //print information about current song
              }
              else  //if index is 0
              {
                    iter = list.listIterator(1);                    //set iter to node at index 1
                    System.out.println("Current song:");
                    System.out.println(iter.previous().toString()); //print information for previos node (at index 0)
              }

           do   //ask for input and check that it is valid, else continue asking
            {
                System.out.println("Please enter 'n', 'b', 'i', 'p', 'h', or 'q'");
                input = scan.nextLine();
            }
             while (input.length() != 1 || !input.equalsIgnoreCase("n") &&
                    !input.equalsIgnoreCase("b") && !input.equalsIgnoreCase("i") &&
                    !input.equalsIgnoreCase("p") && !input.equalsIgnoreCase("h")&&
                    !input.equalsIgnoreCase("q"));

          if (input.equalsIgnoreCase("n")) //move to the next file
            {
              if (iter.hasNext())         //check if the next file is available
              {
                  iter.next();  //move iter to the next node
                  index++;      //increment index since iter has moved to the next node.
              }
              else  //if there is not a next node
              {
                  System.out.println("End of the list.");
                  index = list.size()-1;    //set index to index of node at top of the list
              }
            }

          else if (input.equalsIgnoreCase("b")) //move to the previous file
            {
                if (iter.hasPrevious())         //check if the next file is available
                {
                    iter.previous();    //move iter to previous node
                    index--;            //decrease index since iter moved to previous node
                }
                else    //if there is not a previous node
                {
                    System.out.println("Top of the list.");
                    index = 0;  //set index to the first node
                }
            }

          else if (input.equalsIgnoreCase("i")) //print info of current file
            {
              if (index > 0)    //if iter has a previous node
              {
                    iter.previous();    //go back to the previous node
                    System.out.println(iter.next().toString()); //print the info of the next node (current)
              }
              else // if iter is a the first node
              {
                    iter.next();    //set iter to the next node
                    System.out.println(iter.previous().toString()); //print the info of the previus node (current)
              }
            }

          else if (input.equalsIgnoreCase("p")) //play the current file
            {
              MP3File mp3file;  //create a temporary MP3File
                if (index > 0)  //if iter has a previous node
                {
                    iter.previous();                //move iter to previous song
                    mp3file = (MP3File)iter.next(); //set the MP3File to the next iter
                }
                else    //if iter doesn't have a previous node
                {
                    iter = list.listIterator(1);        //change the position of iter to 1
                    mp3file = (MP3File)iter.previous(); //set the MP3File to the previous iter
                }
                mp3file.play(); //play the current song
            }

          else if (input.equalsIgnoreCase("h")) //print a help screen
            {
                System.out.println("Enter 'n' to select the next song");
                System.out.println("Enter 'b' to select the previous song");
                System.out.println("Enter 'i' to see information about the selected song");
                System.out.println("Enter 'p' to play the selected song");
                System.out.println("Enter 'q' to quit the program");
            }
          else if (input.equalsIgnoreCase("q")) //quit the program
            {
                System.out.println("Goodbye!");
                System.exit(0); //exit
            }
        }
    }
}
