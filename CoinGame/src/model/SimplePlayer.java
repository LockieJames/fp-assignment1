package model;

//Created by Lockie

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

public class SimplePlayer implements Player
{
    private String playerId;
    private String playerName;
    private int initialPoints;

    //??
    private int points;

    public SimplePlayer(String playerId, String playerName, int initialPoints)
    {
        this.playerId = playerId;
        this.playerName = playerName;
        this.initialPoints = initialPoints;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public String getPlayerId()
    {
        return playerId;
    }

    public boolean setBet(int bet)
    {

    }

    public int getBet()
    {

    }

    public void setBetType(BetType betType)
    {

    }

    public BetType getBetType()
    {

    }

    public void resetBet()
    {

    }

    public CoinPair getResult()
    {

    }

    public void setResult(CoinPair coinPair)
    {

    }

    @Override
    public String toString()
    {

    }
}
