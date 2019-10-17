package view;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class SummaryPanel extends JPanel
{	
	private GameEngine gameEngine;
	
	private Map<String, String> playerData;
	private Map<String, String> betData;
	private Map<String, String> betResults;
	
	public SummaryPanel(GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
		
		this.playerData = new HashMap<String, String>();
		this.betData = new HashMap<String, String>();
		this.betResults = new HashMap<String, String>();
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(200,0));
		
		for(Player players : gameEngine.getAllPlayers())
		{
			addPlayer(players);
		}
	}
	
	public void addPlayer(Player player)
	{		
		playerData.put(player.getPlayerId(), player.getPlayerName() + " " + player.getPoints());
		add(new JLabel(playerData.get(player.getPlayerId())));
		
		betData.put(player.getPlayerId(), "No bet");
		add(new JLabel(betData.get(player.getPlayerId())));
		
		betResults.put(player.getPlayerId(), "No result");
		add(new JLabel(betResults.get(player.getPlayerId())));
		
		add(new JLabel(" "));
		
		updateUI();
	}
	
	public void removePlayer()
	{
		removeAll();
		
		updateSummary();
		
		updateUI();
	}
	
	public void setResults(Player player, CoinPair coinPair)
	{
		betResults.put(player.getPlayerId(), coinPair.toString());
		updateSummary();
		
		updateUI();
	}
	
	public void setBet(Player player, BetType betType, int bet)
	{
		betData.put(player.getPlayerId(), "Bet " + bet + " on " + betType.toString());
		updateSummary();
		
		updateUI();
	}
	
	public void updateSummary()
	{
		removeAll();
		
		for(Player players : gameEngine.getAllPlayers())
		{
			add(new JLabel(playerData.get(players.getPlayerId())));
			add(new JLabel(betData.get(players.getPlayerId())));
			add(new JLabel(betResults.get(players.getPlayerId())));
			add(new JLabel(" "));
		}
		
		updateUI();
	}
	
	public void setNewPoints()
	{
		removeAll();
		
		for(Player players : gameEngine.getAllPlayers())
		{
			playerData.put(players.getPlayerId(), players.getPlayerName() + " " + players.getPoints());
			betData.put(players.getPlayerId(), "No bet");
			betResults.put(players.getPlayerId(), "No result");
			
			add(new JLabel(playerData.get(players.getPlayerId())));
			add(new JLabel(betData.get(players.getPlayerId())));
			add(new JLabel(betResults.get(players.getPlayerId())));
			add(new JLabel(" "));
		}
		
		updateUI();
	}
	
	public void removeBet(Player player)
	{
		betData.put(player.getPlayerId(), "No bet");
		updateSummary();
		
		updateUI();
	}
}