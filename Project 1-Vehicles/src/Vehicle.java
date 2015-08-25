/**
 *  Author: Kristin Ottofy
 *  Date June 22, 2010
 *  Program Name: Vehicles
 *
 * Vehicle is an abstract class that implements the Movable interface.
 * Each vehicle needs a name, a manufacurer, and a year of manufacture.
 * Each vehicle also needs a set number of passengers and a set top speed
 * which were implemented from the Movable interface.
 *
 */

/*This class and its methods have been set to public so
 it can be used by other classes */
public abstract class Vehicle implements Movable
    {
        public String name;             //public because used in Vehicles class
        public String manufacturer;     //public because used in Vehicles class
        public int yearOfManufacture;   //public because used in Vehicles class
        private int noPassengers;       //private because only used in Vehicle class
        private int topSpeed;           //private because only used in Vehicle class
        public static int countOfVehicles;  //public and static so it can be used in many classes

        /* The following methods have been declared public so they can be used in
        the Vehicles class*/
        public int getNoPassengers()
        {
            return noPassengers;
        }
        public void setNoPassengers(int noPassangers)
        {
            this.noPassengers = noPassangers;
        }
        public int getTopSpeed()
        {
            return topSpeed;
        }

        public void setTopSpeed(int topSpeed)
        {
            this.topSpeed = topSpeed;
        }

        abstract void countVehicles();
    }