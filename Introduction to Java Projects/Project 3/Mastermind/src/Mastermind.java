/*
* Mastermind.java
* Author: Kristin Ottofy
* Last edited: 03/17/2009
*
* Purpose: This program is based on the game Mastermind. The user will be
* prompted whether they would like to play or not. If the user responds no,
* the game will terminate. If the user responds yes, the user will then be
* prompted to enter the amount of money they have to play. This amount needs
* to be greater than 2.00 dollars or the game will terminate. The user will
* then be asked the level of difficulty they would like. Beginner will allow
* the user 30 guesses to guess the 3 digit number. Intermediate will allow
* the user 20 guesses to guess the 4 digit number. Advance will allow the user
* 10 guesses to guess the 5 digit number. After the user chooses their
* difficulty, they will be pasked how much money they want to bet. This
* number must be at least 2.00 dollars  and no more than the original amount
* the user has, or the user will be prompted again
* how much money they would like to bet. Then, the user will be asked to
* guess the secret code that the program has already determined. The program
* will then display the number of correct digits in the correct place and
* the sum of those digits. The user will then be prompted to reguess the
* secret code until they guess it right. If the user guesses the secret code,
* the program will display that they have won, how many wrong guesses they
* had, how much money they have earned, how much their new balance is (their
* original amount of money plus the money they earned for guessing right), and
* if they would like to play again. If the user responds yes, the program will
* ask what level of difficulty (changing levels is allowed), and continue
* through the rest of the steps just as before. However, If the user runs out
* of guesses, the program will display that they have lost, how many guesses
* they took, the secret code, how much money they have lost, the new
* balance (the original amount of money the user had minus the money they
* lost, and the game will then terminate.
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

public class Mastermind
{
public static final double MIN_BET = 2;

    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println("Would you like to play Mastermind (yes/no)? ");
        String answer = scan.nextLine();

        String difficulty; // the level of difficulty the user enters    
        double moneyToPlay = 0; // the amount of money the user would like to bet
        double amount; // the amount of money the user has total
        int secretCodeDigits = 0; // the number of digits in the secret code
        int maxGuesses = 0; // the maximum guesses allowed for each difficulty (will be changed later in code)
        int secretCode; // the automated secret code
        int guess; // the guess the user enters
        int secretCodeDigit1; // the digit in the ones spot of the secret code (for all difficulty levels)
        int secretCodeDigit2; // the digit in the tens spot of the secret code (for all difficulty levels)
        int secretCodeDigit3; // the digit in the hundred spot of the secret code (for all difficulty levels)
        int secretCodeDigit4; // the digit in the thousands spot of the secret code (for intermediate and advance only)
        int secretCodeDigit5; // the digit in the ten thousands spot of the secret code (for advance only)
        int guessDigit1; // the digit in the ones spot of the number the user guesses (for all difficulty levels)
        int guessDigit2; // the digit in the tens spot of the number the user guesses (for all difficulty levels)
        int guessDigit3; // the digit in the hundreds spot of the number the user guesses (for all difficulty levels)
        int guessDigit4; // the digit in the thousands spot of the number the user guesses (for intermediate or advance only)
        int guessDigit5; // the digit in the ten thousands spot of the number the user guesses (for advance only)
        int incorrectGuesses = 0; // the number of guesses the user gets incorrect
        int sum = 0; // the sum of the digits the user guessed correctly
        int numberCorrect = 0; // the number of digits the user guessed correctly
        boolean win = false; // sets to true if user wins and false if the user loses (game terminates if user loses)
        String answer2 = ""; // the answer if the user wants to play the game again or not         
        double moneyEarned; // the amount of money earned by winning
        boolean wrongLevel = false; // used to determine if the user enters a wrong difficulty

        if (answer.equalsIgnoreCase ("no")) // if user would not like to play MasterMind
        {
            System.out.println("Bye, see you next time.");
            System.exit(0);
        }
        else if (answer.equalsIgnoreCase ("yes")) // if user would like to play MasterMind
        {
            System.out.println("Enter the amount of money you have to play: ");
            amount = scan.nextDouble();
            if (amount < MIN_BET)
            {
                System.out.println("Sorry, you should have at least 2.0 dollars to play the game. Bye!");
                System.exit(0);
            }
            else // if (amount >= MIN_BET)
            {
                do // do while loop
                {
                    win = false; // initialized to false at the beginning of each loop and will be changed to true if the user wins a game
                    wrongLevel = false; // initialized to false at the beginning of each loop and will be changed to true if the user does not enter a correct difficulty level

                    System.out.println("Please enter the level of difficulty (beginner, intermediate, advance): ");
                    difficulty = scan.next();
                    do // do while loop
                    {
                        // if statements will execute according to each difficulty level
                        if (difficulty.equalsIgnoreCase ("beginner"))
                        {
                            System.out.println("Enter the amount of money you want to bet: ");
                            moneyToPlay = scan.nextDouble();

                            while (moneyToPlay > amount) // while the money the user wants to bet is greater than the amount the user has
                            {
                                System.out.println("Sorry, you cannot bet more money than what you have.");
                                System.out.println("Enter the amount of money you want to bet: ");
                                moneyToPlay = scan.nextDouble();
                            }
                            while (moneyToPlay < MIN_BET) // money the user wants to bet must be greater than 2 dollars
                            {
                                System.out.println("Sorry, the minimum amount of money is 2.00 dollars.");
                                System.out.println("Enter the amount of money you want to bet: ");
                                moneyToPlay = scan.nextDouble();
                            }

                            secretCode = (int) (Math.random()*900) + 100; // the secret code is created from this formula

                            System.out.println("Please guess the 3 digit number: ");
                            guess = scan.nextInt();

                            // the guess number the user enters will be seperated into digits by the following section
                            guessDigit1 = guess / 100;
                            guessDigit2 =  (guess - ( guessDigit1 * 100)) / 10;
                            guessDigit3 = (guess - ( guessDigit1 * 100) - (guessDigit2 * 10));

                            maxGuesses = 30; // for beginner
                            incorrectGuesses = 1; // initalized to 1 in the beginning because the program will loop if the user wins

                            // the secret code will be seperated into digits by the following section
                            secretCodeDigits = 3;
                            secretCodeDigit1 = secretCode / 100;
                            secretCodeDigit2 = (secretCode - (secretCodeDigit1 * 100)) / 10;
                            secretCodeDigit3 = (secretCode - (secretCodeDigit1 * 100) - (secretCodeDigit2 * 10));

                            while (guess > 999 || guess < 100) // while guess is invalid, the user will be prompted to enter a new guess
                            {
                                System.out.println("The guess you have entered is ill-formed.");
                                System.out.println("Please guess the 3 digit number: ");
                                guess = scan.nextInt();

                                guessDigit1 = guess / 100;
                                guessDigit2 =  (guess - ( guessDigit1 * 100)) / 10;
                                guessDigit3 = (guess - ( guessDigit1 * 100) - (guessDigit2 * 10));
                            }

                            while (incorrectGuesses < maxGuesses) // while the number of incorrect guesses is less than the maximum amount of guesses, the user will be asked to enter a new guess
                            {
                                while (guess > 999 || guess < 100)
                                {
                                    System.out.println("The guess you have entered is ill-formed.");
                                    System.out.println("Please guess the 3 digit number: ");
                                    guess = scan.nextInt();

                                    guessDigit1 = guess / 100;
                                    guessDigit2 =  (guess - ( guessDigit1 * 100)) / 10;
                                    guessDigit3 = (guess - ( guessDigit1 * 100) - (guessDigit2 * 10));
                                }

                                sum = 0; // set to zero in the beginning of each loop to allow for each new sum
                                numberCorrect = 0; // set to zero in the beginning of each loop to allow for a new number of correct digits

                                // if a guessed digit equals a secret code digit (in the right spot), the sum will be edited and the number of correct digits will increase by 1
                                if (guessDigit1 == secretCodeDigit1)
                                {
                                   sum = sum + secretCodeDigit1;
                                   numberCorrect++;
                                }
                                if (guessDigit2 == secretCodeDigit2)
                                {
                                    sum = sum + secretCodeDigit2;
                                    numberCorrect++;
                                }
                                if (guessDigit3 == secretCodeDigit3)
                                {
                                    sum = sum + secretCodeDigit3;
                                    numberCorrect++;
                                }
                                
                                // this following section will display if the user guesses the secret code within the maximum amount of guesses
                                if (guess == secretCode)
                                {
                                    moneyEarned = (moneyToPlay * secretCodeDigits * (maxGuesses - incorrectGuesses) ) / maxGuesses;
                                    amount = amount + moneyEarned; // amount the user has increases with what the user has earned
                                    System.out.println();
                                    System.out.println("\t\tYou Won!!!");
                                    System.out.println("\t\tYou have had " + incorrectGuesses + " wrong guesses.");
                                    System.out.println("\t\tYou have earned " + moneyEarned + " dollars");
                                    System.out.println("\t\tYour balance is now " + amount + " dollars");
                                    System.out.println();
                                    win = true; // sets to true since the user won
                                    break; // exit loop because the user guessed the secret code and does not need to guess anymore
                                }
                                
                                // the following displays after each time the user guesses, but not if the guess is correct
                                System.out.println("Number of correct digits: " + numberCorrect);
                                System.out.println("Sum: " + sum);
                                System.out.println("Please guess the 3 digit number: ");
                                guess = scan.nextInt();
                                
                                guessDigit1 = guess / 100;
                                guessDigit2 =  (guess - ( guessDigit1 * 100)) / 10;
                                guessDigit3 = (guess - ( guessDigit1 * 100) - (guessDigit2 * 10));
                                
                                // incorrectGuesses increases by 1 if the user does not guess the secret code
                                if (guess != secretCode)
                                {
                                    incorrectGuesses++;
                                }
                            } // end of loop
                            
                            if (incorrectGuesses == maxGuesses)
                            {
                                if (secretCode == guess) // if the user guesses the code on the last allowable guess, then the following will execute
                                {
                                    moneyEarned = (moneyToPlay * secretCodeDigits * (maxGuesses - incorrectGuesses) ) / maxGuesses;
                                    amount = amount + moneyEarned; // amount the user has is changed to add the amount the user earned from winning
                                    System.out.println();
                                    System.out.println("\t\tYou Won!!!");
                                    System.out.println("\t\tYou have had " + incorrectGuesses + " wrong guesses.");
                                    System.out.println("\t\tYou have earned " + moneyEarned + " dollars");
                                    System.out.println("\t\tYour balance is now " + amount + " dollars");
                                    System.out.println();
                                    win = true; // used to determine whether to prompt the user to play again because they won or not
                                    break; // exit loop since the user guessed the secret code and no longer needs to guess anymore
                                }
                                
                                // if the user does not guess the secret code within the allowable guesses, then the user will lose the money they bet
                                amount = amount - moneyToPlay;
                                System.out.println();
                                System.out.println("\t\tSorry, you lost!!!");
                                System.out.println("\t\tYou have guessed " + maxGuesses + " times");
                                System.out.println("\t\tThe number was " + secretCode);
                                System.out.println("\t\tYou have lost " + moneyToPlay + " dollars");
                                System.out.println("\t\tYour balance is now " + amount + " dollars");
                                System.out.println();
                                System.out.println("The game has terminated.");
                                System.out.println("Bye. Come back to play again!!");
                                System.exit(0); // the program will exit if the user loses
                            }
                            difficulty = ""; //set back to nothing so if the user won then they can pick a new difficulty when prompted
                        }

                        else if (difficulty.equalsIgnoreCase ("intermediate"))
                        {
                            System.out.println("Enter the amount of money you want to bet: ");
                            moneyToPlay = scan.nextDouble();

                            while (moneyToPlay > amount) // money the user bets cannot be more than the money they have. the user will be prompted again
                            {
                                System.out.println("Sorry, you cannot bet more money than what you have.");
                                System.out.println("Enter the amount of money you want to bet: ");
                                moneyToPlay = scan.nextDouble();
                            }
                            while (moneyToPlay < MIN_BET) // money the user bets cannot be less than the minumum bet of 2 dollars, the user will be prompted again
                            {
                                System.out.println("Sorry, the minimum amount of money is 2.00 dollars.");
                                System.out.println("Enter the amount of money you want to bet: ");
                                moneyToPlay = scan.nextDouble();
                            }

                            secretCode = (int) (Math.random()*9000) + 1000; // the secret code for the 4 digit number is determined by this formula

                            System.out.println("Please guess the 4 digit number: ");
                            guess = scan.nextInt();

                            // this section seperates the digits of the number of user guessed
                            guessDigit1 = guess / 1000;
                            guessDigit2 = (guess - ( guessDigit1 * 1000)) / 100;
                            guessDigit3 = (guess - ( guessDigit1 * 1000) - (guessDigit2 * 100)) / 10;
                            guessDigit4 = (guess - ( guessDigit1 * 1000) - (guessDigit2 * 100) - (guessDigit3 * 10));

                            maxGuesses = 20; // for intermediate
                            incorrectGuesses = 1; // sets to one at the beginning of each level because if the user wins, this section may be used again

                            // the secret code digits will be evaluted through this next section
                            secretCodeDigits = 4;
                            secretCodeDigit1 = secretCode / 1000;
                            secretCodeDigit2 = (secretCode - (secretCodeDigit1 * 1000)) / 100;
                            secretCodeDigit3 = (secretCode - (secretCodeDigit1 * 1000) - (secretCodeDigit2 * 100)) / 10;
                            secretCodeDigit4 = (secretCode - (secretCodeDigit1 * 1000) - (secretCodeDigit2 * 100) - (secretCodeDigit3 * 10));

                            while (guess > 9999 || guess < 1000) // while guess is invalid, the user will be prompted to reenter a guess
                            {
                                System.out.println("The guess you have entered is ill-formed.");
                                System.out.println("Please guess the 4 digit number: ");
                                guess = scan.nextInt();

                                guessDigit1 = guess / 1000;
                                guessDigit2 = (guess - ( guessDigit1 * 1000)) / 100;
                                guessDigit3 = (guess - ( guessDigit1 * 1000) - (guessDigit2 * 100)) / 10;
                                guessDigit4 = (guess - ( guessDigit1 * 1000) - (guessDigit2 * 100) - (guessDigit3 * 10));
                            }

                            while (incorrectGuesses < maxGuesses) // while the number of incorrect guess is less than the maximum amount of allowable guesses
                            {
                                while (guess > 9999 || guess < 1000) // while the guess is invalid, the user will be prompted to reenter a guess
                                {
                                    System.out.println("The guess you have entered is ill-formed.");
                                    System.out.println("Please guess the 4 digit number: ");
                                    guess = scan.nextInt();

                                    guessDigit1 = guess / 1000;
                                    guessDigit2 = (guess - ( guessDigit1 * 1000)) / 100;
                                    guessDigit3 = (guess - ( guessDigit1 * 1000) - (guessDigit2 * 100)) / 10;
                                    guessDigit4 = (guess - ( guessDigit1 * 1000) - (guessDigit2 * 100) - (guessDigit3 * 10));
                                }
                                
                                sum = 0; // the sum is set to 0 at the beginning of each loop and can be changed if the user guesses a secret code digit
                                numberCorrect = 0; // sets to 0 at the beginning of each loop and will incerase if the user guesses a secret code digit
                                
                                if (guessDigit1 == secretCodeDigit1)
                                {
                                   sum = sum + secretCodeDigit1;
                                   numberCorrect++;
                                }
                                if (guessDigit2 == secretCodeDigit2)
                                {
                                    sum = sum + secretCodeDigit2;
                                    numberCorrect++;
                                }
                                if (guessDigit3 == secretCodeDigit3)
                                {
                                    sum = sum + secretCodeDigit3;
                                    numberCorrect++;
                                }
                                if (guessDigit4 == secretCodeDigit4)
                                {
                                    sum = sum + secretCodeDigit4;
                                    numberCorrect++;
                                }
                                
                                if (guess == secretCode) // if the user wins
                                {
                                    moneyEarned = (moneyToPlay * secretCodeDigits * (maxGuesses - incorrectGuesses) ) / maxGuesses;
                                    amount = amount + moneyEarned; // the amount of money earned will be added to the amount the user has
                                    System.out.println();
                                    System.out.println("\t\tYou Won!!!");
                                    System.out.println("\t\tYou have had " + incorrectGuesses + " wrong guesses.");
                                    System.out.println("\t\tYou have earned " + moneyEarned + " dollars");
                                    System.out.println("\t\tYour balance is now " + amount + " dollars");
                                    System.out.println();
                                    win = true; // win will be set to true since the user just won
                                    break; // exit loop since there is no longer a need to guess the secret code
                                }
                                
                                // this section displays after each incorrect guess and prompts the user to enter a new guess
                                System.out.println("Number of correct digits: " + numberCorrect);
                                System.out.println("Sum: " + sum);
                                System.out.println("Please guess the 4 digit number: ");
                                guess = scan.nextInt();

                                // the guess is seperated in digits by the following section
                                guessDigit1 = guess / 1000;
                                guessDigit2 = (guess - ( guessDigit1 * 1000)) / 100;
                                guessDigit3 = (guess - ( guessDigit1 * 1000) - (guessDigit2 * 100)) / 10;
                                guessDigit4 = (guess - ( guessDigit1 * 1000) - (guessDigit2 * 100) - (guessDigit3 * 10));

                                // if the user doesn't guess the secret code, the number of incorrect guesses increases by 1
                                if (guess != secretCode)
                                {
                                    incorrectGuesses++;
                                }
                            }

                            if (incorrectGuesses == maxGuesses)
                            {
                                if (secretCode == guess) // if the user wins, the following will execute
                                {
                                    moneyEarned = (moneyToPlay * secretCodeDigits * (maxGuesses - incorrectGuesses) ) / maxGuesses;
                                    amount = amount + moneyEarned; // the amount of money the user earned by winning will be added to the amount the user has
                                    System.out.println();
                                    System.out.println("\t\tYou Won!!!");
                                    System.out.println("\t\tYou have had " + incorrectGuesses + " wrong guesses.");
                                    System.out.println("\t\tYou have earned " + moneyEarned + " dollars");
                                    System.out.println("\t\tYour balance is now " + amount + " dollars");
                                    System.out.println();
                                    win = true; // win is set to true since the user just won
                                    break; // exit loop since there is no longer a need to enter a guess
                                }
                                
                                // if incorrectGuesses == maxGuesses, then the user loses and the following executes
                                amount = amount - moneyToPlay; // the amount the user bets is subtracted from the amount the user had
                                System.out.println();
                                System.out.println("\t\tSorry, you lost!!!");
                                System.out.println("\t\tYou have guessed " + maxGuesses + " times");
                                System.out.println("\t\tThe number was " + secretCode);
                                System.out.println("\t\tYou have lost " + moneyToPlay + " dollars");
                                System.out.println("\t\tYour balance is now " + amount);
                                System.out.println();
                                System.out.println("The game has terminated.");
                                System.out.println("Bye. Come back to play again!!");
                                System.exit(0); // the program exits if the user loses
                            }
                            difficulty = ""; // difficulty is set to nothing at the end of each level in case the user wins and wants to change levels
                        }
                        else if (difficulty.equalsIgnoreCase ("advance"))
                        {
                            System.out.println("Enter the amount of money you want to bet: ");
                            moneyToPlay = scan.nextDouble();

                            while (moneyToPlay > amount) // the amount of money the user bets cannot be more than the amount the user has and the user will be prompted to reenter
                            {
                                System.out.println("Sorry, you cannot bet more money than what you have.");
                                System.out.println("Enter the amount of money you want to bet: ");
                                moneyToPlay = scan.nextDouble();
                            }
                            while (moneyToPlay < MIN_BET) // the amount of money the user bets cannot be less than the minimum bet of 2 dollars and the user will be prompted to reenter
                            {
                                System.out.println("Sorry, the minimum amount of money is 2.00 dollars.");
                                System.out.println("Enter the amount of money you want to bet: ");
                                moneyToPlay = scan.nextDouble();
                            }

                            secretCode = (int) (Math.random()*90000) + 10000; // the secret code for advance is evaluated by this formula

                            System.out.println("Please guess the 5 digit number: ");
                            guess = scan.nextInt();

                            // the guess digits are evaluated by the following section
                            guessDigit1 = guess / 10000;
                            guessDigit2 = (guess - ( guessDigit1 * 10000)) / 1000;
                            guessDigit3 = (guess - ( guessDigit1 * 10000) - (guessDigit2 * 1000)) / 100;
                            guessDigit4 = (guess - ( guessDigit1 * 10000) - (guessDigit2 * 1000) - (guessDigit3 * 100)) / 10;
                            guessDigit5 = (guess - ( guessDigit1 * 10000) - (guessDigit2 * 1000) - (guessDigit3 * 100) - (guessDigit4 * 10));

                            maxGuesses = 10; // for advance
                            incorrectGuesses = 1; // set to 1 at the beginning of each level to clear any other number that incorrectGuessses may have been set to from a previous loop

                            // the secret code digits are evaluated by the following section
                            secretCodeDigits = 5;
                            secretCodeDigit1 = secretCode / 10000;
                            secretCodeDigit2 = (secretCode - (secretCodeDigit1 * 10000)) / 1000;
                            secretCodeDigit3 = (secretCode - (secretCodeDigit1 * 10000) - (secretCodeDigit2 * 1000)) / 100;
                            secretCodeDigit4 = (secretCode - (secretCodeDigit1 * 10000) - (secretCodeDigit2 * 1000) - (secretCodeDigit3 * 100)) /10;
                            secretCodeDigit5 = (secretCode - (secretCodeDigit1 * 10000) - (secretCodeDigit2 * 1000) - (secretCodeDigit3 * 100) - (secretCodeDigit4 * 10));

                            while (guess > 99999 || guess < 10000) // while guess is invalid, the user will be prompted to reenter a guess 
                            {
                                System.out.println("The guess you have entered is ill-formed.");
                                System.out.println("Please guess the 5 digit number: ");
                                guess = scan.nextInt();

                                // the guesss digits are evaluated by the following section
                                guessDigit1 = guess / 10000;
                                guessDigit2 = (guess - ( guessDigit1 * 10000)) / 1000;
                                guessDigit3 = (guess - ( guessDigit1 * 10000) - (guessDigit2 * 1000)) / 100;
                                guessDigit4 = (guess - ( guessDigit1 * 10000) - (guessDigit2 * 1000) - (guessDigit3 * 100)) / 10;
                                guessDigit5 = (guess - ( guessDigit1 * 10000) - (guessDigit2 * 1000) - (guessDigit3 * 100) - (guessDigit4 * 10));
                            }

                            while (incorrectGuesses < maxGuesses) 
                            {
                                while (guess > 99999 || guess < 10000) // while guess is invalid, the user will be prompted to reenter a guess
                                {
                                    System.out.println("The guess you have entered is ill-formed.");
                                    System.out.println("Please guess the 5 digit number: ");
                                    guess = scan.nextInt();

                                    // the guess digits are evaluated by the following section
                                    guessDigit1 = guess / 10000;
                                    guessDigit2 = (guess - ( guessDigit1 * 10000)) / 1000;
                                    guessDigit3 = (guess - ( guessDigit1 * 10000) - (guessDigit2 * 1000)) / 100;
                                    guessDigit4 = (guess - ( guessDigit1 * 10000) - (guessDigit2 * 1000) - (guessDigit3 * 100)) / 10;
                                    guessDigit5 = (guess - ( guessDigit1 * 10000) - (guessDigit2 * 1000) - (guessDigit3 * 100) - (guessDigit4 * 10));
                                }
                                
                                sum = 0; // sum is set to 0 at the beginning of the loop to clear any previously set sum
                                numberCorrect = 0; // numberCorrect is set to 0 at the beginning of the loop to clear any previously set numberCorrect
                                
                                // if the user guesses one of the secret code digits, the sum will be added to the correct digit and the number of correct digits will increase by 1
                                if (guessDigit1 == secretCodeDigit1)
                                {
                                   sum = sum + secretCodeDigit1;
                                   numberCorrect++;
                                }
                                if (guessDigit2 == secretCodeDigit2)
                                {
                                    sum = sum + secretCodeDigit2;
                                    numberCorrect++;
                                }
                                if (guessDigit3 == secretCodeDigit3)
                                {
                                    sum = sum + secretCodeDigit3;
                                    numberCorrect++;
                                }
                                if (guessDigit4 == secretCodeDigit4)
                                {
                                    sum = sum + secretCodeDigit4;
                                    numberCorrect++;
                                }
                                if (guessDigit5 == secretCodeDigit5)
                                {
                                    sum = sum + secretCodeDigit5;
                                    numberCorrect++;
                                }
                                
                                if (guess == secretCode) // if the user wins, the following will execute
                                {
                                    moneyEarned = (moneyToPlay * secretCodeDigits * (maxGuesses - incorrectGuesses) ) / maxGuesses;
                                    amount = amount + moneyEarned; // the amount the user earns for winning will be added to the amount the user had
                                    System.out.println();
                                    System.out.println("\t\tYou Won!!!");
                                    System.out.println("\t\tYou have had " + incorrectGuesses + " wrong guesses.");
                                    System.out.println("\t\tYou have earned " + moneyEarned + " dollars");
                                    System.out.println("\t\tYour balance is now " + amount + " dollars");
                                    System.out.println();
                                    win = true; // win will be set to true since the user just won
                                    break; // exit the loop because the user has just won and there is no more need to enter a new guess
                                }
                                
                                // the following displays after each incorrect guess and the user is prompted to enter a new guess
                                System.out.println("Number of correct digits: " + numberCorrect);
                                System.out.println("Sum: " + sum);

                                System.out.println("Please guess the 5 digit number: ");
                                guess = scan.nextInt();

                                // the guess digits are seperated by the following section
                                guessDigit1 = guess / 10000;
                                guessDigit2 = (guess - ( guessDigit1 * 10000)) / 1000;
                                guessDigit3 = (guess - ( guessDigit1 * 10000) - (guessDigit2 * 1000)) / 100;
                                guessDigit4 = (guess - ( guessDigit1 * 10000) - (guessDigit2 * 1000) - (guessDigit3 * 100)) / 10;
                                guessDigit5 = (guess - ( guessDigit1 * 10000) - (guessDigit2 * 1000) - (guessDigit3 * 100) - (guessDigit4 * 10));

                                if (guess != secretCode) // if the user guesses incoorrectly, the number of incorrect guesses increases by 1
                                {
                                    incorrectGuesses++;
                                }
                            }
                            
                            if (incorrectGuesses == maxGuesses)
                            {
                                if (secretCode == guess) // if the user wins, the following will execute
                                {
                                    moneyEarned = (moneyToPlay * secretCodeDigits * (maxGuesses - incorrectGuesses) ) / maxGuesses;
                                    amount = amount + moneyEarned; // the amount the user has will be added to the amount the user earns by winning
                                    System.out.println();
                                    System.out.println("\t\tYou Won!!!");
                                    System.out.println("\t\tYou have had " + incorrectGuesses + " wrong guesses.");
                                    System.out.println("\t\tYou have earned " + moneyEarned + " dollars");
                                    System.out.println("\t\tYour balance is now " + amount + " dollars");
                                    System.out.println();
                                    win = true; // win will be set to true since the user just won
                                    break; // exit the loop since the user guessed the secret code and there is no longer a need to guess it
                                }
                               
                                amount = amount - moneyToPlay;// if the user loses, the amount the user bet will be subtracted from the amount the user had
                                System.out.println();
                                System.out.println("\t\tSorry, you lost!!!");
                                System.out.println("\t\tYou have guessed " + maxGuesses + " times");
                                System.out.println("\t\tThe number was " + secretCode);
                                System.out.println("\t\tYou have lost " + moneyToPlay + " dollars");
                                System.out.println("\t\tYour balance is now " + amount);
                                System.out.println();
                                System.out.println("The game has terminated.");
                                System.out.println("Bye. Come back to play again!!");
                                System.exit(0); // the program terminates since the user lost
                            }
                            difficulty = ""; // if the user wins, the difficulty will be set to nothing so the user will be prompted to enter a new level
                        }

                        else // else if the difficulty level does not equal beginner, intermediate, or advance
                        {
                           do // do while the user does not enter a correct difficulty level
                           {
                                System.out.println("Sorry, this is not a correct level.");
                                System.out.println("Please enter the level of difficulty (beginner, intermediate, advance): ");
                                difficulty = scan.next();
                                if (difficulty.equalsIgnoreCase("beginner") || difficulty.equalsIgnoreCase("intermediate") || difficulty.equalsIgnoreCase("advance"))
                                    wrongLevel = true;
                           }
                           while (wrongLevel != true);
                        } // end of else clause
                }
                while (difficulty.equalsIgnoreCase("beginner") || difficulty.equalsIgnoreCase("intermediate") || difficulty.equalsIgnoreCase("advance"));

                    if (win == true) // if the user won, the following will execute
                    {
                        System.out.println("Would you like to play again (yes/no)?");
                        answer2 = scan.next();
                        if (answer2.equalsIgnoreCase("no")) // if the user does not want to play again, the program terminates
                        {
                            System.out.println("The game has terminated.");
                            System.out.println("Bye. Come back to play again!!");
                            System.exit(0);
                        }
                    }
                }
                while (answer2.equalsIgnoreCase("yes")); // if the user does want to play again, the loop will execute again
            }
        }
    }
}