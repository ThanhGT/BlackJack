
package BlackJack;

import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Title: Deck
 * Objective: A class that generates a deck and shuffles the deck
 * Author: Thanh Tran   Student#: 991515427
 * Date: February 12, 2019
 */

public class Deck {
/**********************************Global Variables******************************************/      
       
    private ArrayList<Card> cardsInDeck; //an ArrayList representing the cards in the deck

/**********************************Methods And Constructors******************************************/         
    public Deck () {   
        cardsInDeck = new ArrayList<Card>();
        generateDeck();
    }

/*Clears the entire deck of cards, re-generates the deck, and shuffles it.*/        
    public void restartDeck() {
        cardsInDeck.clear();
        generateDeck();
        shuffle();
    }

/*Generates the cards in the deck from scratch*/
    private void generateDeck() {        
        for(Card.Suits s: Card.Suits.values())
        {
            for(Card.Values v: Card.Values.values())     
            {
                cardsInDeck.add(new Card(s,v));
            } 
        } 
    } 


    /**
     * 
     * A method that draws cards
     * @return the top card of a deck
     */
    
    public Card draw() {        
        return cardsInDeck.get(0);
    }

/*Removes the top card of the deck. This method SHOULD be called AFTER the draw() method. 
  I didn't know how to return the top card from the deck and remove it within the same method without having to resort to creating a new instance of the Card object.*/
    public void removeTopCard() {
        cardsInDeck.remove(0);
    }

/*Shuffles the deck. Assumes that the deck isn't empty; and even if it is, it's just going to do nothing. Uses the Fisher-Yates swap algorithm*/
    public void shuffle() {
        int index;
        Card tempCard = new Card();
        Random rnd = ThreadLocalRandom.current();
        
        for (int i=cardsInDeck.size()-1; i>0; i--)
        {
            index = rnd.nextInt(i + 1);

            //use setter and getter methods to give our temporary Card the suit/value at the current card deck index 
            tempCard.setSuit(cardsInDeck.get(index).getSuit());
            tempCard.setValue(cardsInDeck.get(index).getValue()); 

            //Swap 1: assign the current indexed card the suit/value of the iterated card 
            cardsInDeck.get(index).setSuit(cardsInDeck.get(i).getSuit());
            cardsInDeck.get(index).setValue(cardsInDeck.get(i).getValue());

            //Swap 2: assign the iterated card to have the suit/value of the temp card;
            cardsInDeck.get(i).setSuit(tempCard.getSuit());
            cardsInDeck.get(i).setValue(tempCard.getValue());
        }
    }
}
