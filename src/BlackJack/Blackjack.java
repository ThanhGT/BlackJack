package BlackJack;

import java.util.*;

/**
 * Title: BlackJack
 * Objective: Write a program to play BlackJack.
 * Notes: This will (probably be the main class used to run the game).  
 * Author: ThanhTran Student#: 991515427
 * Date: February 12, 2019
 */

 
public class Blackjack extends Game {
    
     //a deck instance variable exclusively for playing each instance 
    // of blackjack
    private Deck blackJackDeck = new Deck();  

    // empty constructor
    public Blackjack() {
      super("Blackjack");
    }

    /**
     * 
     * Method deals cards to each player
     * @param currentHand the hand the current player is holding
     */
    
    public void dealCard(Hand currentHand) {
      currentHand.addCard(blackJackDeck.draw());    // draw a card
      blackJackDeck.removeTopCard();    // removes the top card from a deck
    }  
    
    /**
    * A method that initializes the players hand and the deck also performs the
    * startingDraw() and the starting hands.
    * @param playerHand
    * @param dealerHand 
    */

    public void init(Hand playerHand, Hand dealerHand) {
      playerHand.clearHand();   // clear playerHand
      dealerHand.clearHand();   // clear dealerHand
      blackJackDeck.restartDeck();  // restarts the deck
      blackJackDeck.shuffle();  // shuffles the deck
      startingDraw(dealerHand, playerHand); // deals 2 cards to the players hand and the dealers hand
      display("\n" + playerHand.getHandString() + "\n" + playerHand.getHandValueString() + "\n" + dealerHand.getPlayerName()+ "'s hand contains: " +  dealerHand.cardToString(0) + " and one Facedown Card.");
    } 

    /**
     * A method to deal 2 cards to both players and the dealers hand
     * @param playerHand deal card to the players hand
     * @param dealerHand deal card to the dealers hand
     */
    
    public void startingDraw(Hand playerHand, Hand dealerHand) {
      dealCard(playerHand);
      dealCard(dealerHand);
      dealCard(playerHand);
      dealCard(dealerHand);
    }

    /**
     * 
     * This method evaluates and compares the hand value between two hands
     * 
     * @param playerValue the value of the players hand
     * @param dealerValue the value of the dealers hand
     */
    
    public void comapareCards(int playerValue, int dealerValue) {
      if (playerValue > dealerValue) 
        {declareWinner(true);}
      else if (playerValue < dealerValue)
        {declareWinner(false);}
      else if (playerValue==dealerValue) 
        {
          display("Draw! YOU WIN (by default)!");
        }
    }

    /**
     * 
     * This method displays a winning text depending on the flag
     * 
     */
    
    @Override
    public void declareWinner(Boolean playerWinsFlag) {
      if (playerWinsFlag)
        {display("Player Wins!");}
      else 
        {display("Dealer Wins!");}
    }    


    /**
     * 
     * Displays output to the user
     * 
     */
    
    public void display (String input) {
      System.out.println(input);
    }


    /**
    *
    * This method asks the player if they would like to hit or pass 
    * @return players final score, returns 0 if player BUSTS
    */
    
    public int playerTurn (Hand playerHand) {
        
      Boolean isFinished = false;
      Scanner keyboardInput = new Scanner(System.in); //scanner for player input
      String userInput;
      int lastCardIndex=1;

      display("\nHit? (Y for Yes and N for No)");
      userInput = keyboardInput.nextLine(); // takes in user input
      userInput = userInput.toUpperCase();  // input not-case sensitive

      while (!isFinished)
      {
        //Hit
        if (userInput.equals("Y")) 
        {
          display("Player hits...");    // display output to user
          dealCard(playerHand); // deals player a card
          lastCardIndex++;  
          display("Next card is: " + playerHand.cardToString(lastCardIndex) + "\n" + playerHand.getHandString() + "\n" + playerHand.getHandValueString());
          if (playerHand.getHandValue()>21) //BUST!
          {
            return 0;
          }        
          display("\nHit again? (Y for Yes and N for No)");
          userInput = keyboardInput.nextLine();
          userInput = userInput.toUpperCase();
        }
        //Pass
        else if (userInput.equals("N"))
        {
          display("Player passes...\n");
          isFinished = true;
        }
        //Invalid input
        else
        {
          display("Invalid input. Try again." + "\nHit? (Y for Yes and N for No)");
          userInput = keyboardInput.nextLine();
          userInput = userInput.toUpperCase();
        }
      }
      return playerHand.getHandValue();
    }

    /**
    * 
    * Method that controls either dealer hits or pass
    * if card value is less than 17, dealer will attempt to hit. Else, dealer will pass.
    * @return dealers final score, returns 0 if dealer BUSTS
    */
    
    public int dealerTurn (Hand dealerHand) {
      Boolean isFinished = false;      
      int lastCardIndex=1;

      display(dealerHand.getHandString() + "\n" + dealerHand.getHandValueString());  

      while (!isFinished)
      {
        if (dealerHand.getHandValue() < 17 )
        {
         dealCard(dealerHand);
         display("Dealer Hits...");
         lastCardIndex++;
         display("Next Card is: " + dealerHand.cardToString(lastCardIndex) + "\n" + dealerHand.getHandString() + "\n" + dealerHand.getHandValueString());
         if (dealerHand.getHandValue() > 21)
         {
            return 0;
         }
        }
        else //dealer's hand value is greater than or equal to 17. Dealer will pass.
        {
          display("Dealer passes...");
          isFinished = true;      
        }
      }
      return dealerHand.getHandValue();    
    }

/*Runs the Blackjack game. Most of the game's logic is in here. */
    @Override
    public void play() { 
      Scanner keyboardInput = new Scanner(System.in); //scanner for player input
      int playerScore, dealerScore;

      display("Game Start!\n" + "Please enter a name:");      
      Hand playerHand = new Hand(UUID.randomUUID().toString(), keyboardInput.nextLine());
      Hand dealerHand = new Hand(UUID.randomUUID().toString(), "Dealer");
      init(playerHand,dealerHand);

      //Check for Blackjack in player's opening hand
      if (playerHand.getHandValue()==21) 
      {
        display("Blackjack!\n");
        declareWinner(true);
        return;
      }

      //do player's turn
      playerScore = playerTurn(playerHand);
      if (playerScore == 0)
      {
        display("\nPlayer BUST!\n");
        declareWinner(false);
        return; 
      }

      //do dealer's turn
      dealerScore = dealerTurn(dealerHand);  
      if (dealerScore == 0)
      {
        display("\nDealer BUST!\n");
        declareWinner(true);
        return;
      }

      //display final hands before comparing
      display("\n" + playerHand.getHandString() + "\n" + playerHand.getHandValueString() + "\n" + dealerHand.getHandString() + "\n" + dealerHand.getHandValueString());
      comapareCards(playerScore, dealerScore);
    }

/******************************* Main Method ***************************************/
    public static void main(String[] args) {      
      Blackjack blackjack = new Blackjack();
      blackjack.play();
    } 

}
