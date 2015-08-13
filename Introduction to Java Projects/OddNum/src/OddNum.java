/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kottofy
 */
public class OddNum {
    
    public static void main (String [] args)
    {
        int num = 1;
        int sum = 0;

        while (num <= 101)
        {
            if (num % 2 != 0)
            {
                System.out.println(num);
                sum += num;
                num++;
                System.out.println(sum);
            }
        }
    }
}