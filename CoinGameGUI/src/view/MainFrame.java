package view;

import java.awt.BorderLayout;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import controllers.AddPlayerController;
import controllers.RemovePlayerController;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MainFrame extends JFrame
{
	private GameEngine gameEngine;
	private MenuBar menuBar;
	private ToolBar toolBar;
	private Dashboard dashboard;
	private StatusBar statusBar;
	
	public MainFrame(GameEngine gameEngine)
	{
		super("Coin Game");
		
		this.gameEngine = gameEngine;
		menuBar = new MenuBar(gameEngine);
		toolBar = new ToolBar(gameEngine);
		dashboard = new Dashboard(gameEngine);
		statusBar = new StatusBar(gameEngine);
		
		setSize(700,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		populate();
		
		setVisible(true);
	}
	
	public void populate()
	{
		setLayout(new BorderLayout());
	
		setJMenuBar(menuBar);
		add(toolBar, BorderLayout.NORTH);
		add(dashboard, BorderLayout.CENTER);
		add(statusBar, BorderLayout.SOUTH);
	}
}
