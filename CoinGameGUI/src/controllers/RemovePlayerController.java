package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

public class RemovePlayerController implements ActionListener
{
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	
	public RemovePlayerController(GameEngine gameEngine, MainFrame mainFrame)
	{
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(gameEngine.getAllPlayers().size() > 0)
		{
			boolean correct = false;
			Player player = null;
			
			String name = JOptionPane.showInputDialog("Enter the name of the player:");
				
			for(Player players : gameEngine.getAllPlayers())
			{
				if(players.getPlayerName().equalsIgnoreCase(name))
				{
					correct = true;
					player = players;
					gameEngine.removePlayer(player);
					
					mainFrame.getDashboard().getInteractivePanel().removePlayer(player);
					mainFrame.getStatusBar().setLastAction(name + " was removed");
				}
			}
				
			if(!correct)
			{
				JOptionPane.showMessageDialog(null, "Player not found!");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No players added!");
		}
	}
}
