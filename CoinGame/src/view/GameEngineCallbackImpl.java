package view;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 *
 * Skeleton implementation of GameEngineCallback showing Java logging behaviour
 *
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 *
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
    private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

    public GameEngineCallbackImpl()
    {
        // NOTE need to also set the console to FINE in %JRE_HOME%\lib\logging.properties
        logger.setLevel(Level.FINE);
    }

    public void playerCoinUpdate(Player player, Coin coin, GameEngine engine)
    {
        // Flips the coin of the player that is passed through
        coin.flip();

        logger.log(Level.FINE,player.getPlayerName() + " coin " + coin.getNumber() + " flipped to " + coin.getFace());
    }

    public void playerResult(Player player, CoinPair coinPair, GameEngine engine)
    {
        logger.log(Level.INFO, player.getPlayerName() + ", final result=" + coinPair.toString());
    }

    // TODO: implement rest of interface

    public void spinnerCoinUpdate(Coin coin, GameEngine engine)
    {
        // Flips the coin of the Spinner that is passed through
        coin.flip();

        logger.log(Level.FINE,"Spinner coin " + coin.getNumber() + " flipped to " + coin.getFace());
    }

    public void spinnerResult(CoinPair coinPair, GameEngine engine)
    {
        logger.log(Level.INFO, "Spinner, final result=" + coinPair.toString());

        // Applies all the results onto the players, going off of the results of the spinners coins
        engine.applyBetResults(coinPair);

        // Assign all of the players in the gameEngine to the players linked list
        List<Player> players = (LinkedList<Player>) engine.getAllPlayers();

        String rString = "";

        // Loops through all the players in the linked list
        for(Player player : players)
        {
            // Adds the toString of the player to the string
            rString += player.toString() + "\n";
        }

        // Logs the final results for all the players to the console
        logger.log(Level.INFO, "Final Player Results\n" + rString);
    }
}
