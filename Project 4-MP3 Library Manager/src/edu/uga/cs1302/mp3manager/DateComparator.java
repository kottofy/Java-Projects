package edu.uga.cs1302.mp3manager;

import java.util.Comparator;

/**
 * Comparator class used to compare dates of MP3Files.
 * @author Kristin Ottofy
 */
public class DateComparator implements Comparator<MP3File>
{
    /**
     * Compare dates of MP3Files o1 and o2.
     * It is public to it can be called from other classes.
     * @param o1    MP3File to compare to o2
     * @param o2    MP3File to compare to o1
     * @return      -1 if o1 is less than o2, 0 is o1 is equal to o2, or 1 if o1 is greater than o2
     */
    public int compare(MP3File o1, MP3File o2)
    {
        if (o1.getYear() < o2.getYear())
            return -1;
        else if (o1.getYear() == o2.getYear())
            return 0;
        else
            return 1;
    }
}
