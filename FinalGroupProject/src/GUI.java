import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;


public class GUI extends JFrame{

	private StartMenu startMenu=new StartMenu();
	private GamePanel gamePanel = new GamePanel();

	public GUI(){
		super();
		this.setLayout(new BorderLayout());
		this.add(startMenu, BorderLayout.NORTH);
		this.add(gamePanel, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
	}
}
