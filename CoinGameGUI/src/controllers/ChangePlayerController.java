package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
			}
		}
		catch(NullPointerException epf)
		{
			
		}
	}

}
