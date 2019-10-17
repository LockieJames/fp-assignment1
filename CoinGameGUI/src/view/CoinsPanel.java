package view;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.enumeration.CoinFace;
import model.interfaces.Coin;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class CoinsPanel extends JPanel
{
	private MainFrame mainFrame;
	private GameEngine gameEngine;
	
	private JLabel coin1;
	private JLabel coin2;
	
	private BufferedImage heads = null;
	private BufferedImage tails = null;
	
	private ImageIcon headsImage = null;
	private ImageIcon tailsImage = null;
	
	public CoinsPanel(GameEngine gameEngine, MainFrame mainFrame)
	{
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
		
		setLayout(new FlowLayout());
		
		
		String dir = Paths.get("").toAbsolutePath().toString();
		
		try 
		{
			heads = ImageIO.read(new File(dir + "/img/heads.png"));
			tails = ImageIO.read(new File(dir + "/img/tails.png"));
		} 
		catch (IOException e) 
		{
			System.out.println("Image not found");
		}
		
		headsImage = new ImageIcon(heads);
		tailsImage = new ImageIcon(tails);
		
		coin1 = new JLabel(headsImage);
		coin2 = new JLabel(tailsImage);
		
		add(coin1);
		add(coin2);
		
		setVisible(true);
	}
	
	public void updateCoin(Coin coin)
	{
		if(coin.getNumber() == 1)
		{
			remove(coin1);
			updateUI();
			coin1 = changeFace(coin, coin1);
			add(coin1);
		}
		else if(coin.getNumber() == 2)
		{
			remove(coin2);
			updateUI();
			coin2 = changeFace(coin, coin2);
			add(coin2);
		}
		
		updateUI();
	}
	
	public JLabel changeFace(Coin coin, JLabel visCoin)
	{	
		CoinFace coinFace = coin.getFace();
		
		if(coinFace.equals(CoinFace.HEADS))
		{
			return visCoin = new JLabel(headsImage);
		}
		else
		{
			return visCoin = new JLabel(tailsImage);
		}
	}
}
