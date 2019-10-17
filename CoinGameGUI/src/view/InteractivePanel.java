package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class InteractivePanel extends JPanel
{
	private JTextField betAmount;
	private JComboBox<String> players;
	private JButton placeBet;
	private JButton removeBet;
	private JButton playerSpin;
	private JButton spinnerSpin;
	private GameEngine gameEngine;
	
	public InteractivePanel(GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
		
		betAmount = new JTextField("0");
		players = new JComboBox<String>();
		placeBet = new JButton("Place bet");
		removeBet = new JButton("Remove bet");
		playerSpin = new JButton("Player spin");
		spinnerSpin = new JButton("Spinner spin");
		
		for(Player gamePlayers : gameEngine.getAllPlayers())
		{
			players.addItem(gamePlayers.getPlayerName());
		}
		
		add(betAmount);
		add(players);
		add(placeBet);
		add(removeBet);
		add(playerSpin);
		add(spinnerSpin);
	}
	
	public void addPlayer(Player player)
	{
		players.addItem(player.getPlayerName());
		updateUI();
	}
	
	public void removePlayer(Player player)
	{
		players.removeItem(player.getPlayerName());
		updateUI();
	}
}
