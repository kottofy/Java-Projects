
package proj3;


import java.util.*;

public class HashLP extends AbstractCollection
                    implements Collection
{
    private static final int EMPTY   = -1;
    private static final int DELETED = -2;

    class Bucket
    {
        int key;
        Bucket () { key = EMPTY; };
    } // Bucket inner class

    private final Bucket [] table;
    private final int       size;
    private       int       count;

    public HashLP (int s)
    {
        table = new Bucket [size = s];
        for (int i = 0; i < size; i++) table [i] = new Bucket ();
        count = 0;
    } // HashLP

    private int h (int key)
    {
        return key % size;
    } // h

    public int size ()
    {
        return size;
    } // size

    public Iterator iterator ()
    {
        throw new UnsupportedOperationException ();
    } // iterator

    public boolean add (int key)
    {
        final int i = h (key);
        int       j = i;
        int       key_j;
        do {
            key_j = table [j].key;
            if (key_j == EMPTY || key_j == DELETED) {
                table [j].key = key;
                return true;
            }; // if
            j = (j + 1) % size;
        } while (j != i);
        return false;
    } // add

    public boolean contains (int key)
    {
        final int i = h (key);
        int       j = i;
        int       key_j;
        do {
            count++;
            key_j = table [j].key;
            if (key_j == EMPTY) return false;
            if (key_j == key)   return true;
            j = (j + 1) % size;
        } while (j != i);
        return false;
    } // contains

    private void print ()
    {
        for (int i = 0; i < size; i++) {
            System.out.print ("@" + i + "\t[ ");
            System.out.print (table [i].key + " ");
            System.out.println ("]");
        }; // for
    } // print

    public static void main (String [] args)
    {
        HashLP ht = new HashLP (11);
        for (int i = 1; i < 20; i += 2) ht.add (i);
        ht.print ();
        for (int i = 0; i < 20; i++) {
            System.out.println ("is " + i + " in: " + ht.contains (i));
        }; // for
        System.out.println ("Number of probes = " + ht.count);
    } // main

} // HashLP class
