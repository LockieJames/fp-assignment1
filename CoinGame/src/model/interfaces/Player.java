package model.interfaces;

import model.enumeration.BetType;

/**
 * <pre> Assignment interface for Further Programming representing the player
 * to be implemented by SimplePlayer class with the following constructor:
 * 	  <b>public SimplePlayer(String playerId, String playerName, int initialPoints)</b>
 *
 * <b>NOTE:</b> playerID is unique and if another player with same id is added it replaces the previous player</pre>
 *
 * @author Caspar Ryan
 *
 */
public interface Player
{
    /**
     * @return - human readable player name
     */
    public abstract String getPlayerName();

    /**
     * @param playerName - human readable player name
     */
    public abstract void setPlayerName(String playerName);

    /**
     *
     * @return - number of points from setPoints()
     */
    public abstract int getPoints();

    /**
     * @param points - for betting (updated by GameEngineImpl via BetType enum with each win or loss)
     */
    public abstract void setPoints(int points);

    /**
     * @return - the player ID which is generated by the implementing class
     */
    public abstract String getPlayerId();

    /**
     * <b>NOTE:</b> must use resetBet() for 0 bet since not valid for this method
     *
     * @param bet - the bet in points
     * @return true - if bet is greater than 0 and player has sufficient points to place the bet<br>
     */
    public abstract boolean setBet(int bet);

    /**
     * @return the bet as set with setBet()
     */
    public abstract int getBet();

    /**
     * @param betType - enum representing the type of bet being placed
     */
    public abstract void setBetType(BetType betType);

    /**
     * @return - the betType as set with setBetType()
     */
    public abstract BetType getBetType();

    /**
     * reset the bet to 0 for next round and set betType to NO_BET (in case player does not bet again in next round)
     */
    public abstract void resetBet();

    /**
     * @return a CoinPair containing final coin values as set by {@link Player#setResult(CoinPair)}
     */
    public abstract CoinPair getResult();

    /**
     *
     * @param coinPair
     *            <pre>a CoinPair containing final coin values (updated from the GameEngine
     *            {@link GameEngine#spinPlayer(Player, int, int, int, int, int, int)})</pre>
     */
    public abstract void setResult(CoinPair coinPair);

    /**
     * @return
     *          <pre>a human readable String that lists the values of this Player
     *          including their last spin result<br>
     * <br>
     * e.g "Player: id=1, name=The Coin Master, bet=100, betType=COIN1, points=900, RESULT .. Coin 1: Heads, Coin 2: Tails"<br>
     *     (see OutputTrace.pdf)</pre>
     */
    @Override
    public abstract String toString();
}
