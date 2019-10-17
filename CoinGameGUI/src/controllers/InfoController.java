package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import view.MainFrame;

public class InfoController implements ActionListener
{
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	
	public InfoController(GameEngine gameEngine, MainFrame mainFrame)
	{
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		JOptionPane.showMessageDialog(null, "Lachlan Boughton\nS3769219");
		
		System.out.println(mainFrame.getCurrentPlayer().getPlayerName());
	}
}
