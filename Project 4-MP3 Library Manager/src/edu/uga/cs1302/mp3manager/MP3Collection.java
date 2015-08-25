package edu.uga.cs1302.mp3manager;

import java.util.Comparator;
import java.util.Scanner;
import java.io.File;

/**
 * MP3Collection created the collection of MP3Files and the array for the sort
 * method and binarySearch method.
 * @author Kristin Ottofy
 */
public class MP3Collection
{
    Scanner scan = new Scanner(System.in);
    private MP3File[] array;            //array to hold the MP3Files
    private int size = 0;               //holds the size of the list
    private LinkedList<MP3File>  list;  //list to hold the mP3Files

    /**
     * Create an empty collection.
     * It is public so it can be used in other classes.
     */
    public MP3Collection()
    {
        list = new LinkedList<MP3File>();
    }

    /**
     * Create a collection containing files in the specified directory.
     * The collection should include only files with the .mp3 extension.
     * @param directoryPathname the directory to obtain the MP3Files from
     */
    public MP3Collection(String directoryPathname)
    {
        this(); // initialize an empty list

        File directoryFile = new File(directoryPathname);    //the directory that holds the MP3s
        File[] files;           //array that will contain MP3 files

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
                size++;
            }
        }

        //create a temporary array to hold the Object array returned form the method toArray
        Object[] temp = list.toArray();

        array = new MP3File[list.size()];   //initialize the array

        //loop through the array and cast each node from the temp array
        for (int i = 0; i < list.size(); i++)
        {
            array[i] = (MP3File)((DLNode) temp[i]).getElement();
        }
    }

    /**
     * Sort the collection according to the given comparator. 
     * Calls the quickSort method.
     * It is public so it can be called from other classes.
     * @param comp  The Comparator needed to do the comparison
     */
	public void sort(Comparator comp) 
    {
        quickSort( 0, size-1, comp);
    }

    /**
     * Sort the collection using the quickSort method.
     * @param first where to start the sort from the left
     * @param last  where to start the sort from the right
     * @param comp  appropriate Comparator needed to do the comparison
     */
    private void quickSort( int first,  int last, Comparator comp ) 
    {
        //while the scanners haven't crossed
        if ( first >= last )   // base case
            return;

        //hold the pivot position from the partition
        int pivotPosition = partition( comp, first, last );

        // recursive case: sort left partition
        quickSort( first, pivotPosition-1 , comp);

        // recursive case: sort right partition
        quickSort( pivotPosition+1, last, comp );
      }

    /**
     * Partition the array for the quick sort method.
     * @param comp  appropriate Comparator needed to do the comparison
     * @param first first where to start the sort from the left
     * @param last  where to start the sort from the right
     * @return  the partitioned value
     */
    private int partition(Comparator comp, int first, int last)
    {
        MP3File pivot = array[first];   //temp MP3File to hold the element at the pivot
        int pivotPosition = first;
        first++;

        while (first <= last)   //while the scanners haven't crossed
        {
            while ((first <= last) && (comp.compare(array[first], pivot) < 0)) // scan right
            {
                first++;
            }
            while ((last >= first) && (comp.compare(array[last], pivot) >= 0 )) // scan left
            {
                last--;
            }

            if (first > last)   //if the scanners have crossed
            {
                //swap the pivot with the value in the left scanner position
                swap(pivotPosition, last);
            }
            else    //if the scanners haven't crossed
            {
                //swap the values at the right and left scanner positions
                swap(first, last);
            }
        }
        return last;
    }

    /**
     * Swap the files in the array.
     * It is private because it is only accessed in this class.
     * @param a index at which to swap with b
     * @param b index at which to swap with a
     */
      private void swap(int a, int b)
      {
        MP3File temp = array[a];    //temp MP3File to hold the file at index a
        array[a] = array[b];        //swap a with b
        array[b] = temp;            //set b with the temp file
      }

    /**
     * Search for a given mp3 file, using the given comparator.
     * Return the index of the file in the collection or -1 if
     * not found. The collection must be sorted using the same
     * comparator.
     * It is public so it can be called from other classes.
     * @param file  MP3File to search for
     * @param comp  appropriate Comparator needed to do the comparison
     * @return  the index of the file if found in the collection, or -1 if not found
     */
    public int binarySearch(MP3File file, Comparator comp)
    {
        return binarySearch(comp, 0, size-1, file);
    }

    /**
     * Recursively use a binary search method to search for an MP3File.
     * It is private because it is only accessed in this class.
     * @param comp  appropriate Comparator needed to do the comparison
     * @param first where to begin the scan from the left
     * @param last  where to beginf the scan from the right
     * @param file  the file to search for
     * @return -1 if file not found or the index of the file if found
     */
    private int binarySearch( Comparator comp, int first, int last, MP3File file ){

         if ( first > last )
            return -1;            //  Base case - failure

         if ( ( first < 0 ) || ( first >= size ) ||
              ( last < 0 ) || ( last >= size ) )
            return -1;  //if index is out of bounds

         int mid = ( first + last ) / 2;            //hold the search point
         if ( comp.compare(array[mid], file) == 0)  //compare the file at the search point with the desired file to find
            return mid;       // Base case - success

         // recursive cases
         if ( comp.compare(array[mid], file) < 0 )  //determine if the file is to the left of the search point or the right
            return binarySearch( comp, mid + 1, last, file );   //call the method scan left
         else
            return binarySearch( comp, first, mid - 1, file );  //call the method again to scan right
}

    /**
     * Return the size of the collection.
     * It is public so it can be called from other classes.
     * @return the size of the collection
     */
    public int size()
    {
        return size;
    }

    /**
     * Return an MP3File at the given index position in the
     * collection. Throw an IndexOutOfBoundsException exception
     * if the index value is out of bounds.
     * It is public so it can be called from other classes.
     * @param index where to look for the MP3File
     * @return      the MP3File at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index is out of bounds
     */
    public MP3File getFile(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index > size-1)
            throw new IndexOutOfBoundsException();
        return array[index];
    }

    /**
     * Start playing a file at a given index position. Throw an
     * IndexOutOfBoundsException exception if the index value is
     * out of bounds.
     * It is public so it can be called from other classes.
     * @param index
     * @throws java.lang.IndexOutOfBoundsException
     */
    public void play(int index) throws IndexOutOfBoundsException
    {
        boolean stop = false;       //flag for if the user wants to quit
        String  selection = null;   //will hold the selection of the user
        MP3Player player   = new MP3Player();       //new MP3Player
        String filename = array[index].getPath();  //name of the file to play

        while( !stop )  //while the user doesn't want to quit playback
        {
            // start playing this file
            player.play( filename );
            // but wait until it finishes, or is interrupted by the user
            player.waitForPlaybackFinish();

            // now, check what to do next
            System.out.println( "RunMP3Player: Enter 'q' to quit the loop, or any other char to continue" );

            selection = scan.next();    //wait for next selection
            if( selection.equals( "q" ) )   //quit if user chooses q
            stop = true;
        }
    }
}
