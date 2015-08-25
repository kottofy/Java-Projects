/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * RectangleDriver.java
 * @author Kristin Ottofy
 * Last Edited: 03/23/2009
 *
 */
import java.util.Scanner;
public class RectangleDriver {

    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);

        System.out.println("Plese input length of the rectangle: ");
        double length = scan.nextDouble();

        System.out.println("Please input width of the rectangle: ");
        double width = scan.nextDouble();
        
        while (length < width)
        {
            System.out.println("Error. The length cannot be less than the width.");

            System.out.println("Plese input length of the rectangle: ");
            length = scan.nextDouble();

            System.out.println("Please input width of the rectangle: ");
            width = scan.nextDouble();
        }

        String displayVal = StaticRectangle.display(length, width);
        System.out.println(displayVal);
    }
}
