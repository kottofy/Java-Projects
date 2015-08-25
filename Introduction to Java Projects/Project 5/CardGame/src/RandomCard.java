/**
 * RandomCard.java
 * Author: Kristin Ottofy
 * Last Edited: 04/05/2009
 *
 * This program will generate and display 15 random cards, then display how
 * many of those cards are Clubs, Spades, Hearts, or Diamonds. It will
 * also display how many are Aces, which card was the highest, and which
 * card was the lowest.
 */
public class RandomCard
{
    public static void main (String[] args)
    {
        // declaration of varables
        int clubsCount = 0; // keeps count of how many Clubs are created
        int diamondsCount = 0; // keeps count of how many Diamonds are created
        int heartsCount = 0; // keep count of how many Hearts are created
        int spadesCount = 0; // keeps count of how many Spades are created
        int acesCount = 0; // keeps count of now many Aces are created

        // declaration of new objects
        Card minCard = new Card (14, 4); // will evaluate to the lowest card created
        Card maxCard = new Card (2, 1); // will evaluate to the highest card created

        // beginning of for loop to create 15 random cards
        for (int count = 1 ; count <= 15 ; count++)
        {
            //  declaration of new object using Card class to create the 15 random cards
            Card card = new Card();

            // statements used to determine if the random card is a club, diamond, heart, or spade
            if (card.getSuit() == 1) // Clubs = 1
                clubsCount++;
            else if (card.getSuit() == 2) // Diamonds = 2
                diamondsCount++;
            else if (card.getSuit() == 3) // Hearts = 3
                heartsCount++;
            else // default = Spades which also = 4
                spadesCount++;

            // if statement to determine if the random card in an Ace, no matter the suit
            if (card.isAce())
                acesCount++;

            System.out.println(card.toString()); // calling the toString method

            // if the newly created card is higher than the current maxCard,
            // then maxCard will now = the newly created card
            if (maxCard.compareTo(card) == -1)
                maxCard = card;

            // if the newly created card is lower than the current minCard,
            // then minCard will now = the newly created card
            if (minCard.compareTo(card) == 1)
                minCard = card;
       }

        // Print lines to declare the summary of the 15 random cards
        System.out.println();
        System.out.println("Highest card: " + maxCard.toString());
        System.out.println("Lowest card: " + minCard.toString());
        System.out.println();
        System.out.println("Number of Clubs: " + clubsCount);
        System.out.println("Number of Diamonds: " + diamondsCount);
        System.out.println("Number of Hearts: " + heartsCount);
        System.out.println("Number of Spades: " + spadesCount);
        System.out.println("Number of Aces: " + acesCount);
    } // end of main method
} // end of RandomCard class