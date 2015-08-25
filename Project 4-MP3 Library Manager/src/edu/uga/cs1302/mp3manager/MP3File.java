package edu.uga.cs1302.mp3manager;

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Map;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFileFormat;

/**
 * MP3File creates the MP3File objects for this program.
 * @author Kristin Ottofy
 * Last Edit: July 28, 2010
 * Program Name: MP3 File Collection
 */
public class MP3File {

    /**
     * path will hold the path to the MP3File.
     * It is private because it is only needed in this class.
     */
    private String path;

    /**
     *  author will hold the author of the MP3File.
     *  It is private because it is only needed in this class.
     */
    private String author;

    /**
     *  album will hold the album name of the MP3File.
     *  It is private because it is only needed in this class.
     */
    private String album;

    /**
     *  title will hold the name of the title of the MP3File.
     *  It is private because it is only needed in this class.
     */
    private String title;

    /**
     *  date will hold the date of the MP3File.
     *  It is private because it is only needed in this class.
     */
    private String date;

    /**
     * Initialize MP3File Objects by setting the attributes to empty.
     * It is public so it can be accessed in other classes.
     */
    public MP3File()
    {
        setPath("");
        setAuthor("");
        setAlbum("");
        setTitle("");
        setDate("");
    }

    /**
     * Create MP3File with suitable values extracted from the existing file.
     * @param pathname  the path of the mp3 file.
     */
    public MP3File(String pathname)
    {
        try //try to get properties of the MP3 File
        {
            //create new FileInputStream
            FileInputStream fis        = new FileInputStream( pathname );
            //create new BufferedInputStream
            BufferedInputStream bis    = new BufferedInputStream(fis);
            //get the audio file format
            AudioFileFormat mpegFormat = AudioSystem.getAudioFileFormat(bis);
            //map the properties of the MP3 File
            Map properties = mpegFormat.properties();

            setPath(pathname);  //set the path
            setAuthor((String) properties.get( "author" )); //set the author
            setAlbum((String) properties.get( "album" ));   //set the album
            setDate((String) properties.get( "date" ));     //set the date
            setTitle((String) properties.get( "title" ));   //set the title

            //if the tags are null, display "Unknown" or "1900" for date
            if(getAuthor() == null)
                setAuthor("Unknown");
            if(getTitle() == null)
                setTitle("Unknown");
            if(getAlbum() == null)
                setAlbum("Unknown");
            if (getDate() == null)
                setDate("1900");
        }
        catch( Exception e )    //catch the exception if thrown
        {
            //print where the exception is thrown to and the exception
            System.out.println("MP3File.java: " + e);
        }
    }

    /**
     * Return a string of the pathname.
     * It is public so it can be used in other classes.
     * @return  a string of the path.
     */
    public String getPath()
    {
        return path;
    }

    /**
     * Set the path of the MP3File.
     * It is public so it can be used in other classes.
     * @param pathname  a string to set the path to.
     */
    public void setPath(String pathname)
    {
        path = pathname;
    }

    /**
     * Return a string of the author of the MP3File.
     * It is public so it can be used in other classes.
     * @return  a string of the author of the MP3File.
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Set the author of the MP3File.
     * It is public so it can be used in other classes.
     * @param author    a string to set the name of the author to.
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }

    /**
     * Return the name of the album of the MP3File.
     * It is public so it can be used in other classes.
     * @return  a string of the name of the album
     */
    public String getAlbum()
    {
        return album;
    }

    /**
     * Set the name of the album of the MP3File.
     * It is public so it can be used in other classes.
     * @param album a string to set the album name to.
     */
    public void setAlbum(String album)
    {
        this.album = album;
    }

    /**
     * Return the date of the MP3File.
     * It is public so it can be used in other classes.
     * @return  a string of the date of the MP3File.
     */
    public String getDate()
    {
        return date;
    }

    /**
     * Set the date of the MP3File.
     * It is public so it can be used in other classes.
     * @param date  a string to the set the date of the MP3File to.
     */
    public void setDate(String date)
    {
        this.date = date;
    }

    /**
     * Return the title of an MP3File.
     * It is public so it can be used in other classes.
     * @return  a string of the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Set the title of the MP3File.
     * It is public so it can be used in other classes.
     * @param   a string to set the title of the MP3File to.
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Set the Year of the MP3File.
     * It is public so it can be used in other classes.
     * @return an int of the date
     */
    public int getYear()
    {
        int year = Integer.parseInt(date);
        return year;
    }

    /**
     * Set the Year of the MP3File.
     * It is public so it can be used in other classes.
     * @param year the number to set the date to. If year is null, set date to "1900"
     */
	private void setYear(int year)
    {
        String yearString = Integer.toString(year);
        if (yearString == null)
            date = "1900";
        else
            date = yearString;
    }

    /**
     * toString() displays all the tags about an MP3File.
     * It is public so it can be accessed in other classes.
     * @return  a string of information about the MP3File
     */
    public String toString()
    {
        return "Information about: " + getPath() + "\nAuthor: " +
                getAuthor() + "\nTitle: " + getTitle() +
                "\nDate: " + getDate() + "\nAlbum: " + getAlbum();
    }

    /**
     * Compare 2 Objects.
     * It is public so it can be accessed by other classes.
     * @param e Object to compare to.
     * @return  true if the objects are equal, false if they are not equal.
     */
    public boolean equals(Object e)
    {
        if (e instanceof MP3File)
            return true;
        else
            return false;
    }

    /**
     * Play song through sound card on system.
     * It is public so it can be accessed by other classes.
     */
    public void play()
    {
        boolean stop = false;       //flag for if the user wants to quit
        String  selection = null;   //will hold the selection of the user
        MP3Player player   = new MP3Player();       //new MP3Player
        Scanner keyboard = new Scanner( System.in );//new Scanner instance
        String filename = getPath();    //name of the file to play

        while( !stop )  //while the user doesn't want to quit playback
        {
            // start playing this file
            player.play( filename );
            // but wait until it finishes, or is interrupted by the user
            player.waitForPlaybackFinish();

            // now, check what to do next
            System.out.println( "RunMP3Player: Enter 'q' to quit the loop, or any other char to continue" );

            selection = keyboard.next();    //wait for next selection
            if( selection.equals( "q" ) )   //quit if user chooses q
            stop = true;
        }
    }
}
