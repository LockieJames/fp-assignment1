package view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class SummaryPanel extends JPanel
{	
	private GameEngine gameEngine;
	
	public SummaryPanel(GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(200,0));
		
		for(Player players : gameEngine.getAllPlayers())
		{
			add(new JLabel(players.getPlayerName()));
		}
	}
	
	public void addPlayer(Player player)
	{
		add(new JLabel(player.getPlayerName()));
		
		updateUI();
	}
	
	public void removePlayer()
	{
		removeAll();
		
		for(Player players : gameEngine.getAllPlayers())
		{
			add(new JLabel(players.getPlayerName()));
		}
		
		updateUI();
	}
}