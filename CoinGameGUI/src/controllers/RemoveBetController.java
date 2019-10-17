package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import view.MainFrame;

public class RemoveBetController implements ActionListener
{
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	
	public RemoveBetController(GameEngine gameEngine, MainFrame mainFrame)
	{
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try
		{
			mainFrame.getCurrentPlayer().resetBet();
			
			mainFrame.getStatusBar().setStatus("Bet removed!");
			mainFrame.getStatusBar().setLastAction(mainFrame.getCurrentPlayer().getPlayerName() + " removed bet");
			mainFrame.getCurrentPlayer().resetBet();
			
			mainFrame.getSummaryPanel().removeBet(mainFrame.getCurrentPlayer());
			
//			mainFrame.getDashboard().getInteractivePanel().enablePlaceBet(true);
//			mainFrame.getDashboard().getInteractivePanel().enablePlayerSpinBet(false);
//			mainFrame.getDashboard().getInteractivePanel().enableRemoveBet(false);
//			mainFrame.getDashboard().getInteractivePanel().enableSpinnerSpinBet(false);
		}
		catch(NullPointerException epj)
		{
			JOptionPane.showMessageDialog(null, "No player selected!");
		}
	}
}
