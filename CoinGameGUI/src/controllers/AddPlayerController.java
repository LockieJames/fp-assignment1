package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.SimplePlayer;
import model.interfaces.GameEngine;

public class AddPlayerController implements ActionListener
{
	private static int count = 1;
	private GameEngine gameEngine;

	public AddPlayerController(GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
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
		
		
		gameEngine.addPlayer(new SimplePlayer(Integer.toString(count), name, bet));
		count++;
	}
}
