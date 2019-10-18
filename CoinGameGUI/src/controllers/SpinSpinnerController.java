package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.MainFrame;

public class SpinSpinnerController implements ActionListener
{
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	
	private final int initialDelay1 = 100;
	private final int finalDelay1 = 1000;
	private final int delayIncrement1 = 100;
	private final int initialDelay2 = 50;
	private final int finalDelay2 = 500;
	private final int delayIncrement2 = 50;
	
	public SpinSpinnerController(GameEngine gameEngine, MainFrame mainFrame)
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
				mainFrame.getDashboard().getInteractivePanel().enablePlaceBet(false);
				mainFrame.getDashboard().getInteractivePanel().enablePlayerSpinBet(false);
				mainFrame.getDashboard().getInteractivePanel().enableRemoveBet(false);
				mainFrame.getDashboard().getInteractivePanel().enableSpinnerSpinBet(false);
				mainFrame.getDashboard().getInteractivePanel().getBetField().setText("0");
				
				mainFrame.getStatusBar().setStatus("Spinner is spinning...");
				gameEngine.spinSpinner(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);
				mainFrame.getStatusBar().setStatus("Spinner spun");
				mainFrame.getStatusBar().setLastAction("Spinner spun");
				
				mainFrame.getDashboard().getInteractivePanel().enablePlaceBet(true);
				mainFrame.getDashboard().getInteractivePanel().enablePlayerSpinBet(false);
				mainFrame.getDashboard().getInteractivePanel().enableRemoveBet(false);
				mainFrame.getDashboard().getInteractivePanel().enableSpinnerSpinBet(false);
				mainFrame.getDashboard().getInteractivePanel().getBetField().setText("0");
			}
		}.start();
	}
}
