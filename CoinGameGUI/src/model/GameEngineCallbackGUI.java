package model;

import javax.swing.SwingUtilities;

import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback
{
	MainFrame mainFrame;
	
	public GameEngineCallbackGUI(MainFrame mainFrame)
	{
		this.mainFrame = mainFrame;
	}
	

	@Override
	public void playerCoinUpdate(Player player, Coin coin, GameEngine engine) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				mainFrame.getDashboard().getCoinsPanel().updateCoin(coin);
			}
		});
	}

	@Override
	public void spinnerCoinUpdate(Coin coin, GameEngine engine) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				mainFrame.getDashboard().getCoinsPanel().updateCoin(coin);
			}
		});
	}

	@Override
	public void playerResult(Player player, CoinPair coinPair, GameEngine engine) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				mainFrame.getSummaryPanel().setResults(player, coinPair);
			}
		});
	}

	@Override
	public void spinnerResult(CoinPair coinPair, GameEngine engine) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				mainFrame.getSummaryPanel().setNewPoints();
			}
		});
	}
	
}
