/**
 *
 * SOMETHING IS WRONG WITH DATEVAL
 *
 *ValidateDate.java
 * @author Kristin Ottofy
 * Last Edited: 02/11/2009
 */



/*import java.util.Scanner;

public class ValidateDate {

    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a year between 1200 and 2050: ");
        int year = scan.nextInt();

        System.out.println("Please enter a month: ");
        int month = scan.nextInt();

        System.out.println("Please enter a day: ");
        int day = scan.nextInt();

        if ( ((year < 1200)||(year > 2050))  || ( (month < 1)||(month > 12) ))
        {
            System.out.println(month + "/" + day + "/" + year + " is not a valid date.");
            System.exit(0);
        }
        else if ( ((month==4) || (month==6) || (month==9) || (month==11)) && ((day<1)||(day>30)))
        {
            System.out.println(month + "/" + day + "/" + year + " is not a valid date.");
            System.exit(0);
        }
        else if ( ((month==1) || (month==3) || (month==5) || (month==7)|| (month==8)|| (month==10)|| (month==12)) && ((day<1)||(day>31)))
        {
            System.out.println(month + "/" + day + "/" + year + " is not a valid date.");
            System.exit(0);
        }
        else if (month==2)
        {
            if (( (((year%100)!=0) && ((year%4)==0) ) || ( (year%100)==0) ) && ((day<=29) || (day>=1)))
                System.out.println(month + "/" + day + "/" + year + " is a valid date.");

            else if ( (day<1) || (day>28))
                System.out.println(month + "/" + day + "/" + year + " is not a valid date.");
        }
        else
            System.out.println(month + "/" + day + "/" + year + " is a valid date.");
    }

}
*/


/**
 *ValidateDate.java
 * @author Kristin Ottofy
 * Last Edited: 02/11/2009
 */

import java.util.Scanner;

public class ValidateDate {

    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a year between 1200 and 2050: ");
        int year = scan.nextInt();

        System.out.println("Please enter a month: ");
        int month = scan.nextInt();

        System.out.println("Please enter a day: ");
        int day = scan.nextInt();

        boolean yearVal = false;
        boolean monthVal = false;
        boolean dateVal = false;
        boolean leap = false;

        if ( year >= 1200 && year <= 2050)
            yearVal = true;
                
        if ( month >= 1 && month <= 12)
            monthVal = true;
        
        if ( (month==4 || month==6 || month==9 || month==11) && (day>=1 && day<=30))
        {
            monthVal = true;
        }
        if ( (month==1 || month==3 || month==5 || month==7|| month==8|| month==10|| month==12) && (day>=1 && day<=31))
        {
            monthVal = true;
        }
        if (year % 100 == 0)
        {
            if (year % 4 == 0)
                leap = true;
        }
        else
        {
            if (year % 4 == 0)
                leap = true;
        }

        if (month == 2)
        {
            if (leap == true && (day >= 1 && day <= 29))
                dateVal = true;
            else if (leap = false  && (day >= 1 && day <= 28))
                dateVal = true;
        }

        if (yearVal == true && monthVal == true && dateVal == true)
            System.out.println(month + "/" + day + "/" + year + " is a valid date.");
        else
            System.out.println(month + "/" + day + "/" + year + " is not a valid date.");
    }

}