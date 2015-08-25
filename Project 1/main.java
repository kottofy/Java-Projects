/**
 *  Author: Kristin Ottofy
 *  Date June 22, 2010
 *  Program Name: Vehicles
 *
 */

//package edu.uga.cs1302.vehicles;

import java.util.Scanner;

public class Vehicles
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner (System.in);

         String userOption = "0"; // userOption will be set to the user's input
         char charZero;         //used to identify the first character of what the user enters

        Vehicle[] Vehicles = new Vehicle[15];   //declaration of the Vehicle array that holds the Vehicles
        
        /* The following for loops initialize each Vehicle in the Vehicles array
         and the constructor from each class will call the countVehicles method
         so we are initializing and counting the vehicles at the same time*/
        for (int count = 0; count < 3; count++)
            Vehicles[count] = new Automobile();

        for (int count = 3; count < 6; count++)
            Vehicles[count] = new Airplane();
			
        for (int count = 6; count < 9; count++)
            Vehicles[count] = new Ship();

        for (int count = 9; count < 12; count++)
            Vehicles[count] = new FlyingSubmarine();

        for (int count = 12; count < 15; count++)
            Vehicles[count] = new FlyingPirateShip();

        /* The following section sets a name to each vehicle */
        Vehicles[0].name = "Corvette";
        Vehicles[1].name = "Z4";
        Vehicles[2].name = "Boxster Spyder";
        Vehicles[3].name = "747";
        Vehicles[4].name = "737";
        Vehicles[5].name = "787 Dreamliner";
        Vehicles[6].name = "Oasis of the Seas";
        Vehicles[7].name = "Monarch of the Seas";
        Vehicles[8].name = "Carnival Destiny";
        Vehicles[9].name = "Dora's Explorer";
        Vehicles[10].name = "The Purple Octopus";
        Vehicles[11].name = "The Bubble";
        Vehicles[12].name = "The Dark Ark";
        Vehicles[13].name = "The Magical Fantasitical Sparrow Ship";
        Vehicles[14].name = "The Flying Ship";

        /* The following section sets a manufacturer to each vehicle */
        Vehicles[0].manufacturer = "Chevrolet";
        Vehicles[1].manufacturer = "BMW";
        Vehicles[2].manufacturer = "Porshe";
        Vehicles[3].manufacturer = "Boeing";
        Vehicles[4].manufacturer = "Boeing";
        Vehicles[5].manufacturer = "Boeing ";
        Vehicles[6].manufacturer = "STX Europe";
        Vehicles[7].manufacturer = "Chantiers de l'Atlantique";
        Vehicles[8].manufacturer = "Fincantier";
        Vehicles[9].manufacturer = "Dora's Flying Underwater Submarines";
        Vehicles[10].manufacturer = "The Little Mermaid Manufacturer";
        Vehicles[11].manufacturer = "Patrick Star Creations";
        Vehicles[12].manufacturer = "Century Ships";
        Vehicles[13].manufacturer = "X Marks the Spot Inc.";
        Vehicles[14].manufacturer = "Hiddren Treasure Manufacturers";

        /* The following section sets a year of manufacture to each vehicle */
        Vehicles[0].yearOfManufacture = 2010;
        Vehicles[1].yearOfManufacture = 2010;
        Vehicles[2].yearOfManufacture = 2009;
        Vehicles[3].yearOfManufacture = 1999;
        Vehicles[4].yearOfManufacture = 2001;
        Vehicles[5].yearOfManufacture = 2009;
        Vehicles[6].yearOfManufacture = 2009;
        Vehicles[7].yearOfManufacture = 1991;
        Vehicles[8].yearOfManufacture = 1996;
        Vehicles[9].yearOfManufacture = 2008;
        Vehicles[10].yearOfManufacture = 1985;
        Vehicles[11].yearOfManufacture = 1950;
        Vehicles[12].yearOfManufacture = 1600;
        Vehicles[13].yearOfManufacture = 1875;
        Vehicles[14].yearOfManufacture = 1885;

        /* The following section sets a number of passengers to each vehicle
         using the setNoPassengers method in Vehicle*/
        Vehicles[0].setNoPassengers(2);
        Vehicles[1].setNoPassengers(2);
        Vehicles[2].setNoPassengers(2);
        Vehicles[3].setNoPassengers(400);
        Vehicles[4].setNoPassengers(150);
        Vehicles[5].setNoPassengers(330);
        Vehicles[6].setNoPassengers(6296);
        Vehicles[7].setNoPassengers(2744);
        Vehicles[8].setNoPassengers(2642);
        Vehicles[9].setNoPassengers(50);
        Vehicles[10].setNoPassengers(100);
        Vehicles[11].setNoPassengers(20);
        Vehicles[12].setNoPassengers(450);
        Vehicles[13].setNoPassengers(400);
        Vehicles[14].setNoPassengers(500);

        /* The following section sets a top speed to each vehicle using the
         setTopSpeed method in Vehicle*/
        Vehicles[0].setTopSpeed(220);
        Vehicles[1].setTopSpeed(180);
        Vehicles[2].setTopSpeed(200);
        Vehicles[3].setTopSpeed(614);
        Vehicles[4].setTopSpeed(544);
        Vehicles[5].setTopSpeed(587);
        Vehicles[6].setTopSpeed(26);
        Vehicles[7].setTopSpeed(25);
        Vehicles[8].setTopSpeed(26);
        Vehicles[9].setTopSpeed(80);
        Vehicles[10].setTopSpeed(100);
        Vehicles[11].setTopSpeed(50);
        Vehicles[12].setTopSpeed(8500);
        Vehicles[13].setTopSpeed(9800);
        Vehicles[14].setTopSpeed(10000);

        /* The following vehicles need to be casted to Automobile to
         set the horse power located in the Automobile class*/
        ((Automobile)Vehicles[0]).setHorsepower(430);
        ((Automobile)Vehicles[1]).setHorsepower(300);
        ((Automobile)Vehicles[2]).setHorsepower(340);

        /* The following section sets a number of engines to the vehicles
         that can fly by casting to the appropriate class */
        ((Airplane)Vehicles[3]).setNumberOfEngines(4);
        ((Airplane)Vehicles[4]).setNumberOfEngines(2);
        ((Airplane)Vehicles[5]).setNumberOfEngines(2);
        ((FlyingSubmarine)Vehicles[9]).setNumberOfEngines(4);
        ((FlyingSubmarine)Vehicles[10]).setNumberOfEngines(2);
        ((FlyingSubmarine)Vehicles[11]).setNumberOfEngines(4);
        ((FlyingPirateShip)Vehicles[12]).setNumberOfEngines(6);
        ((FlyingPirateShip)Vehicles[13]).setNumberOfEngines(8);
        ((FlyingPirateShip)Vehicles[14]).setNumberOfEngines(10);

        /* The following section sets a max altitude to the vehicles that
         can fly by calling the setMaxAltitude method in the casted classes*/
        ((Airplane)Vehicles[3]).setMaxAltitude(35000);
        ((Airplane)Vehicles[4]).setMaxAltitude(37000);
        ((Airplane)Vehicles[5]).setMaxAltitude(35000);
        ((FlyingSubmarine)Vehicles[9]).setMaxAltitude(15000);
        ((FlyingSubmarine)Vehicles[10]).setMaxAltitude(10000);
        ((FlyingSubmarine)Vehicles[11]).setMaxAltitude(12000);
        ((FlyingPirateShip)Vehicles[12]).setMaxAltitude(30000);
        ((FlyingPirateShip)Vehicles[13]).setMaxAltitude(28000);
        ((FlyingPirateShip)Vehicles[14]).setMaxAltitude(29500);

        /* The following section sets a max range to the vehicles that
         can fly by calling the setMaxRange method in the appropriate
         casted method */
        ((Airplane)Vehicles[3]).setMaxRange(14815);
        ((Airplane)Vehicles[4]).setMaxRange(6340);
        ((Airplane)Vehicles[5]).setMaxRange(9780);
        ((FlyingSubmarine)Vehicles[9]).setMaxRange(9000);
        ((FlyingSubmarine)Vehicles[10]).setMaxRange(10123);
        ((FlyingSubmarine)Vehicles[11]).setMaxRange(12345);
        ((FlyingPirateShip)Vehicles[12]).setMaxRange(7543);
        ((FlyingPirateShip)Vehicles[13]).setMaxRange(19200);
        ((FlyingPirateShip)Vehicles[14]).setMaxRange(5672);

        /* The following section sets a tonnage to the vehicles that can
         float by calling the setTonnage method in the appropriate
         casted method*/
        ((Ship)Vehicles[6]).setTonnage(225282);
        ((Ship)Vehicles[7]).setTonnage(73941);
        ((Ship)Vehicles[8]).setTonnage(101353);
        ((FlyingSubmarine)Vehicles[9]).setTonnage(50126);
        ((FlyingSubmarine)Vehicles[10]).setTonnage(101999);
        ((FlyingSubmarine)Vehicles[11]).setTonnage(200931);
        ((FlyingPirateShip)Vehicles[12]).setTonnage(75843);
        ((FlyingPirateShip)Vehicles[13]).setTonnage(54678);
        ((FlyingPirateShip)Vehicles[14]).setTonnage(101123);

        /* The following section sets a shipping line owner to the vehicles
         that can float by calling the setShippingLineOwner method in the
         appropriate casted method*/
        ((Ship)Vehicles[6]).setShippingLineOwner("Royal Caribbean International");
        ((Ship)Vehicles[7]).setShippingLineOwner("Royal Caribbean International");
        ((Ship)Vehicles[8]).setShippingLineOwner("Carnival Corporation & PLC");
        ((FlyingSubmarine)Vehicles[9]).setShippingLineOwner("Nemo");
        ((FlyingSubmarine)Vehicles[10]).setShippingLineOwner("Flounder");
        ((FlyingSubmarine)Vehicles[11]).setShippingLineOwner("SpongeBob Squarepants");
        ((FlyingPirateShip)Vehicles[12]).setShippingLineOwner("Barbossa");
        ((FlyingPirateShip)Vehicles[13]).setShippingLineOwner("Captain Jack Sparrow");
        ((FlyingPirateShip)Vehicles[14]).setShippingLineOwner("Bootstrap Bill");
        
//This while loop will continue as long as the user doesn't want to quit by typing 'q'
        while(!userOption.equalsIgnoreCase("q"))
        {
            System.out.println("Press 1 to see how many vehicles are in the system.");
            System.out.println("Press 2 to see the name and kind of each vehicle.");
            System.out.println("Press 3 to see which vehicles can fly.");
            System.out.println("Press 4 to see which vehicles can float.");
            System.out.println("Press 5 to see which vehicles can float AND fly.");
            System.out.println("Press 6 to see a description of each vehicle.");
            System.out.println("Press h to see a brief help information for your system.");
            System.out.println("Press q to terminate the program.");

            userOption = scan.nextLine();   //userOption is set to the user's input
            charZero  = userOption.charAt(0);   //first index of the user's input

            /* the following if statement checks to make sure the user has entered an appropriate
            option or it will display an error message and go back to the top of the while loop */
            if (userOption.length() != 1 || ( charZero != '1' && charZero != '2' && charZero != '3' && charZero != '4' && charZero != '5' && charZero != '6' && charZero != 'h' && charZero != 'q'))
            {
                System.out.println("Sorry, please enter \{1, 2, 3, 4, 5, 6\} or  'h' for help or  'q' to quit");
                continue;
            }

            
            if(userOption.equalsIgnoreCase("1"))
                printOption1(Vehicles);

            if(userOption.equalsIgnoreCase("2"))
                printOption2(Vehicles);

            if(userOption.equalsIgnoreCase("3"))
                printOption3(Vehicles);

            if(userOption.equalsIgnoreCase("4"))
                printOption4(Vehicles);

            if(userOption.equalsIgnoreCase("5"))
                printOption5(Vehicles);

            if(userOption.equalsIgnoreCase("6"))
                printOption6(Vehicles);         

            if(userOption.equalsIgnoreCase("h"))
            {
                System.out.println("This program will allow you to choose from 8 view options of the vehicles in the system.");
                System.out.println("Select between \{1, 2, 3, 4, 5, 6\} or q to quit (followed by the enter button).");
            }
        }

        if (userOption.equalsIgnoreCase("q"))
           System.exit(0);
    }

    public static void getVehicleType(Vehicle vehicles)
    {
            if (vehicles instanceof Automobile)
                System.out.println("Type: Automobile");
                
            if (vehicles instanceof Airplane)
                System.out.println("Type: Airplane");
            
            if (vehicles instanceof Ship)
                System.out.println("Type: Ship");
            
            if (vehicles instanceof FlyingSubmarine)
                System.out.println("Type: Flying Submarine");
            
            if (vehicles instanceof FlyingPirateShip)
                System.out.println("Type: Flying Pirate Ship");
    }

   public static void printOption1(Vehicle[] vehicles)
   {
        System.out.println("The number of vehicles in the system: " + Vehicle.countOfVehicles);
   }

    public static void printOption2(Vehicle[] vehicles)
    {
        System.out.println("The names and types of each vehicle in the system: ");
        int count;
        for (count = 0; count < vehicles.length ; count++)
        {
            getVehicleType(vehicles[count]);
            System.out.println("Name: " + vehicles[count].name + "\\n");
        }
    }

    private static void printOption3(Vehicle[] vehicles)
    {
        System.out.println("Vehicles that can fly: ");
        int count;
        for (count = 0; count < vehicles.length ; count++)
        {
            if (vehicles[count] instanceof Flyable)
            {
                getVehicleType(vehicles[count]);
                System.out.println("Name: " + vehicles[count].name + "\\n");
            }
        }
    }

    private static void printOption4(Vehicle[] vehicles)
    {
        System.out.println("Vehicles that can float: ");
        for (int count = 0; count < vehicles.length ; count++)
        {
            if (vehicles[count] instanceof Floatable)
            {
                getVehicleType(vehicles[count]);
                System.out.println("Name: " + vehicles[count].name + "\\n");
            }
        }
    }

    private static void printOption5(Vehicle[] vehicles)
    {
        System.out.println("Vehicles that can float and fly: ");
       for (int count = 0; count < vehicles.length ; count++)
        {
            if (vehicles[count] instanceof Floatable && vehicles[count] instanceof Flyable)
            {
                getVehicleType(vehicles[count]);
                System.out.println("Name: " + vehicles[count].name + "\\n");
            }
        }
    }

    private static void printOption6(Vehicle[] vehicles)
    {
        System.out.println("\\nDescription of all vehicles: ");

        for (int count = 0; count < vehicles.length ; count++)
        {
            getVehicleType(vehicles[count]);
            System.out.println("Name: " + vehicles[count].name);
            System.out.println("Manufacturer: " + vehicles[count].manufacturer);
            System.out.println("Manufacture Year: " + vehicles[count].yearOfManufacture);

            if (vehicles[count] instanceof Automobile)
            {
                System.out.println("Engine power: " + ((Automobile)vehicles[count]).getHorsepower());
                System.out.println("Number of passengers: " + ((Automobile)vehicles[count]).getNoPassengers());
                System.out.println("Top speed: " + ((Automobile)vehicles[count]).getTopSpeed() + "\\n");
            }

            if (vehicles[count] instanceof Ship)
            {
                 System.out.println("Tonnage: " + ((Ship)vehicles[count]).getTonnage());
                 System.out.println("Owner: " + ((Ship)vehicles[count]).getShippingLineOwner());
                 System.out.println("Number of passengers: " + vehicles[count].getNoPassengers());
                 System.out.println("Top speed: " + vehicles[count].getTopSpeed() + "\\n");
            }

            if (vehicles[count] instanceof Airplane)
            {
                 System.out.println("Number of engines: " + ((Airplane)vehicles[count]).getNumberOfEngines());
                 System.out.println("Max altutide: " + ((Airplane)vehicles[count]).getMaxAltitude());
                 System.out.println("Max range: " + ((Airplane)vehicles[count]).getMaxRange());
                  System.out.println("Number of passengers: " + vehicles[count].getNoPassengers());
                 System.out.println("Top speed: " + vehicles[count].getTopSpeed() + "\\n");
            }

            if (vehicles[count] instanceof FlyingPirateShip)
            {
                 System.out.println("Number of engines: " + ((FlyingPirateShip)vehicles[count]).getNumberOfEngines());
                 System.out.println("Max altutide: " + ((FlyingPirateShip)vehicles[count]).getMaxAltitude());
                 System.out.println("Max range: " + ((FlyingPirateShip)vehicles[count]).getMaxRange());
                  System.out.println("Tonnage: " + ((FlyingPirateShip)vehicles[count]).getTonnage());
                 System.out.println("Owner: " + ((FlyingPirateShip)vehicles[count]).getShippingLineOwner());
                  System.out.println("Number of passengers: " + vehicles[count].getNoPassengers());
                 System.out.println("Top speed: " + vehicles[count].getTopSpeed() + "\\n");
            }

            if (vehicles[count] instanceof FlyingSubmarine)
            {
                 System.out.println("Number of engines: " + ((FlyingSubmarine)vehicles[count]).getNumberOfEngines());
                 System.out.println("Max altutide: " + ((FlyingSubmarine)vehicles[count]).getMaxAltitude());
                 System.out.println("Max range: " + ((FlyingSubmarine)vehicles[count]).getMaxRange());
                  System.out.println("Tonnage: " + ((FlyingSubmarine)vehicles[count]).getTonnage());
                 System.out.println("Owner: " + ((FlyingSubmarine)vehicles[count]).getShippingLineOwner());
                  System.out.println("Number of passengers: " + vehicles[count].getNoPassengers());
                 System.out.println("Top speed: " + vehicles[count].getTopSpeed() + "\\n");
            }
        }
    }
}}