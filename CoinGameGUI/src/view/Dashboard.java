package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import model.interfaces.GameEngine;

public class Dashboard extends JPanel
{
	private GameEngine gameEngine;
	private CoinsPanel coinsPanel;
	private InteractivePanel interactivePanel;
	
	public Dashboard(GameEngine gameEngine, MainFrame mainFrame)
	{
		this.gameEngine = gameEngine;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		coinsPanel = new CoinsPanel();
		interactivePanel = new InteractivePanel(gameEngine, mainFrame);
		
		add(coinsPanel);
		add(interactivePanel);
	}
	
	public InteractivePanel getInteractivePanel()
	{
		return interactivePanel;
	}
}
