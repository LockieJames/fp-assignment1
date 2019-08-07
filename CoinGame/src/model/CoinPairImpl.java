package model;

//Created by Lockie

import model.interfaces.Coin;
import model.interfaces.CoinPair;

import java.util.Objects;

public class CoinPairImpl implements CoinPair
{
    //MIGHT need to changed type to 'Coin'
    private CoinImpl coin1;
    private CoinImpl coin2;

    public CoinPairImpl()
    {
        coin1 = new CoinImpl(1);
        coin2 = new CoinImpl(2);
    }

    public Coin getCoin1()
    {
        return coin1;
    }

    public Coin getCoin2()
    {
        return coin2;
    }

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

    @Override
    public int hashCode()
    {
        return Objects.hash(coin1, coin2);
    }

    @Override
    public String toString()
    {
        return coin1.toString() + ", " + coin2.toString();
    }
}
