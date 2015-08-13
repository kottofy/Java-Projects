
package db;

/*****************************************************************************************
 * @file  Conversions.java
 *
 * @author   John Miller, Kristin Ottofy
 * @version  0.9, Mon Aug 16 13:56:42 EDT 2010
 *
 * @see http://snippets.dzone.com/posts/show/93
 */
/*****************************************************************************************
 * This class provides methods for converting Java's primitive data types into byte arrays.
 */
public class Conversions
{

    /*************************************************************************************
     * Convert short into a byte array.
     * @param value  the short value to convert
     * @return  a corresponding byte array
     */
    public static byte[] short2ByteArray(short value)
    {
        return new byte[]
                {
                    (byte) (value >>> 8),
                    (byte) value
                };
    } // short2ByteArray

    /*************************************************************************************
     * Convert int into a byte array.
     * @param value  the int value to convert
     * @return  a corresponding byte array
     */
    public static byte[] int2ByteArray(int value)
    {
        return new byte[]
                {
                    (byte) (value >>> 24),
                    (byte) (value >>> 16),
                    (byte) (value >>> 8),
                    (byte) value
                };
    } // int2ByteArray

    /*************************************************************************************
     * Convert long into a byte array.
     * @param value  the long value to convert
     * @return  a corresponding byte array
     */
    public static byte[] long2ByteArray(long value)
    {
        return new byte[]
                {
                    (byte) (value >>> 56),
                    (byte) (value >>> 48),
                    (byte) (value >>> 40),
                    (byte) (value >>> 32),
                    (byte) (value >>> 24),
                    (byte) (value >>> 16),
                    (byte) (value >>> 8),
                    (byte) value
                };
    } // long2ByteArray

    /*************************************************************************************
     * Convert float into a byte array.  4 bytes in a float
     * @param value  the float value to convert
     * @return  a corresponding byte array
     */
    public static byte[] float2ByteArray(float value)
    {
        int intValue = Float.floatToRawIntBits(value);

        return int2ByteArray(intValue);
    } // float2ByteArray

    /*************************************************************************************
     * Convert double into a byte array. 8 bytes in a double
     * @param value  the double value to convert
     * @return  a corresponding byte array
     */
    public static byte[] double2ByteArray(double value)
    {
        long longValue = Double.doubleToRawLongBits(value);

        return long2ByteArray(longValue);
    } // double2ByteArray

    /**
     * Convert String into a byte array
     * @param s the String value to convert
     * @return a corresponding byte array
     */
    public static byte[] string2ByteArray(String s)
    {
        int i = 32;
        byte[] temp = (s).getBytes();
        byte[] b = new byte[i];


        if (temp.length < i)
        {
            for (int n = i - temp.length, t = 0; n < i; n++, t++)
            {
                b[n] = temp[t];
            }
        }
        else
        {
            for (int n = 0; n < i; n++)
            {
                b[n] = temp[n];
            }
        }

        return b;
    }

    /**
     * Convert a char into a byte array
     * @param value  the char value to convert
     * @return a corresponding byte array
     */
    public static byte[] char2ByteArray(char value)
    {
        return new byte[]
                {
                    (byte) (value >>> 8),
                    (byte) value
                };
    }

    /**
     * Convert a byte array into an int
     * @param b the byte array to convert
     * @return a corresponding int
     */
    public static int byteArray2Int(byte[] b)
    {
        int value = 0;
        for (int i = 0; i < 4; i++)
        {
            int shift = (3 - i) * 8;
            value += (int) (b[i] & 0xFF) << shift;
        }

        return value;
    }

    /**
     * Convert a byte array into a short
     * @param b the byte array to convert
     * @return a corresponding short
     */
    public static short byteArray2Short(byte[] b)
    {
        int value = 0;
        for (int i = 0; i < 2; i++)
        {
            int shift = (1 - i) * 8;
            value += (b[i] & 0x000000FF) << shift;
        }

        return (short) value;
    }

    /**
     * Convert a byte array into a long
     * @param b the byte array to convert
     * @return a corresponding long
     */
    public static long byteArray2Long(byte[] b)
    {
        long value = 0;
        for (int i = 0; i < 8; i++)
        {
            int shift = (7 - i) * 8;
            value += (long) (b[i] & 0xFF) << shift;
        }

        return value;
    }

    /**
     * Convert a byte array into a float
     * @param b the byte array to convert
     * @return a corresponding float
     */
    public static float byteArray2Float(byte[] b)
    {
        return Float.intBitsToFloat(byteArray2Int(b));
    }

    /**
     * Convert a byte array into a double
     * @param b the byte array to convert
     * @return a corresponding double
     */
    public static double byteArray2Double(byte[] b)
    {
        long value = 0;
        for (int i = 0; i < 8; i++)
        {
            int shift = (7 - i) * 8;
            value += ((long) b[i] & 0x000000FF) << shift;
        }

        return Double.longBitsToDouble(value);
    }

    /**
     * Convert a byte array into a String
     * @param b the byte array to convert
     * @return a corresponding String
     */
    public static String byteArray2String(byte[] b)
    {
        String s = "";
        for (int i = 0; i < 32; i++)
        {
            //out.print(record[counter++] + " ");
            if ((char) b[i] != 0)
            {
                s += (char) b[i];
            }
        }
        return s;
    }

    /**
     * Convert a byte array into a char
     * @param b the byte array to convert
     * @return a corresponding char
     */
    public static char byteArray2Char(byte[] b)
    {
        int value = 0;
        for (int i = 0; i < 2; i++)
        {
            int shift = (1 - i) * 8;
            value += (b[i] & 0x000000FF) << shift;
        }

        return (char) value;
    }
} // Conversions


/*
public static void main(String[] args)
{

double d = 15;
short s = 15;
int i = 15;
long l = 15;
float f = 15f;


byte[] db = double2ByteArray(d);
out.println("double: " + d);
for (int n = 0; n < db.length; n++)
{

out.print((db[n]) + " ");
}
out.println();


byte[] sb = short2ByteArray(s);
out.println("short: " + s);
for (int n = 0; n < sb.length; n++)
{
out.print(sb[n] + " ");
}
out.println();

byte[] ib = int2ByteArray(i);
out.println("int: " + i);
for (int n = 0; n < ib.length; n++)
{
out.print(ib[n] + " ");
}
out.println();

byte[] lb = long2ByteArray(l);
out.println("long: " + l);
for (int n = 0; n < lb.length; n++)
{
out.print(lb[n] + " ");
}
out.println();

byte[] fb = float2ByteArray(f);
out.println("float: " + f);
for (int n = 0; n < fb.length; n++)
{
out.print(fb[n] + " ");
}
out.println();
}*/
