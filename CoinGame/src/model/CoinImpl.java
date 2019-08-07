package model;

//Created by Lockie

import model.enumeration.CoinFace;
import model.interfaces.Coin;

import java.util.Objects;
import java.util.Random;

public class CoinImpl implements Coin
{
    private int number;
    private CoinFace face;

    public CoinImpl(int number)
    {
        this.number = number;

        //Generates a random number of 0 or 1, then assigns HEADS or TAILS to face respectively.
        Random rand = new Random();
        CoinFace arr [] = CoinFace.values();

        face = arr[rand.nextInt(1)];
    }

    public int getNumber()
    {
        return number;
    }

    public CoinFace getFace()
    {
        return face;
    }

    //flip the face of the coin to the opposing side
    public void flip()
    {
        /*  Checks if the face is HEADS, if true then face is changed to TAILS;
            else if face is TAILS, face is changed to HEADS */
        if(face.equals(CoinFace.HEADS))
        {
            face = CoinFace.TAILS;
        }
        else
        {
            face = CoinFace.HEADS;
        }
    }

    public boolean equals(Coin coin)
    {
        if(face.equals(coin.getFace()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean equals(Object coin)
    {
        Coin otherCoin = (Coin) coin;

        if(face.equals(otherCoin.getFace()))
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
        return Objects.hash(face);
    }

    @Override
    public String toString()
    {
        String rString = "";

        if(face.equals(CoinFace.HEADS))
        {
            rString = "Coin " + number + ": Heads";
        }
        else
        {
            rString = "Coin " + number + ": Tails";
        }

        return rString;
    }
}
