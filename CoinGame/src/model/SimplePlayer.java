package model;

//Created by Lockie

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

public class SimplePlayer implements Player
{
    private String playerId;
    private String playerName;

    //??
    private int points;
    private BetType betType;
    private CoinPair coinPair;
    private int bet;

    public SimplePlayer(String playerId, String playerName, int initialPoints)
    {
        this.playerId = playerId;
        this.playerName = playerName;
        this.points = initialPoints;
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
        boolean verdict = false;

        if(bet > 0 && bet <= points)
        {
            this.bet = bet;
            verdict = true;
        }

        return verdict;
    }

    public int getBet()
    {
        return bet;
    }

    public void setBetType(BetType betType)
    {
        this.betType = betType;
    }

    public BetType getBetType()
    {
        return betType;
    }

    public void resetBet()
    {
        bet = 0;
        this.betType = BetType.NO_BET;
    }

    public CoinPair getResult()
    {
        return coinPair;
    }

    public void setResult(CoinPair coinPair)
    {
        this.coinPair = coinPair;
    }

    @Override
    public String toString()
    {
        return "Player: id=" + playerId + ", name=" + playerName + ", bet=" + bet + ", betType=" + betType + ", points=" + points + ", RESULT .. " + coinPair.toString();
    }
}
