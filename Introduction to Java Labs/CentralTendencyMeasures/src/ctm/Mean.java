/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ctm;

/**
 *
 * @author kristin
 */
public class Mean {
    public static void main (String[] args)
    {
        int[] A = {5, 6, 2, 7, 2, 8, 5, 0, 3, 7};
        double sum = 0;
        
        for (int i = 0; i < A.length; i++)
        {
            sum += A[i];
        }
        System.out.println(sum);
        double mean = sum / A.length;
        
        System.out.println("The mean is: " + sum + "/" + A.length + "or " + mean);
    }   
}
