/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kristin Ottofy
 * Last Edited: 02/09/2009
 */

//importing the Scanner class
import java.util.Scanner;

//creating class called BodyMassIndex
public class BodyMassIndex {

        //establishing 2.2 as a constant to convert kilograms to pounds
        public static final double KLG_TO_POUNDS = 2.2;

        //establishing 3.2808399 as a constant to convert meters to feet
        public static final double METERS_TO_FEET = 3.2808399;

        //establing 12 inches in a foot as a constant
        public static final double INCHES_IN_FOOT = 12;

        public static final double UNDERWEIGHT = 18.5;

        public static final double NORMAL = 25;

        public static final double OVERWEIGHT = 30;

    //Creating the main method
    public static void main(String[]args)
    {
        //creating Scanner object
        Scanner keyboard = new Scanner(System.in);

        //asking the user to enter their height
        System.out.println("Please enter your height in meters: ");

        //creating the float height from what the user imputed
        double heightInMeters = keyboard.nextDouble();

            if (heightInMeters < 0)
            {
                System.out.println("Sorry, " + heightInMeters + " is not a valid height in meters. Bye.");
                System.exit(0);
            }

        //asking the user to enter their weight
        System.out.println("Please enter your weight in kilograms: ");

        //creating the float weight from what the user imputed
        double weightInKgs = keyboard.nextDouble();

            if (weightInKgs < 0)
            {
                System.out.println("Sorry, " + weightInKgs + " is not a valid weight in kilograms. Bye.");
                System.exit(0);
            }

        //creating a double that converts kilograms to pounds
        double poundsFromKgs = ((double)weightInKgs * KLG_TO_POUNDS);

        //creating a double that converts meters to feet
        double heightToFeet = (heightInMeters * METERS_TO_FEET);

        //creating an int that will display the feet
        int Feet = (int)heightToFeet;

        //creating a double that will display the inches
        double Inch = (heightToFeet - Feet) * INCHES_IN_FOOT;

        int inchInteger = (int)Inch;

        //creating a float for BMI
        double BodyMassIndex = weightInKgs / (heightInMeters * heightInMeters);

        System.out.println("Weight in kilograms" + weightInKgs);
        System.out.println("Height in meters: " + heightInMeters);

        System.out.println("User's Information:");
        System.out.print("\tWeight: " + weightInKgs + " kgs.");
        System.out.println("(" + poundsFromKgs + " lbs.)");

        System.out.print("\tHeight: " + heightInMeters + " m.");
        System.out.println("(" + Feet + "'" + inchInteger + "\")");

        System.out.println("\tBMI: " + BodyMassIndex);

        String weightGroup;

       if (BodyMassIndex < UNDERWEIGHT)
            weightGroup = "Underweight";

       else if ((BodyMassIndex >= UNDERWEIGHT) && (BodyMassIndex < NORMAL))
            weightGroup = "Normal";

       else if ((BodyMassIndex >= NORMAL) && (BodyMassIndex < OVERWEIGHT))
            weightGroup = "Overweight";

       else
           weightGroup = "Obesity";


        System.out.println("\tWeight Group: " + weightGroup + " (*)");
        System.out.println("");
        System.out.println("(*) Disclaimer:");
        System.out.println("");
        System.out.println("The BMI score is valid for both men and women but it does have some limits. The limits are:");
        System.out.println("a) It may overestimate body fat in athletes and others who have a muscular build.");
        System.out.println("b) It may underestimate body fat in older persons and others who have lost muscle mass.");
    }

}
