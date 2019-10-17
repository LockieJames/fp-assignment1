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

public class CoinsPanel extends JPanel
{
	private JLabel coin1;
	private JLabel coin2;
	
	public CoinsPanel()
	{
		setLayout(new FlowLayout());
		
		
		String dir = Paths.get("").toAbsolutePath().toString();
		
		BufferedImage heads = null;
		BufferedImage tails = null;
		
		try 
		{
			heads = ImageIO.read(new File(dir + "/img/heads.png"));
			tails = ImageIO.read(new File(dir + "/img/tails.png"));
		} 
		catch (IOException e) 
		{
			System.out.println("Image not found");
		}
		
		ImageIcon headsImage = new ImageIcon(heads);
		ImageIcon tailsImage = new ImageIcon(tails);
		
		coin1 = new JLabel(headsImage);
		coin2 = new JLabel(tailsImage);
		
		
		
		add(coin1);
		add(coin2);
		
		setVisible(true);
	}
	
	public void setFaces()
	{
		
	}
}
