package view;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.interfaces.Player;

public class SummaryPanel extends JPanel
{	
	public SummaryPanel()
	{
		setUp();
	}
	
	public SummaryPanel(List<Player> players)
	{
		setUp();
		
		for(int i = 0; i < players.size(); i++)
		{
			add(new JLabel(players.get(i).getPlayerName()));
			add(new JLabel(Integer.toString(players.get(i).getPoints())));
		}
	}
	
	public void setUp()
	{
		setBackground(Color.gray);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("\t\t\tPlayer Summary\t\t\t");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Calibri", Font.PLAIN, 20));
		add(title);
	}
	
	public void addPlayer(String name, String points)
	{
		add(new JLabel(name));
		add(new JLabel(points));
	}
}