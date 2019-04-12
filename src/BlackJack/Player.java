package BlackJack;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 */

public abstract class Player 
{
/**********************************Global Variables******************************************/

    private String playerID; //the unique ID for this player. 
    private String playerName;

/**********************************Methods And Constructors******************************************/         
    /**
     * A constructor that allows you to set the player's unique ID
     * @param name the unique ID to assign to this player.
     */
    public Player(String givenID, String givenName)
    {
        playerID=givenID;
        playerName=givenName;
    }
    
    /**
     * @return the playerID
     */
    public String getPlayerID() 
    {
        return playerID;
    }

    public String getPlayerName() 
    {
        return playerName;
    }

    /**
     * Ensure that the playerID is unique
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) 
    {
        playerID = givenID;
    }

    /*Renames the player... for whatever reason. I actually didn't use this method¯\_(ツ)_/¯ */
    public void setPlayerName (String givenName)
    {
        playerName = givenName;
    }
    
}
