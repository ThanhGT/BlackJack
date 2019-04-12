package BlackJack;

/*Class for each player's hand
  In the case of multiple players, there should be a unique ID for each instance of the hand class.*/

/*List of methods in this class:
  */

import java.util.*;

public class Hand extends Player {

/**********************************Global Variables******************************************/

	private ArrayList<Card> cardsInHand;			//instantiate the cards in hand only on construction

/**********************************Methods And Constructors******************************************/

/*Constructor. Sets the player ID and name of the super class to the inputted strings. Also instantiates the ArrayList */
	public Hand (String givenID, String givenName) 
	{		
		super(givenID, givenName);
		cardsInHand = new ArrayList<Card>();	
	}

/*Utility method for returning the arraylist*/
	public int getHandSize() 
	{
		return cardsInHand.size();
	}

/*Clears the hand*/
	public void clearHand ()
	{
		cardsInHand.clear();
	}
/*Adds a card to the arraylist. Since we're using the add() function, it adds the card as the last element*/
	public void addCard(Card newCard)
	{
		cardsInHand.add(newCard);
	}

/*Removes card at the given index*/
	public void removeCard(int index)
	{
		cardsInHand.remove(index);
	}

/*Returns (but doesn't remove) a card object at the given index*/
	public Card getCardAtIndex(int index)
	{
		return cardsInHand.get(index);
	}

/*Calculates the total value of the hand of the given player. 
  Adds ACE as an 11 unless hand value is over 21, which returns 1 instead. Only returns the highest possible value that the hand could have with an ACE(s) */
    public int getHandValue() {
      int sum = 0;
      int aceCount=0;    
      for (Card c : cardsInHand)
      {        
        if (c.getValueInt()==11) 
          {aceCount++;}
        sum += c.getValueInt();              
      }
      if ((aceCount>0) && (sum>21)) 
      {      
        while (sum>21)
        {
          sum -= 10;          
        }        
      }
      return sum;
    }

/*Returns the entire hand value as a string with player's name as formatting*/
    public String getHandValueString() {
    	StringBuilder sumString = new StringBuilder(super.getPlayerName() + "'s " + "hand value is: " + getHandValue());
    	return sumString.toString();
    }

/* Returns a card at a given index as a string */
    public String cardToString (int index) {
      StringBuilder cardString = new StringBuilder (cardsInHand.get(index).valueString());    
      cardString.append(" of " + cardsInHand.get(index).suitString());      
      return cardString.toString();
    }

/*Returns the entire Hand as a String*/
    public String getHandString() {
      int size = cardsInHand.size();
      StringBuilder tempString = new StringBuilder(super.getPlayerName() + "'s " + "hand contains: ");
      for (int i=0; i<size;i++) 
      {
        //formatting
        if (i==(size-1)) //last card so don't put a comma
        {
        	tempString.append(cardToString(i));
        }
        else 
        {
          tempString.append(cardToString(i) + ", ");
        }
      } 
      return tempString.toString();     
    }
}