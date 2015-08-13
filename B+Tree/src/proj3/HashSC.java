
package proj3;

/************************************************************************************
 * @file HashSC.java
 *
 * @author  John Miller
 * @version 0.9, Thu Aug 19 16:22:50 EDT 2010
 */
import java.io.*;
import java.lang.reflect.Array;
import static java.lang.System.out;
import java.util.*;

/************************************************************************************
 * This class provides hash maps that use the hashing with separate chaining algorithm.
 * A hash table is created that is an array of buckets.  It restricts the number of
 * slots per bucket to one (just one key-value pair), but could easily be extended
 * to support multiple key-value pairs per bucket.
 */
public class HashSC<K, V>
        extends AbstractMap<K, V>
        implements Serializable, Cloneable, Map<K, V>
{

    /********************************************************************************
     * This inner class defines buckets that are stored in the hash table.
     */
    private class Bucket
    {

        K key;       // alt. use K [] instead of K
        V value;     // alt. use V [] instead of V
        Bucket next;

        Bucket(K k, V v, Bucket n)
        {
            key = k;
            value = v;
            next = n;
        }
    } // Bucket inner class

    /** The array of buckets making up the hash table.
     */
    private final Bucket[] hTable;
    /** The size of the hash table (number of home buckets)
     */
    private final int size;
    /** Counter for the number buckets accessed (for performance testing)
     */
    private int count = 0;

    /********************************************************************************
     * Construct a hash table that uses separate chaining.
     * @param cap  the capacity of the hash table
     */
    @SuppressWarnings("unchecked")
    public HashSC(int cap)
    {
        hTable = (Bucket[]) Array.newInstance(Bucket.class, size = cap);
    } // HashSC

    /********************************************************************************
     * Return a set view of map containing all the entries as pairs of keys and values.
     * @return  the set view of the map
     */
    public Set<Map.Entry<K, V>> entrySet()
    {
        Set<Map.Entry<K, V>> enSet = new HashSet<Map.Entry<K, V>>();
        for (int i = 0; i < size; i++)
        {
            for (Bucket b = hTable[i]; b != null; b = b.next)
            {
                enSet.add(new AbstractMap.SimpleEntry<K, V>(b.key, b.value));
            } // for
        } // for

        return enSet;
    } // entrySet

    /********************************************************************************
     * Given the key, look up the value in the hash table.
     * @param key  the key used for look up
     * @return  the value associated with the key
     */
    public V get(Object key)
    {
        int i = h(key);
        for (Bucket b = hTable[i]; b != null; b = b.next)
        {
            count++;
            if (b.key.equals((K) key))
            {
                return b.value;   //should be b.key.equals((K)key)
            }
        } // for
        return null;
    } // get

    /********************************************************************************
     * Put the key-value pair in the hash table.
     * @param key    the key to insert
     * @param value  the value to insert
     * @return  null (not the previous value)
     */
    public V put(K key, V value)
    {
        int i = h(key);
        hTable[i] = new Bucket(key, value, hTable[i]);
        return null;
    } // put

    /********************************************************************************
     * Return the size (number of home buckets) in the hash table.
     * @return  the size of the hash table
     */
    public int size()
    {
        return size;
    } // size

    /********************************************************************************
     * Print the hash table.
     */
    private void print()
    {
        out.println("Hash Table (hashing with separate chaining)");
        out.println("-------------------------------------------");
        for (int i = 0; i < size; i++)
        {
            out.print(i + ":\t");
            boolean notFirst = false;
            for (Bucket b = hTable[i]; b != null; b = b.next)
            {
                if (notFirst)
                {
                    out.print("--> ");
                }
                out.print("[ " + b.key + " ]\t");
                notFirst = true;
            } // for
            out.println();
        } // for
        out.println("-------------------------------------------");
    } // print

    /********************************************************************************
     * Hash the key using the hash function.
     * @param key  the key to hash
     * @return  the location of the bucket chain containing the key-value pair
     */
    private int h(Object key)
    {
        out.println("h = " + key.hashCode() % size);
        return key.hashCode() % size;
    } // h

    /********************************************************************************
     * The main method used for testing.
     * @param  the command-line arguments (args [0] gives number of keys to insert)
     */
    public static void main(String[] args)
    {
        HashSC<Integer, Integer> ht = new HashSC<Integer, Integer>(11);
        int nKeys = 30;

        if (args.length == 1)
        {
            nKeys = Integer.valueOf(args[0]);
        }

        for (int i = 1; i < nKeys; i += 2)
        {
            int n = i*i;
            out.println("ht.put(" + i + ", " + n + ")");
            ht.put(i, i * i);
        }
        
        ht.print();

        for (int i = 0; i < nKeys; i++)
        {
            out.println("key = " + i + " value = " + ht.get(i));
        } // for

        out.println("-------------------------------------------");
        out.println("Average number of buckets accessed = " + ht.count / (double) nKeys);
    } // main
} // HashSC class

