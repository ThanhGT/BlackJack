/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JD
 */
public class BlackjackTest {
    
    public BlackjackTest() {
    }
    

    /**
     * Test of dealCard method, of class Blackjack.
     */
    @Test
    public void testDealCard() {
        System.out.println("dealCard");
        Hand currentHand = null;
        Blackjack instance = new Blackjack();
        instance.dealCard(currentHand);
    }

    /**
     * Test of init method, of class Blackjack.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        Hand playerHand = null;
        Hand dealerHand = null;
        Blackjack instance = new Blackjack();
        instance.init(playerHand, dealerHand);
    }

    /**
     * Test of startingDraw method, of class Blackjack.
     */
    @Test
    public void testStartingDraw() {
        System.out.println("startingDraw");
        Hand playerHand = null;
        Hand dealerHand = null;
        Blackjack instance = new Blackjack();
        instance.startingDraw(playerHand, dealerHand);
    }

    /**
     * Test of comapareCards method, of class Blackjack.
     */
    @Test
    public void testComapareCards() {
        System.out.println("comapareCards");
        int playerValue = 0;
        int dealerValue = 0;
        Blackjack instance = new Blackjack();
        instance.comapareCards(playerValue, dealerValue);
    }

    /**
     * Test of declareWinner method, of class Blackjack.
     */
    @Test
    public void testDeclareWinner() {
        System.out.println("declareWinner");
        Boolean playerWinsFlag = null;
        Blackjack instance = new Blackjack();
        instance.declareWinner(playerWinsFlag);
    }

    /**
     * Test of display method, of class Blackjack.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        String input = "";
        Blackjack instance = new Blackjack();
        instance.display(input);
    }

    /**
     * Test of playerTurn method, of class Blackjack.
     */
    @Test
    public void testPlayerTurn() {
        System.out.println("playerTurn");
        Hand playerHand = null;
        Blackjack instance = new Blackjack();
        int expResult = 0;
        int result = instance.playerTurn(playerHand);
        assertEquals(expResult, result);
    }

    /**
     * Test of dealerTurn method, of class Blackjack.
     */
    @Test
    public void testDealerTurn() {
        System.out.println("dealerTurn");
        Hand dealerHand = null;
        Blackjack instance = new Blackjack();
        int expResult = 0;
        int result = instance.dealerTurn(dealerHand);
        assertEquals(expResult, result);
    }

    /**
     * Test of play method, of class Blackjack.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Blackjack instance = new Blackjack();
        instance.play();
    }

    /**
     * Test of main method, of class Blackjack.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Blackjack.main(args);
    }
    
}
