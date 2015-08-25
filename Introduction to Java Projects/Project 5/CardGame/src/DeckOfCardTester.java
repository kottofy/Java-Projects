/**
 *   DeckOfCardTester.java
 *   A tester class that tests the Card Deck class to make
 *   sure that it is working correctly.
 */
public class DeckOfCardTester {

    public static void main(String [] args)
    {
		DeckOfCards myDeck=new DeckOfCards();

		System.out.println(myDeck);

		myDeck.shuffle();

		System.out.println("Shuffling\n"+myDeck);

		for (int i=1;i<=52;i++)
        {
			if (!myDeck.isEmpty())
				System.out.println("Card: "+myDeck.draw() +	"\nCurrent Deck\n"+myDeck);
		}

		if (myDeck.isEmpty())
        {
			System.out.println("Correct!! The Deck is empty.");

			if (myDeck.draw()==null)
            {
				System.out.println("Correct!! The Deck is empty, draw returns the null reference.");
			}
			else
            {
				System.out.println("Incorrect. The Deck is empty, draw must return the null reference.");
			}
		}
		else
        {
			System.out.println("Incorrect. The Deck must be empty at this point");
		} 
    }
    //end main
}
//end class