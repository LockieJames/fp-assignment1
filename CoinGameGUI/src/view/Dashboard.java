package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import model.interfaces.GameEngine;

public class Dashboard extends JPanel
{
	private CoinsPanel coinsPanel;
	private InteractivePanel interactivePanel;
	
	public Dashboard(GameEngine gameEngine, MainFrame mainFrame)
	{
		// Panel set up
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Coin panel
		coinsPanel = new CoinsPanel();
		add(coinsPanel);
		
		// Interactive panel
		interactivePanel = new InteractivePanel(gameEngine, mainFrame);
		add(interactivePanel);
	}
	
	public InteractivePanel getInteractivePanel()
	{
		return interactivePanel;
	}
}
