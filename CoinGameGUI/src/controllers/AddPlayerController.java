package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

public class AddPlayerController implements ActionListener
{
	private static int count = 1;
	private GameEngine gameEngine;
	private MainFrame mainFrame;

	public AddPlayerController(GameEngine gameEngine, MainFrame mainFrame)
	{
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}

	public void actionPerformed(ActionEvent e) 
	{
		String betStr;
		int bet = 0;
		String name = JOptionPane.showInputDialog("Enter the name of the new player:");
		
		boolean correct = false;
		
		while(!correct)
		{
			betStr = JOptionPane.showInputDialog("Enter your Buy-in:");
			
			try
			{
				bet = Integer.parseInt(betStr);
				correct = true;
			}
			catch(NumberFormatException | NullPointerException nfe)
			{
				JOptionPane.showMessageDialog(null, "Amount invalid!");
			}
		}
		
		Player player = new SimplePlayer(Integer.toString(count), name, bet);
		
		gameEngine.addPlayer(player);
		count++;
		
		mainFrame.getDashboard().getInteractivePanel().addPlayer(player);
		mainFrame.getStatusBar().setLastAction("New player " + name + " was added");
		mainFrame.setCurrentPlayer(player);
		mainFrame.getSummaryPanel().addPlayer(player);
	}
}
