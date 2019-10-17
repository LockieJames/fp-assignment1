package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import model.interfaces.GameEngine;

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
		add(statusBar, BorderLayout.SOUTH);
	}
}
