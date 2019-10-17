package client;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.CoinPairImpl;
import model.GameEngineImpl;
import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import validate.Validator;
import view.GameEngineCallbackImpl;

/**
 * <pre> Simple console client for Further Programming assignment 2, 2019
 * <b>NOTE:</b> This code will not compile until you have implemented code for the supplied interfaces!
 *
 * You must be able to compile your code WITHOUT modifying this class.
 * Additional testing should be done by copying and adding to this class while ensuring this class still works.
 *
 * The provided Validator.jar will check if your code adheres to the specified interfaces!</pre>
 *
 * @author Caspar Ryan
 *
 */
public class SimpleTestClient
{
    private static final Logger logger = Logger.getLogger(SimpleTestClient.class.getName());

    public static void main(String args[])
    {
        final GameEngine gameEngine = new GameEngineImpl();

        // call method in Validator.jar to test *structural* correctness
        // just passing this does not mean it actually works .. you need to test yourself!
        // pass false if you want to show minimal logging (pass/fail) .. (i.e. ONLY once it passes)
        Validator.validate(true);

        // create some test players
        Player[] players = new Player[] { new SimplePlayer("1", "The Coin Master", 1000),
                new SimplePlayer("2", "The Loser", 750), new SimplePlayer("3", "The Dabbler", 500) };

        // add logging callback
        gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
//        gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());

        // main loop to add players and place a bet
        int enumOrdinal = 0;
        for (Player player : players)
        {
            gameEngine.addPlayer(player);
            // mod with BetType length so we always stay in range even if num players increases
            // NOTE: we are passing a different BetType each time!
            gameEngine.placeBet(player, 100, BetType.values()[enumOrdinal++ % BetType.values().length]);
            gameEngine.spinPlayer(player, 100, 1000, 100, 50, 500, 50);
        }

        logger.log(Level.INFO, "SPINNING ...");
        // OutputTrace.pdf was generated with these parameter values (using only first 3 params as per spec)
        gameEngine.spinSpinner(100, 1000, 200, 50, 500, 25);


        // TODO reset bets for next round if you were playing again

//        Player[] players2 = new Player[] { new SimplePlayer("1", "The Coin Master", 1000),
//                new SimplePlayer("2", "The Loser", 1000),
//                new SimplePlayer("3", "The Dabbler", 1000),
//                new SimplePlayer("4", "Poop", 200),
//                new SimplePlayer("5", "Lockie", 0),
//                new SimplePlayer("6", "Stef Queen", 300)};
//
//        gameEngine.addPlayer(players2[0]);
//        gameEngine.addPlayer(players2[1]);
//        gameEngine.addPlayer(players2[2]);
////        gameEngine.addPlayer(players2[3]);
////        gameEngine.addPlayer(players2[4]);
////        gameEngine.addPlayer(players2[5]);
//
//
//        gameEngine.placeBet(players2[0], 200, BetType.COIN1);
//        gameEngine.placeBet(players2[1], 100, BetType.BOTH);
//        gameEngine.placeBet(players2[2], 0, BetType.NO_BET);
////        gameEngine.placeBet(players2[3], 550, BetType.COIN2);
////        gameEngine.placeBet(players2[4], 100, BetType.COIN1);
////        gameEngine.placeBet(players2[5], 69, BetType.COIN2);
//
//
//        gameEngine.spinPlayer(players2[0], 100, 1000, 100, 50, 500, 50);
//        gameEngine.spinPlayer(players2[1], 100, 1000, 100, 50, 500, 50);
//        gameEngine.spinPlayer(players2[2], 100, 1000, 100, 50, 500, 50);
////        gameEngine.spinPlayer(players2[3], 100, 1000, 100, 50, 500, 50);
////        gameEngine.spinPlayer(players2[4], 100, 1000, 100, 50, 500, 50);
////        gameEngine.spinPlayer(players2[5], 100, 1000, 100, 50, 500, 50);
//
//
//        logger.log(Level.INFO, "SPINNING ...");
//
//        gameEngine.spinSpinner(100, 1000, 200, 50, 500, 25);
//
//        for(Player player : players2)
//        {
//            player.resetBet();
//        }
//
//        gameEngine.placeBet(players2[0], 50, BetType.COIN1);
//        gameEngine.placeBet(players2[1], 100, BetType.COIN2);
//        gameEngine.placeBet(players2[2], 150, BetType.COIN1);
//
//        gameEngine.spinPlayer(players2[0], 100, 1000, 100, 50, 500, 50);
//        gameEngine.spinPlayer(players2[1], 100, 1000, 100, 50, 500, 50);
//        gameEngine.spinPlayer(players2[2], 100, 1000, 100, 50, 500, 50);
//
//        logger.log(Level.INFO, "SPINNING ...");
//
//        gameEngine.spinSpinner(100, 1000, 200, 50, 500, 25);
//
//        for(Player player : players2)
//        {
//            player.resetBet();
//        }
//
//        gameEngine.removePlayer(players2[1]);
//
//        gameEngine.placeBet(players2[0], 50, BetType.COIN1);
//        gameEngine.placeBet(players2[2], 150, BetType.COIN1);
//
//        gameEngine.spinPlayer(players2[0], 100, 1000, 100, 50, 500, 50);
//        gameEngine.spinPlayer(players2[2], 100, 1000, 100, 50, 500, 50);
//
//        logger.log(Level.INFO, "SPINNING ...");
//
//        gameEngine.spinSpinner(100, 1000, 200, 50, 500, 25);

    }
}
