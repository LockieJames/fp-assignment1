package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class StatusBar extends JPanel
{
	private JLabel currentPlayer = new JLabel("", JLabel.LEFT);
	private JLabel status = new JLabel("", JLabel.CENTER);
	private JLabel idk = new JLabel("", JLabel.RIGHT);
	
	public StatusBar(GameEngine gameEngine)
	{
		setLayout(new GridLayout(1,3));
		
		currentPlayer.setBorder(BorderFactory.createLineBorder(Color.black));
		status.setBorder(BorderFactory.createLineBorder(Color.black));
		idk.setBorder(BorderFactory.createLineBorder(Color.black));
		
		currentPlayer.setText("Add a player");
		
		add(currentPlayer);
		add(status);
		add(idk);
	}
	
	public void setCurrentPlayer(Player player)
	{
		
	}
}
