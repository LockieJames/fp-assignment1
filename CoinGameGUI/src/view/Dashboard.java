package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import model.interfaces.GameEngine;

public class Dashboard extends JPanel
{
	private GameEngine gameEngine;
	private CoinsPanel coinsPanel;
	
	public Dashboard(GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
		setLayout(new BorderLayout());
		
		coinsPanel = new CoinsPanel();
		
		add(coinsPanel);
	}
}
