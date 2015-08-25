/**
 *  Author: Kristin Ottofy
 *  Date June 22, 2010
 *  Program Name: Vehicles
 *
 * The interface Floatable is implented by the classes that can float:
 * Ship, FlyingSubmarine, and FlyingPirateShip. The vehicle in the system
 * that can float require a set tonnage.
 *
 */

/*Everything in this interface has been set to public so
 they can be used by other classes */
    public interface Floatable
    {
        public int getTonnage();
        public void setTonnage(int tonnage);
    }
