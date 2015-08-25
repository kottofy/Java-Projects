/**
 *  Author: Kristin Ottofy
 *  Date June 22, 2010
 *  Program Name: Vehicles
 *
 * The interface Flyable is implemented by the classes that can fly:
 * Airplane, FlyingSubmarine, and FlyingPirateShip. The vehicles in
 * the system that can fly require a set maximum altitude and a set
 * maximum range.
 *
 */

/*Everything in this interface has been set to public so
 they can be used by other classes */
    public interface Flyable
    {
        public int getMaxAltitude();
        public void setMaxAltitude(int maxAltitude);
        public int getMaxRange();
        public void setMaxRange(int maxRange);
    }
