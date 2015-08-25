package edu.uga.cs1302.txtbuff;

/**
 * The interface Editable holds the methods append, insert, and replace.
 * @author Kristin Ottofy
 */
public interface Editable {

    /**
     * Append will be assigned to add a string fragment to the end of _TextLine
     * @param fragment  the string to add at the end of _TextLine
     */
    public void append(String fragment);

    /**
     * Insert will be assigned to insert string fragment at index 0
     * @param index     the index at which to insert the fragment
     * @param fragment  the fragment that will be inserted at index
     */
    public void insert(int index, String fragment);
    /**
     * Replace will replace from a starting index to an ending index with
     * the string fragment
     * @param start     where to start replacing
     * @param end       where to end replacing
     * @param fragment  string to insert at start index
     */
    public void replace(int start, int end, String fragment);

}
