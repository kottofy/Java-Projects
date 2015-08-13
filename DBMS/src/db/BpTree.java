  package db;
/************************************************************************************
 * @file BpTree.java
 *
 * @author  John Miller
 * @version 0.9, Thu Aug 19 16:22:50 EDT 2010
 */

import java.io.*;
import java.lang.reflect.Array;
import static java.lang.System.out;
import java.util.*;

/************************************************************************************
 * This class provides B+Tree maps.  B+Trees are used as multi-level index structures
 * that provide efficient access for both point queries and range queries.
 */
public class BpTree <K extends Comparable <K>, V>
       extends AbstractMap <K, V>
       implements Serializable, Cloneable, SortedMap <K, V>
{
    /** The maximum fanout for a B+Tree node.
     */
    private static final int ORDER = 5;

    /** The class for type K.
     */
    private final Class <K> classK;

    /** The class for type V.
     */
    private final Class <V> classV;

    /********************************************************************************
     * This inner class defines nodes that are stored in the B+tree map.
     */
    private class Node
    {
        boolean   isLeaf;
        int       nKeys;
        K []      key;
        Object [] ref;
        @SuppressWarnings("unchecked")
        Node (boolean _isLeaf)
        {
            isLeaf = _isLeaf;
            nKeys  = 0;
            key    = (K []) Array.newInstance (classK, ORDER - 1);

            if (isLeaf) {
		ref = new Object [ORDER];
            } else {
                ref = (Node []) Array.newInstance (Node.class, ORDER);
            } // if
        } // constructor
    } // Node inner class

    /** The root of the B+Tree
     */
    private final Node root;

    /** Number of keys inserted into the tree
     */
    private int keyCount = 0;

    /** The largest key in the tree
     */
    private K smallestKey;

    /** The smallest key in the tree
     */
    private K largestKey;

    /** The counter for the number nodes accessed (for performance testing).
     */
    private int count = 0;

    /********************************************************************************
     * Construct an empty B+Tree map.
     * @param _classK  the class for keys (K)
     * @param _classV  the class for values (V)
     */
    public BpTree (Class <K> _classK, Class <V> _classV){
        classK = _classK;
        classV = _classV;
        root   = new Node (true);
    } // BpTree

    /********************************************************************************
     * Return null to use the natural order based on the key type.  This requires the
     * key type to implement Comparable.
     */
    public Comparator <? super K> comparator ()
    {
        return null;
    } // comparator

    /********************************************************************************
     * Return a set containing all the entries as pairs of keys and values.
     * @return  the set view of the map
     */
    public Set <Map.Entry <K, V>> entrySet ()
    {
        Set <Map.Entry <K, V>> enSet = new HashSet <Map.Entry <K, V>> ();

             //-----------------\\
            // TO BE IMPLEMENTED \\
           //---------------------\\

        return enSet;
    } // entrySet

    /********************************************************************************
     * Given the key, look up the value in the B+Tree map.
     * @param key  the key used for look up
     * @return  the value associated with the key
     */
    @SuppressWarnings("unchecked")
    public V get (Object key)
    {
        return find ((K) key, root);
    } // get


    /********************************************************************************
     * Return the first (smallest) key in the B+Tree map.
     * @return  the first key in the B+Tree map.
     */
    public K firstKey (){

        return smallestKey;
    } // firstKey

    /********************************************************************************
     * Return the last (largest) key in the B+Tree map.
     * @return  the last key in the B+Tree map.
     */
    public K lastKey (){

        return largestKey;
    } // lastKey

    /********************************************************************************
     * Return the portion of the B+Tree map where key < toKey.
     * @return  the submap with keys in the range [firstKey, toKey)
     */
    public SortedMap <K,V> headMap (K toKey){
             //-----------------\\
            // TO BE IMPLEMENTED \\
           //---------------------\\

        return null;
    } // headMap

    /********************************************************************************
     * Return the portion of the B+Tree map where fromKey <= key.
     * @return  the submap with keys in the range [fromKey, lastKey]
     */
    public SortedMap <K,V> tailMap (K fromKey){
             //-----------------\\
            // TO BE IMPLEMENTED \\
           //---------------------\\

        return null;
    } // tailMap

    /********************************************************************************
     * Return the portion of the B+Tree map whose keys are between fromKey and toKey,
     * i.e., fromKey <= key < toKey.
     * @return  the submap with keys in the range [fromKey, toKey)
     */
    public SortedMap <K,V> subMap (K fromKey, K toKey){
             //-----------------\\
            // TO BE IMPLEMENTED \\
           //---------------------\\

        return null;
    } // subMap

    /********************************************************************************
     * Return the size (number of keys) in the B+Tree.
     * @return  the size of the B+Tree
     */
    public int size (){

        return  keyCount;
    } // size

    /********************************************************************************
     * Print the B+Tree using a pre-order traveral and indenting each level.
     * @param n      the current node to print
     * @param level  the current level of the B+Tree
     */
    private void print (Node n, int level){
        out.println ("BpTree");
        out.println ("-------------------------------------------");

        for (int j = 0; j < level; j++)
            out.print ("\t");
        out.print ("[ . ");

        for (int i = 0; i < n.nKeys; i++)
            out.print (n.key [i] + " . ");
        out.println ("]");

        try{
            if ( ! n.isLeaf) {
                for (int i = 0; i <= n.nKeys; i++){

                    print ((Node) n.ref [i], level + 1);
                }
            } // if
        }catch(Exception e){}

        out.println ("-------------------------------------------");
    } // print


    /********************************************************************************
     * Recursive helper function for finding a key in B+trees.
     * @param key  the key to find
     * @param ney  the current node
     */
    @SuppressWarnings("unchecked")
    private V find (K key, Node n){
        try{
            count++;
            for (int i = 0; i < n.nKeys; i++) {
                K k_i = n.key [i];

                if (key.compareTo (k_i) <= 0) {
                    if (n.isLeaf)
                        return (key.equals (k_i)) ? (V) n.ref [i] : null;
                    else
                        return find (key, (Node) n.ref [i]);
                } // if
            } // for

            return (n.isLeaf) ? null : find (key, (Node) n.ref [n.nKeys]);
        }catch(Exception e){}

        return null;
    } // find


    /********************************************************************************
     * Put the key-value pair in the B+Tree map.
     * @param key    the key to insert
     * @param value  the value to insert
     * @return  null (not the previous value)
     */
    public V put (K key, V value){
        insert (key, value, root, null);
        return null;
    } // put


    /********************************************************************************
     * Recursive helper function for inserting a key in B+trees.
     * @param key  the key to insert
     * @param ref  the value/node to insert
     * @param n    the current node
     * @param p    the parent node
     */
    private void insert (K key, V ref, Node n, Node p){

        if (n.nKeys < ORDER - 1) {
            for (int i = 0; i < n.nKeys; i++) {
                K k_i = n.key [i];
                if (key.compareTo (k_i) < 0)
                    wedge (key, ref, n, i);

                else if (key.equals (k_i))
                    out.println ("BpTree:insert: attempt to insert duplicate key = " + key);

            } // for
            wedge (key, ref, n, n.nKeys);
            if(keyCount == 0){
                smallestKey = key;
                largestKey = key;
            }
            else{
                if(key.compareTo(smallestKey) < 0)
                    smallestKey = key;
                if(key.compareTo(largestKey) > 0)
                    largestKey = key;
            }
            keyCount++;
        } else {
            Node sib = split (key, ref, n);
            keyCount++;

            if(keyCount == 0){
                smallestKey = key;
                largestKey = key;
            }
            else{
                if(key.compareTo(smallestKey) < 0)
                    smallestKey = key;
                if(key.compareTo(largestKey) > 0)
                    largestKey = key;
            }

             //-----------------\\
            // TO BE IMPLEMENTED \\
           //---------------------\\

        } // if
    } // insert

    /********************************************************************************
     * Wedge the key-ref pair into node n.
     * @param key  the key to insert
     * @param ref  the value/node to insert
     * @param n    the current node
     * @param i    the insertion position within node n
     */
    private void wedge (K key, V ref, Node n, int i)
    {
        for (int j = n.nKeys; j > i; j--) {

            n.key [j] = n.key [j - 1];
            n.ref [j] = n.ref [j - 1];
        } // for
        n.key [i] = key;
        n.ref [i] = ref;
        n.nKeys++;
    } // wedge


    /********************************************************************************
     * Splits the root and creates two new children
     * @param key  the key to insert
     * @param ref  the value/node to insert
     * @param n    root node
     * @return     root's root.ref[1]
     */
    private Node rootIsLeafSplit (K key, V ref, Node n){
        Node node = new Node(true);
        Node other = new Node(true);

        if(key.compareTo(n.key[0]) < 0){
            out.println("Case: 1.k0123");
            for(int i = 0; i < 3; i++){
                if(i == 0){
                    node.key[i] = key;
                    node.ref[i] = ref;
                }
                else{
                    node.key[i] = n.key[i-1];
                    node.ref[i] = n.ref[i-1];
                }
            }

            n.key[0] = node.key[2];

            for(int i = 0; i < 2; i++){
                other.key[i] = n.key[i+2];
                other.ref[i] = n.ref[i+2];
            }

            for(int i = 1; i < n.nKeys; i++)
                n.key[i] = null;

            n.ref[0] = node;
            n.ref[1] = other;

            n.nKeys = n.key.length;
            node.nKeys = node.key.length;
            other.nKeys = other.key.length;
            n.isLeaf = false;

        }
        else if(key.compareTo(n.key[0]) > 0 && key.compareTo(n.key[1]) < 0){
            out.println("Case: 1.0k123");
            node.key[0]= n.key[0];
            node.key[1]= key;
            node.key[2]= n.key[1];
            node.ref[0]= n.ref[0];
            node.ref[1]= ref;
            node.ref[2]= n.ref[1];

            n.key[0] = node.key[2];

            for(int i = 0; i < 2; i++){
                other.key[i] = n.key[i+2];
                other.ref[i] = n.ref[i+2];
            }

            for(int i = 1; i < n.nKeys; i++){
                n.key[i] = null;
                n.ref[i+1] = null;
            }

            n.ref[0] = node;
            n.ref[1] = other;

            n.nKeys = n.key.length;
            node.nKeys = node.key.length;
            other.nKeys = other.key.length;
            n.isLeaf = false;
        }
        else if(key.compareTo(n.key[1]) > 0 && key.compareTo(n.key[2]) < 0){
            out.println("Case: 1.01k23");
            node.key[0]= n.key[0];
            node.key[1]= n.key[1];
            node.key[2]= key;
            node.ref[0]= n.ref[0];
            node.ref[1]= n.ref[1];
            node.ref[2]= ref;

            n.key[0] = node.key[2];

            for(int i = 0; i < 2; i++){
                other.key[i] = n.key[i+2];
                other.ref[i] = n.ref[i+2];
            }

            for(int i = 1; i < n.nKeys; i++){
                n.key[i] = null;
                n.ref[i+1] = null;
            }

            n.ref[0] = node;
            n.ref[1] = other;

            n.nKeys = n.key.length;
            node.nKeys = node.key.length;
            other.nKeys = other.key.length;
            n.isLeaf = false;
        }
        else if(key.compareTo(n.key[2]) > 0 && key.compareTo(n.key[3]) < 0){
            out.println("Case: 1.012k3");
            for(int i = 0; i < n.nKeys-1; i++){
                node.key[i] = n.key[i];
                node.ref[i] = n.ref[i];
            }

            other.key[0] = key;
            other.key[1] = n.key[3];
            other.ref[0] = ref;
            other.ref[1] = n.ref[3];

            n.key[0] = n.key[2];

            for(int i = 1; i < n.nKeys; i++)
                n.key[i] = null;

            n.ref[0] = node;
            n.ref[1] = other;

            n.nKeys = n.key.length;
            node.nKeys = node.key.length;
            other.nKeys = other.key.length;
            n.isLeaf = false;
        }
        else{
            out.println("Case: 1.0123k");
            for(int i = 0; i < n.nKeys-1; i++){
                node.key[i] = n.key[i];
                node.ref[i] = n.ref[i];
            }

            other.key[0] = n.key[3];
            other.key[1] = key;
            other.ref[0] = n.ref[3];
            other.ref[1] = ref;

            n.key[0] = n.key[2];

            for(int i = 1; i < n.nKeys; i++)
                n.key[i] = null;

            n.ref[0] = node;
            n.ref[1] = other;

            n.nKeys = n.key.length;
            node.nKeys = node.key.length;
            other.nKeys = other.key.length;
            n.isLeaf = false;
        }

        return (Node) n.ref[1];
    }


    /********************************************************************************
     * Splits the root and creates two new children
     * @param key  the key to insert
     * @param ref  the value/node to insert
     * @param n    root node
     * @param i    reference that is getting created
     * @return     root's root.ref[n]
     */
    private Node rootIsNotLeafSplit (K key, V ref, Node n, int i){
        Node temp = new Node(true);

        if(key.compareTo(n.key[0]) < 0){
            out.println("Case: 1.k0123");

        }
        else if(key.compareTo(n.key[0]) > 0 && key.compareTo(n.key[1]) < 0){
            out.println("Case: 1.0k123");

        }
        else if(key.compareTo(n.key[1]) > 0 && key.compareTo(n.key[2]) < 0){
            out.println("Case: 1.01k23");

        }
        else if(key.compareTo(n.key[2]) > 0 && key.compareTo(n.key[3]) < 0){
            out.println("Case: 1.012k3");

        }
        else{
            out.println("Case: 1.0123k");

        }


        return temp;

    }
    /********************************************************************************
     * Split node n and return the newly created node.
     * @param key  the key to insert
     * @param ref  the value/node to insert
     * @param n    the current node
     */
    private Node split (K key, V ref, Node n){

        Node temp = new Node(true);

        if(root.isLeaf)
            temp = rootIsLeafSplit(key, ref, n);

        else if(!root.isLeaf && root.key.length != 5){
            //temp = rootIsNotLeafSplit(key, ref, n, root.ref.length+1);
        }
        else{
            //after split,  root is full so the root splits
        }



        return temp;
    } // split

    /********************************************************************************
     * The main method used for testing.
     * @param  the command-line arguments (args [0] gives number of keys to insert)
     */
    public static void main (String [] args)
    {
        BpTree <Integer, Integer> bpt = new BpTree <Integer, Integer>
                                                   (Integer.class, Integer.class);
        int totKeys = 10;
        if (args.length == 1)
            totKeys = Integer.valueOf (args [0]);

        //for (int i = 1; i < totKeys; i += 2)
        bpt.put (2, 2);
        bpt.put (4, 4);
        bpt.put (6, 6);
        bpt.put (8, 8);
        bpt.put (10, 10);


        bpt.print (bpt.root, 0);

        for (int i = 0; i < totKeys; i++)
            out.println ("key = " + i + " value = " + bpt.get (i));

        out.println ("-------------------------------------------");
        out.println ("Average number of nodes accessed = " + bpt.count / (double) totKeys);
        out.println ("Size() = " + bpt.size());
        out.println ("smallestKey() = " + bpt.firstKey());
        out.println ("largestKey() = " + bpt.lastKey());
    } // main

} // BpTree class
