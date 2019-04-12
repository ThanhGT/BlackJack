package BlackJack;

/**
 * Title: Card
 * Objective: models individual cards
 * Author: Thanh Tran   Student#: 
 * Date: February 12, 2019
 */
public class Card {
/**********************************Global Variables******************************************/

    public enum Suits {HEARTS, SPADES, CLUBS, DIAMONDS};
    public enum Values {ACE,TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};

    private Suits suit;
    private Values val;

/**********************************Methods And Constructors******************************************/         

    public Card() {}
        
    public Card(Suits suit, Values val)
    {
       this.suit = suit;
       this.val = val;
    }
        
	public Values getValue() {
            return this.val;
	}

	public Suits getSuit() {
            return this.suit;
    }

    //Utility method used to set the value of a given card. Use mainly for the shuffle method in the Deck class
    public void setValue(Values val) {
        this.val = val;
    }
    
    //Utility method used to set the suit of a given card. Use mainly for the shuffle method in the Deck class
    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    //used to return a string of the value of a given card. Used for display purposes
    public String valueString() {
        return "" + this.val;
    }

    //used to return a string of the suit of a given card. Used for display purposes
    public String suitString() {
        return "" + this.suit;
    }

    //ACE is either 1 or 11 and has to be calculated based on the current Hand. So we'll calculate that not here but in the Blackjack class.
    public int getValueInt() {
        String valString = valueString();
        if (valString.equals("TWO")) {return 2;}
        else if (valString.equals("THREE")) {return 3;}
        else if (valString.equals("FOUR")) {return 4;}
        else if (valString.equals("FIVE")) {return 5;}
        else if (valString.equals("SIX")) {return 6;}
        else if (valString.equals("SEVEN")) {return 7;}
        else if (valString.equals("EIGHT")) {return 8;}
        else if (valString.equals("NINE")) {return 9;}
        else if (valString.equals("TEN") || valString.equals("JACK") || valString.equals("QUEEN") || valString.equals("KING")) {return 10;}
        else {return 11;} //else, it is an ACE. Return the highest value of ACE, which is 11, for now.   
    } 
}