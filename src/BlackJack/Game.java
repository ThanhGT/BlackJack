package BlackJack;

import java.util.ArrayList;

public abstract class Game 
{

    private final String gameName;  //the title of the game


    public Game(String givenName)
    {
        gameName = givenName;
    }

    /**
     * @return the gameName
     */
    
    public String getGameName() 
    {
        return gameName;
    }
    
    /**
    *  an abstract method that plays the game 
    */
    
    public abstract void play();
    
    /**
     * 
     * This method declares the winner
     * 
     */
    
    public abstract void declareWinner(Boolean playerWinsFlag);   
    
}//end class
