/**
 *  Author: Kristin Ottofy
 *  Date June 22, 2010
 *  Program Name: Vehicles
 *
 * The class FlyingSubmarine extends from Vehicle and also implements
 * the interfaces Flyable and Floatable.
 * Each Vehicle that is a FlyingSubmarine in the system will have
 * a set number of engines and a Shipping Line Owner. From Flyable,
 * each FlyingSubmarine will have a set maximum altitude and a set
 * maximum range. From Floatable, each FlyingSubmarine will will have
 * a set tonnage.
 *
 */

/*This class and its methods have been set to public so
 it can be used by other classes */
public class FlyingSubmarine extends Vehicle implements Flyable, Floatable
    {
    /*the following ints are private since they only need to be used in this
     class and can be returned using the get... methods*/
        private int numberOfEngines;    //private because only used in this class
        private int maxAltitude;        //private because only used in this class
        private int maxRange;           //private because only used in this class
        private String shippingLineOwner;   //private because only used in this class
        private int tonnage;            //private because only used in this class

    /* The following methods have been declared public so they can be used in
     the Vehicles class*/
        public FlyingSubmarine()
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

        public String getShippingLineOwner()
        {
            return shippingLineOwner;
        }

        public void setShippingLineOwner(String shippingLineOwner)
        {
            this.shippingLineOwner = shippingLineOwner;
        }

        public int getTonnage()
        {
            return tonnage;
        }

        public void setTonnage(int tonnage)
        {
            this.tonnage = tonnage;
        }

    }