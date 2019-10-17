package view;

import javax.swing.JButton;
import javax.swing.JToolBar;
import controllers.AddPlayerController;
import controllers.RemovePlayerController;
import model.interfaces.GameEngine;

public class ToolBar extends JToolBar 
{
	public ToolBar(GameEngine gameEngine)
	{		
		JButton addPlayer = new JButton("Add Player");
		addPlayer.addActionListener(new AddPlayerController(gameEngine));
		
		JButton removePlayer = new JButton("Remove Player");
		removePlayer.addActionListener(new RemovePlayerController(gameEngine));
		
		add(addPlayer);
		add(removePlayer);
		
		setVisible(true);
	}
}
