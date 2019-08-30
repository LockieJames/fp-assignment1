package model;

//Created by Lockie

import model.enumeration.CoinFace;
import model.interfaces.Coin;

import java.util.Objects;
import java.util.Random;

public class CoinImpl implements Coin
{
    // Class members:
    // number - the number of the coin : Integer
    // face - the face of the coin, either heads or tails : CoinFace
    private int number;
    private CoinFace face;

    // Class methods:
    // Constructor: 1 argument, int number. Assigns the number passed through to the number variable of the class
    // and then randomly generates a number that assigns a HEADS or TAILS value to the face variable.
    public CoinImpl(int number)
    {
        this.number = number;

        // Generates a random number of 0 or 1, then assigns HEADS or TAILS to face respectively.
        Random rand = new Random();
        CoinFace arr [] = CoinFace.values(); // Gets all values of the enum CoinFace and puts those values into arr.

        face = arr[rand.nextInt(2)];
    }

    // Returns the number
    public int getNumber()
    {
        return number;
    }

    // Returns the face
    public CoinFace getFace()
    {
        return face;
    }

    // Flips the face of the coin to the opposing side (Heads -> Tails; Tails -> Heads)
    public void flip()
    {
        // Checks if the face is HEADS, if true then face is changed to TAILS;
        // else if face is TAILS, face is changed to HEADS
        if(face.equals(CoinFace.HEADS))
        {
            face = CoinFace.TAILS;
        }
        else
        {
            face = CoinFace.HEADS;
        }
    }

    // Returns true if the face of the coin passed through is equal to this coin
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

    // Casts the object passed through as a Coin object and then returns true if the face of the coin
    // passed through is equal to this coin
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

    // Returns the hash code of the face
    @Override
    public int hashCode()
    {
        return Objects.hash(face);
    }

    // Returns a string with the details of the coin
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
