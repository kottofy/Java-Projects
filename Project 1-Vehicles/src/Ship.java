/**
 *  Author: Kristin Ottofy
 *  Date June 22, 2010
 *  Program Name: Vehicles
 *
 * The class Ship extends from the abstract class Vehicle and also
 * implememnts the interface Floatable.
 * For each vehicle that is a ship in the system will also be floatable
 * and have a shipping line owner and a set tonnage from the floatable interface.
 *
 */

/*This class and its methods have been set to public so
 it can be used by other classes */
public class Ship extends Vehicle implements Floatable
{
    /*the following ints are private since they only need to be used in this
     class and can be returned using the get... methods*/
    private String shippingLineOwner;   //private because only used in this class
    private int tonnage;                //private because only used in this class

    /* The following methods have been declared public so they can be used in
     the Vehicles class*/
    public Ship()
    {
        countVehicles();
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

    public void countVehicles()
    {
        countOfVehicles++;
    }
}