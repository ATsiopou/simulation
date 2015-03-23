import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;


public class GUI extends JFrame{

	private StartMenu startMenu=new StartMenu();
	private GamePanel gamePanel = new GamePanel();
	private TimePanel  timePanel = new TimePanel();

	public GUI(){
		super();
		this.setLayout(new BorderLayout());
		this.add(timePanel, BorderLayout.NORTH);
		this.add(gamePanel, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
	}
}
