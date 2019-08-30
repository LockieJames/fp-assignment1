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
    // Class members:
    // players - a Linked List of all the players in the game : Player
    // gameEngineCallbacks - a Linked List of all the gameEngine : GameEngineCallback
    private List<Player> players = new LinkedList<>();
    private List<GameEngineCallback> gameEngineCallbacks = new LinkedList<>();

    // Methods:
    // This method spins the coins for the player passed through at the delays passed through, and then
    // uses the gameEngineCallbacks to log all the output to the console. Also sleeps the program for the
    // specified amount of time within each spin.
    public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) throws java.lang.IllegalArgumentException
    {
        try
        {
            // The final coin pair for the player passed through
            CoinPair coinPair = new CoinPairImpl();

            // This loops through the amount of time it takes for the coin to go up in the air and then land.
            // Continues until the initialDelay is the same or greater than the finalDelay, being increment
            // by the delayIncrement each interation
            for(int i = initialDelay1; i <= finalDelay1; i += delayIncrement1)
            {
                // Loops through all gameEngineCallbacks
                for(GameEngineCallback gameEngineCallback : gameEngineCallbacks)
                {
                    // Flips the first coin of the player in the gameEngineCallback
                    gameEngineCallback.playerCoinUpdate(player, coinPair.getCoin1(), this);
                }

                // Loops through all gameEngineCallbacks
                for(GameEngineCallback gameEngineCallback : gameEngineCallbacks)
                {
                    // Flips the second coin of the player in the gameEngineCallback, also logs output to the
                    // console (FINE)
                    gameEngineCallback.playerCoinUpdate(player, coinPair.getCoin2(), this);
                }

                // Pauses the program (sleep) for i (an increasing amount by the delayIncrement)
                sleep(i);
            }

            // This sets the final results of the coinPair for the player
            player.setResult(coinPair);

            // Loops through all gameEngineCallbacks
            for(GameEngineCallback gameEngineCallback : gameEngineCallbacks)
            {
                // This logs output to the console (INFO)
                gameEngineCallback.playerResult(player, coinPair, this);
            }

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    // This method spins the coins for the spinner at the delays passed through, and then uses the
    // gameEngineCallbacks to log all the output to the console. Also sleeps the program for the
    // specified amount of time within each spin.
    public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) throws java.lang.IllegalArgumentException
    {
        try
        {
            // The final coin pair for the spinner
            CoinPair coinPair = new CoinPairImpl();

            // This loops through the amount of time it takes for the coin to go up in the air and then land.
            // Continues until the initialDelay is the same or greater than the finalDelay, being increment
            // by the delayIncrement each interation
            for(int i = initialDelay1; i <= finalDelay1; i += delayIncrement1)
            {
                // Loops through all gameEngineCallbacks
                for(GameEngineCallback gameEngineCallback : gameEngineCallbacks)
                {
                    // Flips the first coin of the spinner in the gameEngineCallback
                    gameEngineCallback.spinnerCoinUpdate(coinPair.getCoin1(), this);
                }

                // Loops through all gameEngineCallbacks
                for(GameEngineCallback gameEngineCallback : gameEngineCallbacks)
                {
                    // Flips the second coin of the spinner in the gameEngineCallback
                    gameEngineCallback.spinnerCoinUpdate(coinPair.getCoin2(), this);
                }

                // Pauses the program (sleep) for i (an increasing amount by the delayIncrement)
                sleep(i);
            }

            // Loops through all gameEngineCallbacks
            for(GameEngineCallback gameEngineCallback : gameEngineCallbacks)
            {
                // This logs output to the console (INFO)
                gameEngineCallback.spinnerResult(coinPair, this);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    // This method applies all of the win or loss results to the players in the players linked list based
    // on the spinners results.
    public void applyBetResults(CoinPair spinnerResult)
    {
        // Loops through the players linked list
        for(Player player : players)
        {
            player.getBetType().applyWinLoss(player, spinnerResult);
        }
    }

    // Adds a player to the back of the linked list, unless the player ID already exists then the player
    // at that ID will be replaced.
    public void addPlayer(Player player)
    {
        boolean flag = true;
        Iterator<Player> itr = players.iterator();

        // Loops through the players array
        for(int i = 0; i < players.size(); i++)
        {
            // Checks if the ID of the player being added already exist
            if(player.getPlayerId().equals(itr.next().getPlayerId()))
            {
                // If player ID exists then replace player with that ID with the new player
                players.set(i, player);
                flag = false;
            }
        }

        // If player ID is not being used, then flag will be true and the new player will be added.
        if(flag)
        {
            players.add(player);
        }
    }

    // Returns the player with the ID that is passed through the parameters
    public Player getPlayer(String id)
    {
        Player player = null;
        Iterator<Player> itr = players.iterator();

        // Loops through the player array
        for(int i = 0; i < players.size(); i++)
        {
            if(id.equals(itr.next().getPlayerId()))
            {
                player = players.get(i);
            }
        }

        return player;
    }

    // Removes the player that is passed through from the players linked list
    public boolean removePlayer(Player player)
    {
        boolean found = false;
        Iterator<Player> itr = players.iterator();

        // Loops through the players linked list
        for(int i = 0; i < players.size(); i++)
        {
            if(player.getPlayerId().equals(itr.next().getPlayerId()))
            {
                // Removes the player at i from the players linked list
                players.remove(i);
                found = true;
                break;
            }
        }

        return found;
    }

    // Adds a gameEngineCallback to the back of the gameEngineCallbacks linked list
    public void addGameEngineCallback(GameEngineCallback gameEngineCallback)
    {
        gameEngineCallbacks.add(gameEngineCallback);
    }

    // Removes the gameEngineCallback passed through the parameter and returns true if it was found and removed
    public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback)
    {
        boolean removed = false;
        Iterator<GameEngineCallback> itr = gameEngineCallbacks.iterator();

        // Loops through the gameEngineCallbacks linked list
        for(int i = 0; i < gameEngineCallbacks.size(); i++)
        {
            if(gameEngineCallback.equals(itr.next()))
            {
                // Removes the gameEngineCallback at i
                gameEngineCallbacks.remove(i);
                removed = true;
                break;
            }
        }

        return removed;
    }

    // Returns the collection (linked list) of all the players.
    public Collection<Player> getAllPlayers()
    {
        return players;
    }

    // Returns true if the players bet is greater than 0 and that they have enough points to place
    // the bet, if all is true it sets the players bet and bet type passed through. Else, it will return false
    // if what mention before is false, and will set the players bet to 0 and their bet type to NO_BET.
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
