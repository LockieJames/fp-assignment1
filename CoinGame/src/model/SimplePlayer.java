package model;

//Created by Lockie

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

public class SimplePlayer implements Player
{
    // Class members:
    // playerId - the unique id of the player : String
    // playerName - the name of the player : String
    // points - the amount of points that player has : Integer
    // betType - the betType for the player during that round : BetType
    // coinPair - the CoinPair the player has after spinning : CoinPair
    // bet - the bet (points) the player makes that round : Integer
    private String playerId;
    private String playerName;
    private int points;
    private BetType betType;
    private CoinPair coinPair;
    private int bet;

    // Constructor: 3 arguments, playerId, playerName, initialPoints. Assigns all values to there
    // respective class member variables.
    public SimplePlayer(String playerId, String playerName, int initialPoints)
    {
        this.playerId = playerId;
        this.playerName = playerName;
        points = initialPoints;
    }

    // Returns the players name
    public String getPlayerName()
    {
        return playerName;
    }

    // Sets the players name to the name passed through the method
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    // Returns the points the player has
    public int getPoints()
    {
        return points;
    }

    // Set the points of the player to the points passed through the method
    public void setPoints(int points)
    {
        this.points = points;
    }

    // Gets the id of the player
    public String getPlayerId()
    {
        return playerId;
    }

    // Sets the bet of the player for that spin, if the bet placed is 0 or the player does not have
    // enough points to place that bet the method returns false, otherwise it returns true.
    public boolean setBet(int bet)
    {
        boolean verdict = false;

        if(bet > 0 && bet <= points)
        {
            this.bet = bet;
            verdict = true;
        }

        return verdict;
    }

    // Returns the bet the player has placed
    public int getBet()
    {
        return bet;
    }

    // Sets the betType to the type passed through the method
    public void setBetType(BetType betType)
    {
        this.betType = betType;
    }

    // Returns the betType
    public BetType getBetType()
    {
        return betType;
    }

    // Resets the bet to 0 and betType to NO_BET
    public void resetBet()
    {
        bet = 0;
        this.betType = BetType.NO_BET;
    }

    // Returns the coinPair
    public CoinPair getResult()
    {
        return coinPair;
    }

    // Sets the coinPair to the coinPair passed through the method
    public void setResult(CoinPair coinPair)
    {
        this.coinPair = coinPair;
    }

    // Returns a string with all the details to do with the player
    @Override
    public String toString()
    {
        return "Player: id=" + playerId + ", name=" + playerName + ", bet=" + bet + ", betType=" + betType + ", points=" + points + ", RESULT .. " + coinPair.toString();
    }
}
