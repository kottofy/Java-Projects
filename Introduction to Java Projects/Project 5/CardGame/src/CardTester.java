/**
 * CardTester.java
 * Author: Kristin Ottofy
 * Last Edited: 04/05/2009
 * 
 * A program that tests the Card class to make
 * sure that it is working correctly.
 */
public class CardTester
{
    public static void main (String[] args)
    {
		int card1Rank = 2;  //rank of first card
		int card1Suit = 3;  //suit of first card
		int card2Rank = 14; //rank of second card
		int card2Suit = 4;  //suit of second card

		Card card1 = new Card(card1Rank, card1Suit);
		Card card2 = new Card(card2Rank, card2Suit);

		// check the ranks and suits to make sure that the
		// card was created correctly
		if(card1.getRank() != card1Rank)
        {
			System.out.println("Rank of Card 1 is incorrect.");
		}
		else
        {
			System.out.println("Rank of Card 1 is correct!");
		}

		if(card2.getRank() != card2Rank)
        {
			System.out.println("Rank of Card 2 is incorrect.");
		}
		else
        {
			System.out.println("Rank of Card 2 is correct!");
		}

		if(card1.getSuit() != card1Suit)
        {
			System.out.println("Suit of Card 1 is incorrect.");
		}
		else
        {
			System.out.println("Suit of Card 1 is correct!");
		}

		if(card2.getSuit() != card2Suit)
        {
			System.out.println("Suit of Card 2 is incorrect.");
		}
		else
        {
			System.out.println("Suit of Card 2 is correct!");
		}

		System.out.println("Card 1: " + card1);

		if(card1.toString().equals("2 of Hearts"))
        {
			System.out.println("toString is working correctly for card 1");
		}
		else
        {
			System.out.println("toString is not working correctly for card 1");
		}

		System.out.println("Card 2: " + card2);
		if(card2.toString().equals("A of Spades"))
        {
		    System.out.println("toString is working correctly for card 2");
		}
		else
        {
			System.out.println("toString is not working correctly for card 2");
		}

		Card card3 = new Card();

		System.out.println("Randomly Generated card: " + card3);

		Card card4 = new Card(100, 1000);

		System.out.println("Invalid card defaulted to: " + card4);

		Card card5 = new Card(1, 1000);

		//System.out.println("Invalid card, valid rank, invalid suit, (suit should default): " + card5);

	    Card card6 = new Card(1000, 2);

		//System.out.println("Invalid card, invalid rank (rank (suit should default), valid suit, : " + card6);

		//insert your code to test the compareTo method here.
        if (card1.compareTo(card2) == -1)
            System.out.println("The " + card2.toString() + " was correctly identified as being greater than the " + card1.toString());
        else
            System.out.println("The " + card1.toString() + " was correctly identified as being greater than the " + card2.toString());
    } // end main
} //end class
