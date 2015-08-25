/******************************************************
 *	DeckOfCards.java
 * Author: Kristin Ottofy
 * Last Edited: 04/30/2009
 *
 * The purpose of this class is to create a deck of cards and allows the user to
 * suffle the deck, draw cards from the deck, determine if the deck is empty,
 * acces the number of cards left in the deck, and see the deck through the toString method.
 *****************************************************/
import java.util.Random;

public class DeckOfCards
{

	// class member variables
	final private int DECK_SIZE = 52;

	// Declare instance member variable
	private Card[] deck;
    private int nCards;


	/***********************************************************************************
	 * Name: DeckofCards
	 * Input: 
	 * Output:
	 * Description: This method creates a new deck of cards and assigns each card a rank and suit
	 ***********************************************************************************/
	public DeckOfCards()
	{
		deck = new Card[DECK_SIZE]; // initializing deck with size 52

        int index = 0;

        // assigning a rank and suit to each Card in deck
        for (int suit = 1; suit <= 4; suit++)
        {
            for (int rank = 2; rank <= 14; rank++)
            {
                deck[index] = new Card (rank, suit);
                index++;
            }
        }
        
        nCards = DECK_SIZE; // the number of cards in the deck
	}

	/***********************************************************************************
	 * Name: shuffle
	 * Input: 
	 * Output:
	 * Description: This method shuffles the cards in the deck.
	 ***********************************************************************************/
	public void shuffle()
    {
		// You don't need to change anything here. I have provided you the body of the Shuffle method ;-)
		// just fill the description of the method
        Card temp;
        for (int i = 0; i < nCards; i++)
        {
			//generating a random number between i and 52
            int index = (int)(Math.random()*(nCards-i))+i;
			// swaping the cards
            temp = deck[i];
            deck[i]= deck[index];
            deck[index]= temp;

        }
    }// end of shuffle

	/***********************************************************************************
	 * Name: draw
	 * Input:
	 * Output: returns either the card at the last position in the deck or null if the deck is empty.
	 * Description: This method draws a card from the deck and subtracts the number of cards in the deck.
	 ***********************************************************************************/
	public Card draw()
	{   
        // if the number of cards in the deck is greater than 0, then subtract 1 from the number of cards and return that card
        if (nCards != 0) 
        {
            nCards--;
            return deck[nCards];
        }

        //if the deck is empty, then return null
        else
        {
            return null;
        }
	}
	/***********************************************************************************
	 * Name: isEmpty
	 * Input:
	 * Output: returns true if the number of cards in the deck is 0 and false if there are cards left in the deck
	 * Description: See output
	 ***********************************************************************************/
	public boolean isEmpty()
    {
        if (this.nCards == 0) // if there are no cards left in the deck, return true
            return true;
        else // if there are cards left in the deck, return false
            return false;
	}
	/***********************************************************************************
	 * Name: cardsInDeck
	 * Input:
	 * Output: returns the number of cards in the deck
	 * Description: See output
	 ***********************************************************************************/
	public int cardsInDeck()
	{
		return this.nCards;
	}

	/***********************************************************************************
	 * Name: toString
	 * Input:
	 * Output: returns a string representation of the deck
	 * Description: See output
	 ***********************************************************************************/
	public String toString()
	{
        String toString = "";
        for (int count = 0; count < nCards; count = count + 4) // count keeps track of the index
        {
            for (int i = 0; i < 4 && count + i < nCards; i++) // by making sure count + i < nCards, this ensures the removed cards will not appear
            {
                toString = toString + deck[count + i] + " "; // since count will not change in this for loop, by adding count to i, the index will appear appropriately
            }
            toString = toString + "\n";
        }
        return toString;
	}
}