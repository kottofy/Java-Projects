/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * StaticRectangle.java
 * @author Kristin Ottofy
 * LastEdited: 03/23/2009
 */
public class StaticRectangle
{
    // perimeter method takes parameters length and width and computes the perimeter
    public static double perimeter (double length, double width)
    {
        double perimeter = (2 * length) + (2 * width);
        return perimeter;
    }

    // diagonal method takes parameters length and width and computes the Pythagorean method
    public static double diagonal (double length, double width)
    {
        double diagonal = Math.sqrt((length * length) + (width * width));
        return diagonal;
    }

    // isEqualateral method takes parameters length and width and determines whether the rectangle is equalateral
    public static boolean isEqualateral (double length, double width)
    {
        boolean isEqualateral;
        if (length == width)
        {
            isEqualateral = true;
        }
        else
        {
            isEqualateral = false;
        }

        return isEqualateral;
    }

    //area method takes parameters length and width and computes the area
    public static double area (double length, double width)
    {
        double area = length * width;

        return area;
    }

    //display method takes parameters length and width and returns a string
    public static String display (double length, double width)
    {
        
        double areaVal = area(length, width);
        boolean isEqualateralVal = isEqualateral(length, width);
        double perimeterVal = perimeter(length, width);
        double diagonalVal = diagonal(length, width);

        String display;

        if (isEqualateralVal == true)
        {
            display = ("Length: " + length + "\nWidth: " + width + "\nDiagonal: " + diagonalVal + "\nArea: " + areaVal + "\nPerimeter: " + perimeterVal + "\nThis rectangle is an equalateral rectangle.");
        }
        else
        {
            display = ("Length: " + length + "\nWidth: " + width + "\nDiagonal: " + diagonalVal + "\nArea: " + areaVal + "\nPerimeter: " + perimeterVal + "\nThis rectangle is not an equalateral rectangle.");
        }
        
        return display;
    }

}
