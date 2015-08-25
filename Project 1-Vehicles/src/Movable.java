/**
 *  Author: Kristin Ottofy
 *  Date June 22, 2010
 *  Program Name: Vehicles
 *
 * The interface Movable is implented by the abstract class Vehicle
 * since all the vehicles in the system are movable and need a set
 * number of passengers and a top speed.
 *
 */

/*Everything in this interface has been set to public so
 they can be used by other classes */
public interface Movable
{
    public int getNoPassengers();
    public void setNoPassengers(int noPassangers);
    public int getTopSpeed();
    public void setTopSpeed(int topSpeed);
}
