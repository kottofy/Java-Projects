/**
 * HotDogStand.java
 * Author: Kristin Otofy
 * Last Edited: 04/08/2009
 * */

public class HotDogStand
{
    /*************************************
     * Static data here
     * The static variable hotDogStands is initialized to 0 and keeps count
     * of how many hot dog Stands are created. The static variable hotDogs
     * is initialized to 0 and keeps count of how many hot dogs are sold.
     ******************************************/
    // Add the static variables  described in part 1 of the lab.
    // Should the static variables be public or private ??

    private static int hotDogStands = 0;
    private static int hotDogs = 0;

    /************************************************
    *  Instance Variables
    *************************************************/
    private int id;
    private int sales;

    // Instance Methods Section
    // Constructors
    /*********************************************************************
     * This constructor takes an int representing the
     *  id of the hot dog stand (hotDogStandId) , sets the id of this object
     *  to the value passed as parameter and sets the value of
     *  the instance variable sales to zero.
     ************************************************************************/

    public HotDogStand(int hotDogStandId)
    {
        this.id = hotDogStandId;
        this.sales = 0;
        this.hotDogStands++;
    }

    /*************************************************************************
     * This constructor takes the id of the hot dog stand (hotDogStandId)
     * and its sales (hotDogStandSales) as parameters. It then initializes the corresponding
     * instance variables of this object to the value of the parameters.
     *****************************************************************************/

    public HotDogStand (int hotDogStandId, int hotDogStandSales)
    {
        this.id = hotDogStandId;
        this.sales = hotDogStandSales;
        this.hotDogStands++;
    }

    /************************************************************
     * getID :
     *      return the id of this HotDogStand
     ******************************************************************/

    public int getID ()
    {
        return this.id;
    }

     /************************************************************
     * getHotDogsSold :
      *     return the sales of this HotDogStand
     ******************************************************************/

    public int getHotDogsSold ()
    {
        return this.sales;
    }

     /************************************************************
     *  justSoldOne :
      *     increments the number of hot dogs sold
      *     by this HotDogStand by one
     ******************************************************************/

    public void justSoldOne()
    {
        this.hotDogs++;
        this.sales++;
    }

     /************************************************************
     *  toString :
      *     return a String represeting thos HotDogStand
      *     Id : 2321
      *     # of Sales: 21
     ******************************************************************/

    public String toString ()
    {
        return "Id: " + this.id + "\n# of Sales: " + this.sales;
    }

    // Static Methods Section
     /************************************************************************************
      * Write the implementation of the static method getTotalHotDogsSold here
      *
     ****************************************************************************************/

    public static int getTotalHotDogsSold ()
    {
        return hotDogs;
    }

     /************************************************************************************
      * Write the implementation of the static method avgHotDogSales here
      *
     ****************************************************************************************/

    public static int avgHotDogsales ()
    {
        return hotDogs / hotDogStands;
    }

}
