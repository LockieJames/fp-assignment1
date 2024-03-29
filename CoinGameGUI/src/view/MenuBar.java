package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controllers.AddPlayerController;
import controllers.InfoController;
import controllers.QuitController;
import controllers.RemovePlayerController;
import model.interfaces.GameEngine;

public class MenuBar extends JMenuBar
{
	public MenuBar(GameEngine gameEngine, MainFrame mainFrame)
	{
		JMenu file = new JMenu("File");
		add(file);
		
		JMenuItem addPlayer = new JMenuItem("Add player");
		addPlayer.addActionListener(new AddPlayerController(gameEngine, mainFrame));
		
		JMenuItem removePlayer = new JMenuItem("Remove player");
		removePlayer.addActionListener(new RemovePlayerController(gameEngine, mainFrame));
		
		JMenuItem info = new JMenuItem("Student info");
		info.addActionListener(new InfoController(gameEngine, mainFrame));
		
		JMenuItem quit = new JMenuItem("Quit");
		quit.addActionListener(new QuitController());
		
		file.add(addPlayer);
		file.add(removePlayer);
		file.add(info);
		file.add(quit);
	}
}
