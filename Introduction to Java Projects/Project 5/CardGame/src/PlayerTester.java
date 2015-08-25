/*
   This class tests the functionality of class Player.
 */
 import java.util.Scanner;

 public class PlayerTester
 {
    public static void main(String args[])
    {
    	int menuOption;
    	Scanner keyboard = new Scanner(System.in);

        //Create the DeckOfCard object

        do
        {
                System.out.println("1. Check the methods getName and toString in the class Player");
                System.out.println("2. Check the constructor and the methods getNumberOfCards and table in the class Player");
                System.out.println("3. Check the method remove with Cards left in the deck");
                System.out.println("4. Check the method remove with no Cards left in the deck");
                System.out.println("5. Check the method removeLowest with Cards left in the deck");
                System.out.println("6. Check the method removeLowest with no Cards left in the deck");
                System.out.print("Enter the test you want to run:");
                menuOption=keyboard.nextInt();

		switch (menuOption)
        {
			case 1:
            {
                System.out.println("\nTest 1: Check getName and toString methods in the class Player.");
                checkGetName ();
                break;
            }
            case 2:
            {
                System.out.println("\nTest 2: Check the methods getNumberOfCards and table in the class Player.");
                checkGetNumberOfCards();
                break;
            }
            case 3:
            {
                System.out.println("\nTest 3: Check the method remove with Cards left in the deck.");
                checkRemoveMethod(4,false);
                break;
            }
            case 4:
            {
                System.out.println("\nTest 4: Check the  method remove with no Cards left in the deck.");
                checkRemoveMethod(4,true);
                break;
            }
            case 5:
            {
                System.out.println("\nTest 5: Check removeLowest method with cards in the deck.");
                checkRemoveLightesMethod(5,false);
                break;

            }
            case 6:
            {
                System.out.println("\nTest 6: Check the method removeLowest with no cards left in the deck.");
                checkRemoveLightesMethod(6,true);
                break;
            }
            default:
            {
                System.out.println("\nThe program terminates when an invalid option is entered");
                System.exit(0);
            }
        }

        System.out.println("\n\n");

	    } while (menuOption >=1 && menuOption <= 7);

	}


    private static void checkGetName() {
 		DeckOfCards deck;
		Player player;

	        //Create the Card deck object
	   		deck=new DeckOfCards();
	       // deck.shuffle();

	        //create the player object
	        player=new Player("Test Player",deck);

	        // Test if the name of the player is set properly
	        if(player.getName().equals("Test Player"))
	            System.out.println("getName() method is correct!!");
	        else
	        	System.out.println("getName() method is not correct!!");

	        System.out.println("Current State of the Player:\n"+player);
	}


	private static void checkGetNumberOfCards()
        {
		DeckOfCards deck;
		int rand;
		String answer;
		Player player;

		Scanner keyboard = new Scanner(System.in);

		//
		// Creates a player with a Card deck having more than 5 Cardes
		//
		//
                System.out.println("Testing the Player constructor with more than 5 Cards left in the deck.");
                deck = new DeckOfCards();
                deck.shuffle();
                player=new Player("Player",deck);

                if (player.getNumberOfCards() != 5) {
                        System.out.println("The constructor does not work correctly when there are more than 4 Cards in the deck.");
                        System.out.println("Fix the Player's constructor and run the tester again. Bye!");
                    System.exit(0);
                }
                System.out.println("Current Player State:\n"+player);
                System.out.println("\nTesting the method table in the class Player.");
                Card[] currentTableau = player.table();
                if (currentTableau.length != player.getNumberOfCards()) {
                        System.out.println("The method table should create an array with as many Cards as the number of current Cards in the player's table.");
                        System.out.println("Fix the Player constructor and run the tester again. Bye!");
                        System.exit(0);
                }

                System.out.println("\nTesting if the method table returns a copy of the player's table.");
                rand = (int) Math.random()*player.getNumberOfCards() + 1;

                currentTableau[rand]= new Card();

                System.out.println("After calling the method table in the Class Player\nPlayer State:\n"+player);
                System.out.print("Has the player's table changed (y/n)?");
                answer=keyboard.next();
                if (answer.equalsIgnoreCase("Y")) {
                        System.out.println("Fix the method table to return a COPY of the player's table and run the tester again. Bye!");
                        System.exit(0);
                }
                else {
                        System.out.println("Correct, the method table must return an array that is a copy of the Player's table.");
                }



                rand = (int) Math.random()*4 + 1;
                System.out.println("\n\nTesting the Player constructor, only "+rand+" Cards in the deck.");
                        //
                        // Creates a player with a Card deck having less than 5 Cardes
                        //
                deck = new DeckOfCards();
                //deck.shuffle();

                for (int i = 1; i <= 52 - rand; i++) {

                        Card waste= deck.draw();
                }


                player=new Player("Player",deck);
                System.out.println("The Card deck has "+rand+" Card(s), the player's table gets "+rand+" Card(s).");
                System.out.println(player);
                if (player.getNumberOfCards() != rand) {
                        System.out.println("The constructor does not work correctly when there are less than 5 Cards in the deck.");
                        System.out.println("Fix the Player constructor and run the tester again. Bye!");
                    System.exit(0);

                }
                else {
                        System.out.println("Correct, the constructor populate the player's table with "+rand+" Card(s).");
                }


	}

    private static void checkRemoveMethod(int testNo, boolean withoutReplacement) {

                Player player;
                DeckOfCards deck;
        	int rand;
    		int index =0;
    		int count =0;
    		int nCards;
    		boolean removed;
    		String answer;

			Scanner keyboard = new Scanner(System.in);

			deck = new DeckOfCards();
        	deck.shuffle();
        	player = new Player("Player Test #"+testNo,deck);
        	//
        	// Generate a player table with at least one Card between matching halves
        	//
        	while (player.canRemove()<=0) {
        		deck = new DeckOfCards();
        		deck.shuffle();
        		player=new Player("Player Test #"+testNo,deck);
        	}

        	System.out.println(player);
        	System.out.print("Is the number of Cards that can be removed "+player.canRemove() +" (y/n)?");
    		answer=keyboard.next();
    		if (answer.equalsIgnoreCase("N")) {
    			System.out.println("Fix the method canRemove of the Player class and run the tester again. Bye!");
    	    	System.exit(0);
    	    }


        	System.out.println("Trying to remove an invalid Card: Card index to be removed is -1...");
        	removed = player.remove(-1,deck);
        	if (removed) {
        		System.out.println("The Card index must be between 0 and "+player.getNumberOfCards());
        		System.out.println("Fix the method remove of the Player class and run the tester again. Bye!");
        		System.exit(0);
        	}
        	else {
        		System.out.println("There is not such Card, so it could not be removed. Correct!!");
        	}


        	System.out.println("Trying to remove an invalid Card: Card index to be removed is "+(player.getNumberOfCards()+2)+"...");
        	removed = player.remove(player.getNumberOfCards()+2,deck);
        	if (removed) {
        		System.out.println("The Card index must be between 0 and "+player.getNumberOfCards()+"." );
        		System.exit(0);
        	}
        	else {
        		System.out.println("There is not such Card, so it could not be removed. Correct!!");
        	}

        	System.out.println(player);
 	        System.out.print("Please enter an index of a Card that CANNOT be removed:");
        	index=keyboard.nextInt();
        	removed = player.remove(index, deck);
        	if (removed) {
        		System.out.println("The Card "+ index + " should not be removed.");
        		System.out.println("Fix the method remove of the Player class and run the tester again. Bye!");
        		System.exit(0);
        	}
        	else {
        		System.out.println("Correct, Card "+index+"  cannot be removed.");
        	}


        	//
        	// Removing Cards from the deck to test the player's remove
        	// method after the Card deck is empty
        	//
        	if (withoutReplacement) {
        		while (!deck.isEmpty()) {
        			deck.draw();
        		}
        	}

        	count = 0;
        	while (player.canRemove() > 0 && count < 3) {
        		nCards=player.getNumberOfCards();
        		System.out.println("\n"+player);
       			System.out.println("Please enter an index of a Card that CAN  be removed:");
       			index=keyboard.nextInt();
    	    	removed = player.remove(index,deck);

    	    	if (removed) {
    	    	    System.out.println("\n"+player);
        	    	System.out.print("Was the correct Card removed (y/n)?");
        	    	answer=keyboard.next();
        			if (answer.equalsIgnoreCase("N")) {
        				System.out.println("There is a problem in either the method remove or replace of the class Player.");
        				System.out.println("Fix the problem and run the tester again. Bye!!!");
        				System.exit(0);
        			}

        	    	if (!deck.isEmpty())
                    {
        	    	    if (player.getNumberOfCards() == nCards)  {
        	       			System.out.println("Now, check the following:");
        	    	    	System.out.println("1. The Cards to the right of the removed Card were shifted one position over to the left.");
        	    	      	System.out.println("2. A new Card should be added to the right.");
        	       			System.out.print("Did that happen in the player's table (y/n)?");
        	       			answer=keyboard.next();
        		   			if (answer.equalsIgnoreCase("N")){
        		   				System.out.println("There is a problem in the method remove or replace of the class Player.");
        						System.out.println("Fix the problem and run the tester again. Bye!!!");
        						System.exit(0);
        		   			}
        	    		}
        	    		else {
        	    			System.out.println("A Card from the deck should be added to the right of the player table.");
							System.out.println("There is a problem in the method replace of the class Player.");
        					System.out.println("Fix the problem and run the tester again. Bye!!!");
        	    			System.exit(0);
        	    		}

    	    		} else if (player.getNumberOfCards() == nCards - 1) {
    	   	   			System.out.println("Correct!! The deck was empty, now check the following:");
    	   	   			System.out.println("1.The Card was removed.");
    	   	   			System.out.println("2.The Cards to the right of the removed Card were shifted one position over to the left.");
    	   	   			System.out.print("Did that happen in the player's table (y/n)?");
        	    		answer=keyboard.next();
        	    		if (answer.equalsIgnoreCase("N")) {
	        	    		System.out.println("There is a problem in the method replace of the class Player.");
	        				System.out.println("Fix the problem and run the tester again. Bye!!!");
	        	    		System.exit(0);
        	    		}

    	    		} 
                    else
                    {
        	        	System.out.println("The deck was empty (correct), the number of Cards in the player's table should be "+(nCards - 1 )+".");
        	        	System.out.println("There is a problem in the method replace of the class Player.");
        				System.out.println("Fix the problem and run the tester again. Bye!!!");
        				System.exit(0);
        	        }
	    	    }
	    	    else
                {
	    	    	System.out.println("There is a problem in the method remove or replace of the class Player.");
	    	    	System.out.println("The method remove should allow removing a Card between matching halves Card.");
        			System.out.println("Fix the problem and run the tester again. Bye!!!");
        			System.exit(0);

	    	    }
        	    count++;
       		}

        }


        private static void checkRemoveLightesMethod(int testNo, boolean withoutReplacement) {

            Card waste;
            String answer;
            Player player;
            DeckOfCards deck;
           	int index =0;
           	int nCards;
    		Scanner keyboard = new Scanner(System.in);
    		boolean removed;

			deck = new DeckOfCards();
        	deck.shuffle();
        	player = new Player("Player Test #"+testNo,deck);

        	//
        	// Generate a player table with at least one Card that can be removed
        	//
        	while (player.canRemove() > 0)
            {
        		deck = new DeckOfCards();
        		deck.shuffle();
        		player = new Player("Player Test #"+testNo,deck);
        	}

        	//
        	// Removing Cards from the deck to test the player's remove
        	// method after the Card deck is empty
        	//
        	if (withoutReplacement)
            {
        		while (!deck.isEmpty())
                {
        			waste = deck.draw();
        		}
        	}


        	System.out.println(player);
        	System.out.print("Is the number of Cards that can be removed "+player.canRemove() +" (y/n)?");
    		answer=keyboard.next();
    		if (answer.equalsIgnoreCase("N"))
            {
    			System.out.println("Fix the method canRemove of the class Player and run the tester again. Bye!");
    	    	System.exit(0);
    	    }

        	nCards=player.getNumberOfCards();


        	System.out.println("Trying to remove the lowest Card from the player's table...");
        	removed = player.removeLowest(deck);
        	if (withoutReplacement)
            {
        		if (!removed)
                {
        			System.out.println("Correct, the lowest Card cannot be removed when the deck is empty!");
        		}
        		else
                {
        			System.out.println("Incorrect, the lowest Card can not be removed when the deck is empty!");
        			System.out.println("There is a problem in either the method removeLowest or replace of the class Player.");
       				System.out.println("Fix the problem and run the tester again. Bye!!!");
       				System.exit(0);
        		}

        	}
        	else
            {
	        	System.out.println("After removing the lowest...");
	        	System.out.println(player);
	   	    	if (removed)
                {
	       	    	System.out.print("Was the correct Card removed ?(y/n)");
	       	    	answer=keyboard.next();
	       			if (answer.equalsIgnoreCase("N"))
                    {
	       				System.out.println("There is a problem in either the method removeLowest or replace of the class Player.");
	       				System.out.println("Fix the problem and run the tester again. Bye!!!");
	       				System.exit(0);
	       			}
	       			else
                    {
		        	    if (player.getNumberOfCards()==nCards)
                        {
		        	       	System.out.println("Now, check the following:");
	    	    	    	System.out.println("1. The Cards to the right of the removed Card were shifted one position over to the left.");
	        		    	System.out.println("2. A new Card should be added to the right.");
	        		       	System.out.print("Did that happen in the player's table (y/n)?");
		       				answer=keyboard.next();
			   				if (answer.equalsIgnoreCase("N"))
                            {
			   					System.out.println("There is a problem in the method removeLowest or replace of the class Player.");
								System.out.println("Fix the problem and run the tester again. Bye!!!");
								System.exit(0);
			   				}
		    			}
		    			else
                        {
		    				System.out.println("The number of Cards in the player's table should be "+nCards);
		    				System.out.println("A Card from the deck should be added to the right of the player table");
							System.out.println("There is a problem in the method removeLowest or replace of the class Player.");
							System.out.println("Fix the problem and run the tester agian. Bye!!!");
		    				System.exit(0);
		    			}
				    }
				}
				else
                {
					System.out.println("There is a problem in either the method removeLowest or replace of the class Player.");
	       			System.out.println("Fix the problem and run the tester again. Bye!!!");
	       			System.exit(0);
				}
           }
     }


}
