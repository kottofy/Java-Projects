package edu.uga.cs1302.mp3manager;

import java.util.Comparator;

/**
 * Comparator class used to compare albums of MP3Files.
 * @author Kristin Ottofy
 */
public class AlbumComparator implements Comparator<MP3File>
{
    /**
     * Compare albums of MP3Files o1 and o2.
     * It is public to it can be called from other classes.
     * @param o1    MP3File to compare to o2
     * @param o2    MP3File to compare to o1
     * @return      -1 if o1 is less than o2, 0 is o1 is equal to o2, or 1 if o1 is greater than o2
     */
    public int compare(MP3File o1, MP3File o2)
    {
        return o1.getAlbum().compareTo(o2.getAlbum());
    }
}
