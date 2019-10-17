package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class RemovePlayerController implements ActionListener
{
	private GameEngine gameEngine;
	
	public RemovePlayerController(GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
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
					JOptionPane.showMessageDialog(null, player.getPlayerName() + " removed!");
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
