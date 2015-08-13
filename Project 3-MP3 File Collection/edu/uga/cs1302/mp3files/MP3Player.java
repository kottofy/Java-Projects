package edu.uga.cs1302.mp3files;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

/**
 * A simple class to play mp3 files
 *
 */
public class MP3Player {

    private boolean stopped = false;

    // forward references to inner classes
    MP3Thread playerThread = null;

    MP3Controller playerController = null;

    /**
     *  an inner class to play an mp3 file inside a Java thread
     *
     */
    private class MP3Thread
	extends Thread
    {
	private String mp3filename;
	private Player player; 

	public MP3Thread(String filename) {
	    super( "Playing " + filename );
	    mp3filename = filename;
	}

	public void close() {
	    if (player != null) 
		player.close(); 
	}

	public void run() {
	    try {
		FileInputStream     fis = new FileInputStream(mp3filename);
		BufferedInputStream bis = new BufferedInputStream(fis);

		player = new Player(bis);
		player.play(); 
		if( !stopped )
		  System.out.println( "MP3Player: playbak finished; press the return key to continue" );
	    }
	    catch (Exception e) {
		System.err.println(e);
		System.err.println( "MP3Player: Cannot play: " + mp3filename);
		System.out.println( "MP3Player: press the return key to continue" );
	    }
	}
    }


    /**
     * an inner class to control (stop) the playback of an mp3 file
     *
     */
    private class MP3Controller
	extends Thread
    {
    	public void run() {
            char ch;
	    try {
	       System.out.println( "MP3Player: press the return key at any time to quit playback" );
	       ch = (char) System.in.read();
	       stopped = true;
	       playerThread.close();
	    }
	    catch (Exception e) {
		System.err.println(e);
	    }
        }
    }

    // Play a given file
    //
    public void play( String filename ) {
	stopped = false;
	playerThread = new MP3Thread( filename );
	playerThread.start();
	System.out.println( "MP3Player: file " + filename + " is playing" );
	playerController = new MP3Controller();
	playerController.start();
    }

    // Wait until the currently running file finishes, or is interrupted
    //
    public void waitForPlaybackFinish() {
	try {
	    playerController.join();
	}
	catch( InterruptedException ie ) {}
    }

}

	
