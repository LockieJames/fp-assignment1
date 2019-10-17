package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.ChangePlayerController;
import controllers.PlaceBetController;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class InteractivePanel extends JPanel
{
	private JTextField betAmount;
	private JComboBox<String> players;
	private JComboBox<String> betTypes;
	private JButton placeBet;
	private JButton removeBet;
	private JButton playerSpin;
	private JButton spinnerSpin;
	
	public InteractivePanel(GameEngine gameEngine, MainFrame mainFrame)
	{	
		// Initial set up
		setLayout(new GridLayout(4,2));
		
		for(Player gamePlayers : gameEngine.getAllPlayers())
		{
			players.addItem(gamePlayers.getPlayerName());
		}
		
		// Player names
		players = new JComboBox<String>();
		players.addActionListener(new ChangePlayerController(gameEngine, mainFrame));
		add(players);
		
		// Fill up space in grid layout
		JLabel nothing = new JLabel(" ");
		add(nothing);
		
		// Enter the bet amount
		betAmount = new JTextField("0");
		add(betAmount);
		
		// Choose the bet type
		String [] strBetTypes = {"Coin 1", "Coin 2", "Both", "No bet"};
		betTypes = new JComboBox<String>(strBetTypes);
		add(betTypes);
		
		// Place bet
		placeBet = new JButton("Place bet");
		placeBet.addActionListener(new PlaceBetController(gameEngine, mainFrame));
		add(placeBet);
		
		// Remove bet
		removeBet = new JButton("Remove bet");
		add(removeBet);
		
		// Spin the players coins
		playerSpin = new JButton("Player spin");
		add(playerSpin);
		
		// Spin the spinners coins
		spinnerSpin = new JButton("Spinner spin");
		add(spinnerSpin);

		setVisible(true);
	}
	
	// Add player to the list of players
	public void addPlayer(Player player)
	{
		players.addItem(player.getPlayerName());
	}
	
	// Remove player from the list of players
	public void removePlayer(Player player)
	{
		players.removeItem(player.getPlayerName());
	}
	
	// To get the players name selected
	public String getPlayerName()
	{
		return (String) players.getSelectedItem();
	}
	
	// To get the amount entered by the user
	public String getBetAmount()
	{
		return betAmount.getText();
	}
	
	// To get the bet type chosen by the user
	public String getBetType()
	{
		return (String) betTypes.getSelectedItem();
	}
}
