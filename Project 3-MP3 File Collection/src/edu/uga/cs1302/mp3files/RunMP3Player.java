package edu.uga.cs1302.mp3files;
import java.util.Scanner;


// A simple test program for MP3Player
//
public class RunMP3Player {

    public static void main( String[] args ) {

        Scanner   keyboard = null;
	MP3Player player   = new MP3Player();

	if( args.length <= 0 ) {
	    System.err.println( "Usage: java RunMP3Player file.mp3" );
	    System.exit(1);
	}

	String filename = args[0];
	boolean stop = false;
	String  selection = null;
	
	keyboard = new Scanner( System.in );

	// a simple illustration on how to play several songs
	while( !stop ) {

	    // start playing this file
	    player.play( filename );
	    // but wait until it finishes, or is interrupted by the user
	    player.waitForPlaybackFinish();

	    // now, check what to do next
	    System.out.println( "RunMP3Player: Enter 'q' to quit the loop, or any other char to continue" );

	    selection = keyboard.next();
	    if( selection.equals( "q" ) )
		stop = true;
	}
    }
}
