/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kottofy
 */
public class sort {

    private static int getIndexOfSmallest (int startIndex, int[] a)
    {
        int minIndex = startIndex;

        for (int i = startIndex; i < a.length; i++)
        {
            if (a[i] < a[minIndex])
                minIndex = i;
        }

        return minIndex;
    }


    private static void swap (int i, int j, int[] array)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main (String[] args)
    {
        int[] numbers = {3,6,1,8,7,9,0,2};

        int minIndex;

        for (int i = 0; i < numbers.length; i++)
        {
            minIndex = getIndexOfSmallest(i, numbers);
            swap(i, minIndex, numbers);
        }

        for (int i = 0; i < numbers.length; i++)
        {
            System.out.print(numbers[i] + " ");
        }

    }
}
