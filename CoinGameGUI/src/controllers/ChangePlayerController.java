package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

public class ChangePlayerController implements ActionListener
{
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	
	public ChangePlayerController(GameEngine gameEngine, MainFrame mainFrame)
	{
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			String name = mainFrame.getDashboard().getInteractivePanel().getPlayerName();
			
			Player player = null;
			
			for(Player players : gameEngine.getAllPlayers())
			{
				if(players.getPlayerName().equals(name))
				{
					player = players;
				}
			}
			
			if(!mainFrame.getCurrentPlayer().getPlayerName().equals(name))
			{
				mainFrame.getStatusBar().setLastAction("Player changed to " + name);
				mainFrame.setCurrentPlayer(player);
				
				if(!(mainFrame.getCurrentPlayer().getBet() > 0 && !mainFrame.getCurrentPlayer().getBetType().equals(BetType.NO_BET)))
				{
					mainFrame.getDashboard().getInteractivePanel().enablePlaceBet(true);
					mainFrame.getDashboard().getInteractivePanel().enablePlayerSpinBet(false);
					mainFrame.getDashboard().getInteractivePanel().enableRemoveBet(false);
					
					mainFrame.getDashboard().getInteractivePanel().getBetField().setText("0");
				}
				else
				{
					mainFrame.getDashboard().getInteractivePanel().enablePlaceBet(false);
					mainFrame.getDashboard().getInteractivePanel().enablePlayerSpinBet(true);
					mainFrame.getDashboard().getInteractivePanel().enableRemoveBet(true);
					
					mainFrame.getDashboard().getInteractivePanel().getBetField().setText("0");
				}
			}
		}
		catch(NullPointerException epf)
		{
			
		}
	}

}
