/**
 * Card.java
 * Author: Kristin Ottofy
 * Last Edited: 04/30/2009
 * 
 *   This is code for a Card class which represents a card in a standard
 *   deck of playing cards.   Each card has a suit and a rank.  The
 *   mapping for these attributes should be as follows:
 *   1 - Clubs, 2 - Diamonds, 3 - Hearts, 4 - Spades
 *   2-10 - normal numbers; 11 - Jack; 12 - Queen; 13 - King; 14 - Ace
 */
public class Card
{
    // instance data declarations
    private int rank;
    private int suit;

    /**
     *  Default constructor - it should construct
     *  a random card (i.e. it should assign random
     *  values to rank and suit).  Make sure the
     *  random values make sense for a card.
     */

    public Card()
	{
        suit = (int)(Math.random()*4) + 1; // numbers 1-4
        rank = (int)(Math.random()*13) + 2; // numbers 2-14
    }

    /****************************************
     *  Constructor that creates a card with rank
     *  r and suit s.
     *  The constructor verifies that the values
     *  passed in these parameters are correct for
     *  rank and suit respectively.Otherwise, if
     *  either the rank or suit (or both) is invalid,
     *  the constructor assign a default valid value.
     *********************************************/

    public Card(int r, int s)
    {
        if (r > 14 || r < 2)
            this.rank = 14;
        else
            this.rank = r;

        if (s < 1 || s > 4)
            this.suit = 4;
        else
            this.suit = s;
    }

    /**************************************************
     *  getSuit - returns the suit of this card as an int
     *******************************************************/

    public int getSuit ()
    {
        return this.suit;
    }

  /********************************************************
    *  getRank - returns the rank of this card as an int
    *********************************************************/

    public int getRank ()
    {
        return this.rank;
    }

    /******************************************************
     * isAce - returns true if the rank of this card as an Ace (14)
     **********************************************************/

    public boolean isAce () // this method is used in RandomCard.java
    {
        if (this.rank == 14) // 14 = Ace
            return true;
        else
            return false;
    }

     /*********************************************************
     *  compareTo  ( Card c)
     *  Returns:
     *	-1: if this card has lower rank than Card c or if the ranks are the same
     *      and  this card's suit is lower than c's suit, it returns -1.
     *   0: if this card has the same rank and suit as Card c
     *	 1: if this card has higher rank than  Card c or if the ranks are the same
     *      and this card's suit is higher than c's suit,
     *
     ****************************************************************/

    // rank is prioritized first, then the suit.
     public int compareTo(Card c) //Card c == card, this == min/maxCard
	{
        if (this.rank < c.rank || (this.rank == c.rank && this.suit < c.suit))
            return -1;
        else if (this.rank == c.rank && this.suit == c.suit)
            return 0;
        else
            return 1;
    }

    /********************************************
     *  Returns a String representation of the suit
     *  of this card.  For example, if this card's suit is a
     *  spade, it returns the string "Spades",
     *  - if it is a club, it
     *  returns the string "Clubs"
     *************************************************/

    private String suit2String()
    {
        if ( this.suit == 1) // 1 = Clubs
            return "Clubs";
        else if (this.suit == 2) // 2 = Diamonds
            return "Diamonds";
        else if (this.suit == 3) // 3 = Hearts
            return "Hearts";
        else // 4 = Spades (DEFAULT)
            return "Spades";
    }

    /**********************************************
     *  Returns a String representation of the rank
     *  of this card.  For example, if this card's rank
     *  is 14, returns the string "Ace",
     *  - if its rank is 2 to 10, it
     *  returns a string representing the number.
     *  If the card's rank is a 12, the method returns
     *  the String "Queen", and so on.
     *
     ****************************************************/
    
    private String rank2String()
    {
        if (this.rank == 2) // numbers are same as card
            return "2";
        else if (this.rank == 3)
            return "3";
        else if (this.rank == 4)
            return "4";
        else if (this.rank == 5)
            return "5";
        else if (this.rank == 6)
            return "6";
        else if (this.rank == 7)
            return "7";
        else if (this.rank == 8)
            return "8";
        else if (this.rank == 9)
            return "9";
        else if (this.rank == 10)
            return "10";
        else if (this.rank == 11) // 11 = Jack (J)
            return "J";
        else if (this.rank == 12) // 12 = Queen (Q)
            return "Q";
        else if (this.rank == 13) // 13 = King (K)
            return "K";
        else // 14 = Ace (A)
            return "A";
    }

    /*****************************************************
     * toString ()-
     *  Returns a String representation of this
     *  card.  For example, if this card is the
     *  ace of spades, it returns the string "A
     *  of Spades" - if it is the two of clubs, it
     *  returns the string "2 of Clubs"
     *********************************************************/

    public String toString ()
    {
        return this.rank2String() + ":" + this.suit2String();
    }
}
//end class card
