package app;

import java.util.LinkedList;
import java.util.List;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

public class Main 
{
	public static void main (String [] args)
	{
		GameEngine gameEngine = new GameEngineImpl();
		
		MainFrame mainFrame = new MainFrame(gameEngine);
	}
}
