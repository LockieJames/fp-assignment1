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
import java.util.List;

import static java.lang.Thread.sleep;

public class GameEngineImpl implements GameEngine
{
    private List<Player> players = new LinkedList<>();
    private List<GameEngineCallback> gameEngineCallbacks = new LinkedList<>();

    public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) throws java.lang.IllegalArgumentException
    {
        try
        {
            CoinPair coinPair = new CoinPairImpl();

            for(int i = initialDelay1; i <= finalDelay1; i += delayIncrement1)
            {
                for(GameEngineCallback gameEngineCallback : gameEngineCallbacks)
                {
                    gameEngineCallback.playerCoinUpdate(player, coinPair.getCoin1(), this);
                }

                for(GameEngineCallback gameEngineCallback : gameEngineCallbacks)
                {
                    gameEngineCallback.playerCoinUpdate(player, coinPair.getCoin2(), this);
                }

                sleep(i);
            }

            player.setResult(coinPair);

            for(GameEngineCallback gameEngineCallback : gameEngineCallbacks)
            {
                gameEngineCallback.playerResult(player, coinPair, this);
            }

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) throws java.lang.IllegalArgumentException
    {
        try
        {
            CoinPair coinPair = new CoinPairImpl();

            for(int i = initialDelay1; i <= finalDelay1; i += delayIncrement1)
            {
                for(GameEngineCallback gameEngineCallback : gameEngineCallbacks)
                {
                    gameEngineCallback.spinnerCoinUpdate(coinPair.getCoin1(), this);


                }

                for(GameEngineCallback gameEngineCallback : gameEngineCallbacks)
                {
                    gameEngineCallback.spinnerCoinUpdate(coinPair.getCoin2(), this);
                }

                sleep(i);
            }

            for(GameEngineCallback gameEngineCallback : gameEngineCallbacks)
            {
                gameEngineCallback.spinnerResult(coinPair, this);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void applyBetResults(CoinPair spinnerResult)
    {
        Iterator<Player> itr = players.iterator();

        for(int i = 0; i < players.size(); i++)
        {
            Player player = itr.next();

            player.getBetType().applyWinLoss(player, spinnerResult);
        }
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
        gameEngineCallbacks.add(gameEngineCallback);
    }

    public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback)
    {
        boolean removed = false;
        Iterator<GameEngineCallback> itr = gameEngineCallbacks.iterator();

        for(int i = 0; i < gameEngineCallbacks.size(); i++)
        {
            if(gameEngineCallback.equals(itr.next()))
            {
                gameEngineCallbacks.remove(i);
                removed = true;
                break;
            }
        }

        return removed;
    }

    public Collection<Player> getAllPlayers()
    {
        return players;
    }

    public boolean placeBet(Player player, int bet, BetType betType)
    {
        boolean betting = false;

        if(bet > 0 && player.getPoints() >= bet)
        {
            player.setBet(bet);
            player.setBetType(betType);
            betting = true;
        }
        else
        {
            player.setBet(0);
            player.setBetType(BetType.NO_BET);
        }

        return betting;
    }
}
