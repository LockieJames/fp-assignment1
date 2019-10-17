package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.MainFrame;

public class PlaceBetController implements ActionListener
{
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	
	public PlaceBetController(GameEngine gameEngine, MainFrame mainFrame)
	{
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
}
