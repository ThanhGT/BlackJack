package BlackJack;

import java.util.*;

public class BlackjackTest {

/*Unit Testing: */

/*Test Case 1: Test the whole thing under normal random conditions (Run this LAST)
  Expected Result: Runs without errors*/
  public static void averageUnitTest() {  	  
      Blackjack blackjackInstance = new Blackjack();
      blackjackInstance.play();
  }
/*Test Case 2: Test for getting handvalue */

/*Test Case 3: Test generate deck methods.
  Generates a deck, and continuously draws, removes, and adds to a hand class. All cards from the generated deck should make it to the hand class. Deck is not shuffled
  Expected Result: 1 of each card suit/value. And total size should be 52
  This will have code coverage over the Card, Deck, and Hand classes. */
  public static Boolean deckShouldGenerateAllCards() {
  	/*Generate expected card deck from scratch (i.e. not calling the method itself)*/
  	ArrayList<Card> expectedDeck = new ArrayList<Card>();
  	StringBuilder expectedString = new StringBuilder();
  	int index=0;
    for(Card.Suits s: Card.Suits.values())
    {
		for(Card.Values v: Card.Values.values())     
        {
            expectedDeck.add(new Card(s,v));     
            expectedString.append(expectedDeck.get(index).getValue() + " of " + expectedDeck.get(index).getSuit() + "\n");           
            index++;
        } 
    }    
    /*Generated the actual card deck using the Deck class AND THEN draw from the deck and put it all in the Hand*/
  	Deck testDeck = new Deck();  	
  	Hand playerTestHand = new Hand("MyID123456!", "TesterMan");
  	StringBuilder testString = new StringBuilder();
  	for (int i=0;i<52;i++)
  	{
  		playerTestHand.addCard(testDeck.draw());
  		testDeck.removeTopCard();
  		testString.append(playerTestHand.cardToString(i) + "\n");
  	}

  	//Compare the String versions of the actual vs the expected decks
  	Boolean areBothDecksTheSame = expectedString.toString().equals(testString.toString());
  	return areBothDecksTheSame;
  }

 /**/
   public static Boolean shuffleMethodShouldProperlyShuffle() {
  	/*Generate unshuffled card deck*/  	
  	Deck unshuffledDeck = new Deck();  	
  	Hand unShuffledHand = new Hand("UnShuffleID!", "UnShuffle");   
	StringBuilder unShuffledString = new StringBuilder();
  	for (int i=0;i<52;i++)
  	{
  		unShuffledHand.addCard(unshuffledDeck.draw());
  		unshuffledDeck.removeTopCard();
  		unShuffledString.append(unShuffledHand.cardToString(i) + "\n");
  	}
  	//Generate shuffled deck
  	Deck shuffledDeck = new Deck();  	
  	Hand shuffledHand = new Hand("ShuffledID!", "ShuffleMan");  
	StringBuilder shuffledString = new StringBuilder();
  	for (int i=0;i<52;i++)
  	{
  		shuffledHand.addCard(shuffledDeck.draw());
  		shuffledDeck.removeTopCard();
  		shuffledString.append(shuffledHand.cardToString(i) + "\n");
  	}

  	Boolean areBothDecksTheSame = unShuffledString.toString().equals(shuffledString.toString());
  	return areBothDecksTheSame;
   }
   
/*Test Case 4: Draws out the entire deck of cards and print it */

   public static void main(String[] args) {  
   System.out.println("Does the generate method generate all the cards? - " + deckShouldGenerateAllCards());    
   System.out.println("Did shuffle fail? - " + shuffleMethodShouldProperlyShuffle());    
   averageUnitTest();
  }
}