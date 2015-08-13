
package db;


/************************************************************************************
 * @file String2Type.java
 *
 * @author  John Miller, Kunal Verma
 * @version 0.9, Thu Aug 19 16:22:50 EDT 2010
 */

import static java.lang.System.out;
import java.lang.reflect.*;

/************************************************************************************
 * This class provides a static method for converting a String into any type that has
 * a constructor which takes a single String as an argument (e.g., Integer (String s)).
 */
class String2Type
{
    /********************************************************************************
     * Construct an object of type T from the String representation of its value.
     * Ex: cons (Integer.class, "7") produces the integer 7.
     * @param clazz  the class for the type to be returned (e.g., Integer.class)
     * @param value  the String representation of the value (e.g., "7")
     * @return  the value as a type T object
     */
    @SuppressWarnings("unchecked")
    public static <T> T cons (Class <T> clazz, String value)
    {
        Class []  argumentTypes = new Class [] { String.class };
        Object [] arguments     = new Object [] { value };

        try {
            Constructor constructor = clazz.getConstructor (argumentTypes);
            return (T) constructor.newInstance (arguments);
        } catch (Exception ex) {
            out.println ("String2Type.cons: " + ex);
        } // try

        return null;
    } // cons

    /********************************************************************************
     * The main method is for testing purposes only.  Note, the result of comparing
     * 7 < 11 depends if they are interpreted as Strings or Integers.
     * @param args  the command-line arguments
     */
    public static void main (String [] args)
    {
        String a = "7";
        String b = "11";

        out.println ("as Strings  a < b = " + (a.compareTo (b) < 0));
        out.println ("as Integers a < b = " +
            (cons (Integer.class, a).compareTo (cons (Integer.class, b)) < 0));
    } // main

} // String2Type class
