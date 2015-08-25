/**
 *
 * @author Anousha Mesbah
 * This class represents a Clock entity
 */
public class Clock
{
    /*****************************************************
     *       Instance data
     ********************************************************/
    private int time; // time in seconds
    private String location;


    /***************************************************
     *   static data
     *******************************************************/
    public final static int SECXMIN = 60;
    public final static int MINXHOUR = 60;
    public final static int HRXDAY = 24;
    public final static int SECXHOUR = 3600;
    public final static int SECXDAY = 86400;
    public final static int NOON = 43200;
    private static int numOfClocks= 0;


    /***************************************************
     *  Default Constructor
     *****************************************************/
    public Clock()
    {
        this.time = (int)Math.random()*86400;
        this.location = "Unknown";
        numOfClocks++;
    }
    /***************************************************
     *  constructor with one parameter
     * @param time
     ********************************************************/
    public Clock (int time)
    {
       this.setTime(time);
       location = "unknown";
       numOfClocks++;
    }
    public Clock (String location, int time)
    {
        this.location = location;
        setTime(time);
        numOfClocks++;
    }
    // Instance Methods
   /********************************************
     * Accessor method to get time
     *  it returns time
     *********************************************/
    public int getTime ()
    {
        return this.time;
    }

    /*****************************************
     *  Setter method
     * @param newTime
     *********************************************/
    public void setTime (int newTime)
    {

        if (newTime <86400 && newTime >=0)
            this.time = newTime;
    }
     /********************************************
     * Accessor method to get location
     *  it returns location
     *********************************************/
    public String getLocation()
    {
        return this.location;
    }
     /*****************************************
     *  Setter method for location
     * @param newLocation
     *********************************************/
    public void setLocation (String newLocation)
    {
        this.location = newLocation;
    }

 /****************************************************************************
     * This method restes the time to specified hour, minutes and seconds
     * @param hr int hours
     * @param min int minutes
     * @param sec int seconds
     *******************************************************************************/
    public void reset(int hr, int min, int sec)
    {
 	// validate the newTime to check whether its value
 	// is in the permitted range
 	//
 	if ((hr > 0 && hr <24) && (min >=0 && min < 60) &&
	      (sec >=0 && sec < 60) )
        {
            this.time = hr * 3600 + min * 60 + sec;

        }

    }

    /**********************************************************************
     * reset: Reset the hour of this clock
     * **********************************************************************/
    public void reset(int hr)
    {
        if ((hr >= 0 && hr < 24) )
        {
            this.time = hr * 3600 + time % 3600;
        }
    }


    /*******************************************************************
     * reset: Reset the hour and minutes of this clock
     * *********************************************************************/
    public void reset(int hr, int min)
    {
        if ((hr >= 0 && hr < 24) && (min >= 0 && min < 60) )
        {
            this.time = hr * 3600 + min * 60 + this.time % 60;
	}
    }


    /*********************************************************************
     * reset: Reset the hour of this clock based on the boolean variable
     * ***********************************************************************/
    public void reset(int hr, boolean isAm)
    {
        if ((hr >= 1 && hr <= 12) )
        {
            this.time = ( isAm ? hr : (12 + hr)%24)*3600 + this.time % 3600;
 	}
    }


   /************************************************************************
    *  This method displays the time in HH:MM:SS format on the screen.
    ***************************************************************************/
    public void display ()
    {
        int hours = this.time/3600;
        int minutes = (this.time%3600)/60;
        int seconds = (this.time)%60;
        System.out.println (format (hours)+":"+ format(minutes)+":"+ format(seconds));

    }
    /************************************************************************
     * format
     * @param number
     * @return formated string representing time
     ***************************************************************************/
    private String format(int number)
    {
      String strNumber="";
      if (number >= 0 && number <10)
      {
          strNumber+="0" + number;
      }
      else
      {
          strNumber+= number;
      }
       return strNumber;
    }

  /************************************************************************
     *  This method returns time in Standard Time format
     * @return time in standard time format
     ************************************************************************/
    public String getStandardTime()
    {
        int hours = this.time/3600;
        int minutes = (this.time%3600)/60;
        int seconds = (this.time)%60;
        String str = format(hours) + ":" + format(minutes) + ":" + format(seconds);
        return str;
    }


    /********************************************************************
     *  write isAm() method that returns true if the time is a.m and false otherwise
     *********************************************************************/
    public boolean isAm()
    {
        return this.time < 43200 ? true : false;

    }

    /***********************************************************************
     *
     *      Write a method called getRegularTime() which returns a string
     *      in the form of HH:MM:SS AM (for time in the mornining to noon)
     *      and pm (noon - midnight)
     *
     ************************************************************************/

     public String getRegularTime()
    {
        int hours = this.time/3600;
        int minutes = (this.time%3600)/60;
        int seconds = (this.time)%60;
        String amPM="";
        if (hours > 12)
            hours = hours - 12;
        else if (hours == 0)
            hours = 12;
        if (!isAm() )
        {
           amPM = "P.M";
        }
        else
        {
            amPM = "A.M";
        }
        String str;
        str= format (hours) + ":" + format(minutes) + ":" + format(seconds) + " "+amPM;
        return str;
    }
    /****************************************************************
     * isEqual method takes one Clock parameter and checks the time
     * of this clock with the time of the parameter clock.
     * if they are equal it returns true, and false otherwise.
     * @param otherClock
     * @return true /false
     *******************************************************************/

    public boolean isEqual(Clock otherClock)
    {
        if (this.time == otherClock.time)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
     /****************************************************************************
     * compareTol method takes one Clock parameter and checks the time
     * of this clock with the time of the parameter clock.
      * it returns:
     *  0 -if they are equal
      * 1 - if the time of this clock is greater than the time of parameter clock
      * -1 - if the time of this clock is less than the time of parameter clock
     *********************************************************************************/
    public int compareTo(Clock otherClock)
    {
        if (this.time > otherClock.time)
        {
            return 1;
        }
        else if (this.time < otherClock.time)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
    /*****************************************************************
     *
     * Write a method called ticktock that adds a second to the current time
     *
     *******************************************************************/

    public void ticktock()
    {
        this.time = (this.time+1) % 86400;
    }

    /*******************************************************************************
     * toString method will return a the instance values in the form of string
     * @return time and location as string
     **********************************************************************************/

    public String toString()
    {
        return ""+this.time+" ";
    }
    /************************************************************************************
    *  Static method
    *  return the number of clock objects that are created so far
    ***************************************************************************************/
    public static int howMany ()
    {
        return numOfClocks;
    }
}