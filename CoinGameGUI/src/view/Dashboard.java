package view;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import model.interfaces.GameEngine;

public class Dashboard extends JPanel
{
	private GameEngine gameEngine;
	private CoinsPanel coinsPanel;
	private InteractivePanel interactivePanel;
	
	public Dashboard(GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
		setLayout(new FlowLayout());
		
		coinsPanel = new CoinsPanel();
		interactivePanel = new InteractivePanel(gameEngine);
		
		add(coinsPanel);
		add(interactivePanel);
	}
	
	public InteractivePanel getInteractivePanel()
	{
		return interactivePanel;
	}
}
