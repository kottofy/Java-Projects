/*************************************************************************
 * Player.java
 * Author: Kristin Ottofy
 * Last Edited: 04/30/2009
 *
 * The purpose of this class is to create the player's tables and allow the player
 * to get the name of the player, get the number of cards in their table, get the
 * number of the same suit of a given suit, get the number of the same rank of
 * a given rank, replace a card if valid, remove a cardif valid, see the number
 * of cards the player can remove, remove the lowest card, get the score of each
 * player, to see a string format of the players table.
 *************************************************************************/

public class Player
{
    final static int MAX_CARDS = 5;  // max number of Cards in the player's table

    // Declare the instance variables
    private String name;
    private Card[] table;
    private int nCards;

	/*************************************************************************
	 * Name: Player
	 * Input: the name of the player and the deck of cards
	 * Output:
	 * Description: This method primarily creates the tables for the players
	 **************************************************************************/
    public Player(String name, DeckOfCards pool)
	{
		this.name = name; // sets the instance variable name to the String passed through the parameters
        
        if (pool.cardsInDeck() >= 5) // if there are more than 5 cards left, then the number of cards in the table is MAX_CARDS (5)
            this.nCards = MAX_CARDS;
        else // else if there are less cards in the deck, then the number of cards in the table will be set to how many cards are left in the deck
            this.nCards = pool.cardsInDeck();

        this.table = new Card [this.nCards]; // creating the tables with size nCards

        for (int i = 0; i < this.table.length; i++) // this loop sets ever index to a drawn card
        {
            this.table[i] = pool.draw(); // i is the indeck and at every index a card will be drawn from the deck
        }
    }
	/******************************************************************************
	 * Name: getName
	 * Input:
	 * Output: returns the name of the player
	 * Description: See output
	 *******************************************************************************/
	public String getName()
	{
        return this.name; 
	}
	/*******************************************************************************
	 * Name: getNumberOfCards
	 * Input:
	 * Output: returns the number of cards in the table
	 * Description:See output
	 *******************************************************************************/
    public int getNumberOfCards()
	{
        return this.nCards;
    }
	/*******************************************************************************
	 * Name: numOfSameSuit
	 * Input: the number of a suit
	 * Output: returns the number of the given suit
	 * Description: This method takes a suit number, searches for the suit number in the table, and returns that number
	 *******************************************************************************/
	public int numOfSameSuit(int suit)
	{
        int suitNum = 0; // number of the same suit

        for (int count = 0; count < this.table.length ; count++) // count is the index
        {
            if (this.table[count].getSuit() == suit) // if the card at index count has the same suit as the suit given, then the number of same suit will go up by 1
                suitNum++;
        }
            
        return suitNum;
	}// end of numOfSameSuit
	/*******************************************************************************
	 * Name: numOfSameRank
	 * Input: the number of a rank
	 * Output: returns the number of the same rank
	 * Description: This method takes a rank number, searches for the rank number in the table, and returns that number
	 *******************************************************************************/
	public int numOfSameRank(int rank)
	{
        int rankNum = 0; // number of same suit

        for (int count = 0; count < this.table.length ; count++) // count is the index
        {
            if (this.table[count].getRank() == rank) // if the card at index count has the same rank as the suit given, then the number of same rank will go up by 1
                rankNum++;
        }
        
        return rankNum;
	}//end of numOfSameRank

    /*************************************************************************************
	 * Name: replace
	 * Input: an index number and the deck of cards
	 * Output: returns true 
	 * Description:  This method checks that the index is not out of bounds and if not, 
     * the index will be replaced with the cards to the right. At the last index, 
     * a new card will be drawn. If the card is the last index, then  a card will just be drawn
     * If there are no cards left in the deck, then the table size will decrease and NO
     * card will be drawn
	 *************************************************************************************/
    private boolean replace(int index,DeckOfCards cardDeck)
	{
        // if the index is out of bounds, return false
        if (index > this.table.length-1 || index < 0)
            return false;

        else // if the index is not out of bounds
        {
            if (index < this.table.length-1) // if the index is less than the last index in the table
            {
                for (int count = index; count < this.table.length -1; count++) // count is the index
                {
                    this.table[count] = this.table[count + 1]; // the index at count is replaced by the index + 1 (the card to the right)
                }
                this.table[this.table.length-1] = cardDeck.draw(); // draws a card for the last index
            }
            else // if the index is the last index in the table, then a just draw a card
                this.table[index] = cardDeck.draw();

            
            // if the deck is empty, the table size will decrease
            if (cardDeck.cardsInDeck() < 1)
            {
                int tableLength = this.table.length -1; // the length of the new table
                Card [] temp = this.table(); // a copy of the old table
                this.table = new Card[tableLength];  // setting this.table to a new length

                for (int count = 0; count < temp.length-1; count++) // count is the index
                {
                    this.table[count] = temp[count]; // initialize the table at count to the copy of the table at count
                }
                this.nCards = this.table.length; // decrease nCards to the length of the new table
            }
         
            return true; // since the card was replaced
        }
    }

	/*******************************************************************************
	 * Name: remove
	 * Input: a number of an index and the deck of cards
	 * Output: returns true if the card at index was removed, false otherwise
	 * Description: This method determines if the index in the deck of cards can be removed,
     * removes it if possible, and returns true if possible. A card can be removed
     * if it is part of a rank pair or a suit flush.
	 *******************************************************************************/
    public boolean remove(int index, DeckOfCards cardDeck)
	{
        if (this.canRemove() > 0) // if there are cards that can be removed
        {
            if (index > this.table.length || index < 0) // if the index is out of bounds, return false
                return false;

            // these booleans change to true if the card at the respecting index can be removed
            boolean canRemove1 = false; // index 0
            boolean canRemove2 = false; // index 1
            boolean canRemove3 = false; // index 2
            boolean canRemove4 = false; // index 3
            boolean canRemove5 = false; // index 4

           for (int i = 0; i < 15; i++) // i is the rank
           {
               if (numOfSameRank(i) > 1) // if the number of the same rank is greater than 1, (there must be at least 2 of the same rank to be removed) then it can be removed
               {
                   for (int count = 0; count < this.table.length; count++) // count is the index
                   {
                       if (this.table[count].getRank() == i) // if the rank of the card at count is equal to the rank i, then change the canRemove boolean for that index to true
                       {
                            if (count == 0)
                                canRemove1 = true;
                            if (count == 1)
                                canRemove2 = true;
                            if (count == 2)
                                canRemove3 = true;
                            if (count == 3)
                                canRemove4 = true;
                            if (count == 4)
                                canRemove5 = true;
                       }
                   }
               }
            }

           for (int i = 0; i < 5; i++) // i is the suit
           {
               if (numOfSameSuit(i) > 2) // if the number of the same suit is greater than 2, (there must be at least 3 of the same suit to be removed) then it can be removed
               {
                   for (int count = 0; count < this.table.length; count++) // count is the index
                   {
                       if (this.table[count].getSuit() == i) // if the suit of the card at count is equal to the suit i, then change the canRemove boolean for that index to true
                       {
                            if (count == 0)
                                canRemove1 = true;
                            if (count == 1)
                                canRemove2 = true;
                            if (count == 2)
                                canRemove3 = true;
                            if (count == 3)
                                canRemove4 = true;
                            if (count == 4)
                                canRemove5 = true;
                       }
                   }
               }
            }

            // if the canRemove boolean has changed to true and the index can be removed, then remove it by calling the replace method and return true
            if (canRemove1 == true && index == 0) 
            {
                this.replace(index, cardDeck);
                return true;
            }
            else if (canRemove2 == true && index == 1)
            {
                this.replace(index, cardDeck);
                return true;
            }
            else if (canRemove3 == true && index == 2)
            {
                this.replace(index, cardDeck);
                return true;
            }
            else if (canRemove4 == true && index == 3)
            {
                this.replace(index, cardDeck);
                return true;
            }
            else if (canRemove5 == true && index == 4)
            {
                this.replace(index, cardDeck);
                return true;
            }
            else
                return false;
        }

        else // if there are no cards that can be removed than return false
            return false;
    }

    /**********************************************************************************
	 * Name: canRemove
	 * Input:
	 * Output: returns an int of the number of cards that can be removed
	 * Description: This
	 ************************************************************************************/
    public int canRemove()
	{
        // these booleans change to true if the card at the respecting index can be removed
        boolean canRemove1 = false;
        boolean canRemove2 = false;
        boolean canRemove3 = false;
        boolean canRemove4 = false;
        boolean canRemove5 = false;
        
       int canRemove = 0; // increases when a card can be removed

       for (int i = 0; i < 15; i++) // i is the rank
       {
           if (numOfSameRank(i) > 1) // the number of the same rank has to be greater than one for the card to be removed
           {
               for (int count = 0; count < this.table.length; count++) // count is the index
               {
                   if (this.table[count].getRank() == i) // if the rank of the card at count is equal to the rank of i, then the canRemove boolean changes to true for that count
                   {
                        if (count == 0)
                            canRemove1 = true;
                        if (count == 1)
                            canRemove2 = true;
                        if (count == 2)
                            canRemove3 = true;
                        if (count == 3)
                            canRemove4 = true;
                        if (count == 4)
                            canRemove5 = true;
                   }
               }
           }
       }

       for (int i = 0; i < 5; i++) // i is the suit
       {
           if (numOfSameSuit(i) > 2) // the number of the same  must be greater than 2 for the card to be able to be removed
           {
               for (int count = 0; count < this.table.length; count++) // count is the index
               {
                   if (this.table[count].getSuit() == i) // if the suit of card at count is equal to the suit of i, then change it's canRemove boolean to true
                   {
                        if (count == 0)
                            canRemove1 = true;
                        if (count == 1)
                            canRemove2 = true;
                        if (count == 2)
                            canRemove3 = true;
                        if (count == 3)
                            canRemove4 = true;
                        if (count == 4)
                            canRemove5 = true;
                   }
               }
           }
       }

       // if the canRemove boolean was changed to true, this means the card is removable and will increase canRemove by 1
        if (canRemove1 == true)
            canRemove++;
        if (canRemove2 == true)
            canRemove++;
        if (canRemove3 == true)
            canRemove++;
        if (canRemove4 == true)
            canRemove++;
        if (canRemove5 == true)
            canRemove++;

        return canRemove;
        
 	}
 	/***********************************************************************************
	 * Name: removeLowest
	 * Input: a deck of cards
	 * Output: removes the lowest card
	 * Description: This method determines if the lowest card can be removed
     * (if the is not empty) removes it, and returns true, otherwise return
     * false and do not remove it
	 **********************************************************************************/
	public boolean removeLowest(DeckOfCards deck)
	{
        Card lowestCard = new Card (14,4); // creating the highest card possible so the lowest card will replace this card
        int index = 0;

        // determines if a lowest card can be removed
        if (deck.cardsInDeck() != 0) // if the deck is not empty
        {
            if (this.canRemove() == 0) // if the card at index can be removed
            {
                for (int count = 0; count < this.table.length; count++) // count is the index of that card
                {
                    if (lowestCard.compareTo(this.table[count]) == 1) // if the card at position count is less than lowestCard, thenlowestCard becomes the card at position count
                    {
                        lowestCard = this.table[count];
                        index = count;
                    }
                }
            }
            else
                return false;

            if (index > this.table.length-1 || index < 0) // if index is out of bounds, return false
                return false;

            else // if index is not out of bounds
            {
                if (index < this.table.length-1) // if index is less than the normal length of the table, then replace the card with the cards on the right and lower the length of the table. do not draw a card.
                {
                    for (int count = index; count < this.table.length -1; count++) // count is the index
                    {
                        this.table[count] = this.table[count + 1]; // by adding one to count, the card will shift from right to left
                    }
                    this.table[this.table.length-1] = deck.draw(); // draw a card for the last available space
                }
                else // if index = the last card in the table then just draw a new card to replace the one being removed
                    this.table[index] = deck.draw();

            }
            return true; // since the lowest card has been removed
        }
        else
            return false; // since the lowest card was not removed
        
    }

	/**************************************************************************************
	 * Name: getScore
	 * Input:
	 * Output: returns the score
	 * Description: This method adds up all the ranks in the player's hand at the end of the game.
	 **************************************************************************************/
    public int getScore()
	{
        int score = 0;
        for (int count = 0; count < this.table.length; count++) // count is the index of each card in the table
        {
            score = score + this.table[count].getRank(); // score keeps track of the sum of the ranks at position count
        }
        return score;
    }

	/****************************************************************************************
	 * Name: table
	 * Input:
	 * Output: returns a copy of the player's table.
	 * Description: See output
	 ***************************************************************************************/
    public Card[] table()
	{
        Card[] newTable = new Card[this.table.length]; // creates a new table with the same length as the original table
        
        for (int count = 0; count < this.table.length; count++) // count is the index
        {
            newTable[count] = this.table[count]; // newTable at count is equal to the original table at count (creating a copy)
        }
        return newTable;
    }

	/*****************************************************************************************
	 * Name: toString
	 * Input:
	 * Output: returns a string format of the player's table
	 * Description: See output
     *****************************************************************************************/
    public String toString()
	{
        String toString = this.getName() + ": "; // "Player 1:"
        for (int count = 0; count < this.table.length -1; count++) // count is equal to the index. this loop iterates until count is equal to the length of the table minus one.
        {
            toString = toString + table[count] + ", ";
        }
        toString = toString + table[this.table.length-1]; // doesn't add the comma at the end like the others.
        return toString;
    }
}