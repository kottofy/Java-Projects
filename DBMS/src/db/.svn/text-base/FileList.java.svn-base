
package db;

/*****************************************************************************************
 * @file  FileList.java
 *
 * @author   John Miller
 * @version  0.9, Mon Aug 16 13:56:42 EDT 2010
 */
import java.io.*;
import static java.lang.System.out;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*****************************************************************************************
 * This class allows data tuples/tuples (e.g., those making up a relational table) to be
 * stored in a random access file.  This implementation requires that each tuple be packed
 * into a fixed length byte array.
 */
public class FileList
        extends AbstractList<Comparable[]>
        implements List<Comparable[]>, RandomAccess
{

    /** File extension for data files.
     */
    private static final String EXT = ".dat";
    /** The random access file that holds the tuples.
     */
    private RandomAccessFile file;
    /** The table it is used to store.
     */
    private final Table table;
    /** The number bytes required to store a "packed tuple"/record.
     */
    private final int recordSize;
    /** Counter for the number of tuples in this list.
     */
    private int nRecords = 0;
    private ArrayList<byte[]> index = new ArrayList<byte[]>();

    /*************************************************************************************
     * Construct a FileList.
     * @param _table       the name of list
     * @param _recordSize  the size of tuple in bytes.
     */
    public FileList(Table _table, int _recordSize)
    {
        table = _table;
        recordSize = _recordSize;

        try
        {
            file = new RandomAccessFile(table.getName() + EXT, "rw");
        }
        catch (FileNotFoundException ex)
        {
            file = null;
            out.println("FileList.constructor: unable to open - " + ex);
        } // try
    } // constructor

    /*************************************************************************************
     * Add a new tuple into the file list by packing it into a record and writing this
     * record to the random access file.  Write the record either at the end-of-file or
     * into a empty slot.
     * @param tuple  the tuple to add
     * @return  whether the addition succeeded
     */
    public boolean add(Comparable[] tuple)        //can change to array of objects
    {
        byte[] record = table.pack(tuple);

        try
        {
            if (record.length != recordSize)
            {
                out.println("FileList.add: wrong record size " + record.length);
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }

        try
        {
            file.seek(this.nRecords * recordSize); //seeks to the end of the file

            //for(int i = 0; i < record.length; i++)
            file.write(record);

        }
        catch (IOException ex)
        {
            out.println(ex);
        }

        nRecords++;

        return true;
    } // add

    /*************************************************************************************
     * Get the ith tuple by seeking to the correct file position and reading the record.
     * @param i  the index of the tuple to get
     * @return  the ith tuple
     */
    public Comparable[] get(int i)
    {
        byte[] record = new byte[recordSize];
        try
        {
            file.seek(i * recordSize);
            file.read(record);

        }
        catch (IOException ex)
        {
            Logger.getLogger(FileList.class.getName()).log(Level.SEVERE, null, ex);
        }

        return table.unpack(record);
    } // get

    /*************************************************************************************
     * Return the size of the file list in terms of the number of tuples/records.
     * @return  the number of tuples
     */
    public int size()
    {
        return nRecords;
    } // size

    /*************************************************************************************
     * Close the file.
     */
    public void close()
    {
        try
        {
            file.close();
        }
        catch (IOException ex)
        {
            out.println("FileList.close: unable to close - " + ex);
        } // try
    } // close
} // FileList class
