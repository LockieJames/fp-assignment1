package view;

import javax.swing.JButton;
import javax.swing.JToolBar;
import controllers.AddPlayerController;
import controllers.RemovePlayerController;
import model.interfaces.GameEngine;

public class ToolBar extends JToolBar 
{
	public ToolBar(GameEngine gameEngine, MainFrame mainFrame)
	{		
		JButton addPlayer = new JButton("Add Player");
		addPlayer.addActionListener(new AddPlayerController(gameEngine, mainFrame));
		
		JButton removePlayer = new JButton("Remove Player");
		removePlayer.addActionListener(new RemovePlayerController(gameEngine, mainFrame));
		
		add(addPlayer);
		add(removePlayer);
		
		setVisible(true);
	}
}
