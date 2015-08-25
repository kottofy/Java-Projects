package edu.uga.cs1302.mp3files;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Map;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFileFormat;

/**
 * A simple class to access and print out some basic tags of an mp3 file
 *
 */
public class PrintMP3Properties {
    public static void main(String[] args) {
	try {
	    FileInputStream fis        = new FileInputStream( args[0] );
	    BufferedInputStream bis    = new BufferedInputStream(fis);
	    AudioFileFormat mpegFormat = AudioSystem.getAudioFileFormat(bis);
	    Map properties             = mpegFormat.properties();

	    System.out.println( "Information about: " + args[0] );
	    System.out.println( "-------------------------- " );
	    System.out.println( "Author: " + (String) properties.get( "author" ) );
	    System.out.println( "Album:  " + (String) properties.get( "album" ) );
	    System.out.println( "Title:  " + (String) properties.get( "title" ) );
	    System.out.println( "Date:   " + (String) properties.get( "date" ) );
        }
        catch( ArrayIndexOutOfBoundsException oobe ) {
            System.err.println( "Usage: java PrintMP3Properties file.mp3" );
        }
        catch( Exception e ) {
            System.out.println(e);
        }
    }

}
