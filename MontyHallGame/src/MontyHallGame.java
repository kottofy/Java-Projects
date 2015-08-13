/*
* MontyHallGame.java
* Author: Kristin Ottofy
* Last edited: 02/15/2009
*
* Purpose: This program is based on the Monty Hall game "Let's Make A Deal."
* A prize will be randomly chosen secretly behind either Door 1, 2, or 3
* by the computer. The contestant will then choose to open one of the doors,
* not knowing which contains the prize. The computer will tell the contestant
* one of the other doors that does not contain the prize, and ask the
* contestant if they would like to switch doors another door that may or
* may not have the prize. If the contestant chooses the door that contains
* the prize, they will win.
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course.
*/


import java.util.Scanner;
//import java.util.Random;

public class MontyHallGame
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        //Random random = new Random();
        
        String answer = "";  //initialize

        do {
        // this section randomly chooses a door to contain the prize
        //variable aRandomNumerselects a random number out of 3
        int aRandomNumber = (int) (Math.random()*3)+1;
        int prize; //variable prize means which door contains the prize
        if (aRandomNumber == 1)
            prize = 1;
        else if (aRandomNumber == 2)
            prize = 2;
        else // if aRandomNumber == 3
            prize = 3;

        // this section determines which of the empty doors to tell the user is empty
        System.out.println("Which door do you want to open? (1, 2, or 3): ");
        int door = scan.nextInt();//variable door is the door the user chooses to open

        //if door = prize, then the other empty door will be randomly chosen
        //variable aNewRandomNumber selects a random number out of 2
        int aNewRandomNumber = (int) (Math.random()*2)+1;
        
        //variable emptyDoor is one of the doors that does not contain the prize
        int emptyDoor = 0;
        
        //if the door the user chooses is the same as the prize, then aNewRandomNumber
        //will select one of the other doors (since they are both empty) at random
        if (door == prize)
        {
             if (door == 1)
             {
                 if (aNewRandomNumber == 1)
                    emptyDoor = 2;
                 else
                    emptyDoor = 3;
             }
             else  if (door == 2)
             {
                 if (aNewRandomNumber == 1)
                    emptyDoor = 1;
                 else
                    emptyDoor = 3;
             }
             else // if door == 3
             {
                 if (aNewRandomNumber == 1)
                    emptyDoor = 1;
                 else
                    emptyDoor = 2;
             }
        }

        //if door doesn't equal prize, then the other empty door will be chosen
        else 
        {
            if (door == 1)
            {
                if (prize == 2)
                     emptyDoor = 3;
                if (prize == 3)
                    emptyDoor = 2;
            }
            else if (door == 2)
            {
                if (prize == 1)
                     emptyDoor = 3;
                if (prize == 3)
                    emptyDoor = 1;
            }
            else // if door == 3
            {
                if (prize == 1)
                     emptyDoor = 2;
                if (prize == 2)
                    emptyDoor = 1;
            }
        }   

       // this section is where the user determines if they want to switch or what door the user will open
       System.out.println("Door " + emptyDoor + " is empty, do you want to switch your choice? (yes/no) ");
       answer = scan.next();

       //variable openDoor means the door the user chooses to open by answering yes or no
       int openDoor = 0;

       //if the user chooses yes, then the door that will open will be switched
       if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))
       {
           if (emptyDoor == 1)
           {
               if (door == 2)
                   openDoor = 3;
               if (door == 3)
                   openDoor = 2;
           }
           else if (emptyDoor == 2)
           {
               if (door == 1)
                   openDoor = 3;
               if (door == 3)
                   openDoor = 1;
           }
           else //if emptyDoor == 3
           {
               if (door == 1)
                   openDoor = 2;
               if (door == 2)
                   openDoor = 1;
           }
       }
       //if the user chooses no, then the original door they chose will open
       else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n"))
            openDoor = door;

       
       //this section is where the win or lose statements will occur
       System.out.println("You choose to open Door " + openDoor);

       //if the user chooses to open the door that contains the prize, they win
       if (openDoor == prize)
       {
           System.out.println("Door " + prize + " contains the prize! You Win!!");
       }
       else // if the user opens the door without the prize, they lose
       {
           System.out.println("Door " + openDoor + " is EMPTY!! Door " + prize + " has the prize! You loose!!");
       }
       
           System.out.println("Do you want to play again?(yes/no)");
           answer = scan.next();
       
        } while (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"));
         System.out.println("Thanks for playing!!");
    }
}