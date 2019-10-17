package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import model.GameEngineCallbackGUI;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MainFrame extends JFrame
{
	private final GameEngine gameEngine;
	private Player currentPlayer;
	
	
	private MenuBar menuBar;
	private ToolBar toolBar;
	private Dashboard dashboard;
	private SummaryPanel summary;
	private StatusBar statusBar;
	
	public MainFrame()
	{
		super("Coin Game");
		
		// Game Engine
		gameEngine = new GameEngineImpl();
		this.gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		this.gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(this));
		
		// Frame set up
		setLayout(new BorderLayout());
		setSize(1200,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Menu bar
		menuBar = new MenuBar(gameEngine, this);
		setJMenuBar(menuBar);
		
		// Tool bar
		toolBar = new ToolBar(gameEngine, this);
		add(toolBar, BorderLayout.NORTH);
		
		// Dash board
		dashboard = new Dashboard(gameEngine, this);
		add(dashboard, BorderLayout.CENTER);
		
		// Summary
		summary = new SummaryPanel(gameEngine);
		add(summary, BorderLayout.EAST);
		
		// Status bar
		statusBar = new StatusBar(gameEngine);
		add(statusBar, BorderLayout.SOUTH);
		
		setVisible(true);
	}
		
	// To change the current player
	public void setCurrentPlayer(Player player)
	{
		currentPlayer = player;
		statusBar.setCurrentPlayer(player);
	}
	
	// To return the currently selected player
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	// To return the status bar for use out of this class
	public StatusBar getStatusBar()
	{
		return statusBar;
	}
	
	// To return the dash board for use out of this class
	public Dashboard getDashboard()
	{
		return dashboard;
	}
	
	// To return the summary panel for use out of this class
	public SummaryPanel getSummaryPanel()
	{
		return summary;
	}
}
