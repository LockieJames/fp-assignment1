package model;

//Created by Lockie

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class GameEngineImpl implements GameEngine
{
    private LinkedList<Player> players = new LinkedList<>();
    private GameEngineCallback gameEngineCallback = null;

    public GameEngineImpl()
    {

    }

    public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) throws IllegalArgumentException
    {

    }

    public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) throws IllegalArgumentException
    {

    }

    public void applyBetResults(CoinPair spinnerResult)
    {

    }

    public void addPlayer(Player player)
    {
        boolean flag = true;
        Iterator<Player> itr = players.iterator();

        for(int i = 0; i < players.size(); i++)
        {
            if(player.getPlayerId().equals(itr.next().getPlayerId()))
            {
                players.set(i, player);
                flag = false;
            }
        }

        if(flag)
        {
            players.add(player);
        }
    }

    public Player getPlayer(String id)
    {
        Player player = null;
        Iterator<Player> itr = players.iterator();

        for(int i = 0; i < players.size(); i++)
        {
            if(id.equals(itr.next().getPlayerId()))
            {
                player = players.get(i);
            }
        }

        return player;
    }

    public boolean removePlayer(Player player)
    {
        boolean found = false;
        Iterator<Player> itr = players.iterator();

        for(int i = 0; i < players.size(); i++)
        {
            if(player.getPlayerId().equals(itr.next().getPlayerId()))
            {
                players.remove(i);
                found = true;
                break;
            }
        }

        return found;
    }

    public void addGameEngineCallback(GameEngineCallback gameEngineCallback)
    {
        this.gameEngineCallback = gameEngineCallback;
    }

    public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback)
    {
        boolean removed = false;

        if(this.gameEngineCallback.equals(gameEngineCallback))
        {
            removed = true;
            this.gameEngineCallback = null;
        }

        return removed;
    }

    public Collection<Player> getAllPlayers()
    {
        return players;
    }

    public boolean placeBet(Player player, int bet, BetType betType)
    {
        return true;
    }
}
