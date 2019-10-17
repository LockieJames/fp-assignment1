package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MainFrame extends JFrame
{
	private GameEngine gameEngine;
	private Player currentPlayer;
	private MenuBar menuBar;
	private ToolBar toolBar;
	private Dashboard dashboard;
	private SummaryPanel summary;
	private StatusBar statusBar;
	
	public MainFrame(GameEngine gameEngine)
	{
		super("Coin Game");
		
		//Game Engine
		this.gameEngine = gameEngine;
		this.gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		
		
		menuBar = new MenuBar(gameEngine, this);
		toolBar = new ToolBar(gameEngine, this);
		dashboard = new Dashboard(gameEngine);
		statusBar = new StatusBar(gameEngine);
		summary = new SummaryPanel(gameEngine);
		
		setLayout(new BorderLayout());
		setSize(700,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		populate();
		
		setVisible(true);
	}
	
	public void populate()
	{
		setJMenuBar(menuBar);
		add(toolBar, BorderLayout.NORTH);
		add(dashboard, BorderLayout.CENTER);
		add(summary, BorderLayout.EAST);
		add(statusBar, BorderLayout.SOUTH);
	}
	
	public StatusBar getStatusBar()
	{
		return statusBar;
	}
	
	public Dashboard getDashboard()
	{
		return dashboard;
	}
	
	public void setCurrentPlayer(Player player)
	{
		currentPlayer = player;
		statusBar.setCurrentPlayer(player);
	}
	
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
}
