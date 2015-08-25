/**
 * (-5) For the remove() method in Player class you must use numOfSameRank and
 * numOfSameSuit to determine if the given card is a member of a flush or pair.
 * If the given card is a member of a flush or pair just call the replcae method.
 * You have some extremely complicated code which is unnecessary (-5) Similary
 * in the canRemove () method just increment the count if the ith card is a
 * member of a flush or rank pair. No need for such complicated statements (-3)
 * In the removeLowest method() you only have to determine the index of the
 * lowest card and then call the replace method. (-4) In the method table() in
 * Player class , you copy every card in the players table using the follwoing
 * statement newTable[count] = this.table[count]; This is wrong. The correct way
 * is newTable[count] =new Card(this.table[count].getRank(),this.table[count].getSuit());
 * (-2) In DeckOfCards constructor shuffle() should be called after the deck is populated
Grade: 	81 out of 100
 */

/*************************************************************************
 * CardGame.java
 * Author: Kristin Ottofy
 * Last Edited: 04/30/2009
 *
 * The purpose of this class is to implement the actual card game. It creates
 * an array of two players, player 1 and player 2. The turns of player 1 and
 * player 2 are determined by an int. The game will fist prompt the players
 * for their names. While the deck is not empty, the the game
 * will print out the player's table, tell them how many cards they can remove,
 * and ask them which index (0-4) they would like to remove. If no card can be
 * removed, then the lowest card will be automatically removed. Then, the int
 * for the turn of each player will change and the other player will go.
 * While the deck is empty, the players' turns will conduct in the same manner,
 * but if a player cannot remove any cards, then a player cannot remove the
 * lowest card and will pass their turn. Once both players have passed their
 * turns, the game will end. The person with the lowest score will win!
 *************************************************************************/


import java.util.Scanner;
public class CardGame
{

	public static void main(String[] args)
	{
		// player array to save the two players
		Player[] players = new Player[2];

		// create a deck of cards here
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

/*EDIT OUT*/ //System.out.println(deck);

		// Your code to implement the logic  of the CardGame  goes here

        Scanner scan = new Scanner (System.in);
        
        
        // get's the name of the player and stores it in the string
        String player1Name = getName(1);
        String player2Name = getName(2);

        // creates Players for player 1 and player 2
        Player player1 = new Player(player1Name,deck);
        Player player2 = new Player(player2Name,deck);

        // initialized the players previously created to the indexes of the player array
        players[0] = player1;
        players[1] = player2;

        int turn = 0; // if turn = 0, it's player 1's turn; else it is player 2's turn
        System.out.println();

        while (deck.isEmpty() != true) // when deck is not empty, this loop iterates each turn
        {
            if (turn == 0) // player 1's turn
            {
                System.out.println(player1Name + "'s Turn: ");
                System.out.println(players[0]);
                System.out.println("You can remove " + players[0].canRemove() + " cards from the table.");
                
                if (players[0].canRemove() == 0) // if the player can't remove any cards, then remove the lowest card
                {
                    players[0].removeLowest(deck);
                    System.out.println("Removing the lowest card form the player's table.");
                }
                else // if the player can remove card, ask which card the user would like to remove and verify it can be removed and then remove it
                {
                    System.out.println("Please indicate the index of the card you want to remove: ");
                    int index = scan.nextInt();

                     // if index is out of bounds, then call the getIndex method
                    if (index < 0 || index > players[0].getNumberOfCards() - 1)
                        index = getIndex(players[0].getNumberOfCards() - 1);

                    // if index is not out of bounds, determine if i can be removed or not and then remove it
                    if (players[0].remove(index, deck) != true)
                        removeMatchingTiles(players[0], deck);
                }

                System.out.println(players[0]);
                System.out.println();
                turn = (turn + 1) % 2;
            }
            
            else // else if turn does not equal 0, then it is player 2's turn
            {
                System.out.println(player2Name + "'s Turn: ");
                System.out.println(players[1]);
                System.out.println("You can remove " + players[1].canRemove() + " cards from the table.");

                if (players[1].canRemove() == 0) // if the player can't remove any cards, then remove the lowest card
                {
                    players[1].removeLowest(deck);
                    System.out.println("Removing the lowest card form the player's table.");
                }
                else // if the player can remove card, ask which card the user would like to remove and verify it can be removed and then remove it
                {
                    System.out.println("Please indicate the index of the card you want to remove: ");
                    int index = scan.nextInt();

                    // if index is out of bounds, then call the getIndex method
                    if (index < 0 || index > players[1].getNumberOfCards() - 1)
                        index = getIndex(players[1].getNumberOfCards() - 1);

                    // if index is not out of bounds, determine if i can be removed or not and then remove it
                    if (players[1].remove(index, deck) != true)
                        removeMatchingTiles(players[1], deck);
                }
                    System.out.println(players[1]);
                    System.out.println();
                    turn = (turn + 1) % 2;
            }
        }
        boolean endGame1 = false; // used to determine when the deck is empty and player 1 has passed their turn
        boolean endGame2 = false; // used to determine when the deck is empty and player 2 has passed their turn

        while (deck.isEmpty() == true) // while the deck is empty
        {
            if (turn == 0) // player 1's turn
            {
                System.out.println(player1Name + "'s Turn: ");
                System.out.println(players[0]);
                System.out.println("You can remove " + players[0].canRemove() + " cards from the table.");

                if (players[0].canRemove() == 0) // if the player can't remove any cards, then the player passes their turn
                {
                    System.out.println("Pass. No card can be removed for the player's table and the deck is empty.");
                    endGame1 = true; // becomes true because since the player has passed their turn
                }
                else // if the player can remove card, ask which card the user would like to remove and verify it can be removed and then remove it
                {
                    System.out.println("Please indicate the index of the card you want to remove: ");
                    int index = scan.nextInt();

                    // if index is out of bounds, then call the getIndex method
                    if (index < 0 || index > players[0].getNumberOfCards() - 1)
                        index = getIndex(players[0].getNumberOfCards() - 1);

                    // if index is not out of bounds, determine if i can be removed or not and then remove it
                    if (players[0].remove(index, deck) != true)
                        removeMatchingTiles(players[0], deck);
                }

                System.out.println(players[0]);
                System.out.println();
                turn = (turn + 1) % 2;
            }
            else // player 2's turn
            {
                System.out.println(player2Name + "'s Turn: ");
                System.out.println(players[1]);
                System.out.println("You can remove " + players[1].canRemove() + " cards from the table.");

                if (players[1].canRemove() == 0) // if the player can't remove any cards, then the player passes their turn
                {
                    System.out.println("Pass. No card can be removed for the player's table and the deck is empty.");
                    endGame2 = true; // becomes true because since the player has passed their turn
                }
                else // if the player can remove card, ask which card the user would like to remove and verify it can be removed and then remove it
                {
                    System.out.println("Please indicate the index of the card you want to remove: ");
                    int index = scan.nextInt();

                    // if index is out of bounds, then call the getIndex method
                    if (index < 0 || index > players[1].getNumberOfCards() - 1)
                        index = getIndex(players[1].getNumberOfCards() - 1);

                    // if index is not out of bounds, determine if i can be removed or not and then remove it
                    if (players[1].remove(index, deck) != true)
                        removeMatchingTiles(players[1], deck);
                }

                System.out.println(players[1]);
                System.out.println();
                turn = (turn + 1) % 2;

                // determines if the game should end or not. if both players have passed a turn then the game will end
                if (endGame1 == true && endGame2 == true)
                {
                    System.out.println("The game has terminated.");
                    System.out.println("Player #1 (" + player1Name + ") score: " + players[0].getScore());
                    System.out.println("Player #2 (" + player2Name + ") score: " + players[1].getScore());

                    if (players[0].getScore() > players[1].getScore()) // if player 1 had a higher score than player 2, then player 2 wins
                        System.out.println("Congratulations " + player2Name + ". You won!!!");
                    else // if player 2 had a higher score than player 1, then player 1 wins
                        System.out.println("Congratulations " + player1Name + ". You won!!!");
                    
                    System.exit(0);
                }
            }
        }
    }

	/******************************************************************************************
	* getIndex:  This method prompts the user for an integer greater than or equal to zero annd less than
	*            the integer upperBound. The method reads an integer from the keyboard. If the user enters
	*            an integer less than zero or greater than the upperBound, the method should display
	*            an error message and prompts the user for an integer between 0 and the upperBound
	*            and prompt again  number until the user enters a number greater than or equal to zero and less
	 *          than the upper bound.
MN	/*******************************************************************************************/
	private static int getIndex(int upperBound)
	{
        Scanner scan = new Scanner (System.in);
        int index;

        System.out.println("The index must be a number between 0 and " + upperBound);
        System.out.println("Please indicate the the index of the card you want to remove: ");
        index = scan.nextInt();
            
        while ( index < 0 || index > upperBound)
        {
            System.out.println("The index must be a number between 0 and " + upperBound);
            System.out.println("Please indicate the the index of the card you want to remove: ");
            index = scan.nextInt();
        }

        return index;
	}

	/************************************************************************************************
	* removeMatchingTiles: This method prompts the player for the index of a card that can be removed
	*			Next, the player attempts to remove the card with the specified index from its table.
	*			If the card was removed sucessfully the method display a message
	*			indicating that the card has been removed. Otherwise, the method
	*			asks the user to try another card in his/her table.
	/**************************************************************************************************/
	private static void removeMatchingTiles(Player player, DeckOfCards cardDeck)
	{
        Scanner scan = new Scanner (System.in);
        
        int index;

        System.out.println("Please try another card. ");
        System.out.println("Please indicate the the index of the card you want to remove: ");
        index = scan.nextInt();

        while (player.remove(index, cardDeck) == false) // while the card cannot be removed
        {
            if (index < 4 || index > player.getNumberOfCards() -1)
                index = getIndex(player.getNumberOfCards() -1);
            else
            {
                System.out.println("Please try another card. ");
                System.out.println("Please indicate the the index of the card you want to remove: ");
                index = scan.nextInt();
            }
        }
	}

	/**************************************************************************************************
	* getName: This method prompts the user for the name of a player, read a name from
	*			the keyboard. Then the method validates the string, if the user has enter
	*			an empty name (by hitting Enter), the method displays an error message
	*			and prompts the user for the name again. This process continues
	*			until the user enter a sequnces of one or more characters as a name.
	***************************************************************************************************/
	private static String getName(int playerNo)
	{
        Scanner scan = new Scanner (System.in);
        System.out.println("Please enter the name of player #" + playerNo + ": ");
        String name = scan.nextLine();

        while (name.length() == 0) // while the user enters no characters
        {
            System.out.println("Please enter a name with at least one character.");
            System.out.println("Please enter the name of player #" + playerNo + ": ");
            name = scan.nextLine();
        }
        
        return name;
	}
}