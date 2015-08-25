/**
 *  Author: Kristin Ottofy
 *  Date June 22, 2010
 *  Program Name: Vehicles
 *
 * The class Autombile extends from the abstract class Vehicle.
 * For each Vehicle of Automobile class, it will have a set horse power.
 *
 */

/*This class and its methods have been set to public so
 it can be used by other classes */
public class Automobile extends Vehicle
{
    /*the following int is private since it only needs to be used in this
     class and can be returned using the get... method*/
    private int horsepower; //private because only used in this class

    /* The following methods have been declared public so they can be used in
     the Vehicles class*/
    public Automobile()
    {
        countVehicles();
    }

    public void setHorsepower( int setHorsepower)
    {
        horsepower = setHorsepower;
    }

    public int getHorsepower()
    {
        return horsepower;
    }

    public void countVehicles()
    {
        countOfVehicles++;
    }

}