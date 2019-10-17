package view;

import javax.swing.JPanel;
import model.interfaces.GameEngine;

public class SummaryPanel extends JPanel
{	
	private GameEngine gameEngine;
	
	public SummaryPanel(GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
	}
}