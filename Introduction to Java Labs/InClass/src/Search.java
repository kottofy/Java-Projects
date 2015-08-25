/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kottofy
 */
public class Search
{
    public static int search (int num, int[] array)
    {
        for (int count = 0; count < array.length; count++)
        {
            if (array[count] == num)
                return count;
        }
                return -1;

    }
}
