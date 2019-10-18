package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

public class SpinPlayerController implements ActionListener
{
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	
	private final int initialDelay1 = 100;
	private final int finalDelay1 = 1000;
	private final int delayIncrement1 = 100;
	private final int initialDelay2 = 50;
	private final int finalDelay2 = 500;
	private final int delayIncrement2 = 50;
	
	public SpinPlayerController(GameEngine gameEngine, MainFrame mainFrame)
	{
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new Thread()
		{
			public void run()
			{
				try
				{
					mainFrame.getStatusBar().setStatus(mainFrame.getCurrentPlayer().getPlayerName() + " is spinning...");
					gameEngine.spinPlayer(mainFrame.getCurrentPlayer(), initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);
					mainFrame.getStatusBar().setStatus(mainFrame.getCurrentPlayer().getPlayerName() + " has spun");
					mainFrame.getStatusBar().setLastAction(mainFrame.getCurrentPlayer().getPlayerName() + " spun");
					
					boolean have = true;
					
					for(Player players : gameEngine.getAllPlayers())
					{
						if(!(players.getBet() > 0 && !players.getBetType().equals(BetType.NO_BET)) && players.getResult() == null)
						{
							have = false;
						}
					}
					
					if(have)
					{
						mainFrame.getDashboard().getInteractivePanel().enableSpinnerSpinBet(true);
					}
				}
				catch(NullPointerException epj)
				{
					JOptionPane.showMessageDialog(null, "Please select a player");
				}
			}
		}.start();
	}

}
