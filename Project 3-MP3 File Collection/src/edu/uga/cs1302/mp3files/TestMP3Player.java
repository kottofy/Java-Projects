package edu.uga.cs1302.mp3files;
// A simple test program for MP3Player
//
public class TestMP3Player {

    public static void main( String[] args ) {

	MP3Player player = new MP3Player();

	try {
          String filename = args[0];
	  player.play( filename );
	  player.waitForPlaybackFinish();
        }
        catch( Exception e ) {
          System.err.println( "Usage: java TestMP3Player file.mp3" );
        }
    }
}
