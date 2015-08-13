
// package proj3
package db;

/************************************************************************************
 * @file LinHash.java
 *
 * @author  John Miller
 * @version 0.9, Thu Aug 19 16:22:50 EDT 2010
 */
import java.io.*;
import java.lang.reflect.Array;
import static java.lang.System.out;
import java.util.*;

/************************************************************************************
 * This class provides hash maps that use the Linear Hashing algorithm.
 * A hash table is created that is an array of buckets.
 */
public class LinHash<K, V>
        extends AbstractMap<K, V>
        implements Serializable, Cloneable, Map<K, V>
{

    /** The number of slots (for key-value pairs) per bucket.
     */
    private static final int SLOTS = 4;
    /** The class for type K.
     */
    private final Class<K> classK;
    /** The class for type V.
     */
    private final Class<V> classV;

    /********************************************************************************
     * This inner class defines buckets that are stored in the hash table.
     */
    private class Bucket
    {

        int nKeys;
        K[] key;
        V[] value;   //reference to tuple
        Bucket next;

        @SuppressWarnings("unchecked")

        Bucket(Bucket n)
        {
            nKeys = 0;
            key = (K[]) Array.newInstance(classK, SLOTS);
            value = (V[]) Array.newInstance(classV, SLOTS);
            next = n;
        } // constructor
    } // Bucket inner class

    /** The list of buckets making up the hash table.
     */
    private final List<Bucket> hTable;
    /** The modulus for low resolution hashing
     */
    private int mod1;
    /** The modulus for high resolution hashing
     */
    private int mod2;
    /** Counter for the number buckets accessed (for performance testing).
     */
    private int count = 0;
    /** The index of the next bucket to split.
     */
    private int split = 0;
    private int keyCount = 0;

    /********************************************************************************
     * Construct a hash table that uses Linear Hashing.
     * @param classK    the class for keys (K)
     * @param classV    the class for keys (V)
     * @param initSize  the initial number of home buckets (a power of 2, e.g., 4)
     */
    public LinHash(Class<K> _classK, Class<V> _classV, int initSize)
    {
        classK = _classK;
        classV = _classV;
        hTable = new ArrayList<Bucket>();
        mod1 = initSize;
        mod2 = 2 * mod1;
    } // LinHash

    /********************************************************************************
     * Return a set containing all the entries as pairs of keys and values.
     * @return  the set view of the map
     */
    public Set<Map.Entry<K, V>> entrySet()
    {
        Set<Map.Entry<K, V>> enSet = new HashSet<Map.Entry<K, V>>();

        //-----------------\\
        for (int i = 0; i < hTable.size(); i++)
        {
            for (Bucket b = hTable.get(i); b != null; b = b.next)
            {
                for (int k = 0; k < b.key.length; k++)
                {
                    if (b.key[k] != null)
                    {
                        enSet.add(new AbstractMap.SimpleEntry<K, V>(b.key[k], b.value[k]));
                    }
                }
            } // for
        } // for
        //---------------------\\

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

        if (i >= hTable.size())
            return null;

        for (Bucket b = hTable.get(i); b != null; b = b.next)
        {
            count++;
            for (int k = 0; k < b.key.length && b.key[k] != null; k++)
            {
                // if (b.key[k] == key)
                if (b.key[k].equals((K) key))
                {
                    return (V) b.value[k];
                }
            }
        } // for

        i = h2(key);
         if (i >= hTable.size())
            return null;

        for (Bucket b = hTable.get(i); b != null; b = b.next)
        {
            count++;
            for (int k = 0; k < b.key.length && b.key[k] != null; k++)
            {
                // if (b.key[k] == key)
                if (b.key[k].equals((K) key))
                {
                    return (V) b.value[k];
                }
            }
        } // for

        return null;
        //---------------------\\
    } // get

    /**
     *
     */
    private void overflow()
    {
        Bucket newBucketAtSplit = new Bucket(null);

        for (Bucket splitMe = hTable.get(split); splitMe != null; splitMe = splitMe.next)
        {
            for (int i = 0; i < SLOTS; i++)
            {
                if (splitMe.key[i] != null)   //can't evaluate key if key is null
                {
                    int h1 = h(splitMe.key[i]);
                    int h2 = h2(splitMe.key[i]);

                    //out.println("h2: " + h2);
                    //out.println("h1: " + h1);

                    if (h1 != h2)   //key moves
                    {
                        checkTableSize(h2);

                        Bucket b = hTable.get(h2);

                        insert(h2, splitMe.key[i], splitMe.value[i], false);

                    }
                    else
                    {
                        insertIntoBucket(newBucketAtSplit, splitMe.key[i], splitMe.value[i]);
                    }
                }//splitMe.key[i]!=null
            }
        }
        hTable.set(split, newBucketAtSplit);
    }

    /*
     * 
     */
    private void checkTableSize(int i)
    {
        if (hTable.size() <= i)
        {
            for (int n = hTable.size(); n <= i; n++)
            {
                hTable.add(new Bucket(null));
            }
        }
    }
    
    private void insertIntoBucket(Bucket b, K key, V value)
    {
        for (int k = 0; k < SLOTS; k++)
        {
            if (b.key[k] == null)
            {
                b.key[k] = key;
                b.value[k] = value;
                b.nKeys++;
                keyCount++;
                break;
            }
            else if(k == SLOTS - 1)
            {
                Bucket newBucket = new Bucket(b);
                newBucket.key[0] = key;
                newBucket.value[0] = value;
                keyCount++;
            }
        }
    }

    /*
     *
     */
    private void insert(int i, K key, V value, boolean overflow)
    {
        Bucket b = hTable.get(i);
        
        for (int k = 0; k < SLOTS; k++)
        {
            if (b.key[k] == null)
            {
                b.key[k] = key;
                b.value[k] = value;
                b.nKeys++;
                keyCount++;
                break;
            }
            else if(k == SLOTS - 1)
            {
                Bucket newBucket = new Bucket(b);
                newBucket.key[0] = key;
                newBucket.value[0] = value;
                keyCount++;
                if (overflow)
                    overflow();
                hTable.set(i, newBucket);
            }
        }
    }

    /********************************************************************************
     * Put the key-value pair in the hash table.
     * @param key    the key to insert
     * @param value  the value to insert
     * @return  null (not the previous value)
     */
    public V put(K key, V value)
    {
        int i = h(key);
        if (i < split)
        {
            i = h2(key);
        }

        checkTableSize(i);

        insert(i, key, value, true);

        if (split >= mod1)
        {
            split = 0;
            mod1 += mod1;
        }

        return null;
    } // put

    /********************************************************************************
     * Put the key-value pair in the hash table.
     * @param key    the key to insert
     * @param value  the value to insert
     * @return  null (not the previous value)
     */
    public V put1(K key, V value)
    {
        int i = h(key);

        if (i < split)
        {
            i = h2(key);
            //out.println("h2(key): " + i);
        }

        //out.println("i: " + i);
        //out.println("split: " + split);
        //out.println("hTable.size(): " + hTable.size());

        //initializing hTable
        if (hTable.size() <= i)
        {
            for (int n = hTable.size(); n <= i; n++)
            {
                hTable.add(new Bucket(null));
            }
        }

        Bucket b = hTable.get(i);
        Bucket bHead = hTable.get(i);

        boolean overflow = false;

        while (b.next != null)
        {
            //out.println("b.next!=null");
            b = b.next;
            //overflow = true;
        }

        for (int k = 0; k < SLOTS; k++)
        {
            if (b.key[k] == null)
            {
                b.key[k] = key;
                b.value[k] = value;
                b.nKeys++;
                keyCount++;
                hTable.set(i, bHead);
                break;
            }
            if (k == SLOTS - 1)
            {
                Bucket newBucket = new Bucket(null);
                newBucket.key[0] = key;
                newBucket.value[0] = value;
                newBucket.nKeys++;
                keyCount++;
                b.next = newBucket;
                overflow = true;
            }
        }

        if (overflow)
        {
            //out.println("OVERFLOW");
            //Bucket newBucket = new Bucket(null);
            //int newBucketCounter = 0;
            Bucket splitBucket = hTable.get(split);
            Bucket replaceSplitBucket = new Bucket(null);
            int replaceSplitCounter = 0;
            //Bucket newBucketHead = newBucket;
            Bucket replaceSplitBucketHead = replaceSplitBucket;


            while (splitBucket != null)
            {
                for (int k = 0; k < splitBucket.key.length && splitBucket.key[k] != null; k++)
                {
                    int h1 = h(splitBucket.key[k]);
                    int h2 = h2(splitBucket.key[k]);

                    if (h1 != h2)   //key moves
                    {
                        //out.println("table.size()=" + hTable.size() );
                        if (h2 >= hTable.size())    //resize table
                        {
                            for (int n = hTable.size(); n <= h2; n++)
                            {
                                hTable.add(new Bucket(null));
                            }
                            Bucket newBucket = new Bucket(null);
                            newBucket.key[0] = splitBucket.key[k];
                            newBucket.value[0] = splitBucket.value[k];
                            hTable.set(h2, newBucket);
                            //out.println("keyCount: " + keyCount);
                            //print();
                        }
                        else //h2 is in table so find and add key
                        {
                            Bucket h2Bucket = hTable.get(h2);
                            Bucket h2BucketHead = hTable.get(h2);

//                            overflow = false;

                            while (h2Bucket.next != null)
                            {
                                //out.println("h2Bucket.next!=null");
                                h2Bucket = h2Bucket.next;
                            }

                            for (int p = 0; p < SLOTS; p++)
                            {
                                if (h2Bucket.key[p] == null)
                                {
                                    h2Bucket.key[p] = splitBucket.key[k];
                                    h2Bucket.value[p] = splitBucket.value[k];
                                    h2Bucket.nKeys++;
                                    //keyCount++;
                                    hTable.set(h2, h2BucketHead);
                                    //print();
                                    break;
                                }
                                if (p == SLOTS - 1)
                                {
                                    Bucket otherNewBucket = new Bucket(null);
                                    otherNewBucket.key[0] = splitBucket.key[k];
                                    otherNewBucket.value[0] = splitBucket.value[k];
                                    otherNewBucket.nKeys++;
                                    //keyCount++;
                                    h2Bucket.next = otherNewBucket;
                                    //   overflow = true;
                                }
                            }
                        }
                    }
                    else    //key is staying put
                    {
                        replaceSplitBucket.key[replaceSplitCounter] = splitBucket.key[k];
                        replaceSplitBucket.value[replaceSplitCounter] = splitBucket.value[k];
                        replaceSplitCounter++;

                        if (replaceSplitCounter == SLOTS)
                        {
                            replaceSplitCounter = 0;
                            Bucket otherNewBucket = new Bucket(null);
                            replaceSplitBucket.next = otherNewBucket;
                            replaceSplitBucket = replaceSplitBucket.next;
                        }
                    }
                }

                splitBucket = splitBucket.next;
            }

            //if ()
            //for (int n = 0; n )
            hTable.set(split, replaceSplitBucketHead);
            replaceSplitBucketHead = null;
            replaceSplitBucket = null;
            //hTable.add(newBucketHead);
            split++;
        }

        if (split == mod1)
        {
            split = 0;
            mod1 += mod1;
        }

        //out.println("keyCount: " + keyCount + ", SLOTS: " + SLOTS + ", size: " + size());
/*
        double load = (keyCount / size());
        //out.println("load: " + load);

        if (load >= 1)
        {
        split = 0;
        }
        //out.println("split: " + split + ", keyCount: " + keyCount);
         */
        return null;
    } // put

    /********************************************************************************
     * Return the size (SLOTS * number of home buckets) of the hash table.
     * @return  the size of the hash table
     */
    public int size()
    {
        return SLOTS * (mod1 + split);
    } // size

    /********************************************************************************
     * Print the hash table.
     */
    private void print()
    {
        out.println("Hash Table (Linear Hashing)");
        out.println("-------------------------------------------");

        for (int i = 0; i < hTable.size(); i++)
        {
            out.print(i + ":\t");

            boolean notFirst = false;

            for (Bucket b = hTable.get(i); b != null; b = b.next)
            {
                if (notFirst)
                {
                    out.print("--> ");
                }
                for (int k = 0; k < b.key.length; k++)
                {
                    if (b.key[k] != null)
                    {
                        out.print("[ " + b.key[k] + /*" - " + b.value[k] +*/ " ]\t");
                    }
                }
                notFirst = true;

            } // for
            out.println();

        } // for
        out.println("-------------------------------------------");

    } // print

    /********************************************************************************
     * Hash the key using the low resolution hash function.
     * @param key  the key to hash
     * @return  the location of the bucket chain containing the key-value pair
     */
    private int h(Object key)
    {
        //out.println("h: " + key.hashCode() % mod1);
        return Math.abs(key.hashCode()) % mod1;
    } // h

    /********************************************************************************
     * Hash the key using the high resolution hash function.
     * @param key  the key to hash
     * @return  the location of the bucket chain containing the key-value pair
     */
    private int h2(Object key)
    {
        //out.println("h2: " + key.hashCode() % mod2);
        return Math.abs(key.hashCode()) % mod2;
    } // h2

    /********************************************************************************
     * The main method used for testing.
     * @param  the command-line arguments (args [0] gives number of keys to insert)
     */
    public static void main(String[] args)
    {
        LinHash<Integer, Integer> ht = new LinHash<Integer, Integer>(Integer.class, Integer.class, 20);
        int nKeys = 500;

        if (args.length == 1)
        {
            nKeys = Integer.valueOf(args[0]);
        }
        for (int i = 1; i < nKeys; i += 2)
        {
            //out.println("Inserting: " + i + ", " + i * i + ", ");
            ht.put(i, i * i);
            //ht.print();
            /*
            for (int n = 0; n < nKeys; n++)
            {
                try
                {
                    if (ht.get(n) != null)
                    {
                        out.println("key = " + n + " value = " + ht.get(n));
                    }
                }
                catch (Exception e)
                {
                    continue;
                }
            } // for*/
        }
/*
        ht.print();
        for (int i = 0; i < nKeys; i++)
        {
            out.println("key = " + i + " value = " + ht.get(i));
        } // for

        out.println("-------------------------------------------");

        out.println("Average number of buckets accessed = " + ht.count / (double) nKeys);
 * 
 */
    } // main
} // LinHash class

