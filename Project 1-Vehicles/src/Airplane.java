/**
 *  Author: Kristin Ottofy
 *  Date June 22, 2010
 *  Program Name: Vehicles
 *
 * The class Airplane extends from the abstract class Vehicle and
 * implements the interface Flyable.
 * Each vehicle in the system that is an Airplane will have a set number
 * of engines. From Flyable, each Airplane will have a set maximum
 * altitude and a set maximum range.
 *
 */

/*This class and its methods have been set to public so
 it can be used by other classes */
public class Airplane extends Vehicle implements Flyable
{
    /*the following ints are private since they only need to be used in this
     class and can be returned using the get... methods*/
    private int numberOfEngines;    //private because only used in this class
    private int maxAltitude;        //private because only used in this class
    private int maxRange;           //private because only used in this class

    /* The following methods have been declared public so they can be used in
     the Vehicles class*/
    public Airplane()
    {
        countVehicles();
    }

    public int getNumberOfEngines()
    {
        return numberOfEngines;
    }

    public void setNumberOfEngines(int numberOfEngines)
    {
        this.numberOfEngines = numberOfEngines;
    }

    public int getMaxAltitude()
    {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude)
    {
        this.maxAltitude = maxAltitude;
    }

    public int getMaxRange()
    {
        return maxRange;
    }

    public void setMaxRange(int maxRange)
    {
        this.maxRange = maxRange;
    }

    public void countVehicles()
    {
        countOfVehicles++;
    }

}