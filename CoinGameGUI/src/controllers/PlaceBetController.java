package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import view.MainFrame;

public class PlaceBetController implements ActionListener
{
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	
	public PlaceBetController(GameEngine gameEngine, MainFrame mainFrame)
	{
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try
		{
			int bet = Integer.parseInt(mainFrame.getDashboard().getInteractivePanel().getBetAmount());
			
			String betType = mainFrame.getDashboard().getInteractivePanel().getBetType();
			
			if(bet <= mainFrame.getCurrentPlayer().getPoints())
			{
				gameEngine.placeBet(mainFrame.getCurrentPlayer(), bet, asBetType(betType));
				
				mainFrame.getStatusBar().setStatus("Bet placed!");
				mainFrame.getStatusBar().setLastAction(mainFrame.getCurrentPlayer().getPlayerName() + " placed a bet");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Not enough points!");
			}
		}
		catch(NullPointerException | NumberFormatException efj)
		{
			JOptionPane.showMessageDialog(null, "Invalid amount!");
		}
	}
	
	public BetType asBetType(String betType)
	{
		if(betType.equals("Coin 1"))
		{
			return BetType.COIN1;
		}
		else if(betType.equals("Coin 2"))
		{
			return BetType.COIN2;
		}
		else if(betType.equals("Both"))
		{
			return BetType.BOTH;
		}
		else
		{
			return BetType.NO_BET;
		}
	}
}
