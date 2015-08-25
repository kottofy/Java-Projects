package edu.uga.cs1302.mp3manager;

import java.util.Scanner;
import java.io.File;
import java.util.Comparator;

/**
 * MP3CollectionManager manages the collection of MP3Files
 * @author Kristin Ottofy
 * Date: July 28, 2010
 */
public class MP3CollectionManager {

    /**
     * Main method interacts with the user and holds the collection of MP3Files.
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String[] input;             //used to hold the user's input
        String directoryName;       //used to hold the name of the directory to open
        MP3Collection collection;   //used to hold the collection of MP3Files
        File directoryFile = null;  //the directory that holds the MP3s
        Comparator dateComp = new DateComparator();     //Date Comparator
        Comparator albumComp = new AlbumComparator();   //Album Comparator
        Comparator authorComp = new AuthorComparator(); //Author Comparator
        Comparator titleComp = new TitleComparator();   //Title Comparator
        int index = 0;      //holds the index in the collection

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
        while (!directoryFile.exists());    //while the directory file is existent

        collection = new MP3Collection(directoryName);  //initialize the collection

        collection.sort(titleComp); //sort the collection by title

        do  //start while loop
        {
            System.out.println("Please enter a command (Type \"help\" for a menu): ");
            input = scan.nextLine().split(" ");     //split the input into a String array

            if (input[0].equalsIgnoreCase("help"))  //print a help menu
            {
                System.out.println("Type \"list\" to list the current mp3 file.");
                System.out.println("Type \"next \" followed by a number to advance forward to the next number of mp3 files.");
                System.out.println("Type \"prev\" followed by a number to advance backward to the previous number of mp3 files.");
                System.out.println("Yype \"play\" to play the current mp3 file.");
                System.out.println("Type \"sort\" followed by [author|date|album|title] to sort the mp3 files.");
            }
            else if (input[0].equalsIgnoreCase("list")) //list some of the MP3Files
            {
                MP3File prevmp3, nextmp3, currentmp3;   //temporary MP3Files
                currentmp3 = collection.getFile(index); //set temp current MP3File to current file in collection

                if (index - 1 >= 0) //if the previous index is not less than 0
                {
                    prevmp3 = collection.getFile(index-1);  //set temp previous MP3File to the file at index-1
                    System.out.println("\nPrevious MP3:");
                    System.out.println(prevmp3.toString()); //print the previous MP3File
                }
                else
                    System.out.println("Top of the list");   //if the previous index is less than 0

                System.out.println("\nCurrent MP3:");
                System.out.println(currentmp3.toString());  //print the current MP3File

                if (index + 1 < collection.size())  //if the next index is less than the size os the collection
                {
                    nextmp3 = collection.getFile(index+1);  //set the temp next MP3File to the file at index +1
                    System.out.println("\nNext MP3:");
                    System.out.println(nextmp3.toString()); //print the next MP3File
                }
                else
                    System.out.println("End of the list");  //if the next index is out of bounds
            }

            
            else if (input[0].equalsIgnoreCase("next")) //move to the next MP3File
            {
                int nextBy;  //holds the input of how many files to move forward
                if (input.length < 2)
                    nextBy = 1;     //default is 1
                else
                    nextBy = Integer.parseInt(input[1]);  //set nextBy to input

                if (index + nextBy < collection.size())    //check if the desired file exits
                    index = index + nextBy;     //if it does, set index to the desired index
            }

            else if (input[0].equalsIgnoreCase("prev")) //mpve to the previous MP3File
            {
                int prevBy; //holds the input of how many files to move backward
                if (input.length < 2)
                    prevBy = 1;     //default index to move by is 1 if not given input
                else
                    prevBy = Integer.parseInt(input[1]);    //hold the input

                //check if the desired file exits
                if (index - prevBy >= 0)
                    index = index - prevBy; //if it does, set index to the desired index
            }

            else if (input[0].equalsIgnoreCase("play")) //play the current MP3File
            {
                collection.play(index);
            }

            else if (input[0].equalsIgnoreCase("info")) //display the info of the current MP3File
            {
                MP3File mp3file = collection.getFile(index);    //create a temp MP3File to hold current element
                System.out.println(mp3file.toString());
            }

            else if (input[0].equalsIgnoreCase("sort")) //sort the collection
            {
                String sortBy;  //holds the inputted method to sort by

                if (input[1] == null)
                    continue;   //if not input mentioned, continue with the loop
                else
                {
                     sortBy=input[1];
                     //if the input does not match an acceptable sort method, continue with the loop
                     if (!sortBy.equalsIgnoreCase("album") && !sortBy.equalsIgnoreCase("author") && !sortBy.equalsIgnoreCase("title") && !sortBy.equalsIgnoreCase("date"))
                        continue;
                }

                //hold a temp mp3file to search for it after the sort
                MP3File mp3file = collection.getFile(index);

                //call the sort method with the appropriate Comparator
                if (sortBy.equalsIgnoreCase("album"))
                    collection.sort(albumComp);
                else if (sortBy.equalsIgnoreCase("author"))
                    collection.sort(authorComp);
                else if (sortBy.equalsIgnoreCase("title"))
                    collection.sort(titleComp);
                else
                    collection.sort(dateComp);

                for (int i = 0; i < collection.size(); i++)
                {
                    if (((collection.getFile(i)).toString()).compareTo(mp3file.toString()) == 0)
                    {
                        index = i;
                        break;
                    }
                }
            }
        } while (!input[0].equalsIgnoreCase("q"));  //while user does not want to quit

        if (input[0].equalsIgnoreCase("q")) //if user does want to quit
             System.exit(0);    //exit
    }   //end main method
}
