package model;

//Created by Lockie

import model.interfaces.Coin;
import model.interfaces.CoinPair;

import java.util.Objects;

public class CoinPairImpl implements CoinPair
{
    // Class members:
    // coin1 - first coin of the pair : Coin
    // coin2 - second coin of the pair : Coin
    private Coin coin1;
    private Coin coin2;

    // Methods:
    // Constructor: declares coin1 and coin2 and assigns values 1 and 2 respectively
    public CoinPairImpl()
    {
        coin1 = new CoinImpl(1);
        coin2 = new CoinImpl(2);
    }

    // Returns coin1
    public Coin getCoin1()
    {
        return coin1;
    }

    // Returns coin2
    public Coin getCoin2()
    {
        return coin2;
    }

    // Returns true if both coins in the coinPair passed through are the same as the 2 coins in this class
    public boolean equals(CoinPair coinPair)
    {
        if(this.getCoin1().equals(coinPair.getCoin1()) && this.getCoin2().equals(coinPair.getCoin2()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Casts the object passed through as a coinPair and then returns true if both coins in the coinPair passed
    // through are the same as the 2 coins in this class
    @Override
    public boolean equals(Object coinPair)
    {
        CoinPair otherCoinPair = (CoinPair) coinPair;

        if(this.getCoin1().equals(otherCoinPair.getCoin1()) && this.getCoin2().equals(otherCoinPair.getCoin2()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Returns the hash code of the two coins (coin1, coin2)
    @Override
    public int hashCode()
    {
        return Objects.hash(coin1, coin2);
    }

    // Returns a string with all the details of the coinPair, printing the toString of each coin
    @Override
    public String toString()
    {
        return coin1.toString() + ", " + coin2.toString();
    }
}
